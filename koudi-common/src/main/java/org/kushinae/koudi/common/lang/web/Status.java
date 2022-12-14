package org.kushinae.koudi.common.lang.web;

import java.io.Serial;
import java.io.Serializable;

public enum Status implements Serializable {
    ok(0, "succeeded"),
    error(-1, "failed"),

    /*
        100000 - 199999 用户相关异常
     */
    ACCOUNT_NOT_FOUNT(100000, "账户不存在"),
    ACCOUNT_OR_PASSWORD_ERROR(100001, "账户名或密码错误"),

    /*
        400000 - 499999 客户端相关异常
     */
    PAYLOAD_ASSERT_ERROR(400000, "{message}"),
    PARAMETER_CHECK_EXCEPTION(400001, "{message}"),
    /*
        500000 - 599999 系统、业务异常
     */
    UNKNOWN_BUSINESS_EXCEPTION(500000, "未知异常"),
    FOREST_CLIENT_NOT_FOUND(500001, "未找到对应相关HTTP客户端对象"),
    DATA_DOES_NOT_EXIST(500002, "数据不存在"),
    NOT_A_FILE(500003, "不是一个文件"),
    ;

    @Serial
    private static final long serialVersionUID = 94264211209183701L;

    /**
     * 响应状态码
     */
    private Integer code;
    /**
     * 响应信息
     */
    private String message;

    Status(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseCode{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}