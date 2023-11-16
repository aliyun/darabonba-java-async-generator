/* eslint-disable max-len */
'use strict';

const Emitter = require('@darabonba/emitter');
const assert = require('assert');
const DSL = require('@darabonba/parser');
const REQUEST = '_request';
const RESPONSE = '_response';

const { _name, _type, _lowerFirst, _subModelName, _upperFirst, avoidReserveName, collectionType } = require('./util');

class Generator extends Emitter {
  constructor(ast, ctx) {
    super('    ');
    this.ast = ast;
    this.ctx = ctx;
    this.ctx.predefined = this.ast.predefined;
  }

  emitNumber(ast, level) {
    this.emit(ast.value.value, level);
    if (ast.value.type === 'long') {
      this.emit('L');
    }
    if (ast.value.type === 'double') {
      this.emit('D');
    }
    if (ast.value.type === 'float') {
      this.emit('F');
    }
  }

  visitArray(ast, level) {
    assert.equal(ast.type, 'array');
    if (ast.items.length === 0) {
      this.emit('new java.util.ArrayList<>()');
      return;
    }

    this.emit('java.util.Arrays.asList(\n');
    for (let i = 0; i < ast.items.length; i++) {
      const item = ast.items[i];
      var comments = DSL.comment.getFrontComments(this.ctx.comments, item.tokenRange[0]);
      this.visitComments(comments, level + 1);
      this.emit('', level + 1);
      this.visitExpr(item, level + 1);
      if (i < ast.items.length - 1) {
        this.emit(',');
      }
      this.emit('\n');
    }
    this.emit(')', level);
  }

  visitIf(ast, level) {
    assert.equal(ast.type, 'if');
    this.emit('if (', level);
    this.visitExpr(ast.condition, level + 1);
    this.emit(') {\n');
    this.visitStmts(ast.stmts, level + 1);
    this.emit('}', level);
    if (ast.elseIfs) {
      for (let i = 0; i < ast.elseIfs.length; i++) {
        const branch = ast.elseIfs[i];
        this.emit(' else if (');
        this.visitExpr(branch.condition, level + 1);
        this.emit(') {\n');
        this.visitStmts(branch.stmts, level + 1);
        this.emit('}', level);
      }
    }

    if (ast.elseStmts) {
      this.emit(' else {\n');
      for (let i = 0; i < ast.elseStmts.stmts.length; i++) {
        this.visitStmt(ast.elseStmts.stmts[i], level + 1);
      }
      this.emit('}', level);
    }

    this.emit('\n');
    this.emit('\n');
  }

  visitAssign(ast, level) {
    var isCollection = false;
    if (ast.left.type === 'id') {
      this.emit(`${_name(ast.left.id)}`, level);
    } else if (ast.left.type === 'property_assign' || ast.left.type === 'property') {
      var id = _name(ast.left.id);
      if (id === '__request') {
        id = 'request_';
      }
      this.emit(`${id}`, level);
      for (var i = 0; i < ast.left.propertyPath.length; i++) {
        if ((i === ast.left.propertyPath.length - 1 && ast.left.propertyPathTypes[i - 1] && ast.left.propertyPathTypes[i - 1].type === 'map') ||
          (ast.left.id.inferred && ast.left.id.inferred.type === 'map')) {
          this.emit(`.put("${_name(ast.left.propertyPath[i])}", `);
          isCollection = true;
        } else {
          this.emit(`.${_name(ast.left.propertyPath[i])}`);
        }
      }
    } else if (ast.left.type === 'virtualVariable') {
      this.emit(`this.${_name(ast.left.vid).substr(1)}`, level);
    } else if (ast.left.type === 'variable') {
      this.emit(`${_name(ast.left.id)}`, level);
    } else if (ast.left.type === 'map_access') {
      isCollection = true;
      this.visitMapAccess(ast.left, false, level);
    } else if (ast.left.type === 'array_access') {
      isCollection = true;
      this.visitArrayAccess(ast.left, false, level);
    } else {
      throw new Error('unimpelemented');
    }
    if (!isCollection) {
      this.emit(' = ');
    }
    this.visitExpr(ast.expr, level);
    if (isCollection) {
      this.emit(')');
    }
    if (ast.expr.type === 'call' && ast.expr.isAsync) {
      this.emit(`.join()`);
    }
    this.emit(';\n');
  }

