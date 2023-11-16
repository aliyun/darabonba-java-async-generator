/* eslint-disable max-len */
'use strict';

const assert = require('assert');
const DSL = require('@darabonba/parser');

const { _name, _subModelName, getAttr, avoidReserveName, _upperFirst } = require('./util');
const CommonGenerator = require('./common_generator');

class BuilderGenerator extends CommonGenerator {
  constructor(ast, modelName, realModelName, ctx) {
    super(ast, ctx);
    this.modelName = modelName;
    this.realModelName = realModelName;
  }

  codegen(level = 0) {
    if (this.ctx.isResponseModel) {
      this.emitResponseBuilderInterface(this.ctx.extendsPackage, level);
      this.emitln();
      this.emitln(`private static final class BuilderImpl`, level);
      if (this.ctx.extendsPackage) {
        this.emitln(`        extends Response.BuilderImpl<${this.realModelName}, Builder>`, level);
      }
      this.emitln(`        implements Builder {`, level);
      this.emitFields(level + 1);
      this.emitln();
      this.emitResponseConstructor(level + 1);
    } else if (this.ctx.isRequestModel && this.ctx.extendsPackage) {
      this.emitln(`public static final class Builder extends Request.Builder<${this.realModelName}, Builder> {`, level);
      this.emitFields(level + 1);
      this.emitln();
      this.emitRequestConstructor(level + 1);
    } else {
      this.emitln(`public static final class Builder {`, level);
      this.emitFields(level + 1);
    }
    this.emitSetters(level + 1, this.ctx.isResponseModel && this.ctx.extendsPackage);
    this.emitln();
    this.emitBuildMethod(level + 1, (this.ctx.isRequestModel || this.ctx.isResponseModel) && this.ctx.extendsPackage);
    this.emitln();
    this.emitln(`} `, level);
  }

  emitResponseBuilderInterface(extendsPackage, level) {
    this.emitln(`public interface Builder ${extendsPackage ? 'extends Response.Builder<' + this.realModelName + ', Builder>' : ''} {`, level);
    for (let i = 0; i < this.ast.nodes.length; i++) {
      let node = this.ast.nodes[i];
      const value = node.fieldValue;
      const fieldName = avoidReserveName(_name(node.fieldName));
      this.emitln();
      this.emit(`Builder ${fieldName}(`, level + 1);
      this.visitFieldType(value, node, this.modelName);
      this.emitln(`${fieldName});`);

      if (value.fieldType && value.fieldType.idType && value.fieldType.idType === 'enum') {
        this.emitln();
        this.emit(`Builder ${fieldName}(`, level + 1);
        this.visitFieldType(value, node, this.modelName, true);
        this.emitln(`${fieldName});`);
      }
    }
    this.emitln();
    if (extendsPackage) {
      this.emitln(`@Override`, level + 1);
    }
    this.emitln(`${this.realModelName} build();`, level + 1);
    this.emitln();
    this.emitln(`} `, level);
  }

  emitFields(level) {
    assert.equal(this.ast.type, 'modelBody');
    for (let i = 0; i < this.ast.nodes.length; i++) {
      let node = this.ast.nodes[i];
      const value = node.fieldValue;
      this.emit('private ', level);
      this.visitFieldType(value, node, this.modelName);
      this.emitln(`${avoidReserveName(_name(node.fieldName))}; `);
    }
  }

  emitResponseConstructor(level) {
    assert.equal(this.ast.type, 'modelBody');
    this.emitln(`private BuilderImpl() {`, level);
    this.emitln(`super();`, level + 1);
    this.emitln(`} `, level);
    this.emitln();
    this.emitln(`private BuilderImpl(${this.realModelName} response) {`, level);
    this.emitln(`super(response);`, level + 1);
    for (let i = 0; i < this.ast.nodes.length; i++) {
      let node = this.ast.nodes[i];
      this.emitln(`this.${avoidReserveName(_name(node.fieldName))} = response.${avoidReserveName(_name(node.fieldName))};`, level + 1);
    }
    this.emitln(`} `, level);
  }

