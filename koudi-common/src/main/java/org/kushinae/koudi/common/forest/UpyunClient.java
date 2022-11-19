package org.kushinae.koudi.common.forest;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.Put;
import com.dtflys.forest.annotation.Var;
import org.kushinae.koudi.common.forest.interceptor.UpyunAuthorizationInterceptor;

/**
 * @author bnyte
 * @since 1.0.0
 */
@BaseRequest(
        baseURL = "https://v0.api.upyun.com/#{upyun.service_name}/#{upyun.dir_path}",
        interceptor = UpyunAuthorizationInterceptor.class
)
public interface UpyunClient {

    /**
     * 上传文件
     */
    @Put("/{filename}")
    String uploadFile(@Body byte[] file, @Var("filename") String filename);

    @Put("/{folder}/{filename}")
    String uploadFile(@Body byte[] file, @Var("folder") String folder, @Var("filename") String filename);

    /**
     * 删除文件
     */
    @Put("/{filename}")
    String deleteFile(@Var("filename") String filename);
}
