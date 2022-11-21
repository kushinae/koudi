package org.kushinae.koudi.common.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author bnyte
 * @since 1.0.0
 */
public class CollectionUtils {

    public static boolean isEmpty(Collection<?> collection) {
        return org.springframework.util.CollectionUtils.isEmpty(collection);
    }

    public static boolean notEmpty(Collection<?> collection) {
        return !org.springframework.util.CollectionUtils.isEmpty(collection);
    }

    public static Collection<String> transferFromString(CharSequence delimiter, String sequence) {
        return Arrays.asList(sequence.split(delimiter.toString()));
    }

    public static <T> List<T> reverse(List<T> collection) {
        Collections.reverse(collection);
        return collection;
    }

}
