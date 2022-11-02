package org.kushinae.koudi.product.service.impl;

import org.kushinae.koudi.common.entity.Brand;
import org.kushinae.koudi.product.mapper.BrandMapper;
import org.kushinae.koudi.product.service.IBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author bnyte
 * @since 2022-11-03
 */
@Service
public class IBrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {

}
