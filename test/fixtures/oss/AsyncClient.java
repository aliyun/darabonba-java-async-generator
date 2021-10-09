package com.aliyun.oss20190517;

import com.aliyun.oss20190517.models.*;
import darabonba.core.async.*;
import darabonba.core.sync.*;

import java.util.concurrent.CompletableFuture;

public interface AsyncClient {

    static DefaultAsyncClientBuilder builder() {
        return new DefaultAsyncClientBuilder();
    }

    static AsyncClient create() {
        return builder().build();
    }

    CompletableFuture<GetBucketLocationResponse> getBucketLocation(GetBucketLocationRequest request);

    CompletableFuture<PostVodPlaylistResponse> postVodPlaylist(PostVodPlaylistRequest request);

    CompletableFuture<CompleteBucketWormResponse> completeBucketWorm(CompleteBucketWormRequest request);

    CompletableFuture<PutBucketReplicationResponse> putBucketReplication(PutBucketReplicationRequest request);

    CompletableFuture<ExtendBucketWormResponse> extendBucketWorm(ExtendBucketWormRequest request);

    CompletableFuture<PutObjectResponse> putObject(PutObjectRequest request);

    CompletableFuture<PutObjectResponse> putObjectWithAsyncRequestBody(PutObjectRequest request, AsyncRequestBody requestBody);

    CompletableFuture<PutObjectResponse> putObjectWithRequestBody(PutObjectRequest request, RequestBody requestBody);

    CompletableFuture<DeleteBucketInventoryResponse> deleteBucketInventory(DeleteBucketInventoryRequest request);

    CompletableFuture<GetBucketWormResponse> getBucketWorm(GetBucketWormRequest request);

    CompletableFuture<PutBucketInventoryResponse> putBucketInventory(PutBucketInventoryRequest request);

    CompletableFuture<GetBucketInventoryResponse> getBucketInventory(GetBucketInventoryRequest request);

    CompletableFuture<UploadPartCopyResponse> uploadPartCopy(UploadPartCopyRequest request);

    CompletableFuture<UploadPartCopyResponse> uploadPartCopyWithAsyncRequestBody(UploadPartCopyRequest request, AsyncRequestBody requestBody);

    CompletableFuture<UploadPartCopyResponse> uploadPartCopyWithRequestBody(UploadPartCopyRequest request, RequestBody requestBody);

    CompletableFuture<DeleteBucketWebsiteResponse> deleteBucketWebsite(DeleteBucketWebsiteRequest request);

    CompletableFuture<GetBucketTagsResponse> getBucketTags(GetBucketTagsRequest request);

    CompletableFuture<InitiateMultipartUploadResponse> initiateMultipartUpload(InitiateMultipartUploadRequest request);

    CompletableFuture<DeleteObjectTaggingResponse> deleteObjectTagging(DeleteObjectTaggingRequest request);

    CompletableFuture<PutBucketWebsiteResponse> putBucketWebsite(PutBucketWebsiteRequest request);

    CompletableFuture<HeadObjectResponse> headObject(HeadObjectRequest request);

    CompletableFuture<GetBucketReplicationResponse> getBucketReplication(GetBucketReplicationRequest request);

    CompletableFuture<GetBucketAclResponse> getBucketAcl(GetBucketAclRequest request);

    CompletableFuture<GetSymlinkResponse> getSymlink(GetSymlinkRequest request);

    CompletableFuture<DeleteBucketResponse> deleteBucket(DeleteBucketRequest request);

    CompletableFuture<DeleteMultipleObjectsResponse> deleteMultipleObjects(DeleteMultipleObjectsRequest request);

    CompletableFuture<OptionObjectResponse> optionObject(OptionObjectRequest request);

    CompletableFuture<ListObjectVersionsResponse> listObjectVersions(ListObjectVersionsRequest request);

    CompletableFuture<GetBucketPolicyResponse> getBucketPolicy(GetBucketPolicyRequest request);

    CompletableFuture<GetObjectResponse> getObject(GetObjectRequest request);

    CompletableFuture<GetObjectResponse> getObjectWithAsyncRequestBody(GetObjectRequest request, AsyncRequestBody requestBody);

    CompletableFuture<GetObjectResponse> getObjectWithRequestBody(GetObjectRequest request, RequestBody requestBody);

    CompletableFuture<InitiateBucketWormResponse> initiateBucketWorm(InitiateBucketWormRequest request);

