package org.kushinae.koudi.product.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bnyte.forge.annotation.APIHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.kushinae.koudi.common.entity.product.Attr;
import org.kushinae.koudi.common.enums.product.EAttrSwitchTarget;
import org.kushinae.koudi.common.lang.web.R;
import org.kushinae.koudi.common.lang.web.RPage;
import org.kushinae.koudi.common.mapstruct.product.AttrTransfer;
import org.kushinae.koudi.common.param.search.product.attr.AttrSearch;
import org.kushinae.koudi.common.vo.product.attr.AttrVO;
import org.kushinae.koudi.product.service.IAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 商品、规格与包装的属性key及值,值可以多个 使用英文逗号分隔 前端控制器
 * </p>
 *
 * @author bnyte
 * @since 2022-11-17
 */
@RestController
@RequestMapping("/attr")
@Api(tags = {"商品、规格与包装的属性key及值,值可以多个 使用英文逗号分隔 前端控制器", "AttrController"})
public class AttrController {

    @Autowired
    IAttrService service;

    @APIHelper
    @PostMapping("/editor")
    @ApiOperation(value = "编辑属性", nickname = "editor")
    R<Long> editor(@RequestBody @Validated AttrVO payload) {
        return R.OK(service.editor(AttrTransfer.INSTANCE.toDomain(payload)));
    }

    @APIHelper
    @PostMapping("/page/search")
    @ApiOperation(value = "分页搜索获取所有属性", nickname = "searchWithPage")
    RPage<AttrVO> searchWithPage(@RequestBody(required = false) @Validated AttrSearch search) {
        Page<Attr> attrPage = service.searchWithPage(search);
        return RPage.OK(attrPage, AttrTransfer.INSTANCE.toVOS(attrPage.getRecords()));
    }

    @APIHelper
    @PostMapping("/switch/{target}")
    @ApiOperation(value = "转换当前属性的开启状态", nickname = "switchTarget")
    R<Boolean> switchTarget(@PathVariable("target") EAttrSwitchTarget target, @RequestParam("id") Long id) {
        return R.OK(service.switchTarget(target, id));
    }

    @APIHelper
    @GetMapping("/detail")
    @ApiOperation(value = "获取属性详情", nickname = "detail")
    R<AttrVO> detail(@RequestParam("id") Long id) {
        return R.OK(AttrTransfer.INSTANCE.toVO(service.detailById(id)));
    }

    @APIHelper
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除属性", nickname = "delete")
    R<Boolean> delete(@RequestParam("id") Long id) {
        return R.OK(service.delete(id));
    }

}