  visitExpr(ast, level) {
    if (ast.type === 'boolean') {
      this.emit(`${ast.value}`);
    } else if (ast.type === 'property_access') {
      this.visitPropertyAccess(ast, level);
    } else if (ast.type === 'string') {
      this.emit(`"${ast.value.string.replace(new RegExp('"', 'g'), '\\"')}"`);
    } else if (ast.type === 'null') {
      this.emit('null');
    } else if (ast.type === 'number') {
      this.emitNumber(ast);
    } else if (ast.type === 'object') {
      this.visitObject(ast, level);
    } else if (ast.type === 'variable') {
      var id = _name(ast.id);
      if (id === '__response') {
        this.emit(RESPONSE);
      } else if (id === '__request') {
        this.emit(REQUEST);
      } else if (ast.inferred && ast.inferred.name === 'class') {
        this.emit(avoidReserveName(id) + '.class');
      } else {
        this.emit(avoidReserveName(id));
      }
    } else if (ast.type === 'virtualVariable') {
      const vid = `${_lowerFirst(_name(ast.vid).substr(1))}`;
      this.emit(`${vid}`);
    } else if (ast.type === 'template_string') {
      for (let i = 0; i < ast.elements.length; i++) {
        var item = ast.elements[i];
        if (item.type === 'element') {
          this.emit('"');
          this.emit(item.value.string);
          this.emit('"');
        } else if (item.type === 'expr') {
          if (item.expr.type === 'property_access' && _name(item.expr.id) === '__module') {
            var value = this.__module;
            for (let i = 0; i < item.expr.propertyPath.length; i++) {
              value = value[_name(item.expr.propertyPath[i])];
            }
            this.emit('"');
            this.emit(value);
            this.emit('"');
          } else {
            this.visitExpr(item.expr, level);
          }
        } else {
          throw new Error('unimpelemented');
        }

        if (i < ast.elements.length - 1) {
          this.emit(' + ');
        }
      }
    } else if (ast.type === 'call') {
      this.visitCall(ast, level);
    } else if (ast.type === 'construct') {
      this.visitConstruct(ast, level);
    } else if (ast.type === 'array') {
      this.visitArray(ast, level);
    } else if (ast.type === 'and') {
      this.visitExpr(ast.left, level);
      this.emit(' && ');
      this.visitExpr(ast.right, level);
    } else if (ast.type === 'or') {
      this.visitExpr(ast.left, level);
      this.emit(' || ');
      this.visitExpr(ast.right, level);
    } else if (ast.type === 'null') {
      this.emit('null');
    } else if (ast.type === 'not') {
      this.emit('!');
      this.visitExpr(ast.expr, level);
    } else if (ast.type === 'construct_model') {
      this.visitConstructModel(ast, level);
    } else if (ast.type === 'super') {
      this.emit('super(');
      if (ast.args) {
        for (let i = 0; i < ast.args.length; i++) {
          if (i > 0) {
            this.emit(', ');
          }
          this.visitExpr(ast.args[i], level);
        }
      }
      this.emit(')');
    } else if (ast.type === 'map_access') {
      this.visitMapAccess(ast, true);
    } else if (ast.type === 'array_access') {
      this.visitArrayAccess(ast, true);
    } else {
      throw new Error('unimpelemented');
    }
  }

  visitCall(ast, level) {
    assert.equal(ast.type, 'call');
    if (ast.left.type === 'method_call') {
      this.visitMethodCall(ast, level);
    } else if (ast.left.type === 'instance_call') {
      this.visitInstanceCall(ast, level);
    } else if (ast.left.type === 'static_call') {
      this.visitStaticCall(ast, level);
    } else {
      throw new Error('unimplemented');
    }
  }

  visitStaticCall(ast, level) {
    assert.equal(ast.left.type, 'static_call');
    var className = this.ctx.imports[ast.left.id.lexeme].className || 'DefaultAsyncClient';
    this.emit(`${this.ctx.imports[ast.left.id.lexeme].package}.${className}.${_name(ast.left.propertyPath[0])}(`);
    for (let i = 0; i < ast.args.length; i++) {
      const expr = ast.args[i];
      if (expr.needCast) {
        this.emit('TeaModel.buildMap(');
      }
      this.visitExpr(expr, level);
      if (expr.needCast) {
        this.emit(')');
      }
      if (i !== ast.args.length - 1) {
        this.emit(', ');
      }
    }
    this.emit(')');
  }

