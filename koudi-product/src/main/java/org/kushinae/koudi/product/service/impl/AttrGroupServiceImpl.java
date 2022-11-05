package org.kushinae.koudi.product.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.kushinae.koudi.common.entity.AttrGroup;
import org.kushinae.koudi.common.exception.ParameterCheckException;
import org.kushinae.koudi.common.lang.web.Status;
import org.kushinae.koudi.common.param.search.product.attrgroup.AttrGroupSearch;
import org.kushinae.koudi.common.util.ObjectUtils;
import org.kushinae.koudi.common.util.StringUtils;
import org.kushinae.koudi.product.mapper.AttrGroupMapper;
import org.kushinae.koudi.product.service.IAttrGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.kushinae.koudi.product.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public Page<AttrGroup> listWithPage(AttrGroupSearch search) {
        Page<AttrGroup> page = new Page<>(search.getCurrent(), search.getQueryCount());
        return page(page, Wrappers.lambdaQuery(AttrGroup.class).eq(StringUtils.hasText(search.getKey()), AttrGroup::getName, search.getKey()));
    }

    @Override
    public Long editor(AttrGroup payload) {
        if (ObjectUtils.isNull(service.getById(payload.getCategoryId())))
            throw new ParameterCheckException(Status.DATA_DOES_NOT_EXIST);

        saveOrUpdate(payload);
        return payload.getId();
    }

    @Override
    public AttrGroup detail(Long id) {
        return getById(id);
    }

    @Override
    public Boolean deleteById(Long id) {
        return removeById(id);
    }
}
