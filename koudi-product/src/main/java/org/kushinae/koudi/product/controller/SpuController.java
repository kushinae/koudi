package org.kushinae.koudi.product.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.kushinae.koudi.common.entity.product.Spu;
import org.kushinae.koudi.common.lang.web.R;
import org.kushinae.koudi.common.lang.web.RPage;
import org.kushinae.koudi.common.mapstruct.product.SpuTransfer;
import org.kushinae.koudi.common.param.search.product.spu.SpuSearch;
import org.kushinae.koudi.common.vo.product.spu.SpuVO;
import org.kushinae.koudi.product.service.ISpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * spu商品信息 前端控制器
 * </p>
 *
 * @author bnyte
 * @since 2022-11-26
 */
@Api(tags = "商品管理-----SPU前端控制器")
@RestController
@RequestMapping("/spu")
public class SpuController {

    @Autowired
    ISpuService service;

    @PostMapping("/editor")
    @ApiOperation("编辑SPU信息")
    R<Long> editor(@RequestBody SpuVO payload) {
        return R.OK(service.editor(SpuTransfer.INSTANCE.toDomain(payload)));
    }

    @PostMapping("/search")
    @ApiOperation("分页获取spu列表")
    RPage<SpuVO> searchWithPage(@RequestBody(required = false) SpuSearch search) {
        Page<Spu> page = service.searchWithPage(search);
        return RPage.OK(page, SpuTransfer.INSTANCE.toVOS(page.getRecords()));
    }

    @DeleteMapping("/deleted")
    @ApiOperation("分页获取spu列表")
    R<Boolean> deletedById(@RequestParam("id") Long id) {
        return R.OK(service.deletedById(id));
    }

    @GetMapping("/detail")
    @ApiOperation("获取spu详情")
    R<SpuVO> detailById(@RequestParam("id") Long id) {
        return R.OK(SpuTransfer.INSTANCE.toVO(service.detailById(id)));
    }

}
