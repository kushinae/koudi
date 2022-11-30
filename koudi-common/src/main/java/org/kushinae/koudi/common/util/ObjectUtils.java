package org.kushinae.koudi.common.util;

import java.util.Objects;

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

    public static boolean equals(Object a, Object b) {
        return Objects.equals(a, b);
    }

    public static boolean notEquals(Object a, Object b) {
        return !Objects.equals(a, b);
    }

}
