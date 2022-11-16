package org.kushinae.koudi.product.controller;

import com.bnyte.forge.annotation.APIHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.kushinae.koudi.common.annotation.UploadData;
import org.kushinae.koudi.common.annotation.UploadHandler;
import org.kushinae.koudi.common.enums.EUploadType;
import org.kushinae.koudi.common.lang.web.R;
import org.kushinae.koudi.common.vo.product.upload.UploadVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author bnyte
 * @since 1.0.0
 */
@RestController
@RequestMapping("/upload")
@Api(tags = "上传 前端控制器")
public class UploadController {

    @APIHelper
    @UploadHandler(EUploadType.BRAND)
    @ApiOperation("上传资源")
    @PostMapping("/sso")
    R<UploadVO> resource(@RequestParam("file") MultipartFile file, @UploadData String filepath) {
        return R.OK(new UploadVO(filepath));
    }

}
