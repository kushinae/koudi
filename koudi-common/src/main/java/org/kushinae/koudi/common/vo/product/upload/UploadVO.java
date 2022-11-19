package org.kushinae.koudi.common.vo.product.upload;

/**
 * @author bnyte
 * @since 1.0.0
 */
public class UploadVO {

    private String filepath;

    public UploadVO() {
    }

    public UploadVO(String filepath) {
        this.filepath = filepath;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
}
