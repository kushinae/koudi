package org.kushinae.koudi.product.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.kushinae.koudi.common.entity.Brand;
import org.kushinae.koudi.common.lang.web.R;
import org.kushinae.koudi.common.lang.web.RPage;
import org.kushinae.koudi.common.param.search.product.brand.BrandSearch;
import org.kushinae.koudi.product.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@Api(tags = "品牌表 前端控制器")
public class BrandController {

    @Autowired
    IBrandService service;

    @PostMapping("/list")
    @ApiOperation("分页搜索获取品牌列表")
    public RPage<Brand> listWithPage(@RequestBody BrandSearch search) {
        return RPage.OK(service.listWithPage(search));
    }

    @PostMapping("/editor")
    @ApiOperation("编辑品牌")
    public R<Long> editor(@RequestBody Brand payload) {
        return R.OK(service.editor(payload));
    }

    @GetMapping("/detail")
    @ApiOperation("获取品牌详情")
    public R<Brand> detail(@RequestParam("id") Long id) {
        return R.OK(service.detailById(id));
    }

}
