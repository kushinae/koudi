package org.kushinae.koudi.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.kushinae.koudi.common.entity.Brand;
import org.kushinae.koudi.common.param.search.product.brand.BrandSearch;
import org.springframework.lang.NonNull;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author bnyte
 * @since 2022-11-03
 */
public interface IBrandService extends IService<Brand> {

    Page<Brand> listWithPage(BrandSearch search);

    Long editor(Brand payload);

    Brand queryName(@NonNull String name);

    Brand detailById(Long id);
}