  emitRequestConstructor(level) {
    assert.equal(this.ast.type, 'modelBody');
    this.emitln(`private Builder() {`, level);
    this.emitln(`super();`, level + 1);
    this.emitln(`} `, level);
    this.emitln();
    this.emitln(`private Builder(${this.realModelName} request) {`, level);
    this.emitln(`super(request);`, level + 1);
    for (let i = 0; i < this.ast.nodes.length; i++) {
      let node = this.ast.nodes[i];
      this.emitln(`this.${avoidReserveName(_name(node.fieldName))} = request.${avoidReserveName(_name(node.fieldName))};`, level + 1);
    }
    this.emitln(`} `, level);
  }

  emitSetters(level, isOverride) {
    assert.equal(this.ast.type, 'modelBody');
    for (let i = 0; i < this.ast.nodes.length; i++) {
      let node = this.ast.nodes[i];
      const value = node.fieldValue;
      const fieldName = avoidReserveName(_name(node.fieldName));
      const realName = getAttr(node, 'name') || _name(node.fieldName);
      const position = getAttr(node, 'position');
      const shrink = getAttr(node, 'shrink');
      this.emitln();
      this.emitln('/**', level);
      if (this.ctx.descriptionMap[realName]) {
        for (let j = 0; j < this.ctx.descriptionMap[realName].length; j++) {
          if (j === 0) {
            this.emitln(` * ${this.ctx.descriptionMap[realName][j]}`, level);
            if (this.ctx.descriptionMap[realName].length > 1) {
              this.emitln(` * <p>`, level);
            }
          } else {
            this.emitln(` * ${this.ctx.descriptionMap[realName][j]}`, level);
          }
        }
      } else {
        this.emitln(` * ${realName}.`, level);
      }
      this.emitln(' */', level);
      if (isOverride) {
        this.emitln('@Override', level);
      }
      this.emit(`public Builder ${fieldName}(`, level);
      this.visitFieldType(value, node, this.modelName);
      this.emitln(`${fieldName}) {`);
      if (position) {
        let pos = position.split(',');
        for (let i = 0; i < pos.length; i++) {
          if (shrink) {
            this.emitln(`String ${fieldName}Shrink = shrink(${fieldName}, "${realName}", "${shrink}");`, level + 1);
            this.emitln(`this.put${pos[i]}Parameter("${realName}", ${fieldName}Shrink);`, level + 1);
          } else {
            this.emitln(`this.put${pos[i]}Parameter("${realName}", ${fieldName});`, level + 1);
          }
        }
      }
      this.emitln(`this.${fieldName} = ${fieldName};`, level + 1);
      this.emitln(`return this;`, level + 1);
      this.emitln(`}`, level);

      if (value.fieldType && value.fieldType.idType && value.fieldType.idType === 'enum') {
        this.emitln();
        this.emitln('/**', level);
        if (this.ctx.descriptionMap[realName]) {
          for (let j = 0; j < this.ctx.descriptionMap[realName].length; j++) {
            if (j === 0) {
              this.emitln(` * ${this.ctx.descriptionMap[realName][j]}`, level);
              if (this.ctx.descriptionMap[realName].length > 1) {
                this.emitln(` * <p>`, level);
              }
            } else {
              this.emitln(` * ${this.ctx.descriptionMap[realName][j]}`, level);
            }
          }
        } else {
          this.emitln(` * ${realName}.`, level);
        }
        this.emitln(' */', level);
        if (isOverride) {
          this.emitln('@Override', level);
        }
        this.emit(`public Builder ${fieldName}(`, level);
        this.visitFieldType(value, node, this.modelName, true);
        this.emitln(`${fieldName}) {`);
        if (position) {
          this.emitln(`this.put${position}Parameter("${realName}", ${fieldName}.getValue());`, level + 1);
        }
        this.emitln(`this.${fieldName} = ${fieldName}.getValue();`, level + 1);
        this.emitln(`return this;`, level + 1);
        this.emitln(`}`, level);
      }
    }
  }

