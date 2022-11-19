package org.kushinae.koudi.common.annotation;

import org.kushinae.koudi.common.enums.EUploadType;

import java.lang.annotation.*;

/**
 * @author bnyte
 * @since 1.0.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface UploadHandler {

    /**
     *
     * @return
     */
    EUploadType value() default EUploadType.DEFAULT;

}
