// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.models;

import darabonba.core.RequestModel;
import darabonba.core.TeaModel;

/**
 * @deprecated Test4 is deprecated, use Test3 instead.
 * 
 * {@link Test4} extends {@link TeaModel}
 *
 * <p>Test4</p>
 */
@Deprecated
public class Test4 extends TeaModel {
    @com.aliyun.core.annotation.NameInMap("test")
    @Deprecated
    @com.aliyun.core.annotation.Validation(required = true)
    private String test;

    @com.aliyun.core.annotation.NameInMap("test2")
    @com.aliyun.core.annotation.Validation(required = true)
    private String test2;

    private Test4(Builder builder) {
        this.test = builder.test;
        this.test2 = builder.test2;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Test4 create() {
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

        private Builder(Test4 model) {
            this.test = model.test;
            this.test2 = model.test2;
        } 

        /**
         * <p>The natural language that is used to filter responses. For more information, visit <a href="https://tools.ietf.org/html/rfc7231">RFC 7231</a>. Valid values:</p>
         * <ul>
         * <li>zh-CN: Chinese</li>
         * <li>en-US: English</li>
         * <li>ja: Japanese</li>
         * </ul>
         * <p>Default value: zh-CN.</p>
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

        public Test4 build() {
            return new Test4(this);
        } 

    } 

}
