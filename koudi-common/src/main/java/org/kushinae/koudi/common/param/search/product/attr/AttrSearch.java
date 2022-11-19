package org.kushinae.koudi.common.param.search.product.attr;

import org.kushinae.koudi.common.param.search.Search;

import java.util.List;

/**
 * 属性搜索参数
 * @author bnyte
 * @since 1.0.0
 */
public class AttrSearch extends Search {

    private List<Integer> type;

    private Boolean enableSearch;

    private Boolean multiple;

    public List<Integer> getType() {
        return type;
    }

    public void setType(List<Integer> type) {
        this.type = type;
    }

    public Boolean getEnableSearch() {
        return enableSearch;
    }

    public void setEnableSearch(Boolean enableSearch) {
        this.enableSearch = enableSearch;
    }

    public Boolean getMultiple() {
        return multiple;
    }

    public void setMultiple(Boolean multiple) {
        this.multiple = multiple;
    }
}
