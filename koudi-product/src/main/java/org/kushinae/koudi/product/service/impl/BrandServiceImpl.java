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
        Page<Brand> brandPage = new Page<>(search.getCurrent(), search.getQueryCount());
        return page(brandPage);
    }

    @Override
    public Long editor(Brand payload) {
        if (ObjectUtils.isNull(payload.getId()) && ObjectUtils.nonNull(queryName(payload.getName()))) {
            throw new ParameterCheckException("品牌名称已经存在");
        }
        saveOrUpdate(payload);
        return payload.getId();
    }

    @Override
    public Brand queryName(@NotNull String name) {
        return getOne(Wrappers.lambdaQuery(Brand.class).eq(Brand::getName, name));
    }

    @Override
    public Brand detailById(Long id) {
        Brand brand = getById(id);
        brand.setCategory(categoryService.treeWithBrand(brand.getId()));
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

        categoryBrandRelationService.saveOrUpdateBatch(categories.stream().map(e -> {
            CategoryBrandRelation relation = new CategoryBrandRelation();
            relation.setBrandId(payload.getId());
            relation.setCategoryId(e.getId());
            relation.setBrandName(brand.getName());
            relation.setCategoryName(e.getName());
            return relation;
        }).toList());

        return true;
    }
}
