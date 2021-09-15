'use strict';

const assert = require('assert');
const DSL = require('@darabonba/parser');

const { _name, _type, getEnumAttr } = require('./util');
const CommonGenerator = require('./common_generator');

class Generator extends CommonGenerator {
  constructor(ast, ctx) {
    super(ast, ctx);
  }

  codegen(level = 0) {
    const enumType = _type(this.ast.enumType.lexeme);
    const enumName = this.ast.enumName.lexeme
    this.emitHeader(enumName, level);
    this.emitEnumBody(this.ast.enumBody, enumType, level + 1);
    this.emitConstructor(enumName, enumType, level + 1);
    this.emitln();
    this.emitGetters(enumType, level + 1);
    this.emitln();
    this.emitln('}', level);
  }

  emitHeader(enumName, level) {
    this.emitln(`// This file is auto-generated, don't edit it. Thanks.`, level);
    this.emitln(`package ${this.ctx.package}.models;`, level);
    this.emitln();
    this.emitln(`import com.aliyun.core.annotation.EnumType;`, level);
    this.emitln();
    this.emitln(`@EnumType`, level);
    this.emitln(`public enum ${enumName} {`, level);
    this.emitln();
  }

  emitEnumBody(ast, enumType, level) {
    assert.equal(ast.type, 'enumBody');
    let node;
    for (let i = 0; i < ast.nodes.length; i++) {
      node = ast.nodes[i];
      let comments = DSL.comment.getFrontComments(this.ctx.comments, node.tokenRange[0]);
      this.visitComments(comments, level);
      const fieldName = _name(node.fieldName);
      const value = getEnumAttr(node, 'value') || fieldName;
      const description = getEnumAttr(node, 'description');
      if (enumType === 'String') {
        this.emit(`${fieldName}("${value}"`, level);
      } else if (enumType === 'Number' || enumType === 'Integer') {
        this.emit(`${fieldName}(${value}`, level);
      } else if (enumType === 'Long') {
        this.emit(`${fieldName}(${value}L`, level);
      } else if (enumType === 'Float') {
        this.emit(`${fieldName}(${value}F`, level);
      } else if (enumType === 'Double') {
        this.emit(`${fieldName}(${value}D`, level);
      }
      this.emit(`, "${description}")`);
      this.emitln(`,`);
      this.emitln();
    }
    this.emitln(`UNKNOWN_VALUE(null, "UNKNOWN_VALUE");`, level);
    this.emitln();
    if (node) {
      //find the last node's back comment
      let comments = DSL.comment.getBetweenComments(this.ctx.comments, node.tokenRange[0], ast.tokenRange[1]);
      this.visitComments(comments, level);
    }

    if (ast.nodes.length === 0) {
      //empty block's comment
      let comments = DSL.comment.getBetweenComments(this.ctx.comments, ast.tokenRange[0], ast.tokenRange[1]);
      this.visitComments(comments, level);
    }
  }

  emitConstructor(enumName, enumType, level) {
    this.emitln(`private ${enumType} value;`, level);
    this.emitln(`private String  description;`, level);
    this.emitln();
    this.emitln(`${enumName}(${enumType} value, String description) {`, level);
    this.emitln(`this.value = value;`, level + 1);
    this.emitln(`this.description = description;`, level + 1);
    this.emitln(`}`, level);
  }

  emitGetters(enumType, level) {
    this.emit('public ', level);
    this.emitln(`${enumType} getValue() {`);
    this.emitln(`return this.value;`, level + 1);
    this.emitln('}', level);
    this.emitln();
    this.emit('public ', level);
    this.emitln(`String getDescription() {`);
    this.emitln(`return this.description;`, level + 1);
    this.emitln('}', level);
  }

}

module.exports = Generator;