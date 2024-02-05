// This file is auto-generated, don't edit it. Thanks.
package com.aliyun;

import com.aliyun.core.http.*;
import com.aliyun.models.*;
import darabonba.core.utils.*;
import com.import.*;
import com.import.models.*;

import java.util.concurrent.CompletableFuture;


/**
 * <p>Main client.</p>
 */
public final class NameTest implements ImplementsTest {

    protected final String protocol;
    protected final String pathname;
    protected final java.util.List<java.util.List<String>> compleList;
    protected final java.util.List<com.aliyun.models.Config> configs;

    protected NameTest(com.aliyun.models.Config config) {
        this.protocol = config.getProtocol();
        this.configs.set(0, config);
        this.REQUEST = TeaRequest.create().setProduct(product).setEndpointRule(endpointRule).setEndpointMap(endpointMap).setVersion(version);
    }

    public static void assign(ComplexRequest request) {
        request = request.toBuilder().accessKey("test").build();
    }

    public static void arrayAssign3(ComplexRequest request, String config) {
        request.getConfigs().getValue().set(0, config);
    }

    public static String mapAccess(ComplexRequest request) {
        String configInfo = request.getConfigs().getExtra().get("name");
        return configInfo;
    }

    public static String mapAccess2(Request.Configs configs) {
        String configInfo = configs.getExtra().get("name");
        return configInfo;
    }

    public static String mapAccess3() {
        java.util.Map<String, java.util.Map<String, String>> data = CommonUtil.buildMap(
            new TeaPair("configs", CommonUtil.buildMap(
                new TeaPair("value", "string"),
                new TeaPair("\"\"", "\"\"")
            ))
        );
        data.get("configs").get("\"\"");
        return data.get("configs").get("value");
    }

    public static void mapAssign(ComplexRequest request, String name) {
        request.getConfigs().getExtra().put("name", name);
        request.getConfigs().getExtra().put("\"name\"", name);
    }

    public static java.util.List<String> arrayAssign2(String config) {
        java.util.Map<String, java.util.List<String>> data = CommonUtil.buildMap(
            new TeaPair("configs", java.util.Arrays.asList(
                "a",
                "b",
                "c"
            ))
        );
        data.get("configs").set(3, config);
        return data.get("configs");
    }

    public static java.util.List<String> arrayAssign(String config) {
        java.util.List<String> configs = java.util.Arrays.asList(
            "a",
            "b",
            "c"
        );
        configs.set(3, config);
        return configs;
    }

    public static String arrayAccess3(ComplexRequest request) {
        String configVal = request.getConfigs().getValue().get(0);
        return configVal;
    }

    public static String arrayAccess2() {
        java.util.Map<String, java.util.List<String>> data = CommonUtil.buildMap(
            new TeaPair("configs", java.util.Arrays.asList(
                "a",
                "b",
                "c"
            ))
        );
        String config = data.get("configs").get(0);
        return config;
    }

    public static String arrayAccess() {
        java.util.List<String> configs = java.util.Arrays.asList(
            "a",
            "b",
            "c"
        );
        String config = configs.get(0);
        return config;
    }

    @Override
    public void testSubModel(ComplexRequest.ComplexRequestPart part, java.util.List<java.util.List<String>> complexList) {
        return ;
    }

    @Override
    public CompletableFuture<java.util.List<String>> hello(java.util.Map<String, ?> request, java.util.List<String> strs) {
        try {
            return NameTest.array1();
        } catch (Exception e) {
            CompletableFuture<java.util.List<String>> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    public static CompletableFuture<Request> print(TeaRequest reqeust, java.util.List<ComplexRequest> reqs, $Response response, java.util.Map<String, String> val) {
        try {
            return null;
        } catch (Exception e) {
            CompletableFuture<Request> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    public static CompletableFuture<Void> printNull() {
        try {
            CompletableFuture<String> strFuture = this.templateString();
            String str = strFuture.join();
        } catch (Exception e) {
            CompletableFuture<Void> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    public static CompletableFuture<Void> conflict(com.import.models.Config sconf, com.aliyun.models.Config conf) {
        try {
            sconf = sconf.toBuilder().protocol(conf.getProtocol()).build();
        } catch (Exception e) {
            CompletableFuture<Void> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    public static java.util.List<?> array0(java.util.Map<String, ?> req) {
        Long longTest = 1L;
        Double doubleTest = 1D;
        Float floatTest = 1F;
        return new java.util.ArrayList<>();
    }

    public static java.util.List<String> array1() {
        return java.util.Arrays.asList(
            "1"
        );
    }

    @Override
    public CompletableFuture<String> templateString() {
        try {
            return "/" + protocol + "";
        } catch (Exception e) {
            CompletableFuture<String> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

}
