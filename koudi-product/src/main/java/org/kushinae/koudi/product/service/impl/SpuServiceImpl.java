package org.kushinae.koudi.product.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.kushinae.koudi.common.entity.product.Brand;
import org.kushinae.koudi.common.entity.product.Category;
import org.kushinae.koudi.common.entity.product.Spu;
import org.kushinae.koudi.common.exception.ParameterCheckException;
import org.kushinae.koudi.common.param.search.product.spu.SpuSearch;
import org.kushinae.koudi.common.util.CollectionUtils;
import org.kushinae.koudi.common.util.ObjectUtils;
import org.kushinae.koudi.common.util.StringUtils;
import org.kushinae.koudi.product.mapper.SpuMapper;
import org.kushinae.koudi.product.service.IBrandService;
import org.kushinae.koudi.product.service.ICategoryService;
import org.kushinae.koudi.product.service.ISpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * spu商品信息 服务实现类
 * </p>
 *
 * @author bnyte
 * @since 2022-11-26
 */
@Service
public class SpuServiceImpl extends ServiceImpl<SpuMapper, Spu> implements ISpuService {

    @Autowired
    IBrandService brandService;

    @Autowired
    ICategoryService categoryService;

    @Override
    public Long editor(Spu payload) {

        Spu spu = getOne(Wrappers.lambdaQuery(Spu.class).eq(Spu::getName, payload.getName()));
        if (ObjectUtils.nonNull(spu) && ObjectUtils.notEquals(spu.getId(), payload.getId())) {
            throw new ParameterCheckException("商品名称已经存在");
        }

        saveOrUpdate(payload);

        return payload.getId();
    }

    @Override
    public Page<Spu> searchWithPage(SpuSearch search) {
        Page<Spu> page = new Page<>(search.getCurrent(), search.getPageSize());
        page = page(page, Wrappers.lambdaQuery(Spu.class).like(StringUtils.hasText(search.getKey()), Spu::getName, search.getKey())
                .or().like(StringUtils.hasText(search.getTitle()), Spu::getTitle, search.getTitle())
                .or().like(StringUtils.hasText(search.getSubTitle()), Spu::getSubTitle, search.getSubTitle()));

        List<Spu> records = page.getRecords();
        if (CollectionUtils.notEmpty(records)) {
            for (Spu record : records) {
                if (ObjectUtils.nonNull(record.getBrandId()) && record.getBrandId() > 0) {
                    Brand brand = brandService.getById(record.getBrandId());
                    if (ObjectUtils.nonNull(brand)) {
                        record.setBrandName(brand.getName());
                    }
                }

                if (ObjectUtils.nonNull(record.getCategoryId()) && record.getCategoryId() > 0) {
                    Category category = categoryService.getById(record.getCategoryId());
                    if (ObjectUtils.nonNull(category)) {
                        record.setCategoryName(category.getName());
                    }
                }
            }
        }

        return page;
    }

    @Override
    public Boolean deletedById(Long id) {
        // 后面删除的时候要加其他校验 比如sku等
        return removeById(id);
    }

    @Override
    public Spu detailById(Long id) {
        return getById(id);
    }
}
