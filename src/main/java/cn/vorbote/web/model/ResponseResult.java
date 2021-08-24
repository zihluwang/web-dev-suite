package cn.vorbote.web.model;

import cn.vorbote.common.utils.StringUtil;
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

    protected int code;
    protected T data;
    protected long timestamp = DateTime.Now().Unix();
    protected String message;
    protected String exception;

    /**
     * Get the data of status.
     *
     * @return The status.
     */
    public int Code() {
        return code;
    }

    /**
     * Set the data of status.
     *
     * @param code The status.
     * @return The instance itself.
     */
    public ResponseResult<T> Code(int code) {
        this.code = code;
        return this;
    }

    /**
     * Get the data of result.
     *
     * @return The result.
     */
    public T Data() {
        return data;
    }

    /**
     * Set the data of result.
     *
     * @param data The result.
     * @return The instance itself.
     */
    public ResponseResult<T> Data(T data) {
        this.data = data;
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
     * Set the data of message.
     *
     * @param format The format message.
     * @param args   The args to be put into the message.
     * @return The instance itself.
     * @see cn.vorbote.common.utils.StringUtil#Format(String, Object...)
     */
    public ResponseResult<T> Message(String format, Object... args) {
        this.message = StringUtil.Format(format, args);
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
     * Set the data of exception.
     *
     * @param format The format message.
     * @param args   The args to be put into the message.
     * @return The instance itself.
     */
    public ResponseResult<T> Exception(String format, Object... args) {
        this.exception = StringUtil.Format(format, args);
        return this;
    }

    /**
     * Generate a new Response Result instance.
     */
    public ResponseResult() {
        this.timestamp = DateTime.Now().Unix();
        this.code = WebStatus.OK;
    }


    /**
     * A Response result builder.
     *
     * @param <T> The data will be stored.
     */
    public static class ResponseResultBuilder<T> {
        protected int code;
        protected T data;
        protected long timestamp;
        protected String message;
        protected String exception;

        /**
         * Set the status.
         *
         * @param code The status code, recommended to use the data in {@code cn.vorbote.commons.WebStatus}.
         * @return The builder itself.
         */
        public ResponseResultBuilder<T> code(int code) {
            this.code = code;
            return this;
        }

        /**
         * Set the result.
         *
         * @param data The result.
         * @return The builder itself.
         */
        public ResponseResultBuilder<T> data(T data) {
            this.data = data;
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
                    .Data(this.data)
                    .Message(this.message);
            if (this.code != 0 && this.code != 200) {
                response.Code(this.code);
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
