// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.models;

import com.aliyun.core.annotation.*;
import darabonba.core.RequestModel;
import darabonba.core.TeaModel;

/**
 * {@link ComplexRequest} extends {@link RequestModel}
 *
 * <p>ComplexRequest</p>
 */
public class ComplexRequest extends TeaModel {
    @NameInMap("accessKey")
    @Validation(required = true)
    private String accessKey;

    @NameInMap("moduleModelMap")
    @Validation(required = true)
    private java.util.Map < String, Request> moduleModelMap;

    @NameInMap("subModelMap")
    @Validation(required = true)
    private java.util.Map < String, Config.ConfigSubM> subModelMap;

    @NameInMap("complexList")
    @Validation(required = true)
    private java.util.List < java.util.List < java.util.Map<String, String>> > complexList;

    @NameInMap("complexList2")
    @Validation(required = true)
    private java.util.List < ComplexList1> complexList1;

    @NameInMap("complexList2")
    @Validation(required = true)
    private java.util.List < java.util.List < java.util.List < ComplexList2> > > complexList2;

    @NameInMap("complexList3")
    @Validation(required = true)
    private java.util.List < java.util.List < java.util.List < undefined > > > complexList3;

    @NameInMap("Body")
    @Validation(required = true)
    private java.io.InputStream body;

    @NameInMap("UserPsssrivileges")
    private java.util.Map < String, java.util.List<java.util.Map<String, String>>> userTest;

    @NameInMap("Strs")
    @Validation(required = true)
    private java.util.List < String > strs;

    @NameInMap("header")
    @Validation(required = true)
    private ComplexRequestHeader header;

    @NameInMap("num")
    @Validation(required = true)
    private Number num;

    @NameInMap("client")
    @Validation(required = true)
    private com.import.DefaultAsyncClient client;

    @NameInMap("configs")
    @Validation(required = true)
    private Configs configs;

    @NameInMap("Part")
    private java.util.List < Part> part;

