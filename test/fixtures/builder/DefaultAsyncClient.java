// This file is auto-generated, don't edit it. Thanks.
package com.aliyun;

import com.aliyun.core.http.*;
import com.aliyun.models.*;
import darabonba.core.utils.*;

import java.util.concurrent.CompletableFuture;


/**
 * <p>Main client.</p>
 */
public class DefaultAsyncClient {



    public static CompletableFuture<Void> testSet() {
        try {
            Test m = Test.builder()
                    .field1("test1")
                    // test filed2
                    .field2("test2")
                    .field3("test3")
                    // test filed4
                    .field4("test4")
                    .field5(java.util.Arrays.asList(
                        "test5"
                    ))
                    .build();
        } catch (Exception e) {
            CompletableFuture<Void> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

}
