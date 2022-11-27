package org.kushinae.koudi.common.entity.product;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.kushinae.koudi.common.entity.GlobalEntity;

import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * 属性组表
 * </p>
 *
 * @author bnyte
 * @since 2022-11-05
 */
@TableName("t_attr_group")
@ApiModel(value = "AttrGroup对象", description = "规格组")
public class AttrGroup extends GlobalEntity implements Serializable {

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
    private Long categoryId;

    @ApiModelProperty("分类名称")
    @TableField(exist = false)
    private String categoryName;

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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
