'use strict';

// system modules
const CommonGenerator = require('./common_generator');
const { _name } = require('./util');

class Generator extends CommonGenerator {
  constructor(ast, ctx) {
    super(ast, ctx);
  }

  emitInterface(functions, apis, level = 0) {
    this.emitln(`package ${this.ctx.package};`, level);
    this.emitln();
    this.emitln(`import ${this.ctx.package}.models.*;`, level);
    this.emitln();
    this.emitln(`import java.util.concurrent.CompletableFuture;`, level);
    this.emitln();
    this.emitln(`public interface ${this.ctx.implements} {`, level);
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
      this.emitln();
      this.visitAnnotation(functions[i].annotation, level);
      this.emit('CompletableFuture<', level);
      this.visitType(functions[i].returnType);
      this.emit('>');
      this.emit(` ${_name(functions[i].functionName)}`);
      this.visitParams(functions[i].params, level);
      this.emitln(';');
    }
  }

  emitBuilderMethod(level) {
    this.emitln(`static ${this.ctx.className}Builder builder() {`, level);
    this.emitln(`return new ${this.ctx.className}Builder();`, level + 1);
    this.emitln(`}`, level);
  }

  emitCreatorMethod(level) {
    this.emitln(`static ${this.ctx.implements} create() {`, level);
    this.emitln(`return builder().build();`, level + 1);
    this.emitln(`}`, level);
  }

}

module.exports = Generator;
