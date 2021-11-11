'use strict';

// system modules
const fs = require('fs');
const path = require('path');
const xml2js = require('xml2js');
const Entities = require('html-entities').XmlEntities;
const assert = require('assert');

const { remove, save, render, parse } = require('./util');

// inner modules
const ClientGenerator = require('./client_generator');
const ModelGenerator = require('./model_generator');
const EnumGenerator = require('./enum_generator');

class Generator {
  constructor(option = {}) {
    const javaPackage = option && option.java && option.java.package;
    if (!javaPackage) {
      throw new Error(`Darafile -> java -> javaPackage should not empty, please add java option into Darafile.example:
        "java": {"package": "com.aliyun.test"}`);
    }
    this.exec = option.exec || option.java.exec;
    this.package = javaPackage;
    this.pomOutputDir = option.outputDir;
    this.packageInfo = option.java.packageInfo;
    this.baseClient = option && option.baseClient || javaPackage + '.Client';
    option.outputDir = path.join(option.outputDir, 'src/main/java', ...javaPackage.split('.'));
    this.outputDir = option.outputDir;
    this.conflictModelNameMap = {};
    this.allModleNameMap = {};
    if (option.java) {
      this.className = option.java.className || 'DefaultAsyncClient';
      this.implements = option.java.implements;
    }
    this.productId = option.productId;
    this.apiVersions = option.apiVersions;
    this.config = Object.assign({
      outputDir: '',
    }, option);
    remove(path.join(this.outputDir, 'models/'));
  }

  visit(ast, level = 0) {
    assert.equal(ast.type, 'module');
    this.comments = ast.comments;
    this.usedExternModel = ast.usedExternModel;
    this.conflictModels = ast.conflictModels;
    this.eachImport(ast.imports);
    this.visitPom();

    const models = ast.moduleBody.nodes.filter((item) => {
      return item.type === 'model';
    });

    const enums = ast.moduleBody.nodes.filter((item) => {
      return item.type === 'enum';
    });

    const baseModel = new ModelGenerator(ast, this);
    baseModel.codegenRequest();
    save(path.join(this.outputDir, 'models', 'Request.java'), baseModel.output);
    baseModel.output = '';
    baseModel.codegenResponse();
    save(path.join(this.outputDir, 'models', 'Response.java'), baseModel.output);
    // global definition
    let model;
    for (let i = 0; i < models.length; i++) {
      const modelName = models[i].modelName.lexeme;
      this.subModels = [];
      if (ast.models) {
        this.subModels = Object.keys(ast.models).filter((key) => {
          return key.startsWith(modelName + '.');
        }).map((key) => {
          return ast.models[key];
        });
      }
      // model generator
      model = new ModelGenerator(models[i], this);
      model.codegen();
      save(path.join(this.outputDir, 'models', `${modelName}.java`), model.output);
    }

    for (let i = 0; i < enums.length; i++) {
      const enumName = enums[i].enumName.lexeme;
      // enum generator
      const enum_generator = new EnumGenerator(enums[i], this);
      enum_generator.codegen();
      save(path.join(this.outputDir, 'models', `${enumName}.java`), enum_generator.output);
    }

    // client generator
    const client = new ClientGenerator(ast, this);
    client.codegen();
    save(path.join(this.outputDir, `${this.className}.java`), client.output);
  }

  async visitPom() {
    var entities = new Entities();
    var targetFile = path.join(this.pomOutputDir, 'pom.xml');
    let pomName = 'pom.xml';
    if (this.exec) {
      pomName = 'pomWithMain.xml';
    }
    var pomFile = fs.readFileSync(path.join(__dirname, '../template', pomName));
    var dependenciesClass = [];
    Object.keys(this.imports).forEach((key) => {
      if (this.imports[key].release.indexOf('com.aliyun:darabonba-java-core') === -1) {
        dependenciesClass.push(this.imports[key].release);
      }
    });
    const json = await parse(pomFile);
    json.project.dependencies = { dependency: [] };
    dependenciesClass.push('com.aliyun:darabonba-java-core:[0.0.1, 1.0.0)');
    dependenciesClass.forEach((value) => {
      if (value) {
        let dependency = value.split(':');
        var dependencyObject = {};
        dependencyObject.groupId = dependency[0];
        dependencyObject.artifactId = dependency[1];
        dependencyObject.version = dependency[2];
        json.project.dependencies.dependency.push(dependencyObject);
      }
    });
    const builder = new xml2js.Builder();
    let newPom = builder.buildObject(json);
    if (this.exec) {
      let mainClassPath = this.package + '.' + (this.className || 'DefaultAsyncClient');
      newPom = newPom.split('${mainClass}').join(mainClassPath);
    }
    newPom = render(newPom, this.packageInfo);
    save(targetFile, entities.decode(newPom));
  }

  eachImport(imports) {
    this.imports = {};
    if (imports.length === 0) {
      return;
    }
    if (!this.config.pkgDir) {
      throw new Error(`Must specific pkgDir when have imports`);
    }

    const lockPath = path.join(this.config.pkgDir, '.libraries.json');
    const lock = JSON.parse(fs.readFileSync(lockPath, 'utf8'));
    for (let i = 0; i < imports.length; i++) {
      const item = imports[i];
      const aliasId = item.lexeme;
      const moduleDir = this.config.libraries[aliasId];
      let targetPath = '';
      if (moduleDir.startsWith('./') || moduleDir.startsWith('../')) {
        targetPath = path.join(this.config.pkgDir, moduleDir);
      } else if (moduleDir.startsWith('/')) {
        targetPath = moduleDir;
      } else {
        targetPath = path.join(this.config.pkgDir, lock[moduleDir]);
      }
      const pkgPath = fs.existsSync(path.join(targetPath, 'Teafile')) ? path.join(targetPath, 'Teafile') : path.join(targetPath, 'Darafile');
      const pkg = JSON.parse(fs.readFileSync(pkgPath));
      const releaseJava = pkg.releases && pkg.releases.java;
      const javaPkg = pkg.java;
      if (!javaPkg) {
        throw new Error(`The '${aliasId}' has no Java supported.`);
      } else {
        javaPkg.release = releaseJava;
      }
      this.imports[aliasId] = javaPkg;
    }
  }

}

module.exports = Generator;
