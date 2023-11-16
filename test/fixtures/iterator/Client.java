// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.main;


/**
 * <p>Main client.</p>
 */
public final class Client {


    protected Client() {
        this.REQUEST = TeaRequest.create().setProduct(product).setEndpointRule(endpointRule).setEndpointMap(endpointMap).setVersion(version);
    }

    public CompletableFuture<Iterable<String>> test1() {
    }

    public CompletableFuture<Iterable<String>> test2() {
        try {
            CompletableFuture<Iterable<String>> itFuture = this.test1();
            Iterable<String> it = itFuture.join();
            ArrayList<String> _result = new ArrayList<String>();
            for (String test : it) {
                _result.add(test);
            }
        } catch (Exception e) {
            CompletableFuture<Iterable<String>> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    public CompletableFuture<String> test3(Iterable<String> iter) {
        try {
            Iterable<String> it = iter;
            String str = "";
            ArrayList<String> _result = new ArrayList<String>();
            for (String i : it) {
                str = "" + str + ", " + i + "";
            }
            return str;
        } catch (Exception e) {
            CompletableFuture<String> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    public CompletableFuture<Void> test4(Object test) {
        try {
        } catch (Exception e) {
            CompletableFuture<Void> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    public CompletableFuture<Void> test5(Iterable<String> iter) {
        try {
            test3(iter);
            this.test4(iter);
        } catch (Exception e) {
            CompletableFuture<Void> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

}
