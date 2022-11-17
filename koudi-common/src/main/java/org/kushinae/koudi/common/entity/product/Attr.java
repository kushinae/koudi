package org.kushinae.koudi.common.entity.product;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

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
public class Attr implements Serializable {

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

    @ApiModelProperty("所属分类")
    private Long categoryId;

    @ApiModelProperty("快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整")
    private Boolean quickShow;

    @ApiModelProperty("数据创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty("数据更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date modifiedTime;

    @ApiModelProperty("数据创建用户")
    @TableField(fill = FieldFill.INSERT)
    private String createAdminId;

    @ApiModelProperty("数据创建用户名称")
    @TableField(fill = FieldFill.INSERT)
    private String createAdminName;

    @ApiModelProperty("数据更新用户名称")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String modifiedAdminName;

    @ApiModelProperty("数据更新用户")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String modifiedAdminId;

    @ApiModelProperty("是否逻辑删除 0否 1是 默认否")
    @TableLogic
    private Boolean deleted;

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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Boolean getQuickShow() {
        return quickShow;
    }

    public void setQuickShow(Boolean quickShow) {
        this.quickShow = quickShow;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getCreateAdminId() {
        return createAdminId;
    }

    public void setCreateAdminId(String createAdminId) {
        this.createAdminId = createAdminId;
    }

    public String getCreateAdminName() {
        return createAdminName;
    }

    public void setCreateAdminName(String createAdminName) {
        this.createAdminName = createAdminName;
    }

    public String getModifiedAdminName() {
        return modifiedAdminName;
    }

    public void setModifiedAdminName(String modifiedAdminName) {
        this.modifiedAdminName = modifiedAdminName;
    }

    public String getModifiedAdminId() {
        return modifiedAdminId;
    }

    public void setModifiedAdminId(String modifiedAdminId) {
        this.modifiedAdminId = modifiedAdminId;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Attr{" +
            "id = " + id +
            ", name = " + name +
            ", enableSearch = " + enableSearch +
            ", multiple = " + multiple +
            ", icon = " + icon +
            ", multipleValue = " + multipleValue +
            ", type = " + type +
            ", categoryId = " + categoryId +
            ", quickShow = " + quickShow +
            ", createTime = " + createTime +
            ", modifiedTime = " + modifiedTime +
            ", createAdminId = " + createAdminId +
            ", createAdminName = " + createAdminName +
            ", modifiedAdminName = " + modifiedAdminName +
            ", modifiedAdminId = " + modifiedAdminId +
            ", deleted = " + deleted +
        "}";
    }
}
