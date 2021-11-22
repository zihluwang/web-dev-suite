package cn.vorbote.web.model;

import cn.vorbote.common.utils.StringUtil;
import cn.vorbote.commons.consts.WebStatus;
import cn.vorbote.time.DateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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

    private int code;
    private T data;
    private long timestamp;
    private String message;
    private String exception;

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
    }

    /**
     * Generate a new Response Result instance with a success status.
     *
     * @param data The data.
     * @param <T>  The type of the result.
     * @return The instance itself.
     */
    public static <T> ResponseResult<T> success(T data) {
        var result = new ResponseResult<T>();
        result.code = WebStatus.OK;
        result.data = data;
        return result;
    }

    /**
     * Generate a new Response Result instance with a success status.
     *
     * @param data The data.
     * @param <T>  The type of the result.
     * @return The instance itself.
     */
    public static <T> ResponseResult<T> Success(T data) {
        var result = new ResponseResult<T>();
        result.code = WebStatus.OK;
        result.data = data;
        return result;
    }

    /**
     * Generate a new Response Result instance with a success status.
     *
     * @param message The message.
     * @param <T>     The type of the result.
     * @return The instance itself.
     */
    public static <T> ResponseResult<T> success(String message) {
        var result = new ResponseResult<T>();
        result.code = WebStatus.OK;
        result.message = message;
        return result;
    }

    /**
     * Generate a new Response Result instance with a success status.
     *
     * @param message The message.
     * @param <T>     The type of the result.
     * @return The instance itself.
     */
    public static <T> ResponseResult<T> Success(String message) {
        var result = new ResponseResult<T>();
        result.code = WebStatus.OK;
        result.message = message;
        return result;
    }

    /**
     * Generate a new Response Result instance with a success status.
     *
     * @param data    The data.
     * @param message The message.
     * @param <T>     The type of the result.
     * @return The instance itself.
     */
    public static <T> ResponseResult<T> success(T data, String message) {
        var result = new ResponseResult<T>();
        result.code = WebStatus.OK;
        result.data = data;
        result.message = message;
        return result;
    }

    /**
     * Generate a new Response Result instance with a success status.
     *
     * @param data    The data.
     * @param message The message.
     * @param <T>     The type of the result.
     * @return The instance itself.
     */
    public static <T> ResponseResult<T> Success(T data, String message) {
        var result = new ResponseResult<T>();
        result.code = WebStatus.OK;
        result.data = data;
        result.message = message;
        return result;
    }

    /**
     * Generate a new Response Result instance with a timeout status.
     *
     * @param message   The message.
     * @param exception The exception.
     * @param <T>       The type of the result.
     * @return The instance itself.
     */
    public static <T> ResponseResult<T> timeout(String message, String exception) {
        var result = new ResponseResult<T>();
        result.code = WebStatus.REQUEST_TIMEOUT;
        result.message = message;
        result.exception = exception;
        return result;
    }

    /**
     * Generate a new Response Result instance with a timeout status.
     *
     * @param message   The message.
     * @param exception The exception.
     * @param <T>       The type of the result.
     * @return The instance itself.
     */
    public static <T> ResponseResult<T> Timeout(String message, String exception) {
        var result = new ResponseResult<T>();
        result.code = WebStatus.REQUEST_TIMEOUT;
        result.message = message;
        result.exception = exception;
        return result;
    }

    /**
     * Generate a new Response Result instance with a timeout status.
     *
     * @param message The message.
     * @param <T>     The type of the result.
     * @return The instance itself.
     */
    public static <T> ResponseResult<T> timeout(String message) {
        var result = new ResponseResult<T>();
        result.code = WebStatus.REQUEST_TIMEOUT;
        result.message = message;
        return result;
    }

    /**
     * Generate a new Response Result instance with a timeout status.
     *
     * @param message The message.
     * @param <T>     The type of the result.
     * @return The instance itself.
     */
    public static <T> ResponseResult<T> Timeout(String message) {
        var result = new ResponseResult<T>();
        result.code = WebStatus.REQUEST_TIMEOUT;
        result.message = message;
        return result;
    }

    /**
     * Generate a new Response Result instance with an error status.
     *
     * @param message   The message.
     * @param exception The exception.
     * @param <T>       The type of the result.
     * @return The instance itself.
     */
    public static <T> ResponseResult<T> error(String message, String exception) {
        var result = new ResponseResult<T>();
        result.code = WebStatus.INTERNAL_SERVER_ERROR;
        result.message = message;
        result.exception = exception;
        return result;
    }

    /**
     * Generate a new Response Result instance with an error status.
     *
     * @param message   The message.
     * @param exception The exception.
     * @param <T>       The type of the result.
     * @return The instance itself.
     */
    public static <T> ResponseResult<T> Error(String message, String exception) {
        var result = new ResponseResult<T>();
        result.code = WebStatus.INTERNAL_SERVER_ERROR;
        result.message = message;
        result.exception = exception;
        return result;
    }

    /**
     * Generate a new Response Result instance with an error status.
     *
     * @param message The message.
     * @param <T>     The type of the result.
     * @return The instance itself.
     */
    public static <T> ResponseResult<T> error(String message) {
        var result = new ResponseResult<T>();
        result.code = WebStatus.INTERNAL_SERVER_ERROR;
        result.message = message;
        return result;
    }

    /**
     * Generate a new Response Result instance with an error status.
     *
     * @param message The message.
     * @param <T>     The type of the result.
     * @return The instance itself.
     */
    public static <T> ResponseResult<T> Error(String message) {
        var result = new ResponseResult<T>();
        result.code = WebStatus.INTERNAL_SERVER_ERROR;
        result.message = message;
        return result;
    }

    /**
     * Generate a new Response Result instance with an unauthorized status.
     *
     * @param message The message.
     * @param <T>     The type of the result.
     * @return The instance itself.
     */
    public static <T> ResponseResult<T> unauthorized(String message) {
        var result = new ResponseResult<T>();
        result.code = WebStatus.UNAUTHORIZED;
        result.message = message;
        return result;
    }

    /**
     * Generate a new Response Result instance with an unauthorized status.
     *
     * @param message The message.
     * @param <T>     The type of the result.
     * @return The instance itself.
     */
    public static <T> ResponseResult<T> Unauthorized(String message) {
        var result = new ResponseResult<T>();
        result.code = WebStatus.UNAUTHORIZED;
        result.message = message;
        return result;
    }

    /**
     * Generate a new Response Result instance with a forbidden status.
     *
     * @param message The message.
     * @param <T>     The type of the result.
     * @return The instance itself.
     */
    public static <T> ResponseResult<T> forbidden(String message) {
        var result = new ResponseResult<T>();
        result.code = WebStatus.FORBIDDEN;
        result.message = message;
        return result;
    }

    /**
     * Generate a new Response Result instance with a forbidden status.
     *
     * @param message The message.
     * @param <T>     The type of the result.
     * @return The instance itself.
     */
    public static <T> ResponseResult<T> Forbidden(String message) {
        var result = new ResponseResult<T>();
        result.code = WebStatus.FORBIDDEN;
        result.message = message;
        return result;
    }
}
