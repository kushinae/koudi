package org.kushinae.koudi.common.param.search.product.attrgroup;

import org.kushinae.koudi.common.param.search.Search;

/**
 * @author bnyte
 * @since 1.0.0
 */
public class AttrGroupSearch extends Search {

    private Long categoryId;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
