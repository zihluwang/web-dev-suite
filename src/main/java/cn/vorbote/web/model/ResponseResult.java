package cn.vorbote.web.model;

import cn.vorbote.commons.consts.WebStatus;
import cn.vorbote.time.DateTime;
import lombok.*;

/**
 * Response model for response body.
 *
 * @param <T> The type of the result.
 * @author vorbote
 */
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public final class ResponseResult<T> {

    private int status;
    private T result;
    private long timestamp;
    private String message;
    private String exception;

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

    public ResponseResult() {
        this.timestamp = DateTime.Now().Unix();
        this.status = WebStatus.OK;
    }
}
