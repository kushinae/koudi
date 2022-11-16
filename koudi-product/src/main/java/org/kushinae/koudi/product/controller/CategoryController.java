package org.kushinae.koudi.product.controller;

import com.bnyte.forge.annotation.APIHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.kushinae.koudi.common.entity.product.Category;
import org.kushinae.koudi.common.lang.web.R;
import org.kushinae.koudi.common.mapstruct.product.CategoryTransfer;
import org.kushinae.koudi.common.vo.product.category.CategoryVO;
import org.kushinae.koudi.product.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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

    @APIHelper
    @GetMapping("/tree")
    @ApiOperation("获取树装分类列表")
    public R<List<CategoryVO>> tree(@RequestParam(value = "disabled", defaultValue = "false", required = false) Boolean disable) {
        return R.OK(CategoryTransfer.INSTANCE.toVOList(service.tree(disable)));
    }

    @APIHelper
    @PostMapping("/editor")
    @ApiOperation("编辑三级分类")
    public R<Long> editor(@RequestBody @Validated Category category) {
        return R.OK(service.editor(category));
    }

    @APIHelper
    @ApiOperation("获取当前分类等级层级")
    @GetMapping("/level/hierarchy")
    public R<List<CategoryVO>> levelHierarchy(@RequestParam("node_id") Long id) {
        return R.OK(CategoryTransfer.INSTANCE.toVOList(service.levelHierarchy(id)));
    }

    @APIHelper
    @ApiOperation("删除分类")
    @DeleteMapping("/remove")
    public R<Void> removeNode(@RequestParam("node_id") Long nodeId) {
        service.removeNode(nodeId);
        return R.EMPTY();
    }


}