  visitInstanceCall(ast, level) {
    assert.equal(ast.left.type, 'instance_call');
    const method = ast.left.propertyPath[0];
    var id = _name(ast.left.id);
    if (id.indexOf('@') > -1) {
      id = `this.${id.substr(1)}`;
    }
    this.emit(`${id}.${_name(method)}(`);
    for (let i = 0; i < ast.args.length; i++) {
      const expr = ast.args[i];
      this.visitExpr(expr, level);
      if (i !== ast.args.length - 1) {
        this.emit(', ');
      }
    }
    this.emit(')');
  }

  visitMethodCall(ast, level) {
    assert.equal(ast.left.type, 'method_call');
    if (ast.isStatic) {
      var className = this.ctx.className || 'DefaultAsyncClient';
      this.emit(`${className}.${_name(ast.left.id)}(`);
    } else {
      this.emit(`this.${_name(ast.left.id)}(`);
    }
    for (let i = 0; i < ast.args.length; i++) {
      const expr = ast.args[i];
      if (expr.needCast) {
        this.emit('TeaModel.buildMap(');
      }
      this.visitExpr(expr, level);
      if (expr.needCast) {
        this.emit(')');
      }
      if (i !== ast.args.length - 1) {
        this.emit(', ');
      }
    }
    this.emit(')');
  }

  visitDeclare(ast, level) {
    var id = _name(ast.id);
    this.emit(``, level);
    if (ast.expr.type === 'call' && ast.expr.isAsync) {
      this.emit(`CompletableFuture<`);
    }
    this.visitType(ast.expr.inferred);
    if (ast.expr.type === 'call' && ast.expr.isAsync) {
      this.emit(`> ${id}Future = `);
    } else {
      this.emit(` ${id} = `);
    }
    this.visitExpr(ast.expr, level);
    this.emit(';\n');
    if (ast.expr.type === 'call' && ast.expr.isAsync) {
      this.emit(``, level);
      this.visitType(ast.expr.inferred);
      this.emit(` ${id} = ${id}Future.join();\n`);
    }
  }

  visitComments(comments, level) {
    comments.forEach(comment => {
      this.emit(`${comment.value}`, level);
      this.emit(`\n`);
    });
  }

  visitStmts(ast, level) {
    assert.equal(ast.type, 'stmts');
    let node;
    for (var i = 0; i < ast.stmts.length; i++) {
      node = ast.stmts[i];
      this.visitStmt(node, level);
    }
    if (node) {
      //find the last node's back comment
      let comments = DSL.comment.getBackComments(this.ctx.comments, node.tokenRange[1]);
      this.visitComments(comments, level);
    }

    if (ast.stmts.length === 0) {
      //empty block's comment
      let comments = DSL.comment.getBetweenComments(this.ctx.comments, ast.tokenRange[0], ast.tokenRange[1]);
      this.visitComments(comments, level);
    }
  }

  visitConstruct(ast, level) {
    assert.equal(ast.type, 'construct');
    this.emit('new ');
    let className = this.ctx.imports[ast.inferred.name].className;
    let pathName = this.ctx.imports[ast.inferred.name].package;
    if (this.ctx.conflictModels.get(className) && this.ctx.conflictModels.get(className) !== pathName) {
      this.emit(`${pathName}.${className}`);
    } else {
      if (!this.ctx.conflictModels.get(className)) {
        this.ctx.conflictModels.set(className, pathName);
      }
      this.emit(className);
    }
    this.visitArgs(ast.args, level);
  }

  visitConstructModel(ast, level) {
    assert.equal(ast.type, 'construct_model');
    this.visitType(ast.inferred);
    this.emit(`.builder()`);
    if (ast.object && ast.object.fields && ast.object.fields.length > 0) {
      this.visitBuilderMethod(ast.object, level);
    }
    this.emit(`\n`);
    this.emit(`.build()`, level + 2);
  }

  visitArgs(args, level) {
    this.emit('(');
    for (let i = 0; i < args.length; i++) {
      const expr = args[i];
      this.visitExpr(expr, level);
      if (i !== args.length - 1) {
        this.emit(', ');
      }
    }
    this.emit(')');
  }

