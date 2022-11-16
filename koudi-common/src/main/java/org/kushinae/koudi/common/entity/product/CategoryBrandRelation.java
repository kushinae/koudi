package org.kushinae.koudi.common.entity.product;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 品牌分类关联
 * </p>
 *
 * @author bnyte
 * @since 2022-11-16
 */
@TableName("t_category_brand_relation")
@ApiModel(value = "TCategoryBrandRelation对象", description = "品牌分类关联")
public class CategoryBrandRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("品牌id")
    private Long brandId;

    @ApiModelProperty("分类id")
    private Long categoryId;

    @ApiModelProperty("品牌名称")
    private String brandName;

    @ApiModelProperty("分类名称")
    private String categoryName;

    @ApiModelProperty("数据创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("数据更新时间")
    private LocalDateTime modifiedTime;

    @ApiModelProperty("数据创建用户")
    private String createAdminId;

    @ApiModelProperty("数据创建用户名称")
    private String createAdminName;

    @ApiModelProperty("数据更新用户名称")
    private String modifiedAdminName;

    @ApiModelProperty("数据更新用户")
    private String modifiedAdminId;

    @ApiModelProperty("是否逻辑删除 0否 1是 默认否")
    private Boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
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
        return "TCategoryBrandRelation{" +
            "id = " + id +
            ", brandId = " + brandId +
            ", categoryId = " + categoryId +
            ", brandName = " + brandName +
            ", categoryName = " + categoryName +
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
