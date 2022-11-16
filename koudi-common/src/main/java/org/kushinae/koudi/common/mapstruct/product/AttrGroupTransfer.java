package org.kushinae.koudi.common.mapstruct.product;

import org.kushinae.koudi.common.entity.product.AttrGroup;
import org.kushinae.koudi.common.entity.product.Brand;
import org.kushinae.koudi.common.vo.product.attrgroup.AttrGroupVO;
import org.kushinae.koudi.common.vo.product.brand.BrandVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author bnyte
 * @since 1.0.0
 */
@Mapper
public interface AttrGroupTransfer {

    AttrGroupTransfer INSTANCE = Mappers.getMapper(AttrGroupTransfer.class);


    AttrGroup toDomain(AttrGroupVO vo);

    AttrGroupVO toVO(AttrGroup domain);

}
