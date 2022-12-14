package org.kushinae.koudi.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.kushinae.koudi.common.entity.product.Brand;
import org.kushinae.koudi.common.entity.product.Category;
import org.kushinae.koudi.common.param.request.RelationCategoryParam;
import org.kushinae.koudi.common.param.search.product.brand.BrandSearch;
import org.springframework.lang.NonNull;

import java.util.List;

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

    Boolean deleteById(Long id);

    Boolean relationCategory(RelationCategoryParam payload);

    List<Brand> brands();

    List<Category> categories(Long id);
}
