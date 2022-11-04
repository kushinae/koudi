package org.kushinae.koudi.common.properties.upyun.authorization;

/**
 * @author bnyte
 * @since 1.0.0
 */
//@ConfigurationProperties(prefix = "upyun.authorization")
//@AutoConfiguration
public class AuthorizationProperties {

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
