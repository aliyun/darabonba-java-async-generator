// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.test.models;

import com.aliyun.core.annotation.*;
import darabonba.core.RequestModel;
import darabonba.core.TeaModel;

/**
 * {@link SelectObjectRequest} extends {@link RequestModel}
 *
 * <p>SelectObjectRequest</p>
 */
public class SelectObjectRequest extends Request {
    @Host
    @NameInMap("BucketName")
    private String bucketName;

    @Path
    @NameInMap("ObjectName")
    private String objectName;

    @Query
    @NameInMap("Porcess")
    private String porcess;

    @Body
    @NameInMap("SelectRequest")
    private SelectRequest selectRequest;


    private SelectObjectRequest(Builder builder) {
        super(builder);
        this.bucketName = builder.bucketName;
        this.objectName = builder.objectName;
        this.porcess = builder.porcess;
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
    public String bucketName() {
        return this.bucketName;
    }

    /**
     * @return objectName
     */
    public String objectName() {
        return this.objectName;
    }

    /**
     * @return porcess
     */
    public String porcess() {
        return this.porcess;
    }

    /**
     * @return selectRequest
     */
    public SelectRequest selectRequest() {
        return this.selectRequest;
    }

    public static final class Builder extends RequestModel.Builder<SelectObjectRequest.Builder> {
      
        private String bucketName; 
        private String objectName; 
        private String porcess; 
        private SelectRequest selectRequest; 

        /**
         * <p>BucketName.</p>
         */
        public Builder bucketName(String bucketName) {
            this.putHostParameter("BucketName", bucketName);
            this.bucketName = bucketName;
            return this;
        }

        /**
         * <p>ObjectName.</p>
         */
        public Builder objectName(String objectName) {
            this.putPathParameter("ObjectName", objectName);
            this.objectName = objectName;
            return this;
        }

        /**
         * <p>Porcess.</p>
         */
        public Builder porcess(String porcess) {
            this.putQueryParameter("Porcess", porcess);
            this.porcess = porcess;
            return this;
        }

        /**
         * <p>SelectRequest.</p>
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
        @NameInMap("RecordDelimiter")
        private String recordDelimiter;

        @NameInMap("Range")
        private String range;

        @NameInMap("FieldDelimiter")
        private String fieldDelimiter;

        @NameInMap("QuoteCharacter")
        private String quoteCharacter;

        @NameInMap("CommentCharacter")
        private String commentCharacter;

        @NameInMap("FileHeaderInfo")
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
        public String recordDelimiter() {
            return this.recordDelimiter;
        }

        /**
         * @return range
         */
        public String range() {
            return this.range;
        }

        /**
         * @return fieldDelimiter
         */
        public String fieldDelimiter() {
            return this.fieldDelimiter;
        }

        /**
         * @return quoteCharacter
         */
        public String quoteCharacter() {
            return this.quoteCharacter;
        }

        /**
         * @return commentCharacter
         */
        public String commentCharacter() {
            return this.commentCharacter;
        }

        /**
         * @return fileHeaderInfo
         */
        public String fileHeaderInfo() {
            return this.fileHeaderInfo;
        }

        public static final class Builder extends RequestModel.Builder<InputSerializationCSV.Builder> {
      
            private String recordDelimiter; 
            private String range; 
            private String fieldDelimiter; 
            private String quoteCharacter; 
            private String commentCharacter; 
            private String fileHeaderInfo; 

            /**
             * <p>RecordDelimiter.</p>
             */
            public Builder recordDelimiter(String recordDelimiter) {
                this.recordDelimiter = recordDelimiter;
                return this;
            }

            /**
             * <p>Range.</p>
             */
            public Builder range(String range) {
                this.range = range;
                return this;
            }

            /**
             * <p>FieldDelimiter.</p>
             */
            public Builder fieldDelimiter(String fieldDelimiter) {
                this.fieldDelimiter = fieldDelimiter;
                return this;
            }

            /**
             * <p>QuoteCharacter.</p>
             */
            public Builder quoteCharacter(String quoteCharacter) {
                this.quoteCharacter = quoteCharacter;
                return this;
            }

            /**
             * <p>CommentCharacter.</p>
             */
            public Builder commentCharacter(String commentCharacter) {
                this.commentCharacter = commentCharacter;
                return this;
            }

            /**
             * <p>FileHeaderInfo.</p>
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
        @NameInMap("CompressionType")
        private String compressionType;

        @NameInMap("CSV")
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
        public String compressionType() {
            return this.compressionType;
        }

        /**
         * @return inputSerializationCSV
         */
        public InputSerializationCSV inputSerializationCSV() {
            return this.inputSerializationCSV;
        }

        public static final class Builder extends RequestModel.Builder<InputSerialization.Builder> {
      
            private String compressionType; 
            private InputSerializationCSV inputSerializationCSV; 

            /**
             * <p>CompressionType.</p>
             */
            public Builder compressionType(String compressionType) {
                this.compressionType = compressionType;
                return this;
            }

            /**
             * <p>CSV.</p>
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
        @NameInMap("RecordDelimiter")
        private String recordDelimiter;

        @NameInMap("FieldDelimiter")
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
        public String recordDelimiter() {
            return this.recordDelimiter;
        }

        /**
         * @return fieldDelimiter
         */
        public String fieldDelimiter() {
            return this.fieldDelimiter;
        }

        public static final class Builder extends RequestModel.Builder<OutputSerializationCSV.Builder> {
      
            private String recordDelimiter; 
            private String fieldDelimiter; 

            /**
             * <p>RecordDelimiter.</p>
             */
            public Builder recordDelimiter(String recordDelimiter) {
                this.recordDelimiter = recordDelimiter;
                return this;
            }

            /**
             * <p>FieldDelimiter.</p>
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
        @NameInMap("CSV")
        private OutputSerializationCSV outputSerializationCSV;

        @NameInMap("OutputRawData")
        private String outputRawData;

        @NameInMap("OutputHeader")
        private String outputHeader;

        @NameInMap("EnablePayloadCrc")
        private String enablePayloadCrc;

        @NameInMap("KeepAllColumns")
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
        public OutputSerializationCSV outputSerializationCSV() {
            return this.outputSerializationCSV;
        }

        /**
         * @return outputRawData
         */
        public String outputRawData() {
            return this.outputRawData;
        }

        /**
         * @return outputHeader
         */
        public String outputHeader() {
            return this.outputHeader;
        }

        /**
         * @return enablePayloadCrc
         */
        public String enablePayloadCrc() {
            return this.enablePayloadCrc;
        }

        /**
         * @return keepAllColumns
         */
        public String keepAllColumns() {
            return this.keepAllColumns;
        }

        public static final class Builder extends RequestModel.Builder<OutputSerialization.Builder> {
      
            private OutputSerializationCSV outputSerializationCSV; 
            private String outputRawData; 
            private String outputHeader; 
            private String enablePayloadCrc; 
            private String keepAllColumns; 

            /**
             * <p>CSV.</p>
             */
            public Builder outputSerializationCSV(OutputSerializationCSV outputSerializationCSV) {
                this.outputSerializationCSV = outputSerializationCSV;
                return this;
            }

            /**
             * <p>OutputRawData.</p>
             */
            public Builder outputRawData(String outputRawData) {
                this.outputRawData = outputRawData;
                return this;
            }

            /**
             * <p>OutputHeader.</p>
             */
            public Builder outputHeader(String outputHeader) {
                this.outputHeader = outputHeader;
                return this;
            }

            /**
             * <p>EnablePayloadCrc.</p>
             */
            public Builder enablePayloadCrc(String enablePayloadCrc) {
                this.enablePayloadCrc = enablePayloadCrc;
                return this;
            }

            /**
             * <p>KeepAllColumns.</p>
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
        @NameInMap("MaxSkippedRecordsAllowed")
        private String maxSkippedRecordsAllowed;

        @NameInMap("SkipPartialDataRecord")
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
        public String maxSkippedRecordsAllowed() {
            return this.maxSkippedRecordsAllowed;
        }

        /**
         * @return skipPartialDataRecord
         */
        public String skipPartialDataRecord() {
            return this.skipPartialDataRecord;
        }

        public static final class Builder extends RequestModel.Builder<Options.Builder> {
      
            private String maxSkippedRecordsAllowed; 
            private String skipPartialDataRecord; 

            /**
             * <p>MaxSkippedRecordsAllowed.</p>
             */
            public Builder maxSkippedRecordsAllowed(String maxSkippedRecordsAllowed) {
                this.maxSkippedRecordsAllowed = maxSkippedRecordsAllowed;
                return this;
            }

            /**
             * <p>SkipPartialDataRecord.</p>
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
        @NameInMap("InputSerialization")
        private InputSerialization inputSerialization;

        @NameInMap("Expression")
        private String expression;

        @NameInMap("OutputSerialization")
        private OutputSerialization outputSerialization;

        @NameInMap("Options")
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
        public InputSerialization inputSerialization() {
            return this.inputSerialization;
        }

        /**
         * @return expression
         */
        public String expression() {
            return this.expression;
        }

        /**
         * @return outputSerialization
         */
        public OutputSerialization outputSerialization() {
            return this.outputSerialization;
        }

        /**
         * @return options
         */
        public Options options() {
            return this.options;
        }

        public static final class Builder extends RequestModel.Builder<SelectRequest.Builder> {
      
            private InputSerialization inputSerialization; 
            private String expression; 
            private OutputSerialization outputSerialization; 
            private Options options; 

            /**
             * <p>InputSerialization.</p>
             */
            public Builder inputSerialization(InputSerialization inputSerialization) {
                this.inputSerialization = inputSerialization;
                return this;
            }

            /**
             * <p>Expression.</p>
             */
            public Builder expression(String expression) {
                this.expression = expression;
                return this;
            }

            /**
             * <p>OutputSerialization.</p>
             */
            public Builder outputSerialization(OutputSerialization outputSerialization) {
                this.outputSerialization = outputSerialization;
                return this;
            }

            /**
             * <p>Options.</p>
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
