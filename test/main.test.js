/* eslint-disable max-len */
'use strict';

const path = require('path');
const fs = require('fs');
const assert = require('assert');

const DSL = require('@darabonba/parser');

let Generator = require('../lib/generator');

function check(mainFilePath, outputDir, expectedPath, testPath = 'src/main/java/com/aliyun/oss20190517/DefaultAsyncClient.java', options = {}) {
  const generator = new Generator({
    outputDir,
    baseClient: 'com.aliyun.test.Client',
    package: 'com.aliyun.test',
    java: {},
    ...options
  });

  const dsl = fs.readFileSync(mainFilePath, 'utf8');
  const ast = DSL.parse(dsl, mainFilePath);
  generator.visit(ast);
  const clientPath = path.join(outputDir, testPath);
  const expected = fs.readFileSync(expectedPath, 'utf8');
  assert.deepStrictEqual(fs.readFileSync(clientPath, 'utf8'), expected);
}

describe('new Generator', function () {
  it('must pass in outputDir', function () {
    assert.throws(function () {
      new Generator({});
    }, function (err) {
      assert.deepStrictEqual(err.message,
        'Darafile -> java -> javaPackage should not empty, please add java option into Darafile.example:\n        "java": {"package": "com.aliyun.test"}');
      return true;
    });
  });

  it('function should ok', function () {
    const outputDir = path.join(__dirname, 'output/function');
    const mainFilePath = path.join(__dirname, 'fixtures/function/main.dara');
    const pkgContent = fs.readFileSync(path.join(__dirname, 'fixtures/function/Darafile'), 'utf8');
    const pkg = JSON.parse(pkgContent);
    check(mainFilePath, outputDir, path.join(__dirname, 'fixtures/function/DefaultAsyncClient.java'), 'src/main/java/com/aliyun/oss20190517/DefaultAsyncClient.java', {
      pkgDir: path.join(__dirname, 'fixtures/function'),
      baseClient: 'com.aliyun.oss20190517.AsyncClient',
      package: 'com.aliyun.oss20190517',
      ...pkg
    });
  });

  it('model should ok', function () {
    const outputDir = path.join(__dirname, 'output/model');
    const mainFilePath = path.join(__dirname, 'fixtures/model/main.dara');
    const pkgContent = fs.readFileSync(path.join(__dirname, 'fixtures/model/Darafile'), 'utf8');
    const pkg = JSON.parse(pkgContent);
    check(mainFilePath, outputDir, path.join(__dirname, 'fixtures/model/SelectObjectRequest.java'), 'src/main/java/com/aliyun/test/models/SelectObjectRequest.java', {
      pkgDir: path.join(__dirname, 'fixtures/model'),
      baseClient: 'com.aliyun.test.Client',
      package: 'com.aliyun.test',
      ...pkg
    });
  });

  it('enum should ok', function () {
    const outputDir = path.join(__dirname, 'output/enum');
    const mainFilePath = path.join(__dirname, 'fixtures/enum/main.dara');
    const pkgContent = fs.readFileSync(path.join(__dirname, 'fixtures/enum/Darafile'), 'utf8');
    const pkg = JSON.parse(pkgContent);
    check(mainFilePath, outputDir, path.join(__dirname, 'fixtures/enum/Integer.java'), 'src/main/java/com/aliyun/test/models/Integer.java', {
      pkgDir: path.join(__dirname, 'fixtures/enum'),
      baseClient: 'com.aliyun.test.Client',
      package: 'com.aliyun.test',
      ...pkg
    });
  });

  it('main should ok', function () {
    const outputDir = path.join(__dirname, 'output/main');
    const mainFilePath = path.join(__dirname, 'fixtures/main/main.dara');
    const pkgContent = fs.readFileSync(path.join(__dirname, 'fixtures/main/Darafile'), 'utf8');
    const pkg = JSON.parse(pkgContent);
    check(mainFilePath, outputDir, path.join(__dirname, 'fixtures/main/Client.java'), 'src/main/java/com/aliyun/main/Client.java', {
      pkgDir: path.join(__dirname, 'fixtures/main'),
      package: 'com.aliyun.main',
      ...pkg
    });
  });

  it('builder should ok', function () {
    const outputDir = path.join(__dirname, 'output/builder');
    const mainFilePath = path.join(__dirname, 'fixtures/builder/main.dara');
    const pkgContent = fs.readFileSync(path.join(__dirname, 'fixtures/builder/Darafile'), 'utf8');
    const pkg = JSON.parse(pkgContent);
    check(mainFilePath, outputDir, path.join(__dirname, 'fixtures/builder/DefaultAsyncClient.java'), 'src/main/java/com/aliyun/DefaultAsyncClient.java', {
      pkgDir: path.join(__dirname, 'fixtures/builder'),
      exec: true,
      ...pkg
    });
  });

  it('complex should ok', function () {
    const outputDir = path.join(__dirname, 'output/complex');
    const mainFilePath = path.join(__dirname, 'fixtures/complex/main.dara');
    const pkgContent = fs.readFileSync(path.join(__dirname, 'fixtures/complex/Darafile'), 'utf8');
    const pkg = JSON.parse(pkgContent);
    check(mainFilePath, outputDir, path.join(__dirname, 'fixtures/complex/NameTest.java'), 'src/main/java/com/aliyun/NameTest.java', {
      pkgDir: path.join(__dirname, 'fixtures/complex'),
      ...pkg
    });
    check(mainFilePath, outputDir, path.join(__dirname, 'fixtures/complex/ComplexRequest.java'), 'src/main/java/com/aliyun/models/ComplexRequest.java', {
      pkgDir: path.join(__dirname, 'fixtures/complex'),
      ...pkg
    });
    check(mainFilePath, outputDir, path.join(__dirname, 'fixtures/complex/ImplementsTest.java'), 'src/main/java/com/aliyun/ImplementsTest.java', {
      pkgDir: path.join(__dirname, 'fixtures/complex'),
      ...pkg
    });
  });

  it('iterator should ok', function () {
    const outputDir = path.join(__dirname, 'output/iterator');
    const mainFilePath = path.join(__dirname, 'fixtures/iterator/main.dara');
    const pkgContent = fs.readFileSync(path.join(__dirname, 'fixtures/iterator/Darafile'), 'utf8');
    const pkg = JSON.parse(pkgContent);
    check(mainFilePath, outputDir, path.join(__dirname, 'fixtures/iterator/Client.java'), 'src/main/java/com/aliyun/Client.java', {
      pkgDir: path.join(__dirname, 'fixtures/iterator'),
      exec: true,
      ...pkg
    });
  });

  // it('oss should ok', function () {
  //   const outputDir = path.join(__dirname, 'output/oss');
  //   const mainFilePath = path.join(__dirname, 'fixtures/oss/main.dara');
  //   const pkgContent = fs.readFileSync(path.join(__dirname, 'fixtures/oss/Darafile'), 'utf8');
  //   const pkg = JSON.parse(pkgContent);
  //   check(mainFilePath, outputDir, path.join(__dirname, 'fixtures/oss/DefaultAsyncClient.java'), 'src/main/java/com/aliyun/oss20190517/DefaultAsyncClient.java', {
  //     pkgDir: path.join(__dirname, 'fixtures/oss'),
  //     baseClient: 'com.aliyun.oss20190517.AsyncClient',
  //     package: 'com.aliyun.oss20190517',
  //     ...pkg
  //   });
  // });

  // it('sls should ok', function () {
  //   const outputDir = path.join(__dirname, 'output/sls');
  //   const mainFilePath = path.join(__dirname, 'fixtures/sls/main.dara');
  //   const pkgContent = fs.readFileSync(path.join(__dirname, 'fixtures/sls/Darafile'), 'utf8');
  //   const pkg = JSON.parse(pkgContent);
  //   check(mainFilePath, outputDir, path.join(__dirname, 'fixtures/sls/DefaultAsyncClient.java'), 'src/main/java/com/aliyun/sls20201230/DefaultAsyncClient.java', {
  //     pkgDir: path.join(__dirname, 'fixtures/sls'),
  //     baseClient: 'com.aliyun.sls20201230.AsyncClient',
  //     package: 'com.aliyun.sls20201230',
  //     ...pkg
  //   });
  // });

});