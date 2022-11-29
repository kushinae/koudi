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
public class Spu extends GlobalEntity implements Serializable {

    @Serial
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

    @TableField(exist = false)
    private String categoryName;

    @TableField(exist = false)
    private String brandName;

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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
