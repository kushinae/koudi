package org.kushinae.koudi.product.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.kushinae.koudi.common.entity.Category;
import org.kushinae.koudi.common.lang.web.R;
import org.kushinae.koudi.product.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    ICategoryService service;

    @GetMapping("/tree")
    @ApiOperation("获取树装分类列表")
    public R<List<Category>> tree(@RequestParam(value = "disabled", defaultValue = "false", required = false) Boolean disable) {
        return R.OK(service.tree(disable));
    }

    @PostMapping("/editor")
    @ApiOperation("编辑三级分类")
    public R<Long> editor(@RequestBody Category category) {
        return R.OK(service.editor(category));
    }

    @ApiOperation("获取当前分类等级层级")
    @GetMapping("/level/hierarchy")
    public R<List<Category>> levelHierarchy(@RequestParam("node_id") Long id) {
        return R.OK(service.levelHierarchy(id));
    }

    @ApiOperation("删除分类")
    @DeleteMapping("/remove")
    public R<Void> removeNode(@RequestParam("node_id") Long nodeId) {
        service.removeNode(nodeId);
        return R.EMPTY();
    }


}

