package cn.vorbote.web.model;

import cn.vorbote.commons.consts.WebStatus;
import cn.vorbote.time.DateTime;
import lombok.*;

/**
 * Response model for response body.
 *
 * @param <T> The type of the result.
 * @author vorbote thills@vorbote.cn
 */
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public final class ResponseResult<T> {

    protected int status;
    protected T result;
    protected long timestamp = DateTime.Now().Unix();
    protected String message;
    protected String exception;

    /**
     * Get the data of status.
     *
     * @return The status.
     */
    public int Status() {
        return status;
    }

    /**
     * Set the data of status.
     *
     * @param status The status.
     * @return The instance itself.
     */
    public ResponseResult<T> Status(int status) {
        this.status = status;
        return this;
    }

    /**
     * Get the data of result.
     *
     * @return The result.
     */
    public T Result() {
        return result;
    }

    /**
     * Set the data of result.
     *
     * @param result The result.
     * @return The instance itself.
     */
    public ResponseResult<T> Result(T result) {
        this.result = result;
        return this;
    }

    /**
     * Get the data of timestamp.
     *
     * @return The timestamp.
     */
    public long Timestamp() {
        return timestamp;
    }

    /**
     * Set the data of timestamp.
     *
     * @param timestamp The timestamp.
     * @return The instance itself.
     */
    public ResponseResult<T> Timestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * Get the data of message.
     *
     * @return The message.
     */
    public String Message() {
        return message;
    }

    /**
     * Set the data of message.
     *
     * @param message The message.
     * @return The instance itself.
     */
    public ResponseResult<T> Message(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get the data of exception.
     *
     * @return The exception.
     */
    public String Exception() {
        return exception;
    }

    /**
     * Set the data of exception.
     *
     * @param exception The exception.
     * @return The instance itself.
     */
    public ResponseResult<T> Exception(String exception) {
        this.exception = exception;
        return this;
    }

    /**
     * Generate a new Response Result instance.
     */
    public ResponseResult() {
        this.timestamp = DateTime.Now().Unix();
        this.status = WebStatus.OK;
    }



    /**
     * A Response result builder.
     *
     * @param <T> The data will be stored.
     */
    public static class ResponseResultBuilder<T> {
        protected int status;
        protected T result;
        protected long timestamp;
        protected String message;
        protected String exception;

        /**
         * Set the status.
         *
         * @param status The status code, recommended to use the data in {@code cn.vorbote.commons.WebStatus}.
         * @return The builder itself.
         */
        public ResponseResultBuilder<T> status(int status) {
            this.status = status;
            return this;
        }

        /**
         * Set the result.
         *
         * @param result The result.
         * @return The builder itself.
         */
        public ResponseResultBuilder<T> result(T result) {
            this.result = result;
            return this;
        }

        /**
         * Set the timestamp.
         *
         * @param timestamp The timestamp.
         * @return The builder itself.
         */
        public ResponseResultBuilder<T> timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        /**
         * Set the message.
         *
         * @param message The message.
         * @return The builder itself.
         */
        public ResponseResultBuilder<T> message(String message) {
            this.message = message;
            return this;
        }

        /**
         * Set the exception.
         *
         * @param exception The exception.
         * @return The builder itself.
         */
        public ResponseResultBuilder<T> exception(String exception) {
            this.exception = exception;
            return this;
        }

        /**
         * Build a response result.
         *
         * @return A response result.
         */
        public ResponseResult<T> build() {
            var response = new ResponseResult<T>();
            response.Exception(this.exception)
                    .Result(this.result)
                    .Message(this.message);
            if (this.status != 0 && this.status != 200) {
                response.Status(this.status);
            }
            if (this.timestamp != 0 && this.timestamp != DateTime.Now().Unix()) {
                response.Timestamp(this.timestamp);
            }

            return response;
        }
    }

    /**
     * Get a builder for response result.
     *
     * @param <T> The type to store.
     * @return A new builder.
     */
    public static <T> ResponseResultBuilder<T> builder() {
        return new ResponseResultBuilder<>();
    }

}
