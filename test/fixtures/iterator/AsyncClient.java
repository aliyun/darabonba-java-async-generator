// This file is auto-generated, don't edit it. Thanks.
package com.aliyun;

import com.aliyun.core.utils.SdkAutoCloseable;
import com.aliyun.models.*;
import com.aliyun.sdk.gateway.pop.Configuration;
import com.aliyun.sdk.gateway.pop.auth.SignatureVersion;
import darabonba.core.*;
import darabonba.core.async.*;
import darabonba.core.sync.*;

import java.util.concurrent.CompletableFuture;

public interface AsyncClient extends SdkAutoCloseable {

    static DefaultAsyncClientBuilder builder() {
        return new DefaultAsyncClientBuilder().serviceConfiguration(Configuration.create().setSignatureVersion(SignatureVersion.V3));
    }

    static AsyncClient create() {
        return builder().build();
    }

    ResponseIterable<String> test1();

    ResponseIterable<String> test2();

    String test3(ResponseIterable<String> iter);

    void test4(Object test);

    void test5(ResponseIterable<String> iter);

    ResponseIterable<ChatResponseBody> test6(ChatRequest request);

}
