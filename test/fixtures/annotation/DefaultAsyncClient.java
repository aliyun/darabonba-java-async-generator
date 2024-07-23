// This file is auto-generated, don't edit it. Thanks.
package com.aliyun;

import com.aliyun.core.http.*;
import com.aliyun.models.*;
import darabonba.core.utils.*;

import java.util.concurrent.CompletableFuture;


/**
 * <p>Main client.</p>
 */
public final class DefaultAsyncClient {

    protected final java.util.List<String> a;

    /**
     * <b>description</b> :
     * <p>Init Func</p>
     */
    protected DefaultAsyncClient(String a, String b) {
        // string declate comment
        String str = "sss";
        // new model instance comment
        Test1 modelInstance = Test1.builder()
                .test("test")
                //test declare back comment
                .test2("test2")
                .build();
        java.util.List<Object> array = java.util.Arrays.asList(
            // array string comment
            "string",
            // array number comment
            300
        );
        this.REQUEST = TeaRequest.create().setProduct(product).setEndpointRule(endpointRule).setEndpointMap(endpointMap).setVersion(version);
    }

    /**
     * <b>description</b> :
     * <p>staticFunc</p>
     */
    public static void staticFunc() {
        java.util.List<Object> a = new java.util.ArrayList<>();
    }

    /**
     * <b>description</b> :
     * <p>testFunc</p>
     */
    public static CompletableFuture<Void> testFunc() {
        try {
            // empty comment1
            // empty comment2
        } catch (Exception e) {
            CompletableFuture<Void> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    // Deprecated
    /**
     * <b>summary</b> : 
     * <p>Queries available Alibaba Cloud regions. The natural language that is used to filter responses. For more information, visit <a href="https://tools.ietf.org/html/rfc7231">RFC 7231</a>. Valid values:</p>
     * <ul>
     * <li>zh-CN: Chinese</li>
     * <li>en-US: English</li>
     * <li>ja: Japanese</li>
     * </ul>
     * <b>description</b> :
     * <p>Queries available Alibaba Cloud regions. The natural language that is used to filter responses. For more information, visit <a href="https://tools.ietf.org/html/rfc7231">RFC 7231</a>. Valid values:</p>
     * <ul>
     * <li>zh-CN: Chinese</li>
     * <li>en-US: English</li>
     * <li>ja: Japanese</li>
     * </ul>
     * <p>Default value: zh-CN.</p>
     * <blockquote>
     * <p>这是Note的内容</p>
     * </blockquote>
     * <blockquote>
     * <p>Notice: 这是注意的内容</p>
     * </blockquote>
     * 
     * @deprecated deprecatedFunc is deprecated.
     * 
     * @param test string
     * @param _test string
     * @return void
     * 
     * @throws InternalError Server error. 500 服务器端出现未知异常。
     * @throws StackNotFound The Stack (%(stack_name)s) could not be found.  404 资源栈不存在。
     */
    @Deprecated
    public static CompletableFuture<Void> deprecatedFunc(String test, String _test) {
        try {
            // empty comment1
            // empty comment2
        } catch (Exception e) {
            CompletableFuture<Void> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    /**
     * <b>summary</b> : 
     * <p>annotation test summary
     * summary description1
     * summary description2</p>
     * 
     * @deprecated test is deprecated, use xxx instead.
     * deprecated description1
     * deprecated description2
     * 
     * @param test string param1
     * @param _test string param2
     * @return void
     * 
     * @throws InternalError Server error. 500 服务器端出现未知异常。
     */
    @Deprecated
    public static CompletableFuture<Void> multiLineAnnotation(String test, String _test) {
        try {
        } catch (Exception e) {
            CompletableFuture<Void> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    /**
     * @deprecated deprecated test for line break.
     * 
     * @param test string param1
     * param test for line break.
     * @param _test string param2
     * @return void
     * return test for line break.
     * 
     * @throws InternalError Server error. 500 服务器端出现未知异常。
     * throws test for line break.
     */
    @Deprecated
    public static CompletableFuture<Void> lineBreakAnnotation(String test, String _test) {
        try {
        } catch (Exception e) {
            CompletableFuture<Void> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

}
