package org.kushinae.koudi.product.service;

import org.kushinae.koudi.common.entity.product.Category;
import com.baomidou.mybatisplus.extension.service.IService;

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

    List<Category> tree(Boolean disable);

    Long editor(Category category);

    List<Category> levelHierarchy(Long nodeId);

    void removeNode(Long nodeId);

    List<Category> getChildren(Long nodeId);

    List<Category> findBrandRelations(Long brandId);

    List<Long> categoryPath(Long categoryId);
}
