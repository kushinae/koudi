package org.kushinae.koudi.common.enums.product;

/**
 * 当前商品状态: 0 - 库存中 1 - 提交审核 2 - 审核中 3 - 审核拒绝 4 - 审核通过 5 - 发布中
 * @author bnyte
 * @since 1.0.0
 */
public enum ESpuStatus {

    /**
     * 库存中
     */
    IN_STOCK(0),

    /**
     * 提交审核
     */
    SUBMIT_REVIEW(1),

    /**
     * 审核中
     */
    UNDER_REVIEW(2),


    /**
     * 审核拒绝
     */
    REVIEW_REJECTED(3),

    /**
     * 审核通过
     */
    REVIEW_PASSED(4),

    /**
     * 发布中
     */
    PUBLISH(5),
    ;

    /**
     * 获取SPU默认状态
     * @return 库存中 IN_STOCK
     */
    public static ESpuStatus defaultStatus() {
        return IN_STOCK;
    }

    private final Integer code;

    ESpuStatus(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
