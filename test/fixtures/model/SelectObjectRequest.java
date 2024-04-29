// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.test.models;

import darabonba.core.RequestModel;
import darabonba.core.TeaModel;

/**
 * {@link SelectObjectRequest} extends {@link RequestModel}
 *
 * <p>SelectObjectRequest</p>
 */
public class SelectObjectRequest extends TeaModel {
    @com.aliyun.core.annotation.Host
    @com.aliyun.core.annotation.NameInMap("BucketName")
    private String bucketName;

    @com.aliyun.core.annotation.Path
    @com.aliyun.core.annotation.NameInMap("ObjectName")
    private String objectName;

    @com.aliyun.core.annotation.Query
    @com.aliyun.core.annotation.NameInMap("Porcess")
    private String porcess;

    @com.aliyun.core.annotation.Query
    @com.aliyun.core.annotation.NameInMap("enumName")
    private Long enumName;

    @com.aliyun.core.annotation.Body
    @com.aliyun.core.annotation.NameInMap("SelectRequest")
    private SelectRequest selectRequest;

    private SelectObjectRequest(Builder builder) {
        this.bucketName = builder.bucketName;
        this.objectName = builder.objectName;
        this.porcess = builder.porcess;
        this.enumName = builder.enumName;
        this.selectRequest = builder.selectRequest;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static SelectObjectRequest create() {
        return builder().build();
    }

    /**
     * @return bucketName
     */
    public String getBucketName() {
        return this.bucketName;
    }

    /**
     * @return objectName
     */
    public String getObjectName() {
        return this.objectName;
    }

    /**
     * @return porcess
     */
    public String getPorcess() {
        return this.porcess;
    }

    /**
     * @return enumName
     */
    public Long getEnumName() {
        return this.enumName;
    }

    /**
     * @return selectRequest
     */
    public SelectRequest getSelectRequest() {
        return this.selectRequest;
    }

    public static final class Builder {
        private String bucketName; 
        private String objectName; 
        private String porcess; 
        private Long enumName; 
        private SelectRequest selectRequest; 

        /**
         * BucketName.
         */
        public Builder bucketName(String bucketName) {
            this.putHostParameter("BucketName", bucketName);
            this.bucketName = bucketName;
            return this;
        }

        /**
         * ObjectName.
         */
        public Builder objectName(String objectName) {
            this.putPathParameter("ObjectName", objectName);
            this.objectName = objectName;
            return this;
        }

        /**
         * Porcess.
         */
        public Builder porcess(String porcess) {
            this.putQueryParameter("Porcess", porcess);
            this.porcess = porcess;
            return this;
        }

        /**
         * enumName.
         */
        public Builder enumName(Long enumName) {
            this.putQueryParameter("enumName", enumName);
            this.enumName = enumName;
            return this;
        }

        /**
         * enumName.
         */
        public Builder enumName(EnumModule enumName) {
            this.putQueryParameter("enumName", enumName.getValue());
            this.enumName = enumName.getValue();
            return this;
        }

        /**
         * SelectRequest.
         */
        public Builder selectRequest(SelectRequest selectRequest) {
            this.putBodyParameter("SelectRequest", selectRequest);
            this.selectRequest = selectRequest;
            return this;
        }

        public SelectObjectRequest build() {
            return new SelectObjectRequest(this);
        } 

    } 

    public static class InputSerializationCSV extends TeaModel {
        @com.aliyun.core.annotation.NameInMap("RecordDelimiter")
        private String recordDelimiter;

        @com.aliyun.core.annotation.NameInMap("Range")
        private String range;

        @com.aliyun.core.annotation.NameInMap("FieldDelimiter")
        private String fieldDelimiter;

        @com.aliyun.core.annotation.NameInMap("QuoteCharacter")
        private String quoteCharacter;

        @com.aliyun.core.annotation.NameInMap("CommentCharacter")
        private String commentCharacter;

        @com.aliyun.core.annotation.NameInMap("FileHeaderInfo")
        private String fileHeaderInfo;

        private InputSerializationCSV(Builder builder) {
            this.recordDelimiter = builder.recordDelimiter;
            this.range = builder.range;
            this.fieldDelimiter = builder.fieldDelimiter;
            this.quoteCharacter = builder.quoteCharacter;
            this.commentCharacter = builder.commentCharacter;
            this.fileHeaderInfo = builder.fileHeaderInfo;
        }

        public static Builder builder() {
            return new Builder();
        }

        public static InputSerializationCSV create() {
            return builder().build();
        }

        /**
         * @return recordDelimiter
         */
        public String getRecordDelimiter() {
            return this.recordDelimiter;
        }

        /**
         * @return range
         */
        public String getRange() {
            return this.range;
        }

        /**
         * @return fieldDelimiter
         */
        public String getFieldDelimiter() {
            return this.fieldDelimiter;
        }

        /**
         * @return quoteCharacter
         */
        public String getQuoteCharacter() {
            return this.quoteCharacter;
        }

        /**
         * @return commentCharacter
         */
        public String getCommentCharacter() {
            return this.commentCharacter;
        }

        /**
         * @return fileHeaderInfo
         */
        public String getFileHeaderInfo() {
            return this.fileHeaderInfo;
        }

        public static final class Builder {
            private String recordDelimiter; 
            private String range; 
            private String fieldDelimiter; 
            private String quoteCharacter; 
            private String commentCharacter; 
            private String fileHeaderInfo; 

            /**
             * RecordDelimiter.
             */
            public Builder recordDelimiter(String recordDelimiter) {
                this.recordDelimiter = recordDelimiter;
                return this;
            }

            /**
             * Range.
             */
            public Builder range(String range) {
                this.range = range;
                return this;
            }

            /**
             * FieldDelimiter.
             */
            public Builder fieldDelimiter(String fieldDelimiter) {
                this.fieldDelimiter = fieldDelimiter;
                return this;
            }

            /**
             * QuoteCharacter.
             */
            public Builder quoteCharacter(String quoteCharacter) {
                this.quoteCharacter = quoteCharacter;
                return this;
            }

            /**
             * CommentCharacter.
             */
            public Builder commentCharacter(String commentCharacter) {
                this.commentCharacter = commentCharacter;
                return this;
            }

            /**
             * FileHeaderInfo.
             */
            public Builder fileHeaderInfo(String fileHeaderInfo) {
                this.fileHeaderInfo = fileHeaderInfo;
                return this;
            }

            public InputSerializationCSV build() {
                return new InputSerializationCSV(this);
            } 

        } 

    }
    public static class InputSerialization extends TeaModel {
        @com.aliyun.core.annotation.NameInMap("CompressionType")
        private String compressionType;

        @com.aliyun.core.annotation.NameInMap("CSV")
        private InputSerializationCSV inputSerializationCSV;

        private InputSerialization(Builder builder) {
            this.compressionType = builder.compressionType;
            this.inputSerializationCSV = builder.inputSerializationCSV;
        }

        public static Builder builder() {
            return new Builder();
        }

        public static InputSerialization create() {
            return builder().build();
        }

        /**
         * @return compressionType
         */
        public String getCompressionType() {
            return this.compressionType;
        }

        /**
         * @return inputSerializationCSV
         */
        public InputSerializationCSV getInputSerializationCSV() {
            return this.inputSerializationCSV;
        }

        public static final class Builder {
            private String compressionType; 
            private InputSerializationCSV inputSerializationCSV; 

            /**
             * CompressionType.
             */
            public Builder compressionType(String compressionType) {
                this.compressionType = compressionType;
                return this;
            }

            /**
             * CSV.
             */
            public Builder inputSerializationCSV(InputSerializationCSV inputSerializationCSV) {
                this.inputSerializationCSV = inputSerializationCSV;
                return this;
            }

            public InputSerialization build() {
                return new InputSerialization(this);
            } 

        } 

    }
    public static class OutputSerializationCSV extends TeaModel {
        @com.aliyun.core.annotation.NameInMap("RecordDelimiter")
        private String recordDelimiter;

        @com.aliyun.core.annotation.NameInMap("FieldDelimiter")
        private String fieldDelimiter;

        private OutputSerializationCSV(Builder builder) {
            this.recordDelimiter = builder.recordDelimiter;
            this.fieldDelimiter = builder.fieldDelimiter;
        }

        public static Builder builder() {
            return new Builder();
        }

        public static OutputSerializationCSV create() {
            return builder().build();
        }

        /**
         * @return recordDelimiter
         */
        public String getRecordDelimiter() {
            return this.recordDelimiter;
        }

        /**
         * @return fieldDelimiter
         */
        public String getFieldDelimiter() {
            return this.fieldDelimiter;
        }

        public static final class Builder {
            private String recordDelimiter; 
            private String fieldDelimiter; 

            /**
             * RecordDelimiter.
             */
            public Builder recordDelimiter(String recordDelimiter) {
                this.recordDelimiter = recordDelimiter;
                return this;
            }

            /**
             * FieldDelimiter.
             */
            public Builder fieldDelimiter(String fieldDelimiter) {
                this.fieldDelimiter = fieldDelimiter;
                return this;
            }

            public OutputSerializationCSV build() {
                return new OutputSerializationCSV(this);
            } 

        } 

    }
    public static class OutputSerialization extends TeaModel {
        @com.aliyun.core.annotation.NameInMap("CSV")
        private OutputSerializationCSV outputSerializationCSV;

        @com.aliyun.core.annotation.NameInMap("OutputRawData")
        private String outputRawData;

        @com.aliyun.core.annotation.NameInMap("OutputHeader")
        private String outputHeader;

        @com.aliyun.core.annotation.NameInMap("EnablePayloadCrc")
        private String enablePayloadCrc;

        @com.aliyun.core.annotation.NameInMap("KeepAllColumns")
        private String keepAllColumns;

        private OutputSerialization(Builder builder) {
            this.outputSerializationCSV = builder.outputSerializationCSV;
            this.outputRawData = builder.outputRawData;
            this.outputHeader = builder.outputHeader;
            this.enablePayloadCrc = builder.enablePayloadCrc;
            this.keepAllColumns = builder.keepAllColumns;
        }

        public static Builder builder() {
            return new Builder();
        }

        public static OutputSerialization create() {
            return builder().build();
        }

        /**
         * @return outputSerializationCSV
         */
        public OutputSerializationCSV getOutputSerializationCSV() {
            return this.outputSerializationCSV;
        }

        /**
         * @return outputRawData
         */
        public String getOutputRawData() {
            return this.outputRawData;
        }

        /**
         * @return outputHeader
         */
        public String getOutputHeader() {
            return this.outputHeader;
        }

        /**
         * @return enablePayloadCrc
         */
        public String getEnablePayloadCrc() {
            return this.enablePayloadCrc;
        }

        /**
         * @return keepAllColumns
         */
        public String getKeepAllColumns() {
            return this.keepAllColumns;
        }

        public static final class Builder {
            private OutputSerializationCSV outputSerializationCSV; 
            private String outputRawData; 
            private String outputHeader; 
            private String enablePayloadCrc; 
            private String keepAllColumns; 

            /**
             * CSV.
             */
            public Builder outputSerializationCSV(OutputSerializationCSV outputSerializationCSV) {
                this.outputSerializationCSV = outputSerializationCSV;
                return this;
            }

            /**
             * OutputRawData.
             */
            public Builder outputRawData(String outputRawData) {
                this.outputRawData = outputRawData;
                return this;
            }

            /**
             * OutputHeader.
             */
            public Builder outputHeader(String outputHeader) {
                this.outputHeader = outputHeader;
                return this;
            }

            /**
             * EnablePayloadCrc.
             */
            public Builder enablePayloadCrc(String enablePayloadCrc) {
                this.enablePayloadCrc = enablePayloadCrc;
                return this;
            }

            /**
             * KeepAllColumns.
             */
            public Builder keepAllColumns(String keepAllColumns) {
                this.keepAllColumns = keepAllColumns;
                return this;
            }

            public OutputSerialization build() {
                return new OutputSerialization(this);
            } 

        } 

    }
    public static class Options extends TeaModel {
        @com.aliyun.core.annotation.NameInMap("MaxSkippedRecordsAllowed")
        private String maxSkippedRecordsAllowed;

        @com.aliyun.core.annotation.NameInMap("SkipPartialDataRecord")
        private String skipPartialDataRecord;

        private Options(Builder builder) {
            this.maxSkippedRecordsAllowed = builder.maxSkippedRecordsAllowed;
            this.skipPartialDataRecord = builder.skipPartialDataRecord;
        }

        public static Builder builder() {
            return new Builder();
        }

        public static Options create() {
            return builder().build();
        }

        /**
         * @return maxSkippedRecordsAllowed
         */
        public String getMaxSkippedRecordsAllowed() {
            return this.maxSkippedRecordsAllowed;
        }

        /**
         * @return skipPartialDataRecord
         */
        public String getSkipPartialDataRecord() {
            return this.skipPartialDataRecord;
        }

        public static final class Builder {
            private String maxSkippedRecordsAllowed; 
            private String skipPartialDataRecord; 

            /**
             * MaxSkippedRecordsAllowed.
             */
            public Builder maxSkippedRecordsAllowed(String maxSkippedRecordsAllowed) {
                this.maxSkippedRecordsAllowed = maxSkippedRecordsAllowed;
                return this;
            }

            /**
             * SkipPartialDataRecord.
             */
            public Builder skipPartialDataRecord(String skipPartialDataRecord) {
                this.skipPartialDataRecord = skipPartialDataRecord;
                return this;
            }

            public Options build() {
                return new Options(this);
            } 

        } 

    }
    public static class SelectRequest extends TeaModel {
        @com.aliyun.core.annotation.NameInMap("InputSerialization")
        private InputSerialization inputSerialization;

        @com.aliyun.core.annotation.NameInMap("Expression")
        private String expression;

        @com.aliyun.core.annotation.NameInMap("OutputSerialization")
        private OutputSerialization outputSerialization;

        @com.aliyun.core.annotation.NameInMap("Options")
        private Options options;

        private SelectRequest(Builder builder) {
            this.inputSerialization = builder.inputSerialization;
            this.expression = builder.expression;
            this.outputSerialization = builder.outputSerialization;
            this.options = builder.options;
        }

        public static Builder builder() {
            return new Builder();
        }

        public static SelectRequest create() {
            return builder().build();
        }

        /**
         * @return inputSerialization
         */
        public InputSerialization getInputSerialization() {
            return this.inputSerialization;
        }

        /**
         * @return expression
         */
        public String getExpression() {
            return this.expression;
        }

        /**
         * @return outputSerialization
         */
        public OutputSerialization getOutputSerialization() {
            return this.outputSerialization;
        }

        /**
         * @return options
         */
        public Options getOptions() {
            return this.options;
        }

        public static final class Builder {
            private InputSerialization inputSerialization; 
            private String expression; 
            private OutputSerialization outputSerialization; 
            private Options options; 

            /**
             * InputSerialization.
             */
            public Builder inputSerialization(InputSerialization inputSerialization) {
                this.inputSerialization = inputSerialization;
                return this;
            }

            /**
             * Expression.
             */
            public Builder expression(String expression) {
                this.expression = expression;
                return this;
            }

            /**
             * OutputSerialization.
             */
            public Builder outputSerialization(OutputSerialization outputSerialization) {
                this.outputSerialization = outputSerialization;
                return this;
            }

            /**
             * Options.
             */
            public Builder options(Options options) {
                this.options = options;
                return this;
            }

            public SelectRequest build() {
                return new SelectRequest(this);
            } 

        } 

    }
}
