package org.kushinae.koudi.common.entity.product;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * spu商品信息
 * </p>
 *
 * @author bnyte
 * @since 2022-11-26
 */
@TableName("t_spu")
@ApiModel(value = "Spu对象", description = "spu商品信息")
public class Spu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("商品主标题（如果在sku没有设置的话则默认使用spu的标题）")
    private String title;

    @ApiModelProperty("商品副标题（如果在sku没有设置的话则默认使用spu的副标题）")
    private String subTitle;

    @ApiModelProperty("spu的商品名称 如(Apple iPhone 13)")
    private String name;

    @ApiModelProperty("分类表koudi_product.t_category的主键id")
    private Long categoryId;

    @ApiModelProperty("品牌表koudi_product.t_brand的主键id")
    private Long brandId;

    @ApiModelProperty("当前商品状态: 0 - 库存中 1 - 提交审核 2 - 审核中 3 - 审核拒绝 4 - 审核通过 5 - 发布中")
    private Integer status;

    @ApiModelProperty("购买之后所得积分")
    private Long integral;

    @ApiModelProperty("购买之后所得成长值")
    private Long growth;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getIntegral() {
        return integral;
    }

    public void setIntegral(Long integral) {
        this.integral = integral;
    }

    public Long getGrowth() {
        return growth;
    }

    public void setGrowth(Long growth) {
        this.growth = growth;
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
        return "Spu{" +
            "id = " + id +
            ", title = " + title +
            ", subTitle = " + subTitle +
            ", name = " + name +
            ", categoryId = " + categoryId +
            ", brandId = " + brandId +
            ", status = " + status +
            ", integral = " + integral +
            ", growth = " + growth +
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
