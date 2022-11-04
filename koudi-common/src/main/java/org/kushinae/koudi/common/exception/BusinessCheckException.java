package org.kushinae.koudi.common.exception;

import org.kushinae.koudi.common.lang.web.Status;

/**
 * @author bnyte
 * @since 1.0.0
 */
public class BusinessCheckException extends GlobalException {


    public BusinessCheckException(Status status) {
        super(status);
    }

    @Override
    public Status getStatus() {
        return super.getStatus();
    }

    @Override
    public void setStatus(Status status) {
        super.setStatus(status);
    }
}
