package org.kushinae.koudi.common.util;

/**
 * @author bnyte
 * @since 1.0.0
 */
public abstract class StringUtils {

    public static boolean hasText(String source) {
        return org.springframework.util.StringUtils.hasText(source);
    }


    public static boolean notText(String source) {
        return !org.springframework.util.StringUtils.hasText(source);
    }

}