  emitBuildMethod(level, isOverride) {
    if (isOverride) {
      this.emitln('@Override', level);
    }
    this.emitln(`public ${this.realModelName} build() {`, level);
    this.emitln(`return new ${this.realModelName}(this);`, level + 1);
    this.emitln(`} `, level);
  }
}

class Generator extends CommonGenerator {
  constructor(ast, ctx) {
    super(ast, ctx);
    this.ctx.descriptionMap = {};
  }

  codegen(level = 0) {
    this.emitHeader(level);
    this.eachModel(level);
    for (let i = 0; i < this.ctx.subModels.length; i++) {
      this.eachSubModel(this.ctx.subModels[i], level + 1);
    }
    this.emitln('}', level);
  }

  codegenRequest(level = 0) {
    this.emitln(`// This file is auto-generated, don't edit it. Thanks.`, level);
    this.emitln(`package ${this.ctx.package}.models;`, level);
    this.emitln();
    this.emitln(`import darabonba.core.RequestModel;`, level);
    this.emitln();
    this.emitln(`public class Request extends RequestModel {`, level);
    this.emitln();
    this.emitln(`protected Request(Builder builder) {`, level + 1);
    this.emitln(`super(builder);`, level + 2);
    this.emitln(`}`, level + 1);
    this.emitln();
    this.emitln(`}`, level);
  }

  codegenResponse(level = 0) {
    this.emitln(`// This file is auto-generated, don't edit it. Thanks.`, level);
    this.emitln(`package ${this.ctx.package}.models;`, level);
    this.emitln();
    this.emitln(`import darabonba.core.TeaModel;`, level);
    this.emitln();
    this.emitln(`public class Response extends TeaModel {`, level);
    this.emitln();
    this.emitln(`protected Response(Builder builder) {`, level + 1);
    this.emitln(`}`, level + 1);
    this.emitln();
    this.emitln(`public Builder toBuilder() {`, level + 1);
    this.emitln(`return new Builder(this);`, level + 2);
    this.emitln(`}`, level + 1);
    this.emitln();
    this.emitln(`protected static class Builder {`, level + 1);
    this.emitln();
    this.emitln(`protected Builder() {`, level + 2);
    this.emitln(`}`, level + 2);
    this.emitln();
    this.emitln(`protected Builder(Response response) {`, level + 2);
    this.emitln(`}`, level + 2);
    this.emitln();
    this.emitln(`}`, level + 1);
    this.emitln();
    this.emitln(`}`, level);
  }

  emitHeader(level) {
    this.emitln(`// This file is auto-generated, don't edit it. Thanks.`, level);
    this.emitln(`package ${this.ctx.package}.models;`, level);
    this.emitln();
    this.emitln(`import com.aliyun.core.annotation.*;`, level);
    this.emitln(`import darabonba.core.RequestModel;`, level);
    this.emitln(`import darabonba.core.TeaModel;`, level);
    if (this.ctx.extendsPackage) {
      this.emitln(`import ${this.ctx.extendsPackage}.models.*;`, level);
    }
    this.emitln();
  }

