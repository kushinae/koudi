package org.kushinae.koudi.product.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.kushinae.koudi.common.config.CurrentAdmin;
import org.kushinae.koudi.common.constant.ProductConstant;
import org.kushinae.koudi.common.entity.product.Category;
import org.kushinae.koudi.common.entity.product.CategoryBrandRelation;
import org.kushinae.koudi.common.exception.ParameterCheckException;
import org.kushinae.koudi.common.lang.web.Status;
import org.kushinae.koudi.common.param.search.product.category.TreeSearch;
import org.kushinae.koudi.common.util.CollectionUtils;
import org.kushinae.koudi.common.util.ObjectUtils;
import org.kushinae.koudi.product.mapper.CategoryMapper;
import org.kushinae.koudi.product.service.ICategoryBrandRelationService;
import org.kushinae.koudi.product.service.ICategoryService;
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
    public Page<Category> tree(TreeSearch search) {
        Page<Category> page = page(
                new Page<>(search.getCurrent(), search.getPageSize()),
                Wrappers.lambdaQuery(Category.class)
                        .eq(Category::getParentId, ProductConstant.ROOT_CATEGORY_ID)
                        .orderByAsc(Category::getSort));

        if (CollectionUtils.isEmpty(page.getRecords()))
            return page;

        List<Category> subcategories = list(Wrappers.lambdaQuery(Category.class).ne(Category::getParentId, ProductConstant.ROOT_CATEGORY_ID).orderByAsc(Category::getSort));
        page.setRecords(page.getRecords().stream()
                .peek(e -> {
                    e.setDisabled(search.getDisabled() && e.getLevel() > 2);
                    e.setChildren(getChildNode(e, subcategories, search.getDisabled()));
                })
                .collect(Collectors.toList()));

        return page;
    }

    @Override
    public Long editor(Category category) {
        if (!category.getParentId().equals(ProductConstant.ROOT_CATEGORY_ID) && ObjectUtils.isNull(getById(category.getParentId())))
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

    @Override
    public List<Long> categoryPath(Long categoryId) {
        List<Long> categoryPath = new ArrayList<>();
        scanCategoryPath(categoryId, categoryPath);
        return categoryPath;
    }

    private void scanCategoryPath(Long categoryId, List<Long> categoryPath) {
        Category category = getById(categoryId);
        if (ObjectUtils.nonNull(category)) {
            categoryPath.add(category.getId());
        }
        if (!category.getParentId().equals(ProductConstant.ROOT_CATEGORY_ID)) {
            scanCategoryPath(category.getParentId(), categoryPath);
        }
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
