package org.kushinae.koudi.product.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.kushinae.koudi.common.entity.Category;
import org.kushinae.koudi.common.lang.web.R;
import org.kushinae.koudi.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @ApiOperation("获取树装分类列表")
    public R<List<Category>> tree() {
        return R.OK(service.tree());
    }

    @PostMapping("/editor")
    @ApiOperation("编辑三级分类")
    public R<Long> editor(@RequestBody Category category) {
        return R.OK(service.editor(category));
    }

}