  eachModel(level) {
    assert.equal(this.ast.type, 'model');
    const modelName = _name(this.ast.modelName);
    this.ctx.isRequestModel = modelName.endsWith('Request');
    this.ctx.isResponseModel = modelName.endsWith('Response');
    this.visitAnnotation(this.ast.annotation, level);
    this.emitln(`/**`, level);
    this.emitln(` * {@link ${this.ast.title ? this.ast.title : modelName}} extends {@link ${this.ctx.isRequestModel ? 'RequestModel' : 'TeaModel'}}`, level);
    this.emitln(` *`, level);
    this.emitln(` * <p>${this.ast.title ? this.ast.title : modelName}</p>`, level);
    this.emitln(` */`, level);
    const realModelName = _subModelName(modelName, this.ctx.conflictModelNameMap, this.ctx.allModleNameMap);
    this.emitln(`public class ${realModelName} extends ${this.ctx.isRequestModel && this.ctx.extendsPackage ? 'Request' : this.ctx.isResponseModel && this.ctx.extendsPackage ? 'Response' : 'TeaModel'} {`, level);
    this.emitModelBody(this.ast.modelBody, modelName, level + 1);
    this.emitConstructor(this.ast.modelBody, realModelName, this.ctx.isResponseModel, (this.ctx.isRequestModel || this.ctx.isResponseModel) && this.ctx.extendsPackage, level + 1);
    if (!this.ctx.isResponseModel) {
      this.emitln();
      this.emitBuilderMethod(level + 1);
    }
    this.emitln();
    this.emitCreatorMethod(realModelName, this.ctx.isResponseModel, level + 1);
    if ((this.ctx.isRequestModel || this.ctx.isResponseModel) && this.ctx.extendsPackage) {
      this.emitln();
      this.emitToBuilderMethod(this.ctx.isResponseModel, level + 1);
    }
    this.emitGetters(this.ast.modelBody, modelName, level + 1);
    this.emitln();
    this.emitBuilderClass(this.ast.modelBody, modelName, realModelName, level + 1);
  }

  eachSubModel(ast, level) {
    assert.equal(ast.type, 'model');
    const modelName = _name(ast.modelName);
    this.ctx.isRequestModel = false;
    this.ctx.isResponseModel = false;
    this.visitAnnotation(ast.annotation, level);
    const realModelName = _subModelName(modelName, this.ctx.conflictModelNameMap, this.ctx.allModleNameMap);
    this.emit(`public static class ${realModelName} extends TeaModel {\n`, level);
    this.emitModelBody(ast.modelBody, modelName, level + 1);
    this.emitConstructor(ast.modelBody, realModelName, false, false, level + 1);
    this.emitln();
    this.emitBuilderMethod(level + 1);
    this.emitln();
    this.emitCreatorMethod(realModelName, false, level + 1);
    this.emitGetters(ast.modelBody, modelName, level + 1);
    this.emitln();
    this.emitBuilderClass(ast.modelBody, modelName, realModelName, level + 1);
    this.emitln('}', level);
  }

