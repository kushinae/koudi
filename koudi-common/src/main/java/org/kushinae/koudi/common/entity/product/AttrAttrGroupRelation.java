package org.kushinae.koudi.common.entity.product;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.kushinae.koudi.common.entity.GlobalEntity;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * 属性键值和属性分组中间关联表
 * </p>
 *
 * @author bnyte
 * @since 2022-11-17
 */
@TableName("t_attr_attr_group_relation")
@ApiModel(value = "AttrAttrGroupRelation对象", description = "属性键值和属性分组中间关联表")
public class AttrAttrGroupRelation extends GlobalEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("属性规格分组id")
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Long attrGroupId;

    @ApiModelProperty("所属分类")
    private Long categoryId;

    @ApiModelProperty("属性id")
    private Long attrId;

    @ApiModelProperty("排序方式，数值越高优先级越高 默认为0")
    private Integer sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAttrGroupId() {
        return attrGroupId;
    }

    public void setAttrGroupId(Long attrGroupId) {
        this.attrGroupId = attrGroupId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }
}
