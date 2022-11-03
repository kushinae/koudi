package org.kushinae.koudi.product.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jetbrains.annotations.NotNull;
import org.kushinae.koudi.common.entity.Brand;
import org.kushinae.koudi.common.exception.ParameterCheckException;
import org.kushinae.koudi.common.param.search.product.brand.BrandSearch;
import org.kushinae.koudi.common.util.ObjectUtils;
import org.kushinae.koudi.product.mapper.BrandMapper;
import org.kushinae.koudi.product.service.IBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author bnyte
 * @since 2022-11-03
 */
@Service
public class IBrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {

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
        return getById(id);
    }
}
