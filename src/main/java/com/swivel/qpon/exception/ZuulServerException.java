package com.swivel.qpon.exception;

public class ZuulServerException extends RuntimeException {

    /**
     * ZuulServerException with error message.
     *
     * @param errorMessage error message
     */
    public ZuulServerException(String errorMessage) {
        super(errorMessage);
    }

    /**
     * ZuulServerException with error message and throwable error
     *
     * @param errorMessage error message
     * @param error        error
     */
    public ZuulServerException(String errorMessage, Throwable error) {
        super(errorMessage, error);
    }
}
