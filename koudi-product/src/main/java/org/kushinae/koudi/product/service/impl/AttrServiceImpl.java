package org.kushinae.koudi.product.service.impl;

import org.kushinae.koudi.common.entity.product.Attr;
import org.kushinae.koudi.product.mapper.AttrMapper;
import org.kushinae.koudi.product.service.IAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
