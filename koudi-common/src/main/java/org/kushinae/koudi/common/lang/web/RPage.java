package org.kushinae.koudi.common.lang.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @author bnyte
 * @since 1.0.0
 */
public class RPage<T> {

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
    private List<T> records;

    /**
     * 当前页码
     */
    private Long current;

    /**
     * 请求查询的数量
     */
    private Long pageSize;

    /**
     * 当前查询结果的总记录数
     */
    private Long total;

    /**
     * 用于返回给前端本次请求是否成功
     */
    private Boolean success;

    private RPage() {}

    public static <T> RPage<T> OK(Page<T> page) {
        RPage<T> RPage = new RPage<>();
        RPage.setPageSize(page.getSize());
        RPage.setCurrent(page.getCurrent());
        RPage.setRecords(page.getRecords());
        RPage.setTotal(page.getTotal());
        RPage.setCode(Status.ok.getCode());
        RPage.setMessage(Status.ok.getMessage());
        RPage.setSuccess(true);
        return RPage;
    }

    public static <T, R> RPage<R> OK(IPage<T> page, List<R> records) {
        RPage<R> RPage = new RPage<>();
        RPage.setPageSize(page.getSize());
        RPage.setTotal(page.getTotal());
        RPage.setCurrent(page.getCurrent());
        RPage.setRecords(records);
        RPage.setCode(Status.ok.getCode());
        RPage.setMessage(Status.ok.getMessage());
        RPage.setSuccess(true);
        return RPage;
    }

    public static <T, R> RPage<R> OK(IPage<T> page, Class<R> targetType) {
        RPage<R> RPage = new RPage<>();
        RPage.setPageSize(page.getSize());
        RPage.setTotal(page.getTotal());
        RPage.setCurrent(page.getCurrent());
        List<T> pageRecords = page.getRecords();
        if (!CollectionUtils.isEmpty(pageRecords)) {
            RPage.setRecords(pageRecords.stream().map(e -> {
                R instance = null;
                try {
                    instance = targetType.getConstructor().newInstance();
                    BeanUtils.copyProperties(e, instance);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                         NoSuchMethodException ex) {
                    throw new RuntimeException(ex);
                }
                return instance;
            }).toList());
        }
        RPage.setCode(Status.ok.getCode());
        RPage.setMessage(Status.ok.getMessage());
        RPage.setSuccess(true);
        return RPage;
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

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
