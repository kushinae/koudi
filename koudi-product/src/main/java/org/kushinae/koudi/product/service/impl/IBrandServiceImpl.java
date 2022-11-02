package org.kushinae.koudi.product.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.kushinae.koudi.common.entity.Brand;
import org.kushinae.koudi.common.param.search.product.brand.BrandSearch;
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
}
