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
        status = Status.PARAMETER_CHECK_EXCEPTION;
    }
}
