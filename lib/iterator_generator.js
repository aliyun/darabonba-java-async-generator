/* eslint-disable max-len */
'use strict';

const { _name, SSE } = require('./util');
const CommonGenerator = require('./common_generator');

class Generator extends CommonGenerator {
  constructor(ast, ctx) {
    super(ast, ctx);
  }

  codegen(level = 0) {
    const type = _name(this.ast.iteratorType);
    this.emitHeader(type, level);
    this.emitConstructor(type, level + 1);
    this.emitln();
    this.emitIteratorBody(this.ast.iteratorType, type, level + 1);
    this.emitln();
    this.emitln('}', level);
  }

  emitHeader(type, level) {
    this.emitln(`// This file is auto-generated, don't edit it. Thanks.`, level);
    this.emitln(`package ${this.ctx.package}.models;`, level);
    this.emitln();
    if (!this.ast.isStringType) {
      this.emitln(`import com.aliyun.core.utils.ParseUtil;`, level);
    }
    let extendIterator;
    if (this.ast.iteratorStyle === SSE) {
      this.emitln(`import darabonba.core.sse.SSEResponseIterator;`, level);
      extendIterator = 'SSEResponseIterator';
    } else {
      this.emitln(`import darabonba.core.ResponseIterator;`, level);
      extendIterator = 'ResponseIterator';
    }
    if (!this.ast.isStringType) {
      this.emitln(`import darabonba.core.TeaModel;`, level);
    }
    this.emitln(`import darabonba.core.utils.CommonUtil;`, level);
    this.emitln();
    this.emitln(`import java.util.*;`, level);
    this.emitln();
    const typeParam = this.ast.isStringType ? 'String' : type;
    this.emitln(`public class ${type}Iterator extends ${extendIterator}<${typeParam}> {`, level);
    this.emitln();
  }

  emitConstructor(type, level) {
    this.emitln(`${type}Iterator() {`, level);
    this.emitln(`}`, level);
    this.emitln();
    this.emitln(`public static ${type}Iterator create() {`, level);
    this.emitln(`return new ${type}Iterator();`, level + 1);
    this.emitln(`}`, level);
  }

  emitIteratorBody(ast, type, level) {
    const typeParam = this.ast.isStringType ? 'String' : type;
    this.emitln(`@Override`, level);
    this.emitln(`protected ${typeParam} toModel(String data) {`, level);
    if (this.ast.isStringType) {
      this.emitln(`return data;`, level + 1);
    } else if (ast.type === 'model') {
      this.emitln(`${type} result = ${type}.create();`, level + 1);
      this.emitln(`Map<String, Object> object = CommonUtil.assertAsMap(ParseUtil.parseJSON(data));`, level + 1);
      this.emitln(`TeaModel.toModel(object, result);`, level + 1);
      this.emitln(`return result;`, level + 1);
    } else {
      this.emitln(`return (${type}) TeaModel.confirmType(${type}.class, data);`, level + 1);
    }
    this.emitln(`}`, level);
  }

}

module.exports = Generator;