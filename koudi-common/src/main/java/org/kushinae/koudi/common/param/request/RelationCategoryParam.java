package org.kushinae.koudi.common.param.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author bnyte
 * @since 1.0.0
 */
@ApiModel("品牌绑定分类请求参数")
public class RelationCategoryParam {

    @NotNull(message = "品牌未定义请联系管理员")
    @ApiModelProperty("brand主键")
    private Long id;

    @NotNull(message = "分类不能为空")
    @ApiModelProperty("分类列表")
    private List<Long> categories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getCategories() {
        return categories;
    }

    public void setCategories(List<Long> categories) {
        this.categories = categories;
    }
}
