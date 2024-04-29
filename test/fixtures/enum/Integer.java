// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.test.models;

@com.aliyun.core.annotation.EnumType
public enum Integer {

    LRS(1, "LRS"),

    ZRS(2, "ZRS"),

    UNKNOWN_VALUE(null, "UNKNOWN_VALUE");

    private Number value;
    private String  description;

    Integer(Number value, String description) {
        this.value = value;
        this.description = description;
    }

    public Number getValue() {
        return this.value;
    }

    public String getDescription() {
        return this.description;
    }

}
