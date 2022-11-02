package org.kushinae.koudi.common.param.search;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author bnyte
 * @since 1.0.0
 */
@Data
public class Search {

    @ApiModelProperty("当前页码")
    private Long current = 1L;

    @ApiModelProperty("查询记录数")
    private Long queryCount = 20L;

}
