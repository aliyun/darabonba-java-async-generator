/* eslint-disable max-len */
'use strict';

const Emitter = require('@darabonba/emitter');
const assert = require('assert');
const path = require('path');

const { _name, save, SSE } = require('./util');
const CommonGenerator = require('./common_generator');
const InterfaceGenerator = require('./interface_generator');

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
    if (this.ast.extends) {
      this.emitln(`import ${this.ctx.extendsClass.package + '.' + this.ctx.extendsClass.className};`);
    }
    this.emitln();
    this.emit(`public final class ${this.ctx.className}Builder`, level);
    if (this.ast.extends) {
      this.emit(` extends ${this.ctx.extendsClass.className}<${this.ctx.className}Builder, ${this.ctx.implements || this.ctx.className}>`);
    }
    this.emitln(` {`);
    this.emitln();
    this.emitServiceName(level + 1);
    this.emitln();
    this.emitln('@Override', level + 1);
    this.emitln(`protected final ${this.ctx.implements || this.ctx.className} buildClient() {`, level + 1);
    this.emitln(`return new ${this.ctx.className}(super.applyClientConfiguration());`, level + 2);
    this.emitln('}', level + 1);
    this.emitln();
    this.emitln('}', level);
  }

  emitServiceName(level) {
    this.emitln('@Override', level);
    this.emitln(`protected String serviceName() {`, level);
    this.emitln(`return "${this.ctx.productId}${this.ctx.apiVersions}";`, level + 1);
    this.emitln(`}`, level);
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
      if (_name(func.functionName) === 'close' && !this.ctx.exec && this.ctx.implements) {
        this.ctx.closable = true;
      }
      this.emitln();
      this.emitEachFunction(func, level + 1);
    });
    this.emitln();
    this.emitFooter(level);

    const sseIterators = this.ctx.iterators.filter((item) => {
      return item.iteratorStyle === SSE;
    });
    if (sseIterators.length <= 0) {
      this.output = this.output.replace('import darabonba.core.sse.SSEHttpResponseHandler;\n', '');
    }

    if (!this.ctx.exec && init.length === 1) {
      const builder = new BuilderGenerator(this.ast, this.ctx);
      builder.codegen(level);
      save(path.join(this.ctx.outputDir, `${this.ctx.className}Builder.java`), builder.output);
    }

    if (!this.ctx.exec && this.ctx.implements) {
      const inter = new InterfaceGenerator(this.ast, this.ctx);
      inter.emitInterface(nonStaticWraps, apis, level);
      save(path.join(this.ctx.outputDir, `${this.ctx.implements}.java`), inter.output);
    }
  }

  emitHeader(level) {
    this.emitln(`// This file is auto-generated, don't edit it. Thanks.`, level);
    this.emitln(`package ${this.ctx.package};`, level);
    this.emitln();
    if (this.ctx.extendParam.writeImport) {
      this.emitln(`import com.aliyun.core.http.*;`, level);
      this.emitln(`import ${this.ctx.package}.models.*;`, level);
      this.emitln(`import darabonba.core.sse.SSEHttpResponseHandler;`, level);
      this.emitln(`import darabonba.core.utils.*;`, level);
      this.emitExternImport(level);
      this.emitln();
      this.emitln(`import java.util.concurrent.CompletableFuture;`, level);
      this.emitln();
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
      this.visitStmts(ast.initBody, false, level + 1);
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
      this.visitStmts(ast.initBody, false, level + 1);
    }
    this.emitln('}', level);
  }

  visitReturnBody(ast, level) {
    assert.equal(ast.type, 'returnBody');
    this.emit('\n');
    this.visitStmts(ast.stmts, false, level);
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
    if (_name(ast.functionName).endsWith('WithAsyncResponseHandler')) {
      this.emit(`<ReturnT> CompletableFuture<ReturnT>`);
      this.emit(` ${_name(ast.functionName)}`);
    } else {
      this.emit(`${_name(ast.functionName) === 'main' ? '' : ast.isAsync ? 'CompletableFuture<' : ''}`);
      if (ast.isAsync && (ast.returnType.lexeme === 'void' || ast.returnType.name === 'void')) {
        this.emit(`Void`);
      } else {
        this.visitType(ast.returnType);
      }
      this.emit(`${_name(ast.functionName) === 'main' ? '' : ast.isAsync ? '>' : ''}`);
      this.emit(` ${_name(ast.functionName)}`);
    }
    if (_name(ast.functionName) === 'main') {
      if (!ast.params.params || ast.params.params.length === 0) {
        throw new Error('static function main must have a argument');
      }
      this.emit(`(String[] ${_name(ast.params.params[0].paramName)}_)`);
    } else if (_name(ast.functionName).endsWith('WithAsyncResponseHandler')) {
      const params = JSON.parse(JSON.stringify(ast.params));
      params.params.pop();
      this.emit('(');
      this.visitPureParams(params, level);
      this.emit(`, AsyncResponseHandler<`);
      this.visitType(ast.returnType);
      this.emit(`, ReturnT> responseHandler)`);
    } else {
      this.visitParams(ast.params, level);
    }
    this.emitln(' {');
    if (ast.functionBody) {
      if (_name(ast.functionName) === 'main') {
        const args = _name(ast.params.params[0].paramName);
        this.emitln(`java.util.List<String> ${args} = java.util.Arrays.asList(${args}_);`, level + 1);
        this.visitFunctionBody(ast.functionBody, false, level + 1);
      } else {
        if (ast.isAsync) {
          this.emitln(`try {`, level + 1);
          this.visitFunctionBody(ast.functionBody, true, level + 2);
          this.emitln(`} catch (Exception e) {`, level + 1);
          this.emit(`CompletableFuture<`, level + 2);
          if (_name(ast.functionName).endsWith('WithAsyncResponseHandler')) {
            this.emit(`ReturnT`);
          } else if (ast.returnType.lexeme === 'void' || ast.returnType.name === 'void') {
            this.emit(`Void`);
          } else {
            this.visitType(ast.returnType);
          }
          this.emitln(`> future = new CompletableFuture<>();`);
          this.emitln(`future.completeExceptionally(e);`, level + 2);
          this.emitln(`return future;`, level + 2);
          this.emitln(`}`, level + 1);
        } else {
          this.visitFunctionBody(ast.functionBody, false, level + 1);
        }
      }
    }
    this.emitln('}', level);
  }

  visitFunctionBody(ast, isAsync, level) {
    assert.equal(ast.type, 'functionBody');
    this.visitStmts(ast.stmts, isAsync, level);
  }

  emitFooter(level) {
    this.emitln('}', level);
  }
}

module.exports = Generator;