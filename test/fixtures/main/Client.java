// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.main;


/**
 * <p>Main client.</p>
 */
public final class Client {



    public static java.util.List<String> arrayData() {
        java.util.List<String> configs = java.util.Arrays.asList(
            "a",
            "b",
            "c"
        );
        return configs;
    }

    public static CompletableFuture<String> arrayAccess() {
        try {
            java.util.List<String> configs = Client.arrayData();
            String config = configs.get(0);
            return config;
        } catch (Exception e) {
            CompletableFuture<String> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    public static CompletableFuture<String> hello() {
        try {
            return Client.arrayAccess();
        } catch (Exception e) {
            CompletableFuture<String> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    public static String main(String[] args_) {
        java.util.List<String> args = java.util.Arrays.asList(args_);
        Client.hello();
        return args.get(1);
    }

}
