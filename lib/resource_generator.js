'use strict';

const Emitter = require('@darabonba/emitter');

class Generator extends Emitter {
  constructor(ctx) {
    super('    ');
    this.ctx = ctx;
  }

  codegen(level = 0) {
    this.emitHeader(level);
    this.emitln();
    this.emitBody(level + 1);
    this.emitln();
    this.emitln('}', level);
  }

  emitHeader(level) {
    this.emitln(`// This file is auto-generated, don't edit it. Thanks.`, level);
    this.emitln(`package ${this.ctx.package};`, level);
    this.emitln();
    this.emitln(`import java.util.ArrayList;`, level);
    this.emitln(`import java.util.List;`, level);
    this.emitln();
    this.emitln(`public final class Resource {`, level);
  }

  emitBody(level) {
    this.emitln(`public static final List<String> resourceList = new ArrayList();`, level);
    this.emitln();
    this.emitln(`static {`, level);
    for (let i = 0; i < this.ctx.resources.length; i++) {
      this.emitln(`resourceList.add("${this.ctx.resources[i]}");`, level + 1);
    }
    this.emitln(`}`, level);
  }

}

module.exports = Generator;