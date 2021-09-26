'use strict';

const Emitter = require('@darabonba/emitter');
const assert = require('assert');
const path = require('path');

const { _name, save } = require('./util');
const CommonGenerator = require('./common_generator');
const InterfaceGenerator = require('./interface_generator');
const BaseClassGenerator = require('./base_client_generator');

class BuilderGenerator extends Emitter {
  constructor(ast, ctx) {
    super('    ');
    this.ast = ast;
    this.ctx = ctx;
  }

  codegen(level = 0) {
    this.emitln(`// This file is auto-generated, don't edit it. Thanks.`, level);
    this.emitln(`package ${this.ctx.package};`, level);
    this.emitln();
    this.emitln(`public final class ${this.ctx.className}Builder extends BaseClientBuilder<${this.ctx.className}Builder, ${this.ctx.implements || 'Client'}> {`, level);
    this.emitln();
    this.emitln('@Override', level + 1);
    this.emitln(`protected final ${this.ctx.implements || 'Client'} buildClient() {`, level + 1);
    this.emitln();
    this.emitln(`return new ${this.ctx.className}(super.applyClientConfiguration());`, level + 2);
    this.emitln();
    this.emitln('}', level + 1);
    this.emitln();
    this.emitln('}', level);
  }
}

class Generator extends CommonGenerator {
  constructor(ast, ctx) {
    super(ast, ctx);
    this.ctx.extendParam = {};
    this.ctx.extendsClass = {};
  }

  codegen(level = 0) {
    const nonStaticWraps = this.ast.moduleBody.nodes.filter((item) => { return item.type === 'function' && !item.isStatic; });
    const apis = this.ast.moduleBody.nodes.filter((item) => { return item.type === 'api'; });
    const models = this.ast.moduleBody.nodes.filter((item) => { return item.type === 'model'; });
    const types = this.ast.moduleBody.nodes.filter((item) => { return item.type === 'type'; });
    const init = this.ast.moduleBody.nodes.filter((item) => { return item.type === 'init'; });
    const functions = this.ast.moduleBody.nodes.filter((item) => { return item.type === 'function'; });
    if (nonStaticWraps.length > 0 || apis.length > 0) {
      this.ctx.extendParam.writeConstruct = true;
    }
    if (models.length > 0) {
      this.ctx.extendParam.writeImport = true;
    }
    if (!this.ctx.exec && this.ctx.implements) {
      const inter = new InterfaceGenerator(this.ast, this.ctx);
      inter.emitInterface(nonStaticWraps, apis, level);
      save(path.join(this.ctx.outputDir, `${this.ctx.implements}.java`), inter.output);
    }
    if (this.ast.extends) {
      this.ctx.extendsName = _name(this.ast.extends);
      this.ctx.extendsClass.className = this.ctx.imports[this.ctx.extendsName].className;
      this.ctx.extendsClass.package = this.ctx.imports[this.ctx.extendsName].package;
    }
    this.emitHeader(level);
    this.emitln();
    types.forEach(type => { this.emitEachType(type, level + 1); });
    this.emitln();
    if (this.ctx.exec) {
      init.forEach(i => { this.emitEachInit(i, level + 1); });
    } else if (init.length === 1) {
      init.forEach(i => { this.emitConstructor(i, level + 1); });
    }
    // this.emitln();
    // apis.forEach(api => { this.emitEachAPI(api, level + 1); });
    functions.forEach(func => {
      this.emitln();
      this.emitEachFunction(func, level + 1);
    });
    if (!this.ctx.exec && init.length === 1) {
      const final = new BaseClassGenerator(this.ast, this.ctx);
      final.codegen(level);
      save(path.join(this.ctx.outputDir, `BaseClientBuilder.java`), final.output);
    }
    this.emitln();
    this.emitFooter(level);
    if (!this.ctx.exec && init.length === 1) {
      const builder = new BuilderGenerator(this.ast, this.ctx);
      builder.codegen(level);
      save(path.join(this.ctx.outputDir, `${this.ctx.className}Builder.java`), builder.output);
    }
  }

  emitHeader(level) {
    this.emitln(`// This file is auto-generated, don't edit it. Thanks.`, level);
    this.emitln(`package ${this.ctx.package};`, level);
    this.emitln();
    if (this.ctx.extendParam.writeImport) {
      this.emitln(`import com.aliyun.core.http.*;`, level);
      this.emitln(`import ${this.ctx.package}.models.*;`, level);
      this.emitln(`import darabonba.core.utils.*;`, level);
      this.emitExternImport(level);
      this.emitln();
      this.emitln(`import java.util.concurrent.CompletableFuture;`, level);
      this.emitln();
    }
    if (this.ast.extends) {
      this.emitln(`import ${this.ctx.extendsClass.package + '.' + this.ctx.extendsClass.className};`);
    }

    this.emitln();
    this.emitln(`/**`, level);
    this.emitln(` * <p>${this.ctx.description ? this.ctx.description : 'Main client'}.</p>`, level);
    this.emitln(` */`, level);
    if (!this.ctx.exec) {
      this.emit(`public final class ${this.ctx.className}`, level);
    } else {
      this.emit(`public class ${this.ctx.className}`, level);
    }

    if (this.ast.extends) {
      this.emit(` extends ${this.ctx.extendsClass.className}`);
    }
    if (!this.ctx.exec && this.ctx.implements) {
      this.emit(` implements ${this.ctx.implements}`);
    }
    this.emitln(` {`);
  }

