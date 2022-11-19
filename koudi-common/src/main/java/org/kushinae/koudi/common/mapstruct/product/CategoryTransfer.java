package org.kushinae.koudi.common.mapstruct.product;

import org.kushinae.koudi.common.entity.product.Category;
import org.kushinae.koudi.common.vo.product.category.CategoryVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author bnyte
 * @since 1.0.0
 */
@Mapper
public interface CategoryTransfer {

    CategoryTransfer INSTANCE = Mappers.getMapper(CategoryTransfer.class);

    CategoryVO toVO(Category vo);

    List<CategoryVO> toVOList(List<Category> vos);

}
