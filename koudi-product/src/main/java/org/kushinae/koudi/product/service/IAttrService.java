package org.kushinae.koudi.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.kushinae.koudi.common.entity.product.Attr;
import com.baomidou.mybatisplus.extension.service.IService;
import org.kushinae.koudi.common.enums.product.EAttrSwitchTarget;
import org.kushinae.koudi.common.param.search.product.attr.AttrSearch;

/**
 * <p>
 * 商品、规格与包装的属性key及值,值可以多个 使用英文逗号分隔 服务类
 * </p>
 *
 * @author bnyte
 * @since 2022-11-17
 */
public interface IAttrService extends IService<Attr> {

    Long editor(Attr payload);

    Page<Attr> searchWithPage(AttrSearch search);

    Boolean switchTarget(EAttrSwitchTarget target, Long id);

    Attr detailById(Long id);

    Boolean delete(Long id);
}