    CompletableFuture<PutBucketCorsResponse> putBucketCors(PutBucketCorsRequest request);

    CompletableFuture<GetBucketResponse> getBucket(GetBucketRequest request);

    CompletableFuture<PutObjectTaggingResponse> putObjectTagging(PutObjectTaggingRequest request);

    CompletableFuture<CopyObjectResponse> copyObject(CopyObjectRequest request);

    CompletableFuture<CopyObjectResponse> copyObjectWithAsyncRequestBody(CopyObjectRequest request, AsyncRequestBody requestBody);

    CompletableFuture<CopyObjectResponse> copyObjectWithRequestBody(CopyObjectRequest request, RequestBody requestBody);

    CompletableFuture<PutBucketLifecycleResponse> putBucketLifecycle(PutBucketLifecycleRequest request);

    CompletableFuture<DeleteBucketReplicationResponse> deleteBucketReplication(DeleteBucketReplicationRequest request);

    CompletableFuture<GetBucketVersioningResponse> getBucketVersioning(GetBucketVersioningRequest request);

    CompletableFuture<GetBucketTransferAccelerationResponse> getBucketTransferAcceleration(GetBucketTransferAccelerationRequest request);

    CompletableFuture<DeleteBucketEncryptionResponse> deleteBucketEncryption(DeleteBucketEncryptionRequest request);

    CompletableFuture<PutBucketEncryptionResponse> putBucketEncryption(PutBucketEncryptionRequest request);

    CompletableFuture<GetBucketReplicationLocationResponse> getBucketReplicationLocation(GetBucketReplicationLocationRequest request);

    CompletableFuture<PutLiveChannelStatusResponse> putLiveChannelStatus(PutLiveChannelStatusRequest request);

    CompletableFuture<GetBucketLoggingResponse> getBucketLogging(GetBucketLoggingRequest request);

    CompletableFuture<PutBucketRequestPaymentResponse> putBucketRequestPayment(PutBucketRequestPaymentRequest request);

    CompletableFuture<DeleteBucketLoggingResponse> deleteBucketLogging(DeleteBucketLoggingRequest request);

    CompletableFuture<GetLiveChannelStatResponse> getLiveChannelStat(GetLiveChannelStatRequest request);

    CompletableFuture<PutBucketTransferAccelerationResponse> putBucketTransferAcceleration(PutBucketTransferAccelerationRequest request);

    CompletableFuture<PutBucketVersioningResponse> putBucketVersioning(PutBucketVersioningRequest request);

    CompletableFuture<DeleteObjectResponse> deleteObject(DeleteObjectRequest request);

    CompletableFuture<DeleteObjectResponse> deleteObjectWithAsyncRequestBody(DeleteObjectRequest request, AsyncRequestBody requestBody);

    CompletableFuture<DeleteObjectResponse> deleteObjectWithRequestBody(DeleteObjectRequest request, RequestBody requestBody);

    CompletableFuture<GetBucketRefererResponse> getBucketReferer(GetBucketRefererRequest request);

    CompletableFuture<GetBucketReplicationProgressResponse> getBucketReplicationProgress(GetBucketReplicationProgressRequest request);

    CompletableFuture<ListBucketInventoryResponse> listBucketInventory(ListBucketInventoryRequest request);

    CompletableFuture<PutSymlinkResponse> putSymlink(PutSymlinkRequest request);

    CompletableFuture<GetObjectMetaResponse> getObjectMeta(GetObjectMetaRequest request);

    CompletableFuture<GetObjectMetaResponse> getObjectMetaWithAsyncRequestBody(GetObjectMetaRequest request, AsyncRequestBody requestBody);

    CompletableFuture<GetObjectMetaResponse> getObjectMetaWithRequestBody(GetObjectMetaRequest request, RequestBody requestBody);

    CompletableFuture<GetLiveChannelInfoResponse> getLiveChannelInfo(GetLiveChannelInfoRequest request);

    CompletableFuture<DeleteBucketCorsResponse> deleteBucketCors(DeleteBucketCorsRequest request);

    CompletableFuture<GetLiveChannelHistoryResponse> getLiveChannelHistory(GetLiveChannelHistoryRequest request);

    CompletableFuture<GetBucketLifecycleResponse> getBucketLifecycle(GetBucketLifecycleRequest request);

