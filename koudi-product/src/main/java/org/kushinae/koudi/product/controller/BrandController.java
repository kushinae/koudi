package org.kushinae.koudi.product.controller;

import io.swagger.annotations.Api;
import org.kushinae.koudi.common.entity.Brand;
import org.kushinae.koudi.common.lang.web.RPage;
import org.kushinae.koudi.common.param.search.product.brand.BrandSearch;
import org.kushinae.koudi.product.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author bnyte
 * @since 2022-11-03
 */
@Controller
@RequestMapping("/brand")
@Api(tags = "品牌表 前端控制器")
public class BrandController {

    @Autowired
    IBrandService service;

    @GetMapping("list")
    public RPage<Brand> listWithPage(@RequestBody BrandSearch search) {
        return RPage.OK(service.listWithPage(search));
    }

}
