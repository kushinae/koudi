package org.kushinae.koudi.common.entity.product;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.kushinae.koudi.common.entity.GlobalEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 品牌表
 * </p>
 *
 * @author bnyte
 * @since 2022-11-03
 */
@TableName("t_brand")
@ApiModel(value = "Brand对象", description = "品牌表")
public class Brand extends GlobalEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("品牌id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("品牌名")
    @NotBlank(message = "品牌名称不能为空")
    private String name;

    @ApiModelProperty("品牌logo地址")
    @NotBlank(message = "品牌logo地址不能为空")
    private String logo;

    @ApiModelProperty("介绍")
    private String description;

    @ApiModelProperty("显示状态[0-不显示；1-显示]")
    @TableField("`show`")
    @NotNull
    private Boolean show;

    @ApiModelProperty("检索首字母")
    private String firstLetter;

    @ApiModelProperty("排序数字越大排序越高")
    private Integer sort;
    @TableField(exist = false)
    @ApiModelProperty("品牌分类列表")
    private List<Long> categories;

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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<Long> getCategories() {
        return categories;
    }

    public void setCategories(List<Long> categories) {
        this.categories = categories;
    }
}
