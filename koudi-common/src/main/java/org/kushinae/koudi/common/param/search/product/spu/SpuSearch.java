package org.kushinae.koudi.common.param.search.product.spu;

import org.kushinae.koudi.common.param.search.Search;

/**
 * @author bnyte
 * @since 1.0.0
 */
public class SpuSearch extends Search {

    private String title;

    private String subTitle;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