  emitExternImport(level) {
    const importList = [];
    for (var item of this.ctx.usedExternModel.entries()) {
      if (!importList.includes(this.ctx.imports[item[0]].package)) {
        this.emitln(`import ${this.ctx.imports[item[0]].package}.*;`, level);
        importList.push(this.ctx.imports[item[0]].package);
        if (item[1].size > 0) {
          this.emitln(`import ${this.ctx.imports[item[0]].package}.models.*;`, level);
        }
      }
    }
  }

  emitEachType(ast, level) {
    this.emit('protected final ', level);
    this.visitType(ast.value);
    this.emitln(` ${_name(ast.vid).substr(1)};`);
  }

  emitConstructor(ast, level) {
    this.visitAnnotation(ast.annotation, level);
    var className = this.ctx.className || 'DefaultAsyncClient';
    this.emit(`protected ${className}`, level);
    this.visitParams(ast.params, level);
    this.emitln(' {');
    if (ast.initBody) {
      this.visitStmts(ast.initBody, level + 1);
    }
    this.emitln('this.REQUEST = TeaRequest.create().setProduct(product).setEndpointRule(endpointRule).setEndpointMap(endpointMap).setVersion(version);', level + 1);
    this.emitln(`}`, level);
  }

  emitEachInit(ast, level) {
    var className = this.ctx.className || 'DefaultAsyncClient';
    this.visitAnnotation(ast.annotation, level);
    this.emit(`public ${className}`, level);
    this.visitParams(ast.params, level);
    this.emitln(' {');
    if (ast.initBody) {
      this.visitStmts(ast.initBody, level + 1);
    }
    this.emitln('}', level);
  }

  visitReturnBody(ast, level) {
    assert.equal(ast.type, 'returnBody');
    this.emit('\n');
    this.visitStmts(ast.stmts, level);
  }

  emitEachFunction(ast, level) {
    this.visitAnnotation(ast.annotation, level);
    if (!this.ctx.exec && this.ctx.implements && !ast.isStatic) {
      this.emitln(`@Override`, level);
    }
    this.emit('public ', level);
    if (ast.isStatic) {
      this.emit('static ');
    }
    this.emit(`${_name(ast.functionName) === 'main' ? '' : ast.isAsync ? 'CompletableFuture<' : ''}`);
    this.visitType(ast.returnType);
    this.emit(`${_name(ast.functionName) === 'main' ? '' : ast.isAsync ? '>' : ''}`);
    this.emit(` ${_name(ast.functionName)}`);
    if (_name(ast.functionName) === 'main') {
      if (!ast.params.params || ast.params.params.length === 0) {
        throw new Error('static function main must have a argument');
      }
      this.emit(`(String[] ${_name(ast.params.params[0].paramName)}_)`);
    } else {
      this.visitParams(ast.params, level);
    }
    this.emitln(' {');
    if (ast.functionBody) {
      if (_name(ast.functionName) === 'main') {
        const args = _name(ast.params.params[0].paramName);
        this.emitln(`java.util.List<String> ${args} = java.util.Arrays.asList(${args}_);`, level + 1);
        this.visitFunctionBody(ast.functionBody, level + 1);
      } else {
        if (ast.isAsync) {
          this.emitln(`try {`, level + 1);
          this.visitFunctionBody(ast.functionBody, level + 2);
          this.emitln(`} catch (Exception e) {`, level + 1);
          this.emit(`CompletableFuture<`, level + 2);
          this.visitType(ast.returnType);
          this.emitln(`> future = new CompletableFuture<>();`);
          this.emitln(`future.completeExceptionally(e);`, level + 2);
          this.emitln(`return future;`, level + 2);
          this.emitln(`}`, level + 1);
        } else {
          this.visitFunctionBody(ast.functionBody, level + 1);
        }
      }
    }
    this.emitln('}', level);
  }

  visitFunctionBody(ast, level) {
    assert.equal(ast.type, 'functionBody');
    this.visitStmts(ast.stmts, level);
  }

  emitFooter(level) {
    this.emitln('}', level);
  }
}

module.exports = Generator;