package org.kushinae.koudi.common.entity.product;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 属性组表
 * </p>
 *
 * @author bnyte
 * @since 2022-11-05
 */
@Data
@TableName("t_product_attr_group")
@ApiModel(value = "AttrGroup对象", description = "品牌表")
public class AttrGroup implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("分组id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @NotBlank(message = "属性组名不能为空")
    @ApiModelProperty("组名")
    private String name;

    @ApiModelProperty("排序 数值越高排序优先级越高")
    private Integer sort;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("组图标")
    private String icon;

    @ApiModelProperty("所属分类id")
    @NotNull(message = "所属分类不能为空")
    @Min(value = 1, message = "所属分类不存在")
    private Long categoryId;

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

    @ApiModelProperty("分类名称")
    @TableField(exist = false)
    private String categoryName;

}
