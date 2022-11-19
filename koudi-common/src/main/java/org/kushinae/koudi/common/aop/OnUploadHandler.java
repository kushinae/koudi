package org.kushinae.koudi.common.aop;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.kushinae.koudi.common.annotation.UploadData;
import org.kushinae.koudi.common.annotation.UploadHandler;
import org.kushinae.koudi.common.exception.ForestClientNotFount;
import org.kushinae.koudi.common.forest.UpyunClient;
import org.kushinae.koudi.common.properties.upyun.UpyunProperties;
import org.kushinae.koudi.common.util.FileUtils;
import org.kushinae.koudi.common.util.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author bnyte
 * @since 1.0.0
 */
@Aspect
@Component
public class OnUploadHandler {

    @Autowired(required = false)
    UpyunClient upyunClient;

    @Autowired
    UpyunProperties upyunProperties;

    /**
     * 切入点
     */
    @Pointcut("@annotation(org.kushinae.koudi.common.annotation.UploadHandler)")
    public void pointcut(){}

    /**
     * 环绕通知，具体的接口日志输出点，改方式当接口出现异常时不会输出异常日志
     * @param point 切入点重要参数
     * @return 返回方法执行之后的方法返回值
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        if (ObjectUtils.isNull(upyunClient)) {
            throw new ForestClientNotFount();
        }

        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method method = methodSignature.getMethod();
        UploadHandler uploadHandler = method.getAnnotation(UploadHandler.class);
        int writeBackIndex = 0;
        int fileIndex = 0;
        Parameter[] parameters = method.getParameters();
        Object[] args = point.getArgs();
        for (int i = 0; i < parameters.length; i++) {
            UploadData uploadData = parameters[i].getAnnotation(UploadData.class);
            if (ObjectUtils.nonNull(uploadData)) {
                writeBackIndex = i;
                break;
            } else if (args[i] instanceof MultipartFile) {
                fileIndex = i;
            }
        }

        MultipartFile file = (MultipartFile) args[fileIndex];

        String originalFilename = file.getOriginalFilename();
        String filetype = FileUtils.getFiletype(originalFilename);

        String filename = NanoIdUtils.randomNanoId() + "." + filetype;

        String folder = resetStartPaths(uploadHandler.value().getPath());

        upyunClient.uploadFile(file.getBytes(), folder, filename);

        args[writeBackIndex] = upyunProperties.getUploadPath(folder, filename);

        return point.proceed(args);
    }

    public String resetStartPaths(String path) {
        if (path.startsWith("/")) {
            path = path.substring(path.indexOf("/") + 1);
            resetStartPaths(path);
        }
        return path;
    }

}
