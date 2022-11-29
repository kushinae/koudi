package org.kushinae.koudi.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.kushinae.koudi.common.entity.product.Category;
import org.kushinae.koudi.common.param.search.product.category.TreeSearch;

import java.util.List;

/**
 * <p>
 * 商品三级分类 服务类
 * </p>
 *
 * @author bnyte
 * @since 2022-10-31
 */
public interface ICategoryService extends IService<Category> {

    Page<Category> treeWithPage(TreeSearch search);

    Long editor(Category category);

    List<Category> levelHierarchy(Long nodeId);

    void removeNode(Long nodeId);

    List<Category> getChildren(Long nodeId);

    List<Category> findBrandRelations(Long brandId);

    List<Long> categoryPath(Long categoryId);

    Category detail(Long id);

    List<Category> tree(boolean skipLowestLevel, boolean skipRoot);

    List<Category> categoriesByBrand(Long brandId);
}
