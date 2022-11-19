package org.kushinae.koudi.common.mapstruct.product;

import org.kushinae.koudi.common.entity.product.Attr;
import org.kushinae.koudi.common.vo.product.attr.AttrVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author bnyte
 * @since 1.0.0
 */
@Mapper
public interface AttrTransfer {

    AttrTransfer INSTANCE = Mappers.getMapper(AttrTransfer.class);

    @Mappings({
            @Mapping(target = "multipleValue", expression = "java((java.util.List<String>) org.kushinae.koudi.common.util.CollectionUtils.transferFromString(\",\", domain.getMultipleValue()))")
    })
    AttrVO toVO(Attr domain);

    @Mappings({
        @Mapping(target = "multipleValue", expression = "java(org.kushinae.koudi.common.util.StringUtils.transferFromList(\",\", vo.getMultipleValue()))")
    })
    Attr toDomain(AttrVO vo);

    List<AttrVO> toVOS(List<Attr> domain);

}
