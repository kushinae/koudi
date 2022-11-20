package org.kushinae.koudi.common.lang.web;

import java.io.Serial;
import java.io.Serializable;

/**
 * 全局统一返回对象
 * @author bnyte
 * @since 1.0.0
 */
public class R<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 94264211209183700L;

    /**
     * 响应状态码
     */
    private Integer code;

    /**
     * 响应返回信息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 用于返回给前端本次请求是否成功
     */
    private Boolean success;

    private R() {}

    public static <T> R<T> OK(T data) {
        R<T> r = new R<>();
        r.code = Status.ok.getCode();
        r.message = Status.ok.getMessage();
        r.success = true;
        r.data = data;
        return r;
    }

    public static R<Void> EMPTY() {
        R<Void> r = new R<>();
        r.code = Status.ok.getCode();
        r.message = Status.ok.getMessage();
        r.success = true;
        return r;
    }

    public static R<Void> ERROR() {
        R<Void> r = new R<>();
        r.code = Status.error.getCode();
        r.message = Status.error.getMessage();
        r.success = false;
        return r;
    }

    public static R<Void> ERROR(Status status) {
        R<Void> r = new R<>();
        r.code = status.getCode();
        r.message = status.getMessage();
        r.success = false;
        return r;
    }

    public static R<Void> ERROR(Status status, String msg) {
        R<Void> r = new R<>();
        r.code = status.getCode();
        r.message = msg;
        r.success = false;
        return r;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public Boolean getSuccess() {
        return success;
    }
}