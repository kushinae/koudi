package org.kushinae.koudi.product.controller;

import com.bnyte.forge.annotation.APIHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.kushinae.koudi.common.entity.product.AttrGroup;
import org.kushinae.koudi.common.lang.web.R;
import org.kushinae.koudi.common.lang.web.RPage;
import org.kushinae.koudi.common.mapstruct.product.AttrGroupTransfer;
import org.kushinae.koudi.common.mapstruct.product.CategoryTransfer;
import org.kushinae.koudi.common.param.search.product.attrgroup.AttrGroupSearch;
import org.kushinae.koudi.common.vo.product.attrgroup.AttrGroupVO;
import org.kushinae.koudi.common.vo.product.category.CategoryVO;
import org.kushinae.koudi.product.service.IAttrGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 属性分组 前端控制器
 * </p>
 *
 * @author bnyte
 * @since 2022-11-05
 */
@RestController
@Api(tags = {"属性分组 前端控制器", "AttrGroupController"})
@RequestMapping("/attr/group")
public class AttrGroupController {

    @Autowired
    IAttrGroupService service;

    @APIHelper(enableResponse = false)
    @PostMapping("/list")
    @ApiOperation(value = "分页搜索获取属性列表", nickname = "listWithPage")
    RPage<AttrGroupVO> listWithPage(@RequestBody(required = false) AttrGroupSearch search) {
        return RPage.OK(service.listWithPage(search), AttrGroupVO.class);
    }

    @APIHelper
    @PostMapping("/editor")
    @ApiOperation(value = "编辑属性组", nickname = "listWithPage")
    R<Long> editor(@RequestBody @Validated AttrGroup payload) {
        return R.OK(service.editor(payload));
    }

    @APIHelper
    @GetMapping("/detail")
    @ApiOperation(value = "属性组详情", nickname = "editor")
    R<AttrGroupVO> editor(@RequestParam("id") Long id) {
        return R.OK(AttrGroupTransfer.INSTANCE.toVO(service.detail(id)));
    }

    @APIHelper
    @DeleteMapping("/remove")
    @ApiOperation(value = "删除属性组", nickname = "removeById")
    R<Boolean> removeById(@RequestParam("id") Long id) {
        return R.OK(service.deleteById(id));
    }

    @APIHelper(enableResponse = false)
    @PostMapping("/search")
    @ApiOperation(value = "搜索获取属性列表", nickname = "listWithSearch")
    R<List<AttrGroupVO>> listWithSearch(@RequestBody(required = false) AttrGroupSearch search) {
        return R.OK(AttrGroupTransfer.INSTANCE.toVOS(service.listWithSearch(search)));
    }

    @APIHelper
    @GetMapping("/category/detail")
    @ApiOperation(value = "通过属性分组id获取详情", nickname = "detailWithAttrGroup")
    public R<CategoryVO> detailWithAttrGroup(@RequestParam("id") Long id) {
        return R.OK(CategoryTransfer.INSTANCE.toVO(service.detailWithAttrGroup(id)));
    }

}
