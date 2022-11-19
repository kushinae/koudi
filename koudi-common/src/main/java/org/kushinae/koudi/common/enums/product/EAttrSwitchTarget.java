package org.kushinae.koudi.common.enums.product;

/**
 * 属性转换目标类型
 *  search: enable_search: 是否需要检索
 *  multiple: multiple: 值类型，值为单个或者多个
 *  show: quick_show: 是否快速显示
 * @author bnyte
 * @since 1.0.0
 */
public enum EAttrSwitchTarget {
    search("enable_search"),
    multiple("multiple"),
    show("quick_show"),
    ;

    private final String sqlColumn;

    EAttrSwitchTarget(String sqlColumn) {
        this.sqlColumn = sqlColumn;
    }

    public String getSqlColumn() {
        return sqlColumn;
    }
}
