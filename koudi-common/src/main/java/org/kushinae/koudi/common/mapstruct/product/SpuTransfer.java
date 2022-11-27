package org.kushinae.koudi.common.mapstruct.product;

import org.kushinae.koudi.common.entity.product.Spu;
import org.kushinae.koudi.common.vo.product.spu.SpuVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author bnyte
 * @since 1.0.0
 */
@Mapper
public interface SpuTransfer {

    SpuTransfer INSTANCE = Mappers.getMapper(SpuTransfer.class);

    Spu toDomain(SpuVO vo);

    SpuVO toVO(Spu domain);

    List<SpuVO> toVOS(List<Spu> domains);

}
