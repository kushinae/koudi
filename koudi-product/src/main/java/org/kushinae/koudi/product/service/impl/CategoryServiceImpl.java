package org.kushinae.koudi.product.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.kushinae.koudi.common.config.CurrentAdmin;
import org.kushinae.koudi.common.constant.ProductConstant;
import org.kushinae.koudi.common.entity.product.Category;
import org.kushinae.koudi.common.entity.product.CategoryBrandRelation;
import org.kushinae.koudi.common.exception.ParameterCheckException;
import org.kushinae.koudi.common.lang.web.Status;
import org.kushinae.koudi.common.util.CollectionUtils;
import org.kushinae.koudi.common.util.ObjectUtils;
import org.kushinae.koudi.product.mapper.CategoryMapper;
import org.kushinae.koudi.product.service.ICategoryService;
import org.kushinae.koudi.product.service.ICategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品三级分类 服务实现类
 * </p>
 *
 * @author bnyte
 * @since 2022-10-31
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Autowired
    CurrentAdmin currentAdmin;

    @Autowired
    ICategoryBrandRelationService categoryBrandRelationService;

    @Override
    public List<Category> tree(Boolean disable) {
        List<Category> categories = list(Wrappers.lambdaQuery(Category.class).orderByAsc(Category::getSort));
        return categories.stream()
                .filter(e -> e.getParentId().equals(ProductConstant.ROOT_CATEGORY_ID))
                .peek(e -> {
                    e.setDisabled(disable && e.getLevel() > 2);
                    e.setChildren(getChildNode(e, categories, disable));
                })
                .collect(Collectors.toList());
    }

    @Override
    public Long editor(Category category) {
        if (!category.getParentId().equals(ProductConstant.ROOT_CATEGORY_ID) || ObjectUtils.isNull(getById(category.getParentId())))
            throw new ParameterCheckException(Status.DATA_DOES_NOT_EXIST);
        category.setLevel(1);
        // editor
        saveOrUpdate(category);
        category.setLevel(levelHierarchy(category.getId()).size());
        saveOrUpdate(category);
        return category.getId();
    }

    @Override
    public List<Category> levelHierarchy(Long nodeId) {
        List<Category> categories = new ArrayList<>();
        getLevelHierarchy(nodeId, categories);
        return categories.stream().sorted((Comparator.comparing(Category::getLevel))).toList();
    }

    @Override
    public void removeNode(Long nodeId) {
        List<Category> children = getChildren(nodeId);
        if (CollectionUtils.notEmpty(children)) {
            throw new ParameterCheckException("当前节点存在未删除子节点");
        }
        removeById(nodeId);
    }

    @Override
    public List<Category> getChildren(Long nodeId) {
        return list(Wrappers.lambdaQuery(Category.class).eq(Category::getParentId, nodeId));
    }

    @Override
    public List<Category> findBrandRelations(Long brandId) {
        List<Long> categoryIds = null;

        List<CategoryBrandRelation> categoryBrandRelations = categoryBrandRelationService.list(Wrappers.lambdaQuery(CategoryBrandRelation.class)
                .eq(CategoryBrandRelation::getBrandId, brandId));
        if (CollectionUtils.notEmpty(categoryBrandRelations)) {
            categoryIds = categoryBrandRelations.stream().map(CategoryBrandRelation::getCategoryId).toList();
        }



        return CollectionUtils.isEmpty(categoryIds) ? null : list(Wrappers.lambdaQuery(Category.class).in(Category::getId, categoryIds).orderByAsc(Category::getSort));
    }

    private void getLevelHierarchy(Long nodeId, List<Category> hierarchy) {
        Category category = getById(nodeId);
        hierarchy.add(category);
        if (!category.getParentId().equals(ProductConstant.ROOT_CATEGORY_ID)) {
            getLevelHierarchy(category.getParentId(), hierarchy);
        }
    }

    private List<Category> getChildNode(Category parentNode, List<Category> categories, Boolean disable) {
        return categories.stream()
                .filter(e -> e.getParentId().equals(parentNode.getId()))
                .peek(e -> {
                    e.setDisabled(disable && e.getLevel() > 2);
                    e.setChildren(getChildNode(e, categories, disable));
                })
                .collect(Collectors.toList());
    }
}
