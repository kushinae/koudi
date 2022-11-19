package org.kushinae.koudi.product.controller;

import com.bnyte.forge.annotation.APIHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.kushinae.koudi.common.entity.product.Brand;
import org.kushinae.koudi.common.lang.web.R;
import org.kushinae.koudi.common.lang.web.RPage;
import org.kushinae.koudi.common.mapstruct.product.BrandTransfer;
import org.kushinae.koudi.common.param.request.RelationCategoryParam;
import org.kushinae.koudi.common.param.search.product.brand.BrandSearch;
import org.kushinae.koudi.common.vo.product.brand.BrandVO;
import org.kushinae.koudi.product.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author bnyte
 * @since 2022-11-03
 */
@RestController
@RequestMapping("/brand")
@Api(tags = {"品牌表 前端控制器", "BrandController"})
public class BrandController {

    @Autowired
    IBrandService service;

    @APIHelper
    @PostMapping("/list")
    @ApiOperation(value = "分页搜索获取品牌列表", nickname = "listWithPage")
    public RPage<BrandVO> listWithPage(@RequestBody BrandSearch search) {
        return RPage.OK(service.listWithPage(search), BrandVO.class);
    }

    @APIHelper
    @PostMapping("/editor")
    @ApiOperation(value = "编辑品牌", nickname = "editor")
    public R<Long> editor(@RequestBody @Validated Brand payload) {
        return R.OK(service.editor(payload));
    }

    @APIHelper
    @GetMapping("/detail")
    @ApiOperation(value = "获取品牌详情", nickname = "detail")
    public R<BrandVO> detail(@RequestParam("id") Long id) {
        return R.OK(BrandTransfer.INSTANCE.toVO(service.detailById(id)));
    }

    @APIHelper
    @DeleteMapping("/remove")
    @ApiOperation(value = "通过id删除品牌", nickname = "removeById")
    public R<Boolean> removeById(@RequestParam("id") Long id) {
        return R.OK(service.deleteById(id));
    }

    @APIHelper
    @PutMapping("/relation/category")
    @ApiOperation(value = "关联分类", nickname = "relationCategory")
    public R<Boolean> relationCategory(@Validated @RequestBody RelationCategoryParam payload) {
        return R.OK(service.relationCategory(payload));
    }

}
