package org.kushinae.koudi.product.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jetbrains.annotations.NotNull;
import org.kushinae.koudi.common.entity.product.Brand;
import org.kushinae.koudi.common.entity.product.Category;
import org.kushinae.koudi.common.entity.product.CategoryBrandRelation;
import org.kushinae.koudi.common.exception.ParameterCheckException;
import org.kushinae.koudi.common.forest.UpyunClient;
import org.kushinae.koudi.common.lang.web.Status;
import org.kushinae.koudi.common.param.request.RelationCategoryParam;
import org.kushinae.koudi.common.param.search.product.brand.BrandSearch;
import org.kushinae.koudi.common.util.CollectionUtils;
import org.kushinae.koudi.common.util.ObjectUtils;
import org.kushinae.koudi.product.mapper.BrandMapper;
import org.kushinae.koudi.product.service.IBrandService;
import org.kushinae.koudi.product.service.ICategoryBrandRelationService;
import org.kushinae.koudi.product.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author bnyte
 * @since 2022-11-03
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {

    @Autowired
    UpyunClient upyunClient;

    @Autowired
    ICategoryService categoryService;

    @Autowired
    ICategoryBrandRelationService categoryBrandRelationService;

    @Override
    public Page<Brand> listWithPage(BrandSearch search) {
        Page<Brand> brandPage = new Page<>(search.getCurrent(), search.getPageSize());
        return page(brandPage, Wrappers.lambdaQuery(Brand.class).orderByDesc(Brand::getSort));
    }

    @Override
    public Long editor(Brand payload) {
        if (ObjectUtils.isNull(payload.getId()) && ObjectUtils.nonNull(queryName(payload.getName()))) {
            throw new ParameterCheckException("品牌名称已经存在");
        }
        saveOrUpdate(payload);

        // 绑定分类
        List<Long> categories = payload.getCategories();
        if (CollectionUtils.notEmpty(categories)) {

            // 删除旧的
            categoryBrandRelationService.remove(Wrappers.lambdaQuery(CategoryBrandRelation.class)
                    .eq(CategoryBrandRelation::getBrandId, payload.getId())
                    .notIn(CategoryBrandRelation::getCategoryId, categories)
            );

            List<CategoryBrandRelation> relations = categories.stream().map(category -> {
                CategoryBrandRelation relation = new CategoryBrandRelation();
                relation.setCategoryId(category);
                relation.setBrandId(payload.getId());
                relation.setBrandName(payload.getName());
                Category categoryDB = categoryService.getById(category);
                relation.setCategoryName(categoryDB.getName());
                relation.setDeleted(false);
                return relation;
            }).toList();

            for (CategoryBrandRelation relation : relations) {
                categoryBrandRelationService.saveOrUpdate(relation, Wrappers.lambdaQuery(CategoryBrandRelation.class)
                        .eq(CategoryBrandRelation::getBrandId, relation.getBrandId())
                        .eq(CategoryBrandRelation::getCategoryId, relation.getCategoryId()));
            }
        }

        return payload.getId();
    }

    @Override
    public Brand queryName(@NotNull String name) {
        return getOne(Wrappers.lambdaQuery(Brand.class).eq(Brand::getName, name));
    }

    @Override
    public Brand detailById(Long id) {
        Brand brand = getById(id);
        List<CategoryBrandRelation> relations = categoryBrandRelationService.list(Wrappers.lambdaQuery(CategoryBrandRelation.class).eq(CategoryBrandRelation::getBrandId, brand.getId()));
        if (CollectionUtils.isEmpty(relations))
            return brand;
        brand.setCategories(relations.stream().map(CategoryBrandRelation::getCategoryId).toList());
        return brand;
    }

    @Override
    public Boolean deleteById(Long id) {
        Brand brand = getById(id);
        if (ObjectUtils.isNull(brand))
            throw new ParameterCheckException(Status.DATA_DOES_NOT_EXIST);
        upyunClient.deleteFile(brand.getLogo());

        return removeById(brand.getId());
    }

    @Override
    public Boolean relationCategory(RelationCategoryParam payload) {
        Brand brand = getById(payload.getId());
        if (ObjectUtils.isNull(brand)) {
            throw new ParameterCheckException(Status.DATA_DOES_NOT_EXIST);
        }

        List<Category> categories = categoryService.listByIds(payload.getCategories());
        if (CollectionUtils.isEmpty(categories) || categories.size() != payload.getCategories().size()) {
            throw new ParameterCheckException(Status.DATA_DOES_NOT_EXIST);
        }

        List<CategoryBrandRelation> relationList = categories.stream().map(e -> {
            CategoryBrandRelation relation = new CategoryBrandRelation();
            relation.setBrandId(payload.getId());
            relation.setCategoryId(e.getId());
            relation.setBrandName(brand.getName());
            relation.setCategoryName(e.getName());
            return relation;
        }).toList();

        // 删除旧数据
        categoryBrandRelationService.remove(Wrappers.lambdaQuery(CategoryBrandRelation.class)
                .notIn(CategoryBrandRelation::getCategoryId, relationList.stream().map(CategoryBrandRelation::getCategoryId).toList())
                .and(e -> e.eq(CategoryBrandRelation::getBrandId, brand.getId())));
        // 添加新数据
        for (CategoryBrandRelation categoryBrandRelation : relationList) {
            categoryBrandRelationService.saveOrUpdate(categoryBrandRelation, Wrappers.lambdaQuery(CategoryBrandRelation.class)
                    .eq(CategoryBrandRelation::getBrandId, categoryBrandRelation.getBrandId())
                    .eq(CategoryBrandRelation::getCategoryId, categoryBrandRelation.getCategoryId()));
        }

        return true;
    }
}
