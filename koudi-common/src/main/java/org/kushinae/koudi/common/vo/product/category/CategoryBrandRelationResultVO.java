package org.kushinae.koudi.common.vo.product.category;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author bnyte
 * @since 1.0.0
 */
@ApiModel("分类和品牌绑定详情")
public class CategoryBrandRelationResultVO {

    @ApiModelProperty("分类列表")
    private List<CategoryVO> category;

    @ApiModelProperty("绑定的分类列表")
    private List<CategoryVO> relations;

    public List<CategoryVO> getCategory() {
        return category;
    }

    public void setCategory(List<CategoryVO> category) {
        this.category = category;
    }

    public List<CategoryVO> getRelations() {
        return relations;
    }

    public void setRelations(List<CategoryVO> relations) {
        this.relations = relations;
    }
}