  visitArrayAccess(ast, isExpr, level) {
    assert.equal(ast.type, 'array_access');
    let expr = _name(ast.id);
    if (expr.indexOf('@') > -1) {
      expr = `this.${expr.substr(1)}`;
    }
    if (ast.propertyPath && ast.propertyPath.length) {
      var current = ast.id.inferred;
      for (var i = 0; i < ast.propertyPath.length; i++) {
        var name = _name(ast.propertyPath[i]);
        if (current.type === 'model') {
          expr += `.get${_upperFirst(name)}()`;
        } else {
          expr += `.get("${name}")`;
        }
        current = ast.propertyPathTypes[i];
      }
    }
    if (isExpr) {
      this.emit(`${expr}.get(`);
      this.visitExpr(ast.accessKey);
      this.emit(`)`);
    } else {
      this.emit(`${expr}.set(`, level);
      this.visitExpr(ast.accessKey);
      this.emit(', ');
    }
  }

  visitMapAccess(ast, isExpr, level) {
    assert.equal(ast.type, 'map_access');
    let expr = _name(ast.id);
    if (expr.indexOf('@') > -1) {
      expr = `this.${expr.substr(1)}`;
    }
    if (ast.propertyPath && ast.propertyPath.length) {
      var current = ast.id.inferred;
      for (var i = 0; i < ast.propertyPath.length; i++) {
        var name = _name(ast.propertyPath[i]);
        if (current.type === 'model') {
          expr += `.get${_upperFirst(name)}()`;
        } else {
          expr += `.get("${name}")`;
        }
        current = ast.propertyPathTypes[i];
      }
    }

    if (isExpr) {
      this.emit(`${expr}.get(`);
      this.visitExpr(ast.accessKey);
      this.emit(`)`);
    } else {
      this.emit(`${expr}.put(`, level);
      this.visitExpr(ast.accessKey);
      this.emit(`, `);
    }
  }

  visitPropertyAccess(ast) {
    assert.equal(ast.type, 'property_access');

    var id = _name(ast.id);
    var expr = '';
    if (id === '__response') {
      expr += RESPONSE;
    } else if (id === '__request') {
      expr += REQUEST;
    } else {
      expr += avoidReserveName(id);
    }
    var current = ast.id.inferred;
    for (var i = 0; i < ast.propertyPath.length; i++) {
      var name = _name(ast.propertyPath[i]);
      if (current.type === 'model') {
        expr += `.get${_upperFirst(name)}()`;
      } else {
        expr += `.get("${name}")`;
      }
      current = ast.propertyPathTypes[i];
    }

    this.emit(expr);
  }

  visitBuilderMethod(ast, level) {
    let classFieldName = '';
    for (let i = 0; i < ast.fields.length; i++) {
      classFieldName = _name(ast.fields[i].fieldName);
      this.emit('\n');
      let comments = DSL.comment.getFrontComments(this.ctx.comments, ast.fields[i].tokenRange[0]);
      this.visitComments(comments, level + 2);
      this.emit('', level + 2);
      this.emit(`.${classFieldName}(`);
      this.visitObjectFieldValue(ast.fields[i].expr, level + 2);
      this.emit(')');
    }
  }

  visitStmt(ast, level) {
    let comments = DSL.comment.getFrontComments(this.ctx.comments, ast.tokenRange[0]);
    this.visitComments(comments, level);
    if (ast.type === 'return') {
      this.visitReturn(ast, level);
    } else if (ast.type === 'if') {
      this.visitIf(ast, level);
    } else if (ast.type === 'throw') {
      this.visitThrow(ast, level);
    } else if (ast.type === 'assign') {
      this.visitAssign(ast, level);
    } else if (ast.type === 'retry') {
      this.visitRetry(ast, level);
    } else if (ast.type === 'break') {
      this.emit(`break;\n`, level);
    } else if (ast.type === 'declare') {
      this.visitDeclare(ast, level);
    } else if (ast.type === 'while') {
      this.visitWhile(ast, level);
    } else if (ast.type === 'for') {
      this.visitFor(ast, level);
    } else if (ast.type === 'try') {
      this.visitTry(ast, level);
    } else if (ast.type === 'yield') {
      this.emit(`_result.add(`, level);
      this.visitExpr(ast.expr, level);
      this.emit(`);\n`);
    } else {
      this.emit(``, level);
      this.visitExpr(ast, level);
      this.emit(';\n');
    }
  }