    private ComplexRequest(Builder builder) {
        this.accessKey = builder.accessKey;
        this.moduleModelMap = builder.moduleModelMap;
        this.subModelMap = builder.subModelMap;
        this.complexList = builder.complexList;
        this.complexList1 = builder.complexList1;
        this.complexList2 = builder.complexList2;
        this.complexList3 = builder.complexList3;
        this.body = builder.body;
        this.userTest = builder.userTest;
        this.strs = builder.strs;
        this.header = builder.header;
        this.num = builder.num;
        this.client = builder.client;
        this.configs = builder.configs;
        this.part = builder.part;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static ComplexRequest create() {
        return builder().build();
    }

    /**
     * @return accessKey
     */
    public String getAccessKey() {
        return this.accessKey;
    }

    /**
     * @return moduleModelMap
     */
    public java.util.Map < String, Request> getModuleModelMap() {
        return this.moduleModelMap;
    }

    /**
     * @return subModelMap
     */
    public java.util.Map < String, Config.ConfigSubM> getSubModelMap() {
        return this.subModelMap;
    }

    /**
     * @return complexList
     */
    public java.util.List < java.util.List < java.util.Map<String, String>> > getComplexList() {
        return this.complexList;
    }

    /**
     * @return complexList1
     */
    public java.util.List < ComplexList1> getComplexList1() {
        return this.complexList1;
    }

    /**
     * @return complexList2
     */
    public java.util.List < java.util.List < java.util.List < ComplexList2> > > getComplexList2() {
        return this.complexList2;
    }

    /**
     * @return complexList3
     */
    public java.util.List < java.util.List < java.util.List < undefined > > > getComplexList3() {
        return this.complexList3;
    }

    /**
     * @return body
     */
    public java.io.InputStream getBody() {
        return this.body;
    }

    /**
     * @return userTest
     */
    public java.util.Map < String, java.util.List<java.util.Map<String, String>>> getUserTest() {
        return this.userTest;
    }

    /**
     * @return strs
     */
    public java.util.List < String > getStrs() {
        return this.strs;
    }

    /**
     * @return header
     */
    public ComplexRequestHeader getHeader() {
        return this.header;
    }

    /**
     * @return num
     */
    public Number getNum() {
        return this.num;
    }

    /**
     * @return client
     */
    public com.import.DefaultAsyncClient getClient() {
        return this.client;
    }

    /**
     * @return configs
     */
    public Configs getConfigs() {
        return this.configs;
    }

    /**
     * @return part
     */
    public java.util.List < Part> getPart() {
        return this.part;
    }

    public static final class Builder {
        private String accessKey; 
        private java.util.Map < String, Request> moduleModelMap; 
        private java.util.Map < String, Config.ConfigSubM> subModelMap; 
        private java.util.List < java.util.List < java.util.Map<String, String>> > complexList; 
        private java.util.List < ComplexList1> complexList1; 
        private java.util.List < java.util.List < java.util.List < ComplexList2> > > complexList2; 
        private java.util.List < java.util.List < java.util.List < undefined > > > complexList3; 
        private java.io.InputStream body; 
        private java.util.Map < String, java.util.List<java.util.Map<String, String>>> userTest; 
        private java.util.List < String > strs; 
        private ComplexRequestHeader header; 
        private Number num; 
        private com.import.DefaultAsyncClient client; 
        private Configs configs; 
        private java.util.List < Part> part; 

        /**
         * accessKey.
         */
        public Builder accessKey(String accessKey) {
            this.accessKey = accessKey;
            return this;
        }

        /**
         * moduleModelMap.
         */
        public Builder moduleModelMap(java.util.Map < String, Request> moduleModelMap) {
            this.moduleModelMap = moduleModelMap;
            return this;
        }

        /**
         * subModelMap.
         */
        public Builder subModelMap(java.util.Map < String, Config.ConfigSubM> subModelMap) {
            this.subModelMap = subModelMap;
            return this;
        }

        /**
         * complexList.
         */
        public Builder complexList(java.util.List < java.util.List < java.util.Map<String, String>> > complexList) {
            this.complexList = complexList;
            return this;
        }

        /**
         * complexList2.
         */
        public Builder complexList1(java.util.List < ComplexList1> complexList1) {
            this.complexList1 = complexList1;
            return this;
        }

        /**
         * complexList2.
         */
        public Builder complexList2(java.util.List < java.util.List < java.util.List < ComplexList2> > > complexList2) {
            this.complexList2 = complexList2;
            return this;
        }

        /**
         * complexList3.
         */
        public Builder complexList3(java.util.List < java.util.List < java.util.List < undefined > > > complexList3) {
            this.complexList3 = complexList3;
            return this;
        }

        /**
         * Body
         * <p>
         * body
         */
        public Builder body(java.io.InputStream body) {
            this.body = body;
            return this;
        }

        /**
         * UserPsssrivileges.
         */
        public Builder userTest(java.util.Map < String, java.util.List<java.util.Map<String, String>>> userTest) {
            this.userTest = userTest;
            return this;
        }

        /**
         * Strs
         */
        public Builder strs(java.util.List < String > strs) {
            this.strs = strs;
            return this;
        }

        /**
         * header
         */
        public Builder header(ComplexRequestHeader header) {
            this.header = header;
            return this;
        }

        /**
         * num.
         */
        public Builder num(Number num) {
            this.num = num;
            return this;
        }

        /**
         * client.
         */
        public Builder client(com.import.DefaultAsyncClient client) {
            this.client = client;
            return this;
        }

        /**
         * configs.
         */
        public Builder configs(Configs configs) {
            this.configs = configs;
            return this;
        }

        /**
         * Part
         */
        public Builder part(java.util.List < Part> part) {
            this.part = part;
            return this;
        }

        public ComplexRequest build() {
            return new ComplexRequest(this);
        } 

    } 

    public static class ComplexList1 extends TeaModel {
        @NameInMap("Name")
        private String name;

        @NameInMap("Code")
        private Integer code;

        private ComplexList1(Builder builder) {
            this.name = builder.name;
            this.code = builder.code;
        }

        public static Builder builder() {
            return new Builder();
        }

        public static ComplexList1 create() {
            return builder().build();
        }

        /**
         * @return name
         */
        public String getName() {
            return this.name;
        }

        /**
         * @return code
         */
        public Integer getCode() {
            return this.code;
        }

        public static final class Builder {
            private String name; 
            private Integer code; 

            /**
             * Name.
             */
            public Builder name(String name) {
                this.name = name;
                return this;
            }

            /**
             * Code.
             */
            public Builder code(Integer code) {
                this.code = code;
                return this;
            }

            public ComplexList1 build() {
                return new ComplexList1(this);
            } 

        } 

    }
    public static class ComplexList2 extends TeaModel {
        @NameInMap("Name")
        private String name;

        @NameInMap("Code")
        private Integer code;

        private ComplexList2(Builder builder) {
            this.name = builder.name;
            this.code = builder.code;
        }

        public static Builder builder() {
            return new Builder();
        }

        public static ComplexList2 create() {
            return builder().build();
        }

        /**
         * @return name
         */
        public String getName() {
            return this.name;
        }

        /**
         * @return code
         */
        public Integer getCode() {
            return this.code;
        }

        public static final class Builder {
            private String name; 
            private Integer code; 

            /**
             * Name.
             */
            public Builder name(String name) {
                this.name = name;
                return this;
            }

            /**
             * Code.
             */
            public Builder code(Integer code) {
                this.code = code;
                return this;
            }

            public ComplexList2 build() {
                return new ComplexList2(this);
            } 

        } 

    }
    public static class ComplexRequestHeader extends TeaModel {
        @NameInMap("Content")
        @Validation(required = true)
        private String content;

        private ComplexRequestHeader(Builder builder) {
            this.content = builder.content;
        }

        public static Builder builder() {
            return new Builder();
        }

        public static ComplexRequestHeader create() {
            return builder().build();
        }

        /**
         * @return content
         */
        public String getContent() {
            return this.content;
        }

        public static final class Builder {
            private String content; 

            /**
             * Body
             */
            public Builder content(String content) {
                this.content = content;
                return this;
            }

            public ComplexRequestHeader build() {
                return new ComplexRequestHeader(this);
            } 

        } 

    }
    public static class Configs extends TeaModel {
        @NameInMap("key")
        @Validation(required = true)
        private String key;

        @NameInMap("value")
        @Validation(required = true)
        private java.util.List < String > value;

        @NameInMap("extra")
        @Validation(required = true)
        private java.util.Map < String, String > extra;

        private Configs(Builder builder) {
            this.key = builder.key;
            this.value = builder.value;
            this.extra = builder.extra;
        }

        public static Builder builder() {
            return new Builder();
        }

        public static Configs create() {
            return builder().build();
        }

        /**
         * @return key
         */
        public String getKey() {
            return this.key;
        }

        /**
         * @return value
         */
        public java.util.List < String > getValue() {
            return this.value;
        }

        /**
         * @return extra
         */
        public java.util.Map < String, String > getExtra() {
            return this.extra;
        }

        public static final class Builder {
            private String key; 
            private java.util.List < String > value; 
            private java.util.Map < String, String > extra; 

            /**
             * key.
             */
            public Builder key(String key) {
                this.key = key;
                return this;
            }

            /**
             * value.
             */
            public Builder value(java.util.List < String > value) {
                this.value = value;
                return this;
            }

            /**
             * extra.
             */
            public Builder extra(java.util.Map < String, String > extra) {
                this.extra = extra;
                return this;
            }

            public Configs build() {
                return new Configs(this);
            } 

        } 

    }
    public static class Part extends TeaModel {
        @NameInMap("PartNumber")
        private String partNumber;

        private Part(Builder builder) {
            this.partNumber = builder.partNumber;
        }

        public static Builder builder() {
            return new Builder();
        }

        public static Part create() {
            return builder().build();
        }

        /**
         * @return partNumber
         */
        public String getPartNumber() {
            return this.partNumber;
        }

        public static final class Builder {
            private String partNumber; 

            /**
             * PartNumber
             */
            public Builder partNumber(String partNumber) {
                this.partNumber = partNumber;
                return this;
            }

            public Part build() {
                return new Part(this);
            } 

        } 

    }
}
