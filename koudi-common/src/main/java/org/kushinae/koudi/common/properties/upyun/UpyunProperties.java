package org.kushinae.koudi.common.properties.upyun;

import org.kushinae.koudi.common.properties.upyun.authorization.AuthorizationProperties;
import org.kushinae.koudi.common.properties.upyun.operator.OperatorProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author bnyte
 * @since 1.0.0
 */
@Configuration
@ConfigurationProperties(prefix = "upyun")
public class UpyunProperties {

    /**
     * 又拍云请求地址
     */
    private String httpPath;

    /**
     * 又拍云的服务名称
     */
    private String serviceName;

    /**
     * 上传文件路径
     */
    private String dirPath;

    private AuthorizationProperties authorization;

    private OperatorProperties operator;

    public AuthorizationProperties getAuthorization() {
        return authorization;
    }

    public void setAuthorization(AuthorizationProperties authorization) {
        this.authorization = authorization;
    }

    public OperatorProperties getOperator() {
        return operator;
    }

    public void setOperator(OperatorProperties operator) {
        this.operator = operator;
    }

    public String getHttpPath() {
        return httpPath;
    }

    public void setHttpPath(String httpPath) {
        this.httpPath = httpPath;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDirPath() {
        return dirPath;
    }

    public void setDirPath(String dirPath) {
        this.dirPath = dirPath;
    }

    public String getUploadPath(String filename) {
        return this.getHttpPath() + "/" + getDirPath() + "/" + filename;
    }

    public String getUploadPath(String folder, String filename) {
        return this.getHttpPath() + "/" + getDirPath() + "/" + folder + "/" + filename;
    }
}

