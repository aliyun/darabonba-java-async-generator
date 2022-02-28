// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.oss20190517;

import com.aliyun.core.http.*;
import com.aliyun.oss20190517.models.*;
import darabonba.core.utils.*;
import darabonba.core.*;
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
        this.product = "Oss";
        this.version = "2019-05-17";
        this.endpointRule = "";
        this.endpointMap = new java.util.HashMap<>();
        this.REQUEST = TeaRequest.create().setProduct(product).setEndpointRule(endpointRule).setEndpointMap(endpointMap).setVersion(version);
    }

    @Override
    public CompletableFuture<ListBucketsResponse> listBuckets(ListBucketsRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().setStyle(RequestStyle.RESTFUL).setAction("ListBuckets").setMethod(HttpMethod.GET).setPathRegex("/ ").setBodyType(BodyType.XML).setBodyIsForm(false).formModel(request);
            ClientExecutionParams params = new ClientExecutionParams().withInput(request).withRequest(teaRequest).withOutput(ListBucketsResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<ListBucketsResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public void test() {
        String test1 = "1";
        String test2 = "2";
        java.util.List<String> list = java.util.Arrays.asList(
            test1,
            test2
        );
        java.util.Map<String, String> m = CommonUtil.buildMap(
            new TeaPair("test1", test1),
            new TeaPair("test2", test2)
        );
        java.util.Map<String, String> result = CommonUtil.merge(String.class,
            CommonUtil.buildMap(
                new TeaPair("key", "value"),
                new TeaPair("key-1", "value-1")
            ),
            m
        );
    }

}