  visitReturn(ast, level) {
    assert.equal(ast.type, 'return');
    let property = '';
    if (ast.expr && ast.expr.left && ast.expr.left.propertyPath) {
      property = ast.expr.left.propertyPath.pop();
    }
    if (ast.needCast &&
      (_name(property) === '_do' || _name(property) === 'doAsyncRequestBody'
        || _name(property) === 'doRequestBody' || _name(property) === 'doResponseHandler')) {
      const args = ast.expr.args;
      this.emit(`TeaRequest teaRequest = REQUEST.copy()`, level);
      this.emit('.setStyle(RequestStyle.');
      this.emit(`${args[0].value.string.replace(new RegExp('"', 'g'), '\\"').toUpperCase()}`);
      this.emit(').setAction("');
      this.emit(`${args[1].value.string.replace(new RegExp('"', 'g'), '\\"')}`);
      this.emit('").setMethod(HttpMethod.');
      this.emit(`${args[2].value.string.replace(new RegExp('"', 'g'), '\\"').toUpperCase()}`);
      this.emit(').setPathRegex("');
      this.emit(`${args[3].value.string.replace(new RegExp('"', 'g'), '\\"')}`);
      this.emit('").setBodyType(BodyType.');
      this.emit(`${args[4].value.string.replace(new RegExp('"', 'g'), '\\"').toUpperCase()}`);
      this.emit(').setBodyIsForm(');
      this.emit(`${args[5].value}`);
      if (args[6].value.string && args[6].value.string !== '') {
        this.emit(').setReqBodyType(BodyType.');
        this.emit(`${args[6].value.string.replace(new RegExp('"', 'g'), '\\"').toUpperCase()}`);
      }
      this.emitln(`).formModel(${_name(args[7].id)});`);
      if (args[8] && _name(args[8].id) === 'requestBody') {
        this.emit(`ClientExecutionParams params = new ClientExecutionParams().withInput(${_name(args[7].id)}).withRequest(teaRequest).withRequestBody(${_name(args[8].id)}).withOutput(`, level);
      } else if (args[8] && _name(args[8].id) === 'responseHandler') {
        this.emit(`ClientExecutionParams params = new ClientExecutionParams().withInput(${_name(args[7].id)}).withRequest(teaRequest).withResponseHandler(${_name(args[8].id)}).withOutput(`, level);
      } else {
        this.emit(`ClientExecutionParams params = new ClientExecutionParams().withInput(${_name(args[7].id)}).withRequest(teaRequest).withOutput(`, level);
      }
      this.visitType(ast.expectedType);
      this.emitln('.create());');
      this.emit('return ', level);
      var id = _name(ast.expr.left.id);
      if (id.indexOf('@') > -1) {
        id = `this.${id.substr(1)}`;
      }
      if (_name(property) === 'doResponseHandler') {
        this.emitln(`${id}.execute(params)`);
        this.emit('        .thenCompose((output) -> CompletableFuture.completedFuture(responseHandler.transform((', level);
        this.visitType(ast.expectedType);
        this.emitln(')output)));');
      } else {
        this.emitln(`${id}.execute(params);`);
      }
      return;
    }
    this.emit('return ', level);
    if (!ast.expr) {
      this.emit(';\n');
      return;
    }
    this.visitExpr(ast.expr, level);
    this.emit(';\n');
  }

  visitWhile(ast, level) {
    assert.equal(ast.type, 'while');
    this.emit('\n');
    this.emit('while (', level);
    this.visitExpr(ast.condition, level + 1);
    this.emit(') {\n');
    this.visitStmts(ast.stmts, level + 1);
    this.emit('}\n', level);
  }

  visitFor(ast, level) {
    assert.equal(ast.type, 'for');
    if (ast.list.inferred.type === 'iterator') {
      this.emit(`ArrayList<`, level);
      this.visitType(ast.list.inferred.valueType);
      this.emit(`> _result = new ArrayList<`);
      this.visitType(ast.list.inferred.valueType);
      this.emit(`>();\n`);
    }
    this.emit(`for (`, level);
    this.visitType(ast.list.inferred.itemType || ast.list.inferred.valueType);
    this.emit(` ${_name(ast.id)} : `);
    this.visitExpr(ast.list, level + 1);
    this.emit(') {\n');
    this.visitStmts(ast.stmts, level + 1);
    this.emit('}\n', level);
  }

