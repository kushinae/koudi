package org.kushinae.koudi.common.param.search;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author bnyte
 * @since 1.0.0
 */
public abstract class Search {

    @ApiModelProperty("当前页码")
    private Long current = 1L;

    @ApiModelProperty("查询记录数")
    private Long pageSize = 20L;

    @ApiModelProperty("全局通用搜索关键词")
    private String key;

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
