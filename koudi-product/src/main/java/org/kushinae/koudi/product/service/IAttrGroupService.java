package org.kushinae.koudi.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.kushinae.koudi.common.entity.product.AttrGroup;
import com.baomidou.mybatisplus.extension.service.IService;
import org.kushinae.koudi.common.entity.product.Category;
import org.kushinae.koudi.common.param.search.product.attrgroup.AttrGroupSearch;

import java.util.List;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author bnyte
 * @since 2022-11-05
 */
public interface IAttrGroupService extends IService<AttrGroup> {

    Page<AttrGroup> listWithPage(AttrGroupSearch search);

    Long editor(AttrGroup payload);

    AttrGroup detail(Long id);

    Boolean deleteById(Long id);

    List<AttrGroup> listWithSearch(AttrGroupSearch search);

    Category detailWithAttrGroup(Long id);
}
