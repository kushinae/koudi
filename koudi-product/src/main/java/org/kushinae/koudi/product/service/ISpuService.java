package org.kushinae.koudi.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.kushinae.koudi.common.entity.product.Spu;
import org.kushinae.koudi.common.param.search.product.spu.SpuSearch;

/**
 * <p>
 * spu商品信息 服务类
 * </p>
 *
 * @author bnyte
 * @since 2022-11-26
 */
public interface ISpuService extends IService<Spu> {

    Long editor(Spu payload);

    Page<Spu> searchWithPage(SpuSearch search);

    Boolean deletedById(Long id);

    Spu detailById(Long id);
}
