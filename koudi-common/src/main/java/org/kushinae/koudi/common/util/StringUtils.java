package org.kushinae.koudi.common.util;

import java.util.Collection;
import java.util.stream.Collectors;

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

    public static String transferFromList(CharSequence delimiter, Collection<?> collection) {
        return collection.stream().map(Object::toString).collect(Collectors.joining(delimiter));
    }

}
