package org.kushinae.koudi.product.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.kushinae.koudi.common.entity.Category;
import org.kushinae.koudi.common.lang.web.R;
import org.kushinae.koudi.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 商品三级分类 前端控制器
 * </p>
 *
 * @author bnyte
 * @since 2022-10-31
 */
@RestController
@RequestMapping("/category")
@Api(tags = "商品三级分类 前端控制器")
public class CategoryController {

    @Autowired
    CategoryService service;

    @GetMapping("/tree")
    @ApiOperation("")
    public R<List<Category>> tree() {

    }

}

