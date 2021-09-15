// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.oss20190517;

import com.aliyun.core.http.*;
import com.aliyun.oss20190517.models.*;
import darabonba.core.*;
import darabonba.core.client.*;

import java.util.concurrent.CompletableFuture;

import darabonba.core.utils.*;

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
    public CompletableFuture<GetBucketLocationResponse> getBucketLocation(GetBucketLocationRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("GetBucketLocation").setMethod(HttpMethod.GET).setPathRegex("/?location").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(GetBucketLocationResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<GetBucketLocationResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<GetBucketCORSResponse> getBucketCORS(GetBucketCORSRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("GetBucketCORS").setMethod(HttpMethod.GET).setPathRegex("/?cors").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(GetBucketCORSResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<GetBucketCORSResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<PostVodPlaylistResponse> postVodPlaylist(PostVodPlaylistRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("PostVodPlaylist").setMethod(HttpMethod.POST).setPathRegex("/{channel}/{playlist}?vod").setBodyType(BodyType.NONE).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(PostVodPlaylistResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<PostVodPlaylistResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<CompleteBucketWormResponse> completeBucketWorm(CompleteBucketWormRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("CompleteBucketWorm").setMethod(HttpMethod.POST).setPathRegex("/").setBodyType(BodyType.NONE).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(CompleteBucketWormResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<CompleteBucketWormResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<PutBucketReplicationResponse> putBucketReplication(PutBucketReplicationRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("PutBucketReplication").setMethod(HttpMethod.POST).setPathRegex("/?replication&comp=add").setBodyType(BodyType.NONE).setBodyIsForm(true);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(PutBucketReplicationResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<PutBucketReplicationResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<ExtendBucketWormResponse> extendBucketWorm(ExtendBucketWormRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("ExtendBucketWorm").setMethod(HttpMethod.POST).setPathRegex("/?wormExtend").setBodyType(BodyType.NONE).setBodyIsForm(true);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(ExtendBucketWormResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<ExtendBucketWormResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<PutObjectResponse> putObject(PutObjectRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("PutObject").setMethod(HttpMethod.PUT).setPathRegex("/{key}").setBodyType(BodyType.NONE).setBodyIsForm(true);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(PutObjectResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<PutObjectResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<DeleteBucketInventoryResponse> deleteBucketInventory(DeleteBucketInventoryRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("DeleteBucketInventory").setMethod(HttpMethod.DELETE).setPathRegex("/?inventory").setBodyType(BodyType.NONE).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(DeleteBucketInventoryResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<DeleteBucketInventoryResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<GetBucketWormResponse> getBucketWorm(GetBucketWormRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("GetBucketWorm").setMethod(HttpMethod.GET).setPathRegex("/?worm").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(GetBucketWormResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<GetBucketWormResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<PutBucketInventoryResponse> putBucketInventory(PutBucketInventoryRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("PutBucketInventory").setMethod(HttpMethod.PUT).setPathRegex("/?inventory").setBodyType(BodyType.NONE).setBodyIsForm(true);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(PutBucketInventoryResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<PutBucketInventoryResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<GetBucketInventoryResponse> getBucketInventory(GetBucketInventoryRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("GetBucketInventory").setMethod(HttpMethod.GET).setPathRegex("/?inventory").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(GetBucketInventoryResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<GetBucketInventoryResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<UploadPartCopyResponse> uploadPartCopy(UploadPartCopyRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("UploadPartCopy").setMethod(HttpMethod.PUT).setPathRegex("/{key}").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(UploadPartCopyResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<UploadPartCopyResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<DeleteBucketWebsiteResponse> deleteBucketWebsite(DeleteBucketWebsiteRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("DeleteBucketWebsite").setMethod(HttpMethod.DELETE).setPathRegex("/?website").setBodyType(BodyType.NONE).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(DeleteBucketWebsiteResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<DeleteBucketWebsiteResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<GetBucketTagsResponse> getBucketTags(GetBucketTagsRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("GetBucketTags").setMethod(HttpMethod.GET).setPathRegex("/?tagging").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(GetBucketTagsResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<GetBucketTagsResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<InitiateMultipartUploadResponse> initiateMultipartUpload(InitiateMultipartUploadRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("InitiateMultipartUpload").setMethod(HttpMethod.POST).setPathRegex("/{key}?uploads").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(InitiateMultipartUploadResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<InitiateMultipartUploadResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<DeleteObjectTaggingResponse> deleteObjectTagging(DeleteObjectTaggingRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("DeleteObjectTagging").setMethod(HttpMethod.DELETE).setPathRegex("/{key}?tagging").setBodyType(BodyType.NONE).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(DeleteObjectTaggingResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<DeleteObjectTaggingResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<PutBucketWebsiteResponse> putBucketWebsite(PutBucketWebsiteRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("PutBucketWebsite").setMethod(HttpMethod.PUT).setPathRegex("/?website").setBodyType(BodyType.NONE).setBodyIsForm(true);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(PutBucketWebsiteResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<PutBucketWebsiteResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<HeadObjectResponse> headObject(HeadObjectRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("HeadObject").setMethod(HttpMethod.HEAD).setPathRegex("/{key}").setBodyType(BodyType.NONE).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(HeadObjectResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<HeadObjectResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<GetBucketReplicationResponse> getBucketReplication(GetBucketReplicationRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("GetBucketReplication").setMethod(HttpMethod.GET).setPathRegex("/?replication").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(GetBucketReplicationResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<GetBucketReplicationResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<GetBucketAclResponse> getBucketAcl(GetBucketAclRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("GetBucketAcl").setMethod(HttpMethod.GET).setPathRegex("/?acl").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(GetBucketAclResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<GetBucketAclResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<GetSymlinkResponse> getSymlink(GetSymlinkRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("GetSymlink").setMethod(HttpMethod.GET).setPathRegex("/{key}?symlink").setBodyType(BodyType.NONE).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(GetSymlinkResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<GetSymlinkResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<DeleteBucketResponse> deleteBucket(DeleteBucketRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("DeleteBucket").setMethod(HttpMethod.DELETE).setPathRegex("/").setBodyType(BodyType.NONE).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(DeleteBucketResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<DeleteBucketResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<DeleteMultipleObjectsResponse> deleteMultipleObjects(DeleteMultipleObjectsRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("DeleteMultipleObjects").setMethod(HttpMethod.POST).setPathRegex("/?delete").setBodyType(BodyType.XML).setBodyIsForm(true);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(DeleteMultipleObjectsResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<DeleteMultipleObjectsResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<OptionObjectResponse> optionObject(OptionObjectRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("OptionObject").setMethod(HttpMethod.OPTIONS).setPathRegex("/{key}").setBodyType(BodyType.NONE).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(OptionObjectResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<OptionObjectResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<ListObjectVersionsResponse> listObjectVersions(ListObjectVersionsRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("ListObjectVersions").setMethod(HttpMethod.GET).setPathRegex("/?versions").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(ListObjectVersionsResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<ListObjectVersionsResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<GetBucketPolicyResponse> getBucketPolicy(GetBucketPolicyRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("GetBucketPolicy").setMethod(HttpMethod.GET).setPathRegex("/?policy").setBodyType(BodyType.STRING).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(GetBucketPolicyResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<GetBucketPolicyResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<GetObjectResponse> getObject(GetObjectRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("GetObject").setMethod(HttpMethod.GET).setPathRegex("/{key}").setBodyType(BodyType.NONE).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(GetObjectResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<GetObjectResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<InitiateBucketWormResponse> initiateBucketWorm(InitiateBucketWormRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("InitiateBucketWorm").setMethod(HttpMethod.POST).setPathRegex("/?worm").setBodyType(BodyType.NONE).setBodyIsForm(true);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(InitiateBucketWormResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<InitiateBucketWormResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<GetBucketResponse> getBucket(GetBucketRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("GetBucket").setMethod(HttpMethod.GET).setPathRegex("/").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(GetBucketResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<GetBucketResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<PutObjectTaggingResponse> putObjectTagging(PutObjectTaggingRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("PutObjectTagging").setMethod(HttpMethod.PUT).setPathRegex("/{key}?tagging").setBodyType(BodyType.NONE).setBodyIsForm(true);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(PutObjectTaggingResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<PutObjectTaggingResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<CopyObjectResponse> copyObject(CopyObjectRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("CopyObject").setMethod(HttpMethod.PUT).setPathRegex("/{key}").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(CopyObjectResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<CopyObjectResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<PutBucketLifecycleResponse> putBucketLifecycle(PutBucketLifecycleRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("PutBucketLifecycle").setMethod(HttpMethod.PUT).setPathRegex("/?lifecycle ").setBodyType(BodyType.NONE).setBodyIsForm(true);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(PutBucketLifecycleResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<PutBucketLifecycleResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<DeleteBucketReplicationResponse> deleteBucketReplication(DeleteBucketReplicationRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("DeleteBucketReplication").setMethod(HttpMethod.POST).setPathRegex("/?replication&comp=delete").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(DeleteBucketReplicationResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<DeleteBucketReplicationResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<GetBucketVersioningResponse> getBucketVersioning(GetBucketVersioningRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("GetBucketVersioning").setMethod(HttpMethod.GET).setPathRegex("/?versioning").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(GetBucketVersioningResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<GetBucketVersioningResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<GetBucketTransferAccelerationResponse> getBucketTransferAcceleration(GetBucketTransferAccelerationRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("GetBucketTransferAcceleration").setMethod(HttpMethod.GET).setPathRegex("/?transferAcceleration ").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(GetBucketTransferAccelerationResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<GetBucketTransferAccelerationResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<DeleteBucketEncryptionResponse> deleteBucketEncryption(DeleteBucketEncryptionRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("DeleteBucketEncryption").setMethod(HttpMethod.DELETE).setPathRegex("/?encryption").setBodyType(BodyType.NONE).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(DeleteBucketEncryptionResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<DeleteBucketEncryptionResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<PutBucketEncryptionResponse> putBucketEncryption(PutBucketEncryptionRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("PutBucketEncryption").setMethod(HttpMethod.PUT).setPathRegex("/?encryption").setBodyType(BodyType.NONE).setBodyIsForm(true);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(PutBucketEncryptionResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<PutBucketEncryptionResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<GetBucketReplicationLocationResponse> getBucketReplicationLocation(GetBucketReplicationLocationRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("GetBucketReplicationLocation").setMethod(HttpMethod.GET).setPathRegex("/?replicationLocation").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(GetBucketReplicationLocationResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<GetBucketReplicationLocationResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<PutLiveChannelStatusResponse> putLiveChannelStatus(PutLiveChannelStatusRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("PutLiveChannelStatus").setMethod(HttpMethod.PUT).setPathRegex("/{channel}?live").setBodyType(BodyType.NONE).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(PutLiveChannelStatusResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<PutLiveChannelStatusResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<GetBucketLoggingResponse> getBucketLogging(GetBucketLoggingRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("GetBucketLogging").setMethod(HttpMethod.GET).setPathRegex("/?logging").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(GetBucketLoggingResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<GetBucketLoggingResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<PutBucketRequestPaymentResponse> putBucketRequestPayment(PutBucketRequestPaymentRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("PutBucketRequestPayment").setMethod(HttpMethod.PUT).setPathRegex("/?requestPayment").setBodyType(BodyType.NONE).setBodyIsForm(true);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(PutBucketRequestPaymentResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<PutBucketRequestPaymentResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<DeleteBucketLoggingResponse> deleteBucketLogging(DeleteBucketLoggingRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("DeleteBucketLogging").setMethod(HttpMethod.DELETE).setPathRegex("/?logging").setBodyType(BodyType.NONE).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(DeleteBucketLoggingResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<DeleteBucketLoggingResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<GetLiveChannelStatResponse> getLiveChannelStat(GetLiveChannelStatRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("GetLiveChannelStat").setMethod(HttpMethod.GET).setPathRegex("/{channel}?live&comp=stat").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(GetLiveChannelStatResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<GetLiveChannelStatResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<PutBucketTransferAccelerationResponse> putBucketTransferAcceleration(PutBucketTransferAccelerationRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("PutBucketTransferAcceleration").setMethod(HttpMethod.PUT).setPathRegex("/?transferAcceleration ").setBodyType(BodyType.NONE).setBodyIsForm(true);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(PutBucketTransferAccelerationResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<PutBucketTransferAccelerationResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<PutBucketCORSResponse> putBucketCORS(PutBucketCORSRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("PutBucketCORS").setMethod(HttpMethod.PUT).setPathRegex("/?cors").setBodyType(BodyType.NONE).setBodyIsForm(true);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(PutBucketCORSResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<PutBucketCORSResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<PutBucketVersioningResponse> putBucketVersioning(PutBucketVersioningRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("PutBucketVersioning").setMethod(HttpMethod.PUT).setPathRegex("/?versioning").setBodyType(BodyType.NONE).setBodyIsForm(true);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(PutBucketVersioningResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<PutBucketVersioningResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<DeleteObjectResponse> deleteObject(DeleteObjectRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("DeleteObject").setMethod(HttpMethod.DELETE).setPathRegex("/{key}").setBodyType(BodyType.NONE).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(DeleteObjectResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<DeleteObjectResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<GetBucketRefererResponse> getBucketReferer(GetBucketRefererRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("GetBucketReferer").setMethod(HttpMethod.GET).setPathRegex("/?referer").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(GetBucketRefererResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<GetBucketRefererResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<GetBucketReplicationProgressResponse> getBucketReplicationProgress(GetBucketReplicationProgressRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("GetBucketReplicationProgress").setMethod(HttpMethod.GET).setPathRegex("/?replicationProgress").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(GetBucketReplicationProgressResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<GetBucketReplicationProgressResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<ListBucketInventoryResponse> listBucketInventory(ListBucketInventoryRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("ListBucketInventory").setMethod(HttpMethod.GET).setPathRegex("/?inventory").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(ListBucketInventoryResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<ListBucketInventoryResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<PutSymlinkResponse> putSymlink(PutSymlinkRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("PutSymlink").setMethod(HttpMethod.PUT).setPathRegex("/{key}?symlink").setBodyType(BodyType.NONE).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(PutSymlinkResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<PutSymlinkResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<GetObjectMetaResponse> getObjectMeta(GetObjectMetaRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("GetObjectMeta").setMethod(HttpMethod.HEAD).setPathRegex("/{key}?objectMeta").setBodyType(BodyType.NONE).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(GetObjectMetaResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<GetObjectMetaResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<GetLiveChannelInfoResponse> getLiveChannelInfo(GetLiveChannelInfoRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("GetLiveChannelInfo").setMethod(HttpMethod.GET).setPathRegex("/{channel}?live").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(GetLiveChannelInfoResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<GetLiveChannelInfoResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<GetLiveChannelHistoryResponse> getLiveChannelHistory(GetLiveChannelHistoryRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("GetLiveChannelHistory").setMethod(HttpMethod.GET).setPathRegex("/{channel}?live&comp=history").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(GetLiveChannelHistoryResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<GetLiveChannelHistoryResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<GetBucketLifecycleResponse> getBucketLifecycle(GetBucketLifecycleRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("GetBucketLifecycle").setMethod(HttpMethod.GET).setPathRegex("/?lifecycle ").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(GetBucketLifecycleResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<GetBucketLifecycleResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<PutBucketRefererResponse> putBucketReferer(PutBucketRefererRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("PutBucketReferer").setMethod(HttpMethod.PUT).setPathRegex("/?referer").setBodyType(BodyType.NONE).setBodyIsForm(true);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(PutBucketRefererResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<PutBucketRefererResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<AbortMultipartUploadResponse> abortMultipartUpload(AbortMultipartUploadRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("AbortMultipartUpload").setMethod(HttpMethod.DELETE).setPathRegex("/{key}").setBodyType(BodyType.NONE).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(AbortMultipartUploadResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<AbortMultipartUploadResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<PutBucketAclResponse> putBucketAcl(PutBucketAclRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("PutBucketAcl").setMethod(HttpMethod.PUT).setPathRegex("/?acl").setBodyType(BodyType.NONE).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(PutBucketAclResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<PutBucketAclResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<PutLiveChannelResponse> putLiveChannel(PutLiveChannelRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("PutLiveChannel").setMethod(HttpMethod.PUT).setPathRegex("/{channel}?live").setBodyType(BodyType.XML).setBodyIsForm(true);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(PutLiveChannelResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<PutLiveChannelResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<PutBucketPolicyResponse> putBucketPolicy(PutBucketPolicyRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("PutBucketPolicy").setMethod(HttpMethod.PUT).setPathRegex("/?policy").setBodyType(BodyType.NONE).setBodyIsForm(false).setReqBodyType(BodyType.STRING);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(PutBucketPolicyResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<PutBucketPolicyResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<GetBucketRequestPaymentResponse> getBucketRequestPayment(GetBucketRequestPaymentRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("GetBucketRequestPayment").setMethod(HttpMethod.GET).setPathRegex("/?requestPayment").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(GetBucketRequestPaymentResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<GetBucketRequestPaymentResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<ListMultipartUploadsResponse> listMultipartUploads(ListMultipartUploadsRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("ListMultipartUploads").setMethod(HttpMethod.GET).setPathRegex("/?uploads").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(ListMultipartUploadsResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<ListMultipartUploadsResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<ListBucketsResponse> listBuckets(ListBucketsRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("ListBuckets").setMethod(HttpMethod.GET).setPathRegex("/ ").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(ListBucketsResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<ListBucketsResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<GetObjectAclResponse> getObjectAcl(GetObjectAclRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("GetObjectAcl").setMethod(HttpMethod.GET).setPathRegex("/{key}?acl").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(GetObjectAclResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<GetObjectAclResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<GetVodPlaylistResponse> getVodPlaylist(GetVodPlaylistRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("GetVodPlaylist").setMethod(HttpMethod.GET).setPathRegex("/{channel}?vod").setBodyType(BodyType.BINARY).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(GetVodPlaylistResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<GetVodPlaylistResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<PutBucketTagsResponse> putBucketTags(PutBucketTagsRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("PutBucketTags").setMethod(HttpMethod.PUT).setPathRegex("/?tagging").setBodyType(BodyType.NONE).setBodyIsForm(true);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(PutBucketTagsResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<PutBucketTagsResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<AbortBucketWormResponse> abortBucketWorm(AbortBucketWormRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("AbortBucketWorm").setMethod(HttpMethod.DELETE).setPathRegex("/?worm").setBodyType(BodyType.NONE).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(AbortBucketWormResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<AbortBucketWormResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<GetBucketWebsiteResponse> getBucketWebsite(GetBucketWebsiteRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("GetBucketWebsite").setMethod(HttpMethod.POST).setPathRegex("/?website").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(GetBucketWebsiteResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<GetBucketWebsiteResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<PostObjectResponse> postObject(PostObjectRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("PostObject").setMethod(HttpMethod.POST).setPathRegex("/").setBodyType(BodyType.NONE).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(PostObjectResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<PostObjectResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<SelectObjectResponse> selectObject(SelectObjectRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("SelectObject").setMethod(HttpMethod.POST).setPathRegex("/{key}").setBodyType(BodyType.NONE).setBodyIsForm(true);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(SelectObjectResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<SelectObjectResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<ListObjectsResponse> listObjects(ListObjectsRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("ListObjects").setMethod(HttpMethod.GET).setPathRegex("/").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(ListObjectsResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<ListObjectsResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<ListPartsResponse> listParts(ListPartsRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("ListParts").setMethod(HttpMethod.GET).setPathRegex("/{key}").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(ListPartsResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<ListPartsResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<PutObjectAclResponse> putObjectAcl(PutObjectAclRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("PutObjectAcl").setMethod(HttpMethod.PUT).setPathRegex("/{key}?acl").setBodyType(BodyType.NONE).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(PutObjectAclResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<PutObjectAclResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<UploadPartResponse> uploadPart(UploadPartRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("UploadPart").setMethod(HttpMethod.PUT).setPathRegex("/{key}").setBodyType(BodyType.NONE).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(UploadPartResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<UploadPartResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<PutBucketResponse> putBucket(PutBucketRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("PutBucket").setMethod(HttpMethod.PUT).setPathRegex("/").setBodyType(BodyType.NONE).setBodyIsForm(true);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(PutBucketResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<PutBucketResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<DeleteBucketLifecycleResponse> deleteBucketLifecycle(DeleteBucketLifecycleRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("DeleteBucketLifecycle").setMethod(HttpMethod.DELETE).setPathRegex("/?lifecycle").setBodyType(BodyType.NONE).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(DeleteBucketLifecycleResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<DeleteBucketLifecycleResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<GetObjectTaggingResponse> getObjectTagging(GetObjectTaggingRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("GetObjectTagging").setMethod(HttpMethod.GET).setPathRegex("/{key}?tagging").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(GetObjectTaggingResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<GetObjectTaggingResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<CompleteMultipartUploadResponse> completeMultipartUpload(CompleteMultipartUploadRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("CompleteMultipartUpload").setMethod(HttpMethod.POST).setPathRegex("/{key}").setBodyType(BodyType.XML).setBodyIsForm(true);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(CompleteMultipartUploadResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<CompleteMultipartUploadResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<DeleteBucketCORSResponse> deleteBucketCORS(DeleteBucketCORSRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("DeleteBucketCORS").setMethod(HttpMethod.DELETE).setPathRegex("/?cors").setBodyType(BodyType.NONE).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(DeleteBucketCORSResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<DeleteBucketCORSResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<DeleteLiveChannelResponse> deleteLiveChannel(DeleteLiveChannelRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("DeleteLiveChannel").setMethod(HttpMethod.DELETE).setPathRegex("/{channel}?live").setBodyType(BodyType.NONE).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(DeleteLiveChannelResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<DeleteLiveChannelResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<GetBucketEncryptionResponse> getBucketEncryption(GetBucketEncryptionRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("GetBucketEncryption").setMethod(HttpMethod.GET).setPathRegex("/?encryption").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(GetBucketEncryptionResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<GetBucketEncryptionResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<RestoreObjectResponse> restoreObject(RestoreObjectRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("RestoreObject").setMethod(HttpMethod.POST).setPathRegex("/{key}?restore").setBodyType(BodyType.NONE).setBodyIsForm(true);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(RestoreObjectResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<RestoreObjectResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<DeleteBucketPolicyResponse> deleteBucketPolicy(DeleteBucketPolicyRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("DeleteBucketPolicy").setMethod(HttpMethod.DELETE).setPathRegex("/?policy").setBodyType(BodyType.NONE).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(DeleteBucketPolicyResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<DeleteBucketPolicyResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<AppendObjectResponse> appendObject(AppendObjectRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("AppendObject").setMethod(HttpMethod.POST).setPathRegex("/{key}?append").setBodyType(BodyType.NONE).setBodyIsForm(true);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(AppendObjectResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<AppendObjectResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<ListLiveChannelResponse> listLiveChannel(ListLiveChannelRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("ListLiveChannel").setMethod(HttpMethod.GET).setPathRegex("/?live").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(ListLiveChannelResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<ListLiveChannelResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<PutBucketLoggingResponse> putBucketLogging(PutBucketLoggingRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("PutBucketLogging").setMethod(HttpMethod.PUT).setPathRegex("/?logging").setBodyType(BodyType.NONE).setBodyIsForm(true);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(PutBucketLoggingResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<PutBucketLoggingResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<DeleteBucketTagsResponse> deleteBucketTags(DeleteBucketTagsRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("DeleteBucketTags").setMethod(HttpMethod.DELETE).setPathRegex("/?tagging").setBodyType(BodyType.NONE).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(DeleteBucketTagsResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<DeleteBucketTagsResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<GetBucketInfoResponse> getBucketInfo(GetBucketInfoRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("GetBucketInfo").setMethod(HttpMethod.GET).setPathRegex("/?bucketInfo").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(GetBucketInfoResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<GetBucketInfoResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<GetServiceResponse> getService(GetServiceRequest request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("GetService").setMethod(HttpMethod.GET).setPathRegex("/ ").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(GetServiceResponse.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<GetServiceResponse> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<ListObjectsV2Response> listObjectsV2(ListObjectsV2Request request) {
        try {
            this.handler.validateRequestModel(request);
            TeaRequest teaRequest = REQUEST.copy().formModel(request).setStyle(RequestStyle.RESTFUL).setAction("ListObjectsV2").setMethod(HttpMethod.GET).setPathRegex("/?list-type=2").setBodyType(BodyType.XML).setBodyIsForm(false);
            ClientExecutionParams params = new ClientExecutionParams().withInput(null).withRequest(teaRequest).withOutput(ListObjectsV2Response.create());
            return this.handler.execute(params);
        } catch (Exception e) {
            CompletableFuture<ListObjectsV2Response> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

}