  visitTry(ast, level) {
    this.emit('try {\n', level);
    this.visitStmts(ast.tryBlock, level + 1);
    this.emit('}', level);
    if (ast.catchBlock && ast.catchBlock.stmts.length > 0) {
      let errorName = _name(ast.catchId);
      this.emit(` catch (TeaException ${errorName}) {\n`);
      this.visitStmts(ast.catchBlock, level + 1);
      this.emit(`} catch (Exception _${errorName}) {`, level);
      this.emit('\n');
      this.emit(`TeaException ${errorName} = new TeaException(_${errorName}.getMessage(), _${errorName});\n`, level + 1);
      this.visitStmts(ast.catchBlock, level + 1);
      this.emit('}', level);
    }

    if (ast.finallyBlock && ast.finallyBlock.stmts.length > 0) {
      this.emit(' finally {\n');
      this.visitStmts(ast.finallyBlock, level + 1);
      this.emit('}', level);
    }
    this.emit('\n', level);
  }

  visitParams(ast) {
    assert.equal(ast.type, 'params');
    this.emit('(');
    for (var i = 0; i < ast.params.length; i++) {
      if (i !== 0) {
        this.emit(', ');
      }
      const node = ast.params[i];
      assert.equal(node.type, 'param');
      this.visitType(node.paramType);
      this.emit(` ${avoidReserveName(_name(node.paramName))}`);
    }

    this.emit(')');
  }

  visitPureParams(ast) {
    assert.equal(ast.type, 'params');
    for (var i = 0; i < ast.params.length; i++) {
      if (i !== 0) {
        this.emit(', ');
      }
      const node = ast.params[i];
      assert.equal(node.type, 'param');
      this.visitType(node.paramType);
      this.emit(` ${avoidReserveName(_name(node.paramName))}`);
    }
  }

  getSubFieldClassName(className, hasModel) {
    if (className.indexOf('.') > 0) {
      var names = className.split('.');
      var name = '';
      if (hasModel) {
        name = names[0] + '.';
      }
      name += _subModelName(className, this.ctx.conflictModelNameMap, this.ctx.allModleNameMap);
      return name;
    }
    return className;
  }

  getSubModelClassName(names, index, currentName) {
    if (index < names.length) {
      names[index] = currentName + _upperFirst(names[index]);
      return this.getSubModelClassName(names, index + 1, names[index]);
    }
    return names.join('.');
  }

  visitAnnotation(annotation, level) {
    if (!annotation || !annotation.value) {
      return;
    }
    let comments = DSL.comment.getFrontComments(this.ctx.comments, annotation.index);
    this.visitComments(comments, level);
    annotation.value.split('\n').forEach((line) => {
      this.emit(`${line}`, level);
      this.emit(`\n`);
    });
  }

  visitObjectFieldValue(ast, level) {
    this.visitExpr(ast, level);
  }

  visitObjectField(ast, level) {
    let comments = DSL.comment.getFrontComments(this.ctx.comments, ast.tokenRange[0]);
    this.visitComments(comments, level);
    if (ast.type === 'objectField') {
      var key = _name(ast.fieldName);
      this.emit(`new TeaPair("${key}", `, level);
      this.visitObjectFieldValue(ast.expr, level);
    } else {
      throw new Error('unimpelemented');
    }
    this.emit(')');
  }

