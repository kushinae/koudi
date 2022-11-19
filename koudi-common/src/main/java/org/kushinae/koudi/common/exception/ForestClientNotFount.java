package org.kushinae.koudi.common.exception;

import org.kushinae.koudi.common.lang.web.Status;

/**
 * @author bnyte
 * @since 1.0.0
 */
public class ForestClientNotFount extends GlobalException {

    public ForestClientNotFount() {
        super(Status.FOREST_CLIENT_NOT_FOUND.getMessage());
        setStatus(Status.FOREST_CLIENT_NOT_FOUND);
    }

    public ForestClientNotFount(String message) {
        super(message);
        setStatus(Status.FOREST_CLIENT_NOT_FOUND);
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
