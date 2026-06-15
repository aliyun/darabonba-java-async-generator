// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.models;

import darabonba.core.RequestModel;
import darabonba.core.TeaModel;

/**
 * <b>description</b> :
 * <p>TestModel</p>
 * 
 * {@link Test1} extends {@link TeaModel}
 *
 * <p>Test1</p>
 */
public class Test1 extends TeaModel {
    @com.aliyun.core.annotation.NameInMap("test")
    @com.aliyun.core.annotation.Validation(required = true)
    private String test;

    //model的test back comment
    @com.aliyun.core.annotation.NameInMap("test2")
    @Deprecated
    @com.aliyun.core.annotation.Validation(required = true)
    private String test2;

    //model的test2 back comment
    private Test1(Builder builder) {
        this.test = builder.test;
        this.test2 = builder.test2;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Test1 create() {
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

        private Builder(Test1 model) {
            this.test = model.test;
            this.test2 = model.test2;
        } 

        /**
         * <p>test desc</p>
         * 
         * <strong>check if is blank:</strong>
         * <p>false</p>
         * 
         * <strong>if can be null:</strong>
         * <p>false</p>
         * 
         * <strong>if sensitive:</strong>
         * <p>false</p>
         */
        public Builder test(String test) {
            this.test = test;
            return this;
        }

        /**
         * <p>test2 desc</p>
         * 
         * <strong>check if is blank:</strong>
         * <p>true</p>
         * 
         * <strong>if can be null:</strong>
         * <p>true</p>
         * 
         * <strong>if sensitive:</strong>
         * <p>true</p>
         */
        public Builder test2(String test2) {
            this.test2 = test2;
            return this;
        }

        public Test1 build() {
            return new Test1(this);
        } 

    } 

}
