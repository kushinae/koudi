package org.kushinae.koudi.product.controller;

import com.bnyte.forge.annotation.APIHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.kushinae.koudi.common.entity.product.AttrGroup;
import org.kushinae.koudi.common.lang.web.R;
import org.kushinae.koudi.common.lang.web.RPage;
import org.kushinae.koudi.common.param.search.product.attrgroup.AttrGroupSearch;
import org.kushinae.koudi.product.service.IAttrGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 属性分组 前端控制器
 * </p>
 *
 * @author bnyte
 * @since 2022-11-05
 */
@RestController
@Api(tags = "属性分组 前端控制器")
@RequestMapping("/attr/group")
public class AttrGroupController {

    @Autowired
    IAttrGroupService service;

    @APIHelper
    @PostMapping("/list")
    @ApiOperation("分页搜索获取属性列表")
    RPage<AttrGroup> listWithPage(@RequestBody(required = false) AttrGroupSearch search) {
        return RPage.OK(service.listWithPage(search));
    }

    @APIHelper
    @PostMapping("/editor")
    @ApiOperation("编辑属性组")
    R<Long> editor(@RequestBody @Validated AttrGroup payload) {
        return R.OK(service.editor(payload));
    }

    @APIHelper
    @GetMapping("/detail")
    @ApiOperation("属性组详情")
    R<AttrGroup> editor(@RequestParam("id") Long id) {
        return R.OK(service.detail(id));
    }

    @APIHelper
    @DeleteMapping("/remove")
    @ApiOperation("删除属性组")
    R<Boolean> removeById(@RequestParam("id") Long id) {
        return R.OK(service.deleteById(id));
    }

}
