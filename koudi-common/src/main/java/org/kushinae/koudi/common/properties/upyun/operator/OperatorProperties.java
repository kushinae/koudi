package org.kushinae.koudi.common.properties.upyun.operator;

/**
 * @author bnyte
 * @since 1.0.0
 */
//@AutoConfiguration
//@ConfigurationProperties(prefix = "upyun.operator")
public class OperatorProperties {

    private String name;
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
