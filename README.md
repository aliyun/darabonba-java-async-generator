English | [简体中文](/README-CN.md)

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

# Darabonba Code Generator for Java

## Installation

Darabonba Code Generator was designed to work in Node.js. The preferred way to install the Generator is to use the [NPM](https://www.npmjs.com/) package manager. Simply type the following into a terminal window:
```shell
npm install @darabonba/java-async-generator
```

## Usage

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
  ...packageMeta,
  pkgDir: sourceDir,
  outputDir
};
let generator = new JavaGenerator(generatorConfig);

// generate Java code by generator
generator.visit(ast);
// The execution result will be output in the 'outputDir'
```

## Issues

[Opening an Issue](https://github.com/aliyun/darabonba-java-async-generator/issues/new/choose), Issues not conforming to the guidelines may be closed immediately.

## Changelog

Detailed changes for each release are documented in the [release notes](/CHANGELOG.md).

## License

[Apache-2.0](/LICENSE)
Copyright (c) 2009-present, Alibaba Cloud All rights reserved.
