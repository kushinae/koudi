package org.kushinae.koudi.product.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.kushinae.koudi.common.entity.product.AttrGroup;
import org.kushinae.koudi.common.entity.product.Category;
import org.kushinae.koudi.common.exception.ParameterCheckException;
import org.kushinae.koudi.common.lang.web.Status;
import org.kushinae.koudi.common.param.search.product.attrgroup.AttrGroupSearch;
import org.kushinae.koudi.common.util.CollectionUtils;
import org.kushinae.koudi.common.util.ObjectUtils;
import org.kushinae.koudi.common.util.StringUtils;
import org.kushinae.koudi.product.mapper.AttrGroupMapper;
import org.kushinae.koudi.product.service.IAttrGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.kushinae.koudi.product.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author bnyte
 * @since 2022-11-05
 */
@Service
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupMapper, AttrGroup> implements IAttrGroupService {

    @Autowired
    ICategoryService service;

    @Autowired
    ICategoryService categoryService;

    @Override
    public Page<AttrGroup> listWithPage(AttrGroupSearch search) {
        Page<AttrGroup> page = new Page<>(search.getCurrent(), search.getPageSize());
        page = page(page, Wrappers.lambdaQuery(AttrGroup.class)
                .eq(ObjectUtils.nonNull(search.getCategoryId()), AttrGroup::getCategoryId, search.getCategoryId())
                .and(StringUtils.hasText(search.getKey()), wrapper -> wrapper.like(AttrGroup::getName, search.getKey()))
                .orderByDesc(AttrGroup::getSort));
        List<AttrGroup> records = page.getRecords();
        if (CollectionUtils.notEmpty(records)) {
            page.setRecords(records.stream().peek(e -> {
                Long categoryId = e.getCategoryId();
                Category category = categoryService.getById(categoryId);
                e.setCategoryName(category.getName());
            }).collect(Collectors.toList()));
        }
        return page;
    }

    @Override
    public Long editor(AttrGroup payload) {
        Category category = categoryService.getById(payload.getCategoryId());
        if (ObjectUtils.isNull(category))
            throw new ParameterCheckException(Status.DATA_DOES_NOT_EXIST);

        if (category.getLevel() != 3)
            throw new ParameterCheckException("属性组仅可绑定三级分类");

        saveOrUpdate(payload);
        return payload.getId();
    }

    @Override
    public AttrGroup detail(Long id) {
        AttrGroup attrGroup = getById(id);
        Category category = categoryService.getById(attrGroup.getCategoryId());
        attrGroup.setCategoryName(category.getName());
        return attrGroup;
    }

    @Override
    public Boolean deleteById(Long id) {
        return removeById(id);
    }

    @Override
    public List<AttrGroup> listWithSearch(AttrGroupSearch search) {
        return list(Wrappers.lambdaQuery(AttrGroup.class)
                .like(StringUtils.hasText(search.getKey()), AttrGroup::getName, search.getKey()));
    }

    @Override
    public Category detailWithAttrGroup(Long id) {
        AttrGroup attrGroup = getById(id);
        if (ObjectUtils.isNull(attrGroup))
            throw new ParameterCheckException(Status.DATA_DOES_NOT_EXIST);

        return categoryService.getById(attrGroup.getCategoryId());
    }

}
