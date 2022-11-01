package org.kushinae.koudi.common.util;

/**
 * @author bnyte
 * @since 1.0.0
 */
public class ObjectUtils {

    public static boolean isNull(Object obj) {
        return org.springframework.util.ObjectUtils.isEmpty(obj);
    }

    public static boolean nonNull(Object obj) {
        return !org.springframework.util.ObjectUtils.isEmpty(obj);
    }

}
