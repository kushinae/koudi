package org.kushinae.koudi.common.properties.upyun.operator;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author bnyte
 * @since 1.0.0
 */
@Configuration
@ConfigurationProperties(prefix = "upyun.operator")
public class OperatorProperties {

    /**
     * 操作员用户名
     */
    private String name;

    /**
     * 操作员密码
     */
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "OperatorProperties{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
