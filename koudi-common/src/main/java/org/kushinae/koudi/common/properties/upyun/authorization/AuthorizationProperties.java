package org.kushinae.koudi.common.properties.upyun.authorization;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author bnyte
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "upyun.authorization")
@Configuration
public class AuthorizationProperties {

    /**
     * 鉴权请求头
     */
    private String header = "Authorization";

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    @Override
    public String toString() {
        return "AuthorizationProperties{" +
                "header='" + header + '\'' +
                '}';
    }
}
