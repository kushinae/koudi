package org.kushinae.koudi.product.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bnyte.forge.annotation.APIHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.kushinae.koudi.common.entity.product.Category;
import org.kushinae.koudi.common.lang.web.R;
import org.kushinae.koudi.common.lang.web.RPage;
import org.kushinae.koudi.common.mapstruct.product.CategoryTransfer;
import org.kushinae.koudi.common.param.search.product.category.TreeSearch;
import org.kushinae.koudi.common.vo.product.category.CategoryBrandRelationResultVO;
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
@Api(tags = {"CategoryController", "商品三级分类 前端控制器"})
public class CategoryController {

    @Autowired
    ICategoryService service;

    @APIHelper(enableResponse = false)
    @PostMapping("/tree_page")
    @ApiOperation(value = "获取树装分类列表", nickname = "treeWithPage")
    public RPage<CategoryVO> treeWithPage(@RequestBody(required = false) TreeSearch search) {
        Page<Category> tree = service.treeWithPage(search);
        return RPage.OK(tree, CategoryTransfer.INSTANCE.toVOList(tree.getRecords()));
    }

    @APIHelper
    @PostMapping("/editor")
    @ApiOperation(value = "编辑三级分类", nickname = "editor")
    public R<Long> editor(@RequestBody @Validated Category category) {
        return R.OK(service.editor(category));
    }

    @APIHelper
    @ApiOperation(value = "获取当前分类等级层级", nickname = "levelHierarchy")
    @GetMapping("/level/hierarchy")
    public R<List<CategoryVO>> levelHierarchy(@RequestParam("node_id") Long id) {
        return R.OK(CategoryTransfer.INSTANCE.toVOList(service.levelHierarchy(id)));
    }

    @APIHelper
    @ApiOperation(value = "删除分类", nickname = "removeNode")
    @DeleteMapping("/remove")
    public R<Void> removeNode(@RequestParam("node_id") Long nodeId) {
        service.removeNode(nodeId);
        return R.EMPTY();
    }

    @APIHelper(enableResponse = false)
    @GetMapping("/tree_with_brand")
    @ApiOperation(value = "获取树装分类列表并且指定品牌id绑定信息", nickname = "treeWithBrand")
    public R<CategoryBrandRelationResultVO> treeWithBrand(@RequestParam("brand_id") Long brandId) {
        CategoryBrandRelationResultVO vo = new CategoryBrandRelationResultVO();

//        List<Category> categories = service.tree();
//        vo.setCategory(CategoryTransfer.INSTANCE.toVOList(categories));

        vo.setRelations(CategoryTransfer.INSTANCE.toVOList(service.findBrandRelations(brandId)));

        return R.OK(vo);
    }

    @APIHelper()
    @GetMapping("/detail")
    @ApiOperation(value = "获取分类详情", nickname = "detail")
    public R<CategoryVO> detail(@RequestParam("id") Long id) {
        return R.OK(CategoryTransfer.INSTANCE.toVO(service.detail(id)));
    }

    @APIHelper(enableResponse = false)
    @GetMapping("/tree")
    @ApiOperation(value = "获取树装分类列表", nickname = "treeWithPage")
    public R<List<CategoryVO>> tree(@RequestParam(value = "skip_lowest_level", defaultValue = "false", required = false) Boolean skipLowestLevel,
                                    @RequestParam(value = "skip_root", defaultValue = "false", required = false) Boolean skipRoot) {
        return R.OK(CategoryTransfer.INSTANCE.toVOList(service.tree(skipLowestLevel, skipRoot)));
    }


}

