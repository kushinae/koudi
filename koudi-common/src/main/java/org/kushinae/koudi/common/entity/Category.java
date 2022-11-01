package org.kushinae.koudi.common.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serial;
import java.util.Date;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品三级分类
 * </p>
 *
 * @author bnyte
 * @since 2022-10-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_product_category")
@ApiModel(value="Category对象", description="商品三级分类")
public class Category implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "分类id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "分类名称")
    private String name;

    @ApiModelProperty(value = "父分类id")
    private Long parentId;

    @ApiModelProperty(value = "层级")
    private Integer level;

    @ApiModelProperty(value = "是否显示[0-不显示，1显示]")
    @TableField("`show`")
    private Boolean show;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "图标地址")
    private String icon;

    @ApiModelProperty(value = "计量单位")
    private String productUnit;

    @ApiModelProperty(value = "商品数量")
    private Integer productCount;

    @ApiModelProperty(value = "数据创建时间")
    private Date createTime;

    @ApiModelProperty(value = "数据更新时间")
    private Date modifiedTime;

    @ApiModelProperty(value = "数据创建用户")
    private String createAdminId;

    @ApiModelProperty(value = "数据创建用户名称")
    private String createAdminName;

    @ApiModelProperty(value = "数据更新用户名称")
    private String modifiedAdminName;

    @ApiModelProperty(value = "数据更新用户")
    private String modifiedAdminId;

    @ApiModelProperty(value = "是否逻辑删除 0否 1是 默认否")
    @TableLogic
    private Boolean deleted;

    @ApiModelProperty("当前分类的子分类")
    @TableField(exist = false)
    private List<Category> children;

}
