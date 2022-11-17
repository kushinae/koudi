package org.kushinae.koudi.product.controller;

import com.bnyte.forge.annotation.APIHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.kushinae.koudi.common.lang.web.R;
import org.kushinae.koudi.common.vo.product.attr.AttrVO;
import org.kushinae.koudi.product.service.IAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 商品、规格与包装的属性key及值,值可以多个 使用英文逗号分隔 前端控制器
 * </p>
 *
 * @author bnyte
 * @since 2022-11-17
 */
@RestController
@RequestMapping("/attr")
@Api(tags = "商品、规格与包装的属性key及值,值可以多个 使用英文逗号分隔 前端控制器")
public class AttrController {

    @Autowired
    IAttrService service;

    @APIHelper
    @PostMapping("/editor")
    @ApiOperation("编辑属性")
    R<Long> editor(@RequestBody AttrVO payload) {
        return R.OK(service.editor(payload));
    }

}
