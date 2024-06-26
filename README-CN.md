[English](/README.md) | 简体中文

[![NPM version][npm-image]][npm-url]
![CI Build][action-url]
[![codecov][cov-image]][cov-url]
[![npm download][download-image]][download-url]

[npm-image]: https://img.shields.io/npm/v/@darabonba/java-async-generator.svg?style=flat-square
[npm-url]: https://npmjs.org/package/@darabonba/java-async-generator
[cov-image]: https://codecov.io/gh/aliyun/darabonba-java-async-generator/branch/master/graph/badge.svg
[cov-url]: https://codecov.io/gh/aliyun/darabonba-java-async-generator
[download-image]: https://img.shields.io/npm/dm/@darabonba/java-async-generator.svg?style=flat-square
[download-url]: https://npmjs.org/package/@darabonba/java-async-generator
[action-url]: https://github.com/aliyun/darabonba-java-async-generator/actions/workflows/ci.yml/badge.svg

# Darabonba Java 生成器

## 安装

Darabonba 生成器只能在 Node.js 环境下运行。建议使用 [NPM](https://www.npmjs.com/) 包管理工具安装。在终端输入以下命令进行安装:
```shell
npm install @darabonba/java-async-generator
```

## 使用示例

```js
'use strict';

const path = require('path');
const fs = require('fs');
const parser = require('@darabonba/parser');
const JavaGenerator = require('@darabonba/java-async-generator');

const sourceDir = "<Darabonda package directory>";
const outputDir = "<Generate output directory>";

// generate AST data by parser
let packageMetaFilePath = path.join(sourceDir, 'Darafile');
let packageMeta = JSON.parse(fs.readFileSync(packageMetaFilePath, 'utf8'));
let mainFile = path.join(sourceDir, packageMeta.main);
let ast = parser.parse(fs.readFileSync(mainFile, 'utf8'), mainFile);

// initialize generator
let generatorConfig = {
  ...darabonbaPackageMeta,
  pkgDir: sourceDir,
  outputDir
};
let generator = new JavaGenerator(generatorConfig);

// generate Java code by generator
generator.visit(ast);
// The execution result will be output in the 'outputDir'
```

## 问题反馈

[提出问题](https://github.com/aliyun/darabonba-java-async-generator/issues/new/choose), 不符合指南的问题可能会立即关闭。

## 发布日志

发布详情会更新在 [release notes](/CHANGELOG.md) 文件中

## 许可证

[Apache-2.0](/LICENSE)
Copyright (c) 2009-present, Alibaba Cloud All rights reserved.