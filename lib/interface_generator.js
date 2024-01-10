/* eslint-disable max-len */
'use strict';

// system modules
const CommonGenerator = require('./common_generator');
const { _name } = require('./util');

class Generator extends CommonGenerator {
  constructor(ast, ctx) {
    super(ast, ctx);
  }

  emitInterface(functions, apis, level = 0) {
    this.emitln(`// This file is auto-generated, don't edit it. Thanks.`, level);
    this.emitln(`package ${this.ctx.package};`, level);
    this.emitln();
    if (this.ctx.closable) {
      this.emitln(`import com.aliyun.core.utils.SdkAutoCloseable;`, level);
    }
    this.emitln(`import ${this.ctx.package}.models.*;`, level);
    if (this.ctx.extendsClass && this.ctx.config && this.ctx.config.signVersion === 'v3') {
      this.emitln(`import ${this.ctx.extendsClass.package + '.Configuration;'}`);
      this.emitln(`import ${this.ctx.extendsClass.package + '.auth.SignatureVersion;'}`);
    }
    this.emitln(`import darabonba.core.*;`, level);
    this.emitln(`import darabonba.core.async.*;`, level);
    this.emitln(`import darabonba.core.sync.*;`, level);
    this.emitln();
    this.emitln(`import java.util.concurrent.CompletableFuture;`, level);
    this.emitln();
    this.emitln(`public interface ${this.ctx.implements}${this.ctx.closable ? ' extends SdkAutoCloseable' : ''} {`, level);
    // this.emitApiInterface(apis, level + 1);
    this.emitln();
    this.emitBuilderMethod(level + 1);
    this.emitln();
    this.emitCreatorMethod(level + 1);
    this.emitFunctionInterface(functions, level + 1);
    this.emitln();
    this.emitln('}');
  }

  emitApiInterface(apis, level) {
    for (let i = 0; i < apis.length; i++) {
      this.emitln();
      this.visitAnnotation(apis[i].annotation, level);
      this.emit('', level);
      this.visitType(apis[i].returnType);
      this.emit(` ${_name(apis[i].apiName)}`);
      this.visitParams(apis[i].params, level);
      this.emitln(';');
    }
  }

  emitFunctionInterface(functions, level) {
    for (let i = 0; i < functions.length; i++) {
      if (_name(functions[i].functionName) === 'main') {
        continue;
      }
      if (this.ctx.closable && _name(functions[i].functionName) === 'close') {
        continue;
      }
      this.emitln();
      this.visitAnnotation(functions[i].annotation, level);
      if (_name(functions[i].functionName).endsWith('WithAsyncResponseHandler')) {
        this.emit(`<ReturnT> CompletableFuture<ReturnT>`);
      } else {
        this.emit(`${functions[i].isAsync ? 'CompletableFuture<' : ''}`, level);
        if (functions[i].isAsync && (functions[i].returnType.lexeme === 'void' || functions[i].returnType.name === 'void')) {
          this.emit(`Void`);
        } else {
          this.visitType(functions[i].returnType);
        }
        this.emit(`${functions[i].isAsync ? '>' : ''}`);
      }

      this.emit(` ${_name(functions[i].functionName)}`);
      if (_name(functions[i].functionName).endsWith('WithAsyncResponseHandler')) {
        const params = JSON.parse(JSON.stringify(functions[i].params));
        params.params.pop();
        this.emit('(');
        this.visitPureParams(params, level);
        this.emit(`, AsyncResponseHandler<`);
        this.visitType(functions[i].returnType);
        this.emit(`, ReturnT> responseHandler)`);
      } else {
        this.visitParams(functions[i].params, level);
      }

      this.emitln(';');
    }
  }

  emitBuilderMethod(level) {
    this.emitln(`static ${this.ctx.className}Builder builder() {`, level);
    if (this.ctx.config && this.ctx.config.signVersion === 'v3') {
      this.emitln(`return new ${this.ctx.className}Builder().serviceConfiguration(Configuration.create().setSignatureVersion(SignatureVersion.V3));`, level + 1);
    } else {
      this.emitln(`return new ${this.ctx.className}Builder();`, level + 1);
    }
    this.emitln(`}`, level);
  }

  emitCreatorMethod(level) {
    this.emitln(`static ${this.ctx.implements} create() {`, level);
    this.emitln(`return builder().build();`, level + 1);
    this.emitln(`}`, level);
  }

}

module.exports = Generator;
