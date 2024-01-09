// This file is auto-generated, don't edit it. Thanks.
package com.aliyun;

import com.aliyun.core.http.*;
import com.aliyun.models.*;
import darabonba.core.utils.*;
import com.aliyun.sdk.gateway.pop.*;
import darabonba.core.*;
import darabonba.core.async.*;
import darabonba.core.sync.*;
import darabonba.core.client.*;

import java.util.concurrent.CompletableFuture;


/**
 * <p>Main client.</p>
 */
public final class DefaultAsyncClient implements AsyncClient {

    protected final String product;
    protected final String version;
    protected final String endpointRule;
    protected final java.util.Map<String, String> endpointMap;
    protected final TeaRequest REQUEST;
    protected final TeaAsyncHandler handler;

    protected DefaultAsyncClient(ClientConfiguration configuration) {
        this.handler = new TeaAsyncHandler(configuration);
        this.product = "test";
        this.version = "";
        this.endpointRule = "";
        this.endpointMap = new java.util.HashMap<>();
        this.REQUEST = TeaRequest.create().setProduct(product).setEndpointRule(endpointRule).setEndpointMap(endpointMap).setVersion(version);
    }

    @Override
    public void close() {
        this.handler.close();
    }

    @Override
    public ResponseIterable<String> test1() {
    }

    @Override
    public ResponseIterable<String> test2() {
        return this.test1();
    }

    @Override
    public String test3(ResponseIterable<String> iter) {
        ResponseIterable<String> it = iter;
        String str = "";
        for (String i : it) {
            str = "" + str + ", " + i + "";
        }
        return str;
    }

    @Override
    public void test4(Object test) {
    }

    @Override
    public void test5(ResponseIterable<String> iter) {
        this.test3(iter);
        this.test4(iter);
    }

    @Override
    public ResponseIterable<ChatResponseBody> test6(ChatRequest request) {
        this.handler.validateRequestModel(request);
        TeaRequest teaRequest = REQUEST.copy().setStyle(RequestStyle.SSE).setAction("chat").setMethod(HttpMethod.POST).setPathRegex("/gw/v1/api/doc/docChat").setBodyType(BodyType.JSON).setBodyIsForm(false).setReqBodyType(BodyType.JSON).formModel(request);
        ChatResponseBodyIterator iterator = ChatResponseBodyIterator.create();
        ClientExecutionParams params = new ClientExecutionParams().withInput(request).withRequest(teaRequest).withHttpResponseHandler(new SSEHttpResponseHandler(iterator));
        this.handler.execute(params);
        return new ResponseIterable<>(iterator);
    }

}
