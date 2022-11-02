package org.kushinae.koudi.common.handler;

import org.kushinae.koudi.common.exception.GlobalException;
import org.kushinae.koudi.common.exception.ParameterCheckException;
import org.kushinae.koudi.common.lang.web.R;
import org.kushinae.koudi.common.lang.web.Status;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.List;
import java.util.StringJoiner;

/**
 * @author bnyte
 * @since 1.0.0
 */
@RestControllerAdvice(basePackages = {
        "org.kushinae.koudi.product.controller",
})
public class ResponseAdviceHandler<T> implements ResponseBodyAdvice<R<T>> {

    /**
     * 系统业务请求参数校验异常 HTTP响应code为 400
     * @param e 请求异常对象继承自  {@see org.kushinae.koudi.common.exception.GlobalException}
     *          可通过其父类status属性获取其具体失败原因
     * @return 统一响应结果集
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ParameterCheckException.class)
    R<Void> handleParameterCheckException(ParameterCheckException e) {
        return R.ERROR(e.getStatus(), e.getMessage());
    }

    /**
     * 系统异常 HTTP响应code为 500
     * @param e 请求异常对象 可通过其父类status属性获取其具体失败原因
     * @return 统一响应结果集
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(GlobalException.class)
    R<Void> handleParameterCheckException(GlobalException e) {
        return R.ERROR(e.getStatus(), e.getMessage());
    }

    /**
     * 参数检验异常处理
     * @param e 异常响应
     * @return 响应结果
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    R<Void> handleValidationException(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        StringJoiner message = new StringJoiner(",");
        fieldErrors.forEach(error -> message.add(error.getDefaultMessage()));
        return R.ERROR(Status.PAYLOAD_ASSERT_ERROR, message.toString());
    }


    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public R<T> beforeBodyWrite(R<T> body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return body;
    }
}
