package org.kushinae.koudi.product.controller;

import io.swagger.annotations.ApiOperation;
import org.kushinae.koudi.common.annotation.UploadData;
import org.kushinae.koudi.common.annotation.UploadHandler;
import org.kushinae.koudi.common.lang.web.R;
import org.kushinae.koudi.common.vo.upload.UploadVO;
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
public class UploadController {

    @UploadHandler
    @ApiOperation("上传资源")
    @PostMapping("/resource")
    R<UploadVO> resource(@RequestParam("file") MultipartFile file, @UploadData String filepath) {
        return R.OK(UploadVO.builder().filepath(filepath).build());
    }

}
