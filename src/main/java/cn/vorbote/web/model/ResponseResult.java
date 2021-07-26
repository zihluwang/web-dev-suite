package cn.vorbote.web.model;

import cn.vorbote.time.DateTime;
import cn.vorbote.web.dictionary.StatusDict;

/**
 * Response model for response body.
 *
 * @param <T> The type of the result.
 * @author vorbote
 */
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
     */
    public void Status(int status) {
        this.status = status;
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
     */
    public void Result(T result) {
        this.result = result;
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
     */
    public void Timestamp(long timestamp) {
        this.timestamp = timestamp;
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
     */
    public void Message(String message) {
        this.message = message;
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
     */
    public void Exception(String exception) {
        this.exception = exception;
    }

    /**
     * Build a Response model.
     */
    public ResponseResult() {
        this.timestamp = DateTime.Now().Unix();
        this.status = StatusDict.OK;
    }
}