  visitObject(ast, level) {
    assert.equal(ast.type, 'object');
    if (ast.fields.length === 0) {
      this.emit('new java.util.HashMap<>()');
      return;
    }
    var hasExpandField = false;
    var hasNotExpandField = false;
    for (let i = 0; i < ast.fields.length; i++) {
      const field = ast.fields[i];
      if (field.type === 'expandField') {
        hasExpandField = true;
        break;
      } else {
        hasNotExpandField = true;
      }
    }

    if (!hasExpandField) {
      this.emit('CommonUtil.buildMap(\n');
      for (let i = 0; i < ast.fields.length; i++) {
        this.visitObjectField(ast.fields[i], level + 1);
        if (i < ast.fields.length - 1) {
          this.emit(',');
        }
        this.emit('\n');
      }
      this.emit(')', level);
      return;
    }

    var all = [];
    // 分段
    var current = [];
    for (let i = 0; i < ast.fields.length; i++) {
      const field = ast.fields[i];
      if (field.type === 'objectField') {
        current.push(field);
      } else {
        if (current.length > 0) {
          all.push(current);
        }
        all.push(field);
        current = [];
      }
    }

    if (current.length > 0) {
      all.push(current);
    }

    this.emit('CommonUtil.merge(');
    if (ast.inferred && ast.inferred.valueType.name === 'string') {
      this.emit('String.class');
    } else {
      this.emit('Object.class');
    }
    var hasExpandFieldBuildMap = false;
    if (hasExpandField && hasNotExpandField) {
      hasExpandFieldBuildMap = true;
      this.emit(',\n');
      this.emit('CommonUtil.buildMap(\n', level + 1);
    } else {
      this.emit(',\n');
    }

    for (let i = 0; i < all.length; i++) {
      const item = all[i];
      if (Array.isArray(item)) {
        for (var j = 0; j < item.length; j++) {
          this.visitObjectField(item[j], level + 2);
          if (item[j + 1]) {
            this.emit(',\n');
          } else {
            this.emit('\n');
          }
        }
      } else {
        this.emit('', level + 1);
        this.visitExpr(item.expr, level);
        if (all[i + 1]) {
          this.emit(',');
        }
        this.emit('\n');
      }
      if (hasExpandFieldBuildMap) {
        this.emit(')', level + 1);
        if (all[i + 1]) {
          this.emit(',\n');
        } else {
          this.emit('\n');
        }
        hasExpandFieldBuildMap = false;
      }
    }
    this.emit(')', level);
  }

  visitFieldType(value, node, modelName, useEnum) {
    if (value.fieldType === 'array') {
      // basic type
      this.emit(`java.util.List < `);
      if (value.fieldItemType.tag === 8) {
        this.emit(`${collectionType(_type(value.fieldItemType.lexeme))} `);
      } else if (value.fieldItemType.type === 'map') {
        this.visitType(value.fieldItemType);
      } else if (value.fieldItemType.fieldType === 'array') {
        this.visitFieldType(value.fieldItemType, node, modelName);
      } else {
        if (node.fieldValue.itemType) {
          this.emit(_subModelName(node.fieldValue.itemType, this.ctx.conflictModelNameMap, this.ctx.allModleNameMap));
        } else {
          this.emit(`${_name(node.fieldValue.fieldItemType)} `);
        }
      }
      this.emit(`> `);
    } else if (value.fieldType === 'map') {
      this.emit(`java.util.Map < ${collectionType(_type(value.keyType.lexeme))}, `);
      if (value.valueType.type) {
        this.visitType(value.valueType);
      } else {
        this.emit(`${collectionType(_type(value.valueType.lexeme))} `);
      }
      this.emit('> ');
    } else if (typeof value.fieldType === 'string') {
      this.emit(`${_type(value.fieldType)} `);
    } else if (value.fieldType) {
      if (value.fieldType.idType && value.fieldType.idType === 'module') {
        var className = this.ctx.imports[`${_type(value.fieldType.lexeme)}`].className || 'DefaultAsyncClient';
        this.emit(this.ctx.imports[`${_type(value.fieldType.lexeme)}`].package);
        this.emit(`.${className} `);
      } else if (value.fieldType.type && value.fieldType.type === 'moduleModel') {
        this.emit(this.ctx.imports[_name(value.fieldType.path[0])].package);
        this.emit(`.models.${_name(value.fieldType.path[1])} `);
      } else if (value.fieldType.idType && value.fieldType.idType === 'enum') {
        if (useEnum) {
          this.emit(`${_type(value.fieldType.lexeme)} `);
        } else {
          this.emit(`${_type(this.ctx.enumMap[value.fieldType.lexeme])} `);
        }
      } else {
        this.emit(`${_type(value.fieldType.lexeme)} `);
      }
    } else {
      this.emit(_subModelName([modelName, _name(node.fieldName)].join('.'), this.ctx.conflictModelNameMap, this.ctx.allModleNameMap));
      this.emit(' ');
    }
  }

