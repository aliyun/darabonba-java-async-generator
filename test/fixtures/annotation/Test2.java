// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.models;

import darabonba.core.RequestModel;
import darabonba.core.TeaModel;

/**
 * <b>description</b> :
 * <p>TestModel2</p>
 * 
 * {@link Test2} extends {@link TeaModel}
 *
 * <p>Test2</p>
 */
public class Test2 extends TeaModel {
    // model的test front comment
    @com.aliyun.core.annotation.NameInMap("test")
    @com.aliyun.core.annotation.Validation(required = true)
    private String test;

    // model的test front comment
    @com.aliyun.core.annotation.NameInMap("test2")
    @com.aliyun.core.annotation.Validation(required = true)
    private String test2;

    private Test2(Builder builder) {
        this.test = builder.test;
        this.test2 = builder.test2;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Test2 create() {
        return builder().build();
    }

    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * @return test
     */
    public String getTest() {
        return this.test;
    }

    /**
     * @return test2
     */
    public String getTest2() {
        return this.test2;
    }

    public static final class Builder {
        private String test; 
        private String test2; 

        private Builder() {
        } 

        private Builder(Test2 model) {
            this.test = model.test;
            this.test2 = model.test2;
        } 

        /**
         * <p>test desc</p>
         */
        public Builder test(String test) {
            this.test = test;
            return this;
        }

        /**
         * <p>test2 desc</p>
         */
        public Builder test2(String test2) {
            this.test2 = test2;
            return this;
        }

        public Test2 build() {
            return new Test2(this);
        } 

    } 

}
