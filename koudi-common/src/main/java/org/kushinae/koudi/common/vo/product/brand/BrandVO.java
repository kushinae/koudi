package org.kushinae.koudi.common.vo.product.brand;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author bnyte
 * @since 1.0.0
 */
@ApiModel(value="Brand对象", description="品牌分类")
public class BrandVO {
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

    public List<Long> getCategories() {
        return categories;
    }

    public void setCategories(List<Long> categories) {
        this.categories = categories;
    }
}
