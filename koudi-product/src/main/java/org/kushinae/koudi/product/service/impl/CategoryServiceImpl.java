package org.kushinae.koudi.product.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.kushinae.koudi.common.config.CurrentAdmin;
import org.kushinae.koudi.common.constant.ProductConstant;
import org.kushinae.koudi.common.entity.Category;
import org.kushinae.koudi.common.util.ObjectUtils;
import org.kushinae.koudi.product.mapper.CategoryMapper;
import org.kushinae.koudi.product.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    CurrentAdmin currentAdmin;

    @Override
    public List<Category> tree() {
        List<Category> categories = list(Wrappers.lambdaQuery(Category.class));
        return categories.stream()
                .filter(e -> e.getParentId().equals(ProductConstant.ROOT_CATEGORY_ID))
                .peek(e -> e.setChildren(getChildNode(e, categories)))
                .collect(Collectors.toList());
    }

    @Override
    public Long editor(Category category) {
        // editor
        saveOrUpdate(category);
        return category.getId();
    }

    private List<Category> getChildNode(Category parentNode, List<Category> categories) {
        return categories.stream()
                .filter(e -> e.getParentId().equals(parentNode.getId()))
                .peek(e -> e.setChildren(getChildNode(e, categories)))
                .collect(Collectors.toList());
    }
}
