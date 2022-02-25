package cn.vorbote.web.model;

import cn.vorbote.core.time.DateTime;
import cn.vorbote.core.utils.StringUtil;
import cn.vorbote.web.constants.WebStatus;
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
    public int code() {
        return code;
    }

    /**
     * <b>This method is deprecated, please use {@link #code()} instead.</b><br>
     * Get the data of status.
     *
     * @return The status.
     */
    @Deprecated
    public int Code() {
        return code;
    }

    /**
     * Set the data of status.
     *
     * @param code The status.
     * @return The instance itself.
     */
    public ResponseResult<T> code(int code) {
        this.code = code;
        return this;
    }

    /**
     * <b>This method is deprecated, please use {@link #code(int)} instead.</b><br>
     * Set the data of status.
     *
     * @param code The status.
     * @return The instance itself.
     */
    @Deprecated
    public ResponseResult<T> Code(int code) {
        this.code = code;
        return this;
    }

    /**
     * Get the data of result.
     *
     * @return The result.
     */
    public T data() {
        return data;
    }

    /**
     * <b>This method is deprecated, please use {@link #data()} instead.</b><br>
     * Get the data of result.
     *
     * @return The result.
     */
    @Deprecated
    public T Data() {
        return data();
    }

    /**
     * Set the data of result.
     *
     * @param data The result.
     * @return The instance itself.
     */
    public ResponseResult<T> data(T data) {
        this.data = data;
        return this;
    }

    /**
     * <b>This method is deprecated, please use {@link #data(Object)} instead.</b><br>
     * Set the data of result.
     *
     * @param data The result.
     * @return The instance itself.
     */
    @Deprecated
    public ResponseResult<T> Data(T data) {
        return data(data);
    }

    /**
     * Get the data of timestamp.
     *
     * @return The timestamp.
     */
    public long timestamp() {
        return timestamp;
    }

    /**
     * <b>This method is deprecated, please use {@link #timestamp()} instead.</b><br>
     * Get the data of timestamp.
     *
     * @return The timestamp.
     */
    @Deprecated
    public long Timestamp() {
        return timestamp;
    }

    /**
     * Set the data of timestamp.
     *
     * @param timestamp The timestamp.
     * @return The instance itself.
     */
    public ResponseResult<T> timestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * <b>This method is deprecated, please use {@link #timestamp(long)} instead.</b><br>
     * Set the data of timestamp.
     *
     * @param timestamp The timestamp.
     * @return The instance itself.
     */
    @Deprecated
    public ResponseResult<T> Timestamp(long timestamp) {
        return timestamp(timestamp);
    }

    /**
     * Get the data of message.
     *
     * @return The message.
     */
    public String message() {
        return message;
    }

    /**
     * <b>This method is deprecated, please use {@link #message()} instead.</b><br>
     * Get the data of message.
     *
     * @return The message.
     */
    @Deprecated
    public String Message() {
        return message();
    }

    /**
     * Set the data of message.
     *
     * @param message The message.
     * @return The instance itself.
     */
    public ResponseResult<T> message(String message) {
        this.message = message;
        return this;
    }

    /**
     * <b>This method is deprecated, please use {@link #message(String)} instead.</b><br>
     * Set the data of message.
     *
     * @param message The message.
     * @return The instance itself.
     */
    @Deprecated
    public ResponseResult<T> Message(String message) {
        return message(message);
    }

    /**
     * Set the data of message.
     *
     * @param format The format message.
     * @param args   The args to be put into the message.
     * @return The instance itself.
     * @see StringUtil#format(String, Object...)
     */
    public ResponseResult<T> message(String format, Object... args) {
        this.message = StringUtil.format(format, args);
        return this;
    }

    /**
     * <b>This method is deprecated, please use {@link #message(String, Object...)} instead.</b><br>
     * Set the data of message.
     *
     * @param format The format message.
     * @param args   The args to be put into the message.
     * @return The instance itself.
     * @see StringUtil#format(String, Object...)
     */
    @Deprecated
    public ResponseResult<T> Message(String format, Object... args) {
        return message(format, args);
    }

    /**
     * Get the data of exception.
     *
     * @return The exception.
     */
    public String exception() {
        return exception;
    }

    /**
     * <b>This method is deprecated, please use {@link #exception()} instead.</b><br>
     * Get the data of exception.
     *
     * @return The exception.
     */
    public String Exception() {
        return exception();
    }

    /**
     * Set the data of exception.
     *
     * @param exception The exception.
     * @return The instance itself.
     */
    public ResponseResult<T> exception(String exception) {
        this.exception = exception;
        return this;
    }

    /**
     * <b>This method is deprecated, please use {@link #exception(String)} instead.</b><br>
     * Set the data of exception.
     *
     * @param exception The exception.
     * @return The instance itself.
     */
    @Deprecated
    public ResponseResult<T> Exception(String exception) {
        return exception(exception);
    }

    /**
     * Set the data of exception.
     *
     * @param format The format message.
     * @param args   The args to be put into the message.
     * @return The instance itself.
     */
    public ResponseResult<T> exception(String format, Object... args) {
        this.exception = StringUtil.format(format, args);
        return this;
    }

    /**
     * <b>This method is deprecated, please use {@link #exception(String, Object...)} instead.</b><br>
     * Set the data of exception.
     *
     * @param format The format message.
     * @param args   The args to be put into the message.
     * @return The instance itself.
     */
    @Deprecated
    public ResponseResult<T> Exception(String format, Object... args) {
        this.exception = StringUtil.format(format, args);
        return this;
    }

    /**
     * Generate a new Response Result instance.
     */
    public ResponseResult() {
        this.timestamp = DateTime.now().unix();
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
     * <b>This method is deprecated, please use {@link #success(Object)} instead.</b><br>
     * Generate a new Response Result instance with a success status.
     *
     * @param data The data.
     * @param <T>  The type of the result.
     * @return The instance itself.
     */
    @Deprecated
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
     * <b>This method is deprecated, please use {@link #success(String)} instead.</b><br>
     * Generate a new Response Result instance with a success status.
     *
     * @param message The message.
     * @param <T>     The type of the result.
     * @return The instance itself.
     */
    @Deprecated
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
     * <b>This method is deprecated, please use {@link #success(Object, String)} instead.</b><br>
     * Generate a new Response Result instance with a success status.
     *
     * @param data    The data.
     * @param message The message.
     * @param <T>     The type of the result.
     * @return The instance itself.
     */
    @Deprecated
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
     * <b>This method is deprecated, please use {@link #timeout(String, String)} instead.</b><br>
     * Generate a new Response Result instance with a timeout status.
     *
     * @param message   The message.
     * @param exception The exception.
     * @param <T>       The type of the result.
     * @return The instance itself.
     */
    @Deprecated
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
     * <b>This method is deprecated, please use {@link #timeout(String)} instead.</b><br>
     * Generate a new Response Result instance with a timeout status.
     *
     * @param message The message.
     * @param <T>     The type of the result.
     * @return The instance itself.
     */
    @Deprecated
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
     * <b>This method is deprecated, please use {@link #error(String, String)} instead.</b><br>
     * Generate a new Response Result instance with an error status.
     *
     * @param message   The message.
     * @param exception The exception.
     * @param <T>       The type of the result.
     * @return The instance itself.
     */
    @Deprecated
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
     * <b>This method is deprecated, please use {@link #error(String)} instead.</b><br>
     * Generate a new Response Result instance with an error status.
     *
     * @param message The message.
     * @param <T>     The type of the result.
     * @return The instance itself.
     */
    @Deprecated
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
     * <b>This method is deprecated, please use {@link #unauthorized(String)} instead.</b><br>
     * Generate a new Response Result instance with an unauthorized status.
     *
     * @param message The message.
     * @param <T>     The type of the result.
     * @return The instance itself.
     */
    @Deprecated
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
     * <b>This method is deprecated, please use {@link #forbidden(String)} instead.</b><br>
     * Generate a new Response Result instance with a forbidden status.
     *
     * @param message The message.
     * @param <T>     The type of the result.
     * @return The instance itself.
     */
    @Deprecated
    public static <T> ResponseResult<T> Forbidden(String message) {
        var result = new ResponseResult<T>();
        result.code = WebStatus.FORBIDDEN;
        result.message = message;
        return result;
    }
}