  emitModelBody(ast, modelName, level) {
    assert.equal(ast.type, 'modelBody');
    let node;
    for (let i = 0; i < ast.nodes.length; i++) {
      node = ast.nodes[i];
      let comments = DSL.comment.getFrontComments(this.ctx.comments, node.tokenRange[0]);
      this.visitComments(comments, level);
      const value = node.fieldValue;
      const realName = getAttr(node, 'name') || _name(node.fieldName);
      const description = getAttr(node, 'description');
      const position = getAttr(node, 'position');
      const pattern = getAttr(node, 'pattern') || '';
      const maxLength = getAttr(node, 'maxLength') || 0;
      const minLength = getAttr(node, 'minLength') || 0;
      const maximum = getAttr(node, 'maximum') || 0;
      const minimum = getAttr(node, 'minimum') || 0;
      const required = node.required || false;
      const deprecated = getAttr(node, 'deprecated');
      const parentIgnore = getAttr(node, 'parentIgnore');
      if (description) {
        this.ctx.descriptionMap[realName] = description.split('\n');
      }
      if (position) {
        let pos = position.split(',');
        for (let i = 0; i < pos.length; i++) {
          this.emitln(`@${pos[i]}`, level);
        }
      }
      if (parentIgnore) {
        this.emitln(`@ParentIgnore("${parentIgnore}")`, level);
      }
      this.emitln(`@NameInMap("${realName}")`, level);
      if (deprecated === 'true') {
        this.emitln(`@Deprecated`, level);
      }
      if (required || maxLength > 0 || maximum > 0 || pattern !== '') {
        var validationAnnotation = '@Validation(';
        if (required) {
          validationAnnotation += `required = ${required}`;
        }
        if (pattern !== '') {
          if (!validationAnnotation.endsWith('(')) {
            validationAnnotation += ', ';
          }
          validationAnnotation += `pattern = "${pattern}"`;
        }
        // 不能超过Java中Integer最大值
        if (maxLength > 0 && maxLength <= 2147483647) {
          if (!validationAnnotation.endsWith('(')) {
            validationAnnotation += ', ';
          }
          validationAnnotation += `maxLength = ${maxLength}`;
        }
        // 不能超过Java中Integer最大值
        if (minLength > 0 && minLength <= 2147483647) {
          if (!validationAnnotation.endsWith('(')) {
            validationAnnotation += ', ';
          }
          validationAnnotation += `minLength = ${minLength}`;
        }
        // 不能超过JS中最大安全整数
        if (maximum > 0 && maximum <= Number.MAX_SAFE_INTEGER) {
          if (!validationAnnotation.endsWith('(')) {
            validationAnnotation += ', ';
          }
          validationAnnotation += `maximum = ${maximum}`;
          if (maximum > 2147483647) {
            validationAnnotation += 'D';
          }
        }
        // 不能超过JS中最大安全整数
        if (minimum > 0 && minimum <= Number.MAX_SAFE_INTEGER) {
          if (!validationAnnotation.endsWith('(')) {
            validationAnnotation += ', ';
          }
          validationAnnotation += `minimum = ${minimum}`;
          if (minimum > 2147483647) {
            validationAnnotation += 'D';
          }
        }
        this.emit(validationAnnotation, level);
        this.emitln(')');
      }
      this.emit('private ', level);
      this.visitFieldType(value, node, modelName);
      this.emitln(`${avoidReserveName(_name(node.fieldName))};`);
      this.emitln();
    }
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

  emitConstructor(ast, modelName, isResponseModel, isExtendModel, level) {
    assert.equal(ast.type, 'modelBody');
    this.emitln(`private ${modelName}(${isResponseModel ? 'BuilderImpl' : 'Builder'} builder) {`, level);
    if (isExtendModel) {
      this.emitln(`super(builder);`, level + 1);
    }
    for (let i = 0; i < ast.nodes.length; i++) {
      let node = ast.nodes[i];
      this.emitln(`this.${avoidReserveName(_name(node.fieldName))} = builder.${avoidReserveName(_name(node.fieldName))};`, level + 1);
    }
    this.emitln(`}`, level);
  }

  emitBuilderMethod(level) {
    this.emitln(`public static Builder builder() {`, level);
    this.emitln(`return new Builder();`, level + 1);
    this.emitln(`}`, level);
  }

  emitCreatorMethod(modelName, isResponseModel, level) {
    this.emitln(`public static ${modelName} create() {`, level);
    if (isResponseModel) {
      this.emitln(`return new BuilderImpl().build();`, level + 1);
    } else {
      this.emitln(`return builder().build();`, level + 1);
    }
    this.emitln(`}`, level);
  }

  emitToBuilderMethod(isResponseModel, level) {
    this.emitln(`@Override`, level);
    this.emitln(`public Builder toBuilder() {`, level);
    if (isResponseModel) {
      this.emitln(`return new BuilderImpl(this);`, level + 1);
    } else {
      this.emitln(`return new Builder(this);`, level + 1);
    }
    this.emitln(`}`, level);
  }

  emitGetters(ast, modelName, level) {
    assert.equal(ast.type, 'modelBody');
    for (let i = 0; i < ast.nodes.length; i++) {
      let node = ast.nodes[i];
      const value = node.fieldValue;
      const fieldName = avoidReserveName(_name(node.fieldName));
      this.emitln();
      this.emitln(`/**`, level);
      this.emitln(` * @return ${fieldName}`, level);
      this.emitln(` */`, level);
      this.emit('public ', level);
      this.visitFieldType(value, node, modelName);
      this.emitln(`get${_upperFirst(fieldName)}() {`);
      this.emitln(`return this.${fieldName};`, level + 1);
      this.emitln('}', level);
    }
  }

  emitBuilderClass(ast, modelName, realModelName, level) {
    const generator = new BuilderGenerator(ast, modelName, realModelName, this.ctx);
    generator.codegen(level);
    this.emitln(generator.output);
  }

}

module.exports = Generator;