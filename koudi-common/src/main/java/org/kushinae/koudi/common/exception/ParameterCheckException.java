package org.kushinae.koudi.common.exception;

import org.kushinae.koudi.common.lang.web.Status;

/**
 * 400
 * @author bnyte
 * @since 1.0.0
 */
public class ParameterCheckException extends GlobalException {

    public ParameterCheckException(String message) {
        super(message);
        setStatus(Status.PARAMETER_CHECK_EXCEPTION);
    }

    public ParameterCheckException(Status status) {
        super(status.getMessage());
        setStatus(status);
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
