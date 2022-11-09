package org.kushinae.koudi.common.param.search.product.attrgroup;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.kushinae.koudi.common.param.search.Search;

/**
 * @author bnyte
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AttrGroupSearch extends Search {

    private Long categoryId;

}
