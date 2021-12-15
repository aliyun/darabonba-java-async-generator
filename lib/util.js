'use strict';
const fs = require('fs');
const path = require('path');
const xml2js = require('xml2js');

function _name(str) {
  const keywords = ['default', 'abstract', 'assert',
    'break', 'case', 'catch', 'class', 'const',
    'continue', 'default', 'do', 'else', 'enum',
    'extends', 'final', 'finally', 'for', 'goto',
    'if', 'implements', 'import', 'instanceof',
    'interface', 'native', 'new', 'package',
    'private', 'protected', 'public', 'return',
    'strictfp', 'static', 'super', 'switch',
    'synchronized', 'this', 'throw', 'throws',
    'transient', 'try', 'volatile', 'while',
    'boolean', 'void', 'int', 'char', 'long',
    'short', 'byte', 'float', 'double',
    'true', 'false', 'null'];
  var name = str.lexeme || str.name;
  if (keywords.indexOf(name) > -1) {
    return '_' + name;
  }
  return name;
}

function _upperFirst(str) {
  return str[0].toUpperCase() + str.substring(1);
}

function _lowerFirst(str) {
  return str[0].toLowerCase() + str.substring(1);
}

function _subModelName(name, conflictModelNameMap, allModleNameMap) {
  if (!name) {
    return '';
  }
  if (allModleNameMap[name]) {
    return allModleNameMap[name];
  }
  var modelName = name.split('.').map((name) => _upperFirst(name)).join('');
  const names = name.split('.');
  const modelNameKey = names[0];
  if (!conflictModelNameMap[modelNameKey]) {
    conflictModelNameMap[modelNameKey] = [];
  }
  modelName = _upperFirst(names.pop());
  // while (names.length > 0 && conflictModelNameMap[modelNameKey] && conflictModelNameMap[modelNameKey].includes(modelName)) {
  //   modelName = _upperFirst(names.pop()) + modelName;
  // }
  // 不再对重复名称命名的接口进行生成
  if (conflictModelNameMap[modelNameKey] && conflictModelNameMap[modelNameKey].includes(modelName)) {
    throw new Error(`解析失败！API 定义存在问题，路径 ${name}，${modelNameKey} 下已包含该名称 ${modelName}，需要在接口元数据平台定义 SDK 别名`);
  }
  conflictModelNameMap[modelNameKey].push(modelName);
  allModleNameMap[name] = modelName;
  return modelName;
}

function _type(name) {
  if (name === 'number') {
    return 'Number';
  }

  if (name === 'integer' || name === 'int32') {
    return 'Integer';
  }

  if (name === 'readable') {
    return 'java.io.InputStream';
  }

  if (name === 'writeable') {
    return 'java.io.OutputStream';
  }

  if (name === 'long' | name === 'int64') {
    return 'Long';
  }

  if (name === 'float') {
    return 'Float';
  }

  if (name === 'double') {
    return 'Double';
  }

  if (name === 'object') {
    return 'java.util.Map<String, ?>';
  }

  if (name === 'string') {
    return 'String';
  }

  if (name === 'any') {
    return 'Object';
  }

  if (name === '$Request') {
    return 'TeaRequest';
  }

  if (name === '$Model') {
    return 'TeaModel';
  }

  if (name === 'bytes') {
    return 'byte[]';
  }

  if (name === 'boolean') {
    return 'Boolean';
  }

  if (name === 'array') {
    return 'List';
  }

  return name;
}

function remove(...filesPath) {
  filesPath.forEach(filePath => {
    if (fs.existsSync(filePath)) {
      if (fs.statSync(filePath).isDirectory()) {
        const files = fs.readdirSync(filePath);
        files.forEach((file, index) => {
          let curPath = path.join(filePath, file);
          if (fs.statSync(curPath).isDirectory()) {
            remove(curPath);
          } else {
            fs.unlinkSync(curPath);
          }
        });
        fs.rmdirSync(filePath);
      } else {
        fs.unlinkSync(filePath);
      }
    }
  });
}

function save(targetPath, content) {
  const dir = path.dirname(targetPath);
  if (!(fs.existsSync(dir))) {
    fs.mkdirSync(dir, {
      recursive: true
    });
  }
  fs.writeFileSync(targetPath, content);
}

function mkdir(target) {
  if (!(fs.existsSync(target))) {
    fs.mkdirSync(target, {
      recursive: true
    });
  }
}

function render(template, params = {}) {
  const needParamsKeys = ['description', 'url',
    'licenseName', 'developerId',
    'licenseUrl', 'developerName',
    'developerEmail', 'scmConnection',
    'scmDeveloperConnection', 'scmUrl', 'groupId',
    'artifactId', 'version'
  ];
  needParamsKeys.forEach(key => {
    if (params[key] === undefined) {
      params[key] = '';
    }
  });
  if (params) {
    Object.keys(params).forEach((key) => {
      template = template.split('${' + key + '}').join(params[key]);
    });
  }
  return template;
}

function getAttr(node, attrName) {
  for (let i = 0; i < node.attrs.length; i++) {
    if (_name(node.attrs[i].attrName) === attrName) {
      return node.attrs[i].attrValue.string || node.attrs[i].attrValue.lexeme || node.attrs[i].attrValue.value;
    }
  }
}

function getEnumAttr(node, attrName) {
  for (let i = 0; i < node.enumAttrs.length; i++) {
    if (_name(node.enumAttrs[i].attrName) === attrName) {
      return node.enumAttrs[i].attrValue.value.string || node.enumAttrs[i].attrValue.value.lexeme || node.enumAttrs[i].attrValue.value.value;
    }
  }
}

function parse(xml) {
  return new Promise((resolve, reject) => {
    xml2js.parseString(xml, function (err, result) {
      if (err) {
        return reject(err);
      }
      return resolve(result);
    });
  });
}

function avoidReserveName(name) {
  const reserves = [
    'public'
  ];

  if (reserves.indexOf(name) !== -1) {
    return `${name}_`;
  }

  return name;
}

function collectionType(name) {
  if (name === 'Object') {
    return '?';
  }
  return name;
}

module.exports = {
  _name, _type, _lowerFirst, _subModelName, remove, _upperFirst, save, mkdir, render, getAttr, parse, avoidReserveName, collectionType, getEnumAttr
};
