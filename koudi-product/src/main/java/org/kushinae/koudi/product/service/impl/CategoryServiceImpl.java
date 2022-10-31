package org.kushinae.koudi.product.service.impl;

import org.kushinae.koudi.common.entity.Category;
import org.kushinae.koudi.product.mapper.CategoryMapper;
import org.kushinae.koudi.product.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品三级分类 服务实现类
 * </p>
 *
 * @author bnyte
 * @since 2022-10-31
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