  visitType(ast, isSubType = false) {
    if (ast.type === 'map') {
      this.emit(`java.util.Map<`);
      this.visitType(ast.keyType, true);
      this.emit(`, `);
      this.visitType(ast.valueType, true);
      this.emit(`>`);
    } else if (ast.type === 'array') {
      this.emit(`java.util.List<`);
      this.visitType(ast.subType || ast.itemType, true);
      this.emit(`>`);
    } else if (ast.type === 'model') {
      if (ast.moduleName) {
        const modelMap = `${ast.moduleName}:${_name(ast)}`;
        if (this.ctx.conflictModels.get(modelMap)) {
          this.emit(`${this.ctx.imports[ast.moduleName].package}.models.`);
        }
      } else {
        const modelMap = `${_name(ast)}`;
        if (this.ctx.conflictModels.get(modelMap)) {
          this.emit(`${this.ctx.package}.models.`);
        }
      }
      this.emit(`${_type(this.getSubFieldClassName(ast.name, true))}`);
    } else if (ast.type === 'subModel') {
      let className = '';
      for (let i = 0; i < ast.path.length; i++) {
        const item = ast.path[i];
        if (i > 0) {
          className += '.';
        }
        className += item.lexeme;
      }
      let resultName = this.getSubModelClassName(className.split('.'), 0, '');
      this.emit(resultName);
    } else if (ast.type === 'moduleModel') {
      const [moduleId, ...rest] = ast.path;
      let pathName = rest.map((item) => {
        return item.lexeme;
      }).join('.');
      let subModelName = '';
      if (rest.length > 1) {
        subModelName = `.${_subModelName(pathName, this.ctx.conflictModelNameMap, this.ctx.allModleNameMap)}`;
      }
      var modelName = rest[0].lexeme;
      var moduleName = moduleId.lexeme;
      var packageName = `${this.ctx.imports[moduleName].package}.models.`;
      const checkModel = moduleName + ':' + pathName;
      if (this.ctx.conflictModels.get(checkModel)) {
        this.emit(packageName + modelName + subModelName);
      } else {
        this.emit(modelName + subModelName);
      }
    } else if (ast.type === 'basic') {
      this.emit(_type(ast.name));
    } else if (this.ctx.predefined && this.ctx.predefined[`module:${_name(ast)}`]) {
      var className = this.ctx.imports[ast.lexeme || ast.name].className || 'DefaultAsyncClient';
      this.emit(`${this.ctx.imports[_name(ast)]}.${className}`);
    } else if (ast.idType === 'module') {
      let className = this.ctx.imports[ast.lexeme || ast.name].className;
      if (this.ctx.conflictModels.get(className) && this.ctx.conflictModels.get(className) !== this.ctx.imports[ast.lexeme].package) {
        this.emit(`${this.ctx.imports[ast.lexeme || ast.name].package}.${className}`);
      } else {
        if (!this.ctx.conflictModels.get(className)) {
          this.ctx.conflictModels.set(className, this.ctx.imports[ast.lexeme || ast.name].package);
        }
        this.emit(className);
      }
    } else if (ast.idType === 'model') {
      const modelMap = `${_name(ast)}`;
      if (this.ctx.conflictModels.get(modelMap)) {
        this.emit(`${this.ctx.package}.models.`);
      }
      this.emit(modelMap);
    } else if (ast.type === 'module_instance') {
      let className = this.ctx.imports[ast.lexeme || ast.name].className;
      if (this.ctx.conflictModels.get(className) && this.ctx.conflictModels.get(className) !== this.ctx.imports[ast.lexeme].package) {
        this.emit(`${this.ctx.imports[ast.lexeme || ast.name].package}.${className}`);
      } else {
        if (!this.ctx.conflictModels.get(className)) {
          this.ctx.conflictModels.set(className, this.ctx.imports[ast.lexeme || ast.name].package);
        }
        this.emit(className);
      }
    } else if (ast.type === 'iterator') {
      this.emit(`Iterable<${_type(ast.valueType.lexeme || ast.valueType.name)}>`);
    } else {
      if (isSubType) {
        this.emit(collectionType(_type(ast.lexeme || ast.name)));
      } else {
        this.emit(_type(ast.lexeme || ast.name));
      }
    }
  }

}

module.exports = Generator;