package org.kushinae.koudi.common.exception;

import org.kushinae.koudi.common.lang.web.Status;

/**
 * @see org.kushinae.koudi.common.handler.ResponseAdviceHandler 在此处做了全局异常处理 而新的模块抛出异常时需要在改异常处理类中进行指定包路径
 * @author bnyte
 * @since 1.0.0
 */
public class GlobalException extends RuntimeException {
    protected Status status;

    public GlobalException() {
        super();
    }

    public GlobalException(Status status) {
        super(status.getMessage());
        setStatus(status);
    }

    public GlobalException(Status status, String message) {
        super(message);
        setStatus(status);
    }

    public GlobalException(String message) {
        super(message);
    }

    public GlobalException(String message, Throwable cause) {
        super(message, cause);
    }

    public GlobalException(Throwable cause) {
        super(cause);
    }

    public GlobalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
