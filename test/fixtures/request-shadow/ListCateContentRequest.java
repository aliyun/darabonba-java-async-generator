// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.test.models;

import darabonba.core.RequestModel;
import darabonba.core.TeaModel;
import com.aliyun.sdk.gateway.pop.models.*;

/**
 * <b>description</b> :
 * <p>Nested field named request must not shadow gateway.pop.models.Request.</p>
 * 
 * {@link ListCateContentRequest} extends {@link RequestModel}
 *
 * <p>ListCateContentRequest</p>
 */
public class ListCateContentRequest extends Request {
    @com.aliyun.core.annotation.Body
    @com.aliyun.core.annotation.NameInMap("Request")
    @com.aliyun.core.annotation.Validation(required = true)
    private ListCateContentRequestRequest request;

    private ListCateContentRequest(Builder builder) {
        super(builder);
        this.request = builder.request;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static ListCateContentRequest create() {
        return builder().build();
    }

    @Override
    public Builder toBuilder() {
        return new Builder(this);
    }

    /**
     * @return request
     */
    public ListCateContentRequestRequest getRequest() {
        return this.request;
    }

    public static final class Builder extends Request.Builder<ListCateContentRequest, Builder> {
        private ListCateContentRequestRequest request; 

        private Builder() {
            super();
        } 

        private Builder(ListCateContentRequest request) {
            super(request);
            this.request = request.request;
        } 

        /**
         * <p>This parameter is required.</p>
         */
        public Builder request(ListCateContentRequestRequest request) {
            String requestShrink = shrink(request, "Request", "json");
            this.putBodyParameter("Request", requestShrink);
            this.request = request;
            return this;
        }

        @Override
        public ListCateContentRequest build() {
            return new ListCateContentRequest(this);
        } 

    } 

    /**
     * 
     * {@link ListCateContentRequest} extends {@link TeaModel}
     *
     * <p>ListCateContentRequest</p>
     */
    public static class ListCateContentRequestRequest extends TeaModel {
        @com.aliyun.core.annotation.NameInMap("CateId")
        @com.aliyun.core.annotation.Validation(required = true)
        private Long cateId;

        @com.aliyun.core.annotation.NameInMap("PageNum")
        @com.aliyun.core.annotation.Validation(required = true)
        private Integer pageNum;

        private ListCateContentRequestRequest(Builder builder) {
            this.cateId = builder.cateId;
            this.pageNum = builder.pageNum;
        }

        public static Builder builder() {
            return new Builder();
        }

        public static ListCateContentRequestRequest create() {
            return builder().build();
        }

        /**
         * @return cateId
         */
        public Long getCateId() {
            return this.cateId;
        }

        /**
         * @return pageNum
         */
        public Integer getPageNum() {
            return this.pageNum;
        }

        public static final class Builder {
            private Long cateId; 
            private Integer pageNum; 

            /**
             * CateId.
             */
            public Builder cateId(Long cateId) {
                this.cateId = cateId;
                return this;
            }

            /**
             * PageNum.
             */
            public Builder pageNum(Integer pageNum) {
                this.pageNum = pageNum;
                return this;
            }

            public ListCateContentRequestRequest build() {
                return new ListCateContentRequestRequest(this);
            } 

        } 

    }
}
