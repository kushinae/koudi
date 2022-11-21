package org.kushinae.koudi.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.kushinae.koudi.common.entity.product.Attr;
import org.kushinae.koudi.common.entity.product.AttrAttrGroupRelation;
import org.kushinae.koudi.common.entity.product.AttrGroup;
import org.kushinae.koudi.common.entity.product.Category;
import org.kushinae.koudi.common.enums.product.EAttrSwitchTarget;
import org.kushinae.koudi.common.enums.product.EAttrType;
import org.kushinae.koudi.common.exception.DateNotFountException;
import org.kushinae.koudi.common.exception.ParameterCheckException;
import org.kushinae.koudi.common.lang.web.Status;
import org.kushinae.koudi.common.param.search.product.attr.AttrSearch;
import org.kushinae.koudi.common.util.CollectionUtils;
import org.kushinae.koudi.common.util.ObjectUtils;
import org.kushinae.koudi.common.util.StringUtils;
import org.kushinae.koudi.product.mapper.AttrMapper;
import org.kushinae.koudi.product.service.IAttrAttrGroupRelationService;
import org.kushinae.koudi.product.service.IAttrGroupService;
import org.kushinae.koudi.product.service.IAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.kushinae.koudi.product.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品、规格与包装的属性key及值,值可以多个 使用英文逗号分隔 服务实现类
 * </p>
 *
 * @author bnyte
 * @since 2022-11-17
 */
@Service
public class AttrServiceImpl extends ServiceImpl<AttrMapper, Attr> implements IAttrService {

    @Autowired
    IAttrGroupService attrGroupService;

    @Autowired
    ICategoryService categoryService;

    @Autowired
    IAttrAttrGroupRelationService attrAttrGroupRelationService;

    @Override
    public Long editor(Attr payload) {

        EAttrType attrType = EAttrType.code(payload.getType());
        if (attrType.equals(EAttrType.BASE) && ObjectUtils.isNull(payload.getAttrGroupId()))
            throw new ParameterCheckException("属性组不能为空");

        saveOrUpdate(payload);

        AttrGroup attrGroup;
        if (ObjectUtils.nonNull(payload.getAttrGroupId())) {
            attrGroup = attrGroupService.getById(payload.getAttrGroupId());
        } else {
            attrGroup = new AttrGroup();
        }

        AttrAttrGroupRelation attrAttrGroupRelation = attrAttrGroupRelationService.getOne(Wrappers.lambdaQuery(AttrAttrGroupRelation.class)
                .eq(AttrAttrGroupRelation::getAttrId, payload.getId())
                .eq(attrType.equals(EAttrType.BASE), AttrAttrGroupRelation::getAttrGroupId, attrGroup.getId())
                .eq(AttrAttrGroupRelation::getCategoryId, payload.getCategoryId()));

        if (ObjectUtils.isNull(attrAttrGroupRelation)) {
            attrAttrGroupRelation = new AttrAttrGroupRelation();
            attrAttrGroupRelation.setAttrId(payload.getId());
            attrAttrGroupRelation.setCategoryId(attrGroup.getCategoryId());
            attrAttrGroupRelation.setAttrGroupId(attrGroup.getId());
        }

        attrAttrGroupRelationService.saveOrUpdate(attrAttrGroupRelation, Wrappers.lambdaUpdate(AttrAttrGroupRelation.class)
                .eq(AttrAttrGroupRelation::getAttrId, attrAttrGroupRelation.getAttrId())
                .eq(AttrAttrGroupRelation::getCategoryId, attrAttrGroupRelation.getCategoryId()));

        if (attrType.equals(EAttrType.ALL) && ObjectUtils.isNull(attrGroup.getId())) {
            attrAttrGroupRelation.setAttrGroupId(null);
            attrAttrGroupRelationService.updateById(attrAttrGroupRelation);
        }

        return payload.getId();
    }

    @Override
    public Page<Attr> searchWithPage(AttrSearch search) {
        Page<Attr> page = page(new Page<>(search.getCurrent(), search.getPageSize()),
                Wrappers.lambdaQuery(Attr.class)
                        .like(StringUtils.hasText(search.getKey()), Attr::getName, search.getKey())
                        .or(CollectionUtils.notEmpty(search.getType()), e -> e.in(Attr::getType, search.getType()))
                        .or(ObjectUtils.nonNull(search.getEnableSearch()), e -> e.eq(Attr::getEnableSearch, search.getEnableSearch()))
                        .or(ObjectUtils.nonNull(search.getMultiple()), e -> e.eq(Attr::getMultiple, search.getMultiple()))
        );

        List<Attr> records = page.getRecords();

        if (CollectionUtils.isEmpty(records))
            return page;

        // 写入分类和分组信息
        for (Attr e : records) {
            AttrAttrGroupRelation relation = attrAttrGroupRelationService.getOne(Wrappers.lambdaQuery(AttrAttrGroupRelation.class)
                    .eq(AttrAttrGroupRelation::getAttrId, e.getId()));
            if (EAttrType.SELL.getCode().equals(e.getType())) {
                Category category = categoryService.getById(relation.getCategoryId());
                e.setCategoryName(category.getName());
                e.setCategories(categoryService.categoryPath(category.getId()));
                continue;
            }
            if (ObjectUtils.nonNull(relation.getAttrGroupId())) {
                AttrGroup attrGroup = attrGroupService.getById(relation.getAttrGroupId());
                e.setGroupName(attrGroup.getName());
            }
        }

        return page;
    }

    @Override
    public Boolean switchTarget(EAttrSwitchTarget target, Long id) {

        Attr attr = getById(id);

        if (ObjectUtils.isNull(attr))
            throw new DateNotFountException(Status.DATA_DOES_NOT_EXIST);

        LambdaUpdateWrapper<Attr> wrapper = Wrappers.lambdaUpdate(Attr.class)
                .eq(Attr::getId, attr.getId());
        switch (target) {
            case show -> wrapper.set(Attr::getQuickShow, !attr.getQuickShow());
            case search -> wrapper.set(Attr::getEnableSearch, !attr.getEnableSearch());
            case multiple -> wrapper.set(Attr::getMultiple, !attr.getMultiple());
            default -> throw new ParameterCheckException("修改类型不存在");
        }
        update(wrapper);

        return true;
    }

    @Override
    public Attr detailById(Long id) {
        Attr attr = getById(id);
        if (ObjectUtils.isNull(attr))
            throw new DateNotFountException("属性不存在");


        AttrAttrGroupRelation relation = attrAttrGroupRelationService.getOne(Wrappers.lambdaQuery(AttrAttrGroupRelation.class)
                .eq(AttrAttrGroupRelation::getAttrId, attr.getId()));

        Category category = categoryService.getById(relation.getCategoryId());
        attr.setCategoryName(category.getName());
        attr.setCategories(categoryService.categoryPath(category.getId()));

        if (attr.getType().equals(EAttrType.SELL.getCode()))
            return attr;

        if (ObjectUtils.nonNull(relation.getAttrGroupId())) {
            AttrGroup attrGroup = attrGroupService.getById(relation.getAttrGroupId());
            attr.setGroupName(attrGroup.getName());
            attr.setAttrGroupId(attrGroup.getId());
        }
        return attr;
    }

    @Override
    public Boolean delete(Long id) {
        return removeById(id);
    }
}
