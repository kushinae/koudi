package org.kushinae.koudi.common.enums.product;

import org.kushinae.koudi.common.exception.DateNotFountException;

/**
 * 属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]
 * @author bnyte
 * @since 1.0.0
 */
public enum EAttrType {

    SELL(0),
    BASE(1),
    ALL(2),
    ;

    public static EAttrType code(Integer code) {
        for (EAttrType value : values()) {
            if (value.code.equals(code))
                return value;
        }
        throw new DateNotFountException("属性类型不存在");
    }
    private final Integer code;

    EAttrType(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
