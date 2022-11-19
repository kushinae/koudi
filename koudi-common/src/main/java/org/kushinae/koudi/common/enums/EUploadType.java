package org.kushinae.koudi.common.enums;

/**
 * @author bnyte
 * @since 1.0.0
 */
public enum EUploadType {

    DEFAULT("public"),
    BRAND("brand"),

    ;

    private String path;

    EUploadType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