    CompletableFuture<PutBucketRefererResponse> putBucketReferer(PutBucketRefererRequest request);

    CompletableFuture<AbortMultipartUploadResponse> abortMultipartUpload(AbortMultipartUploadRequest request);

    CompletableFuture<PutBucketAclResponse> putBucketAcl(PutBucketAclRequest request);

    CompletableFuture<PutLiveChannelResponse> putLiveChannel(PutLiveChannelRequest request);

    CompletableFuture<PutBucketPolicyResponse> putBucketPolicy(PutBucketPolicyRequest request);

    CompletableFuture<GetBucketRequestPaymentResponse> getBucketRequestPayment(GetBucketRequestPaymentRequest request);

    CompletableFuture<ListMultipartUploadsResponse> listMultipartUploads(ListMultipartUploadsRequest request);

    CompletableFuture<ListBucketsResponse> listBuckets(ListBucketsRequest request);

    CompletableFuture<GetObjectAclResponse> getObjectAcl(GetObjectAclRequest request);

    CompletableFuture<GetVodPlaylistResponse> getVodPlaylist(GetVodPlaylistRequest request);

    CompletableFuture<PutBucketTagsResponse> putBucketTags(PutBucketTagsRequest request);

    CompletableFuture<AbortBucketWormResponse> abortBucketWorm(AbortBucketWormRequest request);

    CompletableFuture<GetBucketWebsiteResponse> getBucketWebsite(GetBucketWebsiteRequest request);

    CompletableFuture<PostObjectResponse> postObject(PostObjectRequest request);

    CompletableFuture<SelectObjectResponse> selectObject(SelectObjectRequest request);

    CompletableFuture<ListObjectsResponse> listObjects(ListObjectsRequest request);

    CompletableFuture<GetBucketCorsResponse> getBucketCors(GetBucketCorsRequest request);

    CompletableFuture<ListPartsResponse> listParts(ListPartsRequest request);

    CompletableFuture<PutObjectAclResponse> putObjectAcl(PutObjectAclRequest request);

    CompletableFuture<UploadPartResponse> uploadPart(UploadPartRequest request);

    CompletableFuture<UploadPartResponse> uploadPartWithAsyncRequestBody(UploadPartRequest request, AsyncRequestBody requestBody);

    CompletableFuture<UploadPartResponse> uploadPartWithRequestBody(UploadPartRequest request, RequestBody requestBody);

    CompletableFuture<PutBucketResponse> putBucket(PutBucketRequest request);

    CompletableFuture<DeleteBucketLifecycleResponse> deleteBucketLifecycle(DeleteBucketLifecycleRequest request);

    CompletableFuture<GetObjectTaggingResponse> getObjectTagging(GetObjectTaggingRequest request);

    CompletableFuture<CompleteMultipartUploadResponse> completeMultipartUpload(CompleteMultipartUploadRequest request);

    CompletableFuture<DeleteLiveChannelResponse> deleteLiveChannel(DeleteLiveChannelRequest request);

    CompletableFuture<GetBucketEncryptionResponse> getBucketEncryption(GetBucketEncryptionRequest request);

    CompletableFuture<RestoreObjectResponse> restoreObject(RestoreObjectRequest request);

    CompletableFuture<DeleteBucketPolicyResponse> deleteBucketPolicy(DeleteBucketPolicyRequest request);

    CompletableFuture<AppendObjectResponse> appendObject(AppendObjectRequest request);

    CompletableFuture<AppendObjectResponse> appendObjectWithAsyncRequestBody(AppendObjectRequest request, AsyncRequestBody requestBody);

    CompletableFuture<AppendObjectResponse> appendObjectWithRequestBody(AppendObjectRequest request, RequestBody requestBody);

    CompletableFuture<ListLiveChannelResponse> listLiveChannel(ListLiveChannelRequest request);

    CompletableFuture<PutBucketLoggingResponse> putBucketLogging(PutBucketLoggingRequest request);

    CompletableFuture<DeleteBucketTagsResponse> deleteBucketTags(DeleteBucketTagsRequest request);

    CompletableFuture<GetBucketInfoResponse> getBucketInfo(GetBucketInfoRequest request);

    CompletableFuture<GetServiceResponse> getService(GetServiceRequest request);

    CompletableFuture<ListObjectsV2Response> listObjectsV2(ListObjectsV2Request request);

}
