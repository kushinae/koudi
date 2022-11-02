CREATE TABLE `t_product_category`
(
    `id`                  bigint NOT NULL AUTO_INCREMENT COMMENT '分类id',
    `name`                varchar(50)  DEFAULT NULL COMMENT '分类名称',
    `parent_id`           bigint       DEFAULT NULL COMMENT '父分类id',
    `level`               int          DEFAULT NULL COMMENT '层级',
    `show`                tinyint(1) DEFAULT NULL COMMENT '是否显示[0-不显示，1显示]',
    `sort`                int          DEFAULT NULL COMMENT '排序',
    `icon`                varchar(255) DEFAULT NULL COMMENT '图标地址',
    `product_unit`        varchar(50)  DEFAULT NULL COMMENT '计量单位',
    `product_count`       int          DEFAULT NULL COMMENT '商品数量',
    `create_time`         datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建时间',
    `modified_time`       datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '数据更新时间',
    `create_admin_id`     varchar(255) DEFAULT NULL COMMENT '数据创建用户',
    `create_admin_name`   varchar(255) DEFAULT NULL COMMENT '数据创建用户名称',
    `modified_admin_name` varchar(255) DEFAULT NULL COMMENT '数据更新用户名称',
    `modified_admin_id`   varchar(255) DEFAULT NULL COMMENT '数据更新用户',
    `deleted`             tinyint(1) DEFAULT '0' COMMENT '是否逻辑删除 0否 1是 默认否',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品三级分类';