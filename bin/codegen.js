'use strict';

const path = require('path');

const generate = require('../lib/generator');

const [defPath, outputDir] = process.argv.slice(2);

function getOutputDir(outputDir) {
    if (outputDir) {
        return path.resolve(outputDir);
    }

    return path.join(path.dirname(defPath), 'output');
}

generate(path.resolve(defPath), {
    outputDir: getOutputDir(outputDir)
}).then(() => {

}, (err) => {
    console.log(err.stack);
});
