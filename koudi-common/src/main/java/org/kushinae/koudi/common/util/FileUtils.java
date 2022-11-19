package org.kushinae.koudi.common.util;

import org.kushinae.koudi.common.exception.BusinessCheckException;
import org.kushinae.koudi.common.lang.web.Status;

/**
 * @author bnyte
 * @since 1.0.0
 */
public class FileUtils {

    public static String getFiletype(String metaData) {
        try {
            return metaData.substring(metaData.lastIndexOf(".") + 1);
        } catch (Exception e) {
            throw new BusinessCheckException(Status.NOT_A_FILE);
        }
    }

    public static String getFilename(String metaData) {
        try {
            return metaData.substring(0, metaData.lastIndexOf("."));
        } catch (Exception e) {
            throw new BusinessCheckException(Status.NOT_A_FILE);
        }
    }

}
