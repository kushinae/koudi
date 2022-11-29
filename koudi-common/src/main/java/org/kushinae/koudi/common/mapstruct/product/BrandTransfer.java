package org.kushinae.koudi.common.mapstruct.product;

import org.kushinae.koudi.common.entity.product.Brand;
import org.kushinae.koudi.common.vo.product.brand.BrandVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author bnyte
 * @since 1.0.0
 */
@Mapper
public interface BrandTransfer {

    BrandTransfer INSTANCE = Mappers.getMapper(BrandTransfer.class);

    Brand toDomain(BrandVO vo);

    BrandVO toVO(Brand domain);

    List<BrandVO> toVOS(List<Brand> brands);

}
