package org.kushinae.koudi.product.service;

import org.kushinae.koudi.common.entity.product.Attr;
import com.baomidou.mybatisplus.extension.service.IService;
import org.kushinae.koudi.common.vo.product.attr.AttrVO;

/**
 * <p>
 * 商品、规格与包装的属性key及值,值可以多个 使用英文逗号分隔 服务类
 * </p>
 *
 * @author bnyte
 * @since 2022-11-17
 */
public interface IAttrService extends IService<Attr> {

    Long editor(AttrVO payload);
}
