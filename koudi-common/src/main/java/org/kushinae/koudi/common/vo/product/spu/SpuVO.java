package org.kushinae.koudi.common.vo.product.spu;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author bnyte
 * @since 1.0.0
 */
public class SpuVO {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("商品主标题（如果在sku没有设置的话则默认使用spu的标题）")
    @NotBlank(message = "商品主标题不能为空")
    private String title;

    @ApiModelProperty("商品副标题（如果在sku没有设置的话则默认使用spu的副标题）")
    @NotBlank(message = "商品副标题不能为空")
    private String subTitle;

    @ApiModelProperty("spu的商品名称 如(Apple iPhone 13)")
    @NotBlank(message = "商品名称不能为空")
    private String name;

    @ApiModelProperty("分类表koudi_product.t_category的主键id")
    private Long categoryId;

    @ApiModelProperty("品牌表koudi_product.t_brand的主键id")
    private Long brandId;

    /**
     * @see org.kushinae.koudi.common.enums.product.ESpuStatus
     */
    @ApiModelProperty("当前商品状态: 0 - 库存中 1 - 提交审核 2 - 审核中 3 - 审核拒绝 4 - 审核通过 5 - 发布中")
    private Integer status;

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
}
