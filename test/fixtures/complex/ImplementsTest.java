// This file is auto-generated, don't edit it. Thanks.
package com.aliyun;

import com.aliyun.models.*;
import darabonba.core.*;
import darabonba.core.async.*;
import darabonba.core.sync.*;

import java.util.concurrent.CompletableFuture;

public interface ImplementsTest {

    static NameTestBuilder builder() {
        return new NameTestBuilder();
    }

    static ImplementsTest create() {
        return builder().build();
    }

    void testSubModel(ComplexRequest.ComplexRequestPart part, java.util.List<java.util.List<String>> complexList);

    CompletableFuture<java.util.List<String>> hello(java.util.Map<String, ?> request, java.util.List<String> strs);

    CompletableFuture<String> templateString();

}
