package org.kushinae.koudi.common.entity.product;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.kushinae.koudi.common.entity.GlobalEntity;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 商品、规格与包装的属性key及值,值可以多个 使用英文逗号分隔
 * </p>
 *
 * @author bnyte
 * @since 2022-11-17
 */
@TableName("t_attr")
@ApiModel(value = "Attr对象", description = "商品、规格与包装的属性key及值,值可以多个 使用英文逗号分隔")
public class Attr extends GlobalEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("属性名")
    private String name;

    @ApiModelProperty("是否需要检索[0-false-不需要，1-true-需要]")
    private Boolean enableSearch;

    @ApiModelProperty("值类型[0-false-为单个值，1-true-可以选择多个值]")
    private Boolean multiple;

    @ApiModelProperty("属性图标")
    private String icon;

    @ApiModelProperty("可选值列表[用逗号分隔]")
    private String multipleValue;

    @ApiModelProperty("属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]")
    private Integer type;

    @ApiModelProperty("快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整")
    private Boolean quickShow;

    @TableField(exist = false)
    private Long attrGroupId;

    @TableField(exist = false)
    private String groupName;

    @TableField(exist = false)
    private String categoryName;

    @TableField(exist = false)
    private List<Long> categories;

    @ApiModelProperty("分类id")
    @TableField(exist = false)
    private Long categoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMultipleValue() {
        return multipleValue;
    }

    public void setMultipleValue(String multipleValue) {
        this.multipleValue = multipleValue;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getQuickShow() {
        return quickShow;
    }

    public void setQuickShow(Boolean quickShow) {
        this.quickShow = quickShow;
    }

    public Long getAttrGroupId() {
        return attrGroupId;
    }

    public void setAttrGroupId(Long attrGroupId) {
        this.attrGroupId = attrGroupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Long> getCategories() {
        return categories;
    }

    public void setCategories(List<Long> categories) {
        this.categories = categories;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
