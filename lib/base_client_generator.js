'use strict';

const Emitter = require('@darabonba/emitter');
const path = require('path');
const { save } = require('./util');

// system modules
const CommonGenerator = require('./common_generator');

class ConfigurationGenerator extends Emitter {
  constructor(ast, ctx) {
    super('    ');
    this.ast = ast;
    this.ctx = ctx;
  }

  codegen(level = 0) {
    this.emitln(`// This file is auto-generated, don't edit it. Thanks.`, level);
    this.emitln(`package ${this.ctx.package};`, level);
    this.emitln();
    this.emitln(`import darabonba.core.ServiceConfiguration;`, level);
    this.emitln();
    this.emitln(`/**`, level);
    this.emitln(` * <p>${this.ctx.description ? this.ctx.description : 'Base Configuration'}.</p>`, level);
    this.emitln(` * <p>Can be overwritten by handwriting here.</p>`, level);
    this.emitln(` */`, level);
    this.emitln(`public final class Configuration implements ServiceConfiguration {`, level);
    this.emitln();
    this.emitln('private Configuration() {', level + 1);
    this.emitln('}', level + 1);
    this.emitln();
    this.emitln(`public static Configuration create() {`, level + 1);
    this.emitln(`return new Configuration();`, level + 2);
    this.emitln(`}`, level + 1);
    this.emitln();
    this.emitln('}', level);
  }
}

class Generator extends CommonGenerator {
  constructor(ast, ctx) {
    super(ast, ctx);
  }

  codegen(level = 0) {
    this.emitHeader(level);
    this.emitln();
    this.emitServiceName(level + 1);
    this.emitln();
    this.emitServiceConfiguration(level + 1);
    this.emitln();
    this.emitln('}');
    this.emitConfiguration(level);
  }

  emitHeader(level) {
    this.emitln(`// This file is auto-generated, don't edit it. Thanks.`, level);
    this.emitln(`package ${this.ctx.package};`, level);
    this.emitln();
    this.emitln(`import darabonba.core.*;`, level);
    this.emitln(`import darabonba.core.client.*;`, level);
    this.emitln(`import darabonba.core.interceptor.*;`, level);
    this.emitln();
    this.emitln(`/**`, level);
    this.emitln(` * <p>${this.ctx.description ? this.ctx.description : 'Base client'}.</p>`, level);
    this.emitln(` * <p>Can be overwritten by handwriting here.</p>`, level);
    this.emitln(` */`, level);
    this.emitln(`public abstract class BaseClientBuilder<BuilderT extends IClientBuilder<BuilderT, ClientT>, ClientT> extends TeaClientBuilder<BuilderT, ClientT> {`, level);
  }

  emitServiceName(level) {
    this.emitln('@Override', level);
    this.emitln(`protected String serviceName() {`, level);
    this.emitln(`return "${this.ctx.productId}";`, level + 1);
    this.emitln(`}`, level);
  }

  emitServiceConfiguration(level) {
    this.emitln(`BuilderT serviceConfiguration(Configuration serviceConfiguration) {`, level);
    this.emitln('clientConfiguration.setOption(ClientOption.SERVICE_CONFIGURATION, serviceConfiguration);', level + 1);
    this.emitln('return (BuilderT) this;', level + 1);
    this.emitln(`}`, level);
  }

  emitConfiguration(level) {
    const configuration = new ConfigurationGenerator(this.ast, this.ctx);
    configuration.codegen(level);
    save(path.join(this.ctx.outputDir, `Configuration.java`), configuration.output);
  }

}

module.exports = Generator;
