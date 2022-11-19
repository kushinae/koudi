package org.kushinae.koudi.common.param.search.product.category;

import org.kushinae.koudi.common.param.search.Search;

/**
 * @author bnyte
 * @since 1.0.0
 */
public class TreeSearch extends Search {

    private Boolean disabled = false;

    private Long brandId;

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
}
