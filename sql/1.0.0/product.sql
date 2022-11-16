create table `t_product_category`
(
    `id`                  bigint NOT NULL AUTO_INCREMENT comment '分类id',
    `name`                varchar(50)  default null comment '分类名称',
    `parent_id`           bigint       default null comment '父分类id',
    `level`               int          default null comment '层级',
    `show`                tinyint(1) default null comment '是否显示[0-不显示，1显示]',
    `sort`                int          default null comment '排序',
    `icon`                varchar(255) default null comment '图标地址',
    `product_unit`        varchar(50)  default null comment '计量单位',
    `product_count`       int          default null comment '商品数量',
    `create_time`         datetime     DEFAULT CURRENT_TIMESTAMP comment '数据创建时间',
    `modified_time`       datetime     DEFAULT CURRENT_TIMESTAMP comment '数据更新时间',
    `create_admin_id`     varchar(255) default null comment '数据创建用户',
    `create_admin_name`   varchar(255) default null comment '数据创建用户名称',
    `modified_admin_name` varchar(255) default null comment '数据更新用户名称',
    `modified_admin_id`   varchar(255) default null comment '数据更新用户',
    `deleted`             tinyint(1) DEFAULT '0' comment '是否逻辑删除 0否 1是 默认否',
    PRIMARY KEY (`id`)
) comment='商品三级分类';

create table t_product_brand
(
    id                    bigint not null primary key auto_increment comment '品牌id',
    name                  char(50) comment '品牌名',
    logo                  varchar(2000) comment '品牌logo地址',
    description           longtext comment '介绍',
    `show`                tinyint(1) comment '显示状态[0-不显示；1-显示]',
    first_letter          char(1) comment '检索首字母',
    sort                  int comment '排序数字越大排序越高',
    `create_time`         datetime     DEFAULT CURRENT_TIMESTAMP comment '数据创建时间',
    `modified_time`       datetime     DEFAULT CURRENT_TIMESTAMP comment '数据更新时间',
    `create_admin_id`     varchar(255) default null comment '数据创建用户',
    `create_admin_name`   varchar(255) default null comment '数据创建用户名称',
    `modified_admin_name` varchar(255) default null comment '数据更新用户名称',
    `modified_admin_id`   varchar(255) default null comment '数据更新用户',
    `deleted`             tinyint(1) DEFAULT '0' comment '是否逻辑删除 0否 1是 默认否'
) comment '品牌表';

create table t_product_attr_group
(
    id                    bigint primary key not null auto_increment comment '分组id',
    attr_group_name       char(20) comment '组名',
    sort                  int comment '排序 数值越高排序优先级越高',
    description           varchar(255) comment '描述',
    icon                  varchar(255) comment '组图标',
    category_id           bigint comment '所属分类id',
    `create_time`         datetime     DEFAULT CURRENT_TIMESTAMP comment '数据创建时间',
    `modified_time`       datetime     DEFAULT CURRENT_TIMESTAMP comment '数据更新时间',
    `create_admin_id`     varchar(255) default null comment '数据创建用户',
    `create_admin_name`   varchar(255) default null comment '数据创建用户名称',
    `modified_admin_name` varchar(255) default null comment '数据更新用户名称',
    `modified_admin_id`   varchar(255) default null comment '数据更新用户',
    `deleted`             tinyint(1) DEFAULT '0' comment '是否逻辑删除 0否 1是 默认否'
) comment '属性分组表';

create table t_category_brand_relation
(
    id                  bigint(20) not null auto_increment primary key,
    brand_id            bigint(20) default null comment '品牌id',
    category_id         bigint(20) default null comment '分类id',
    brand_name          varchar(255) default null comment '品牌名称',
    category_name       varchar(255) default null comment '分类名称',
    create_time         datetime     default now() comment '数据创建时间',
    modified_time       datetime     default now() comment '数据更新时间',
    create_admin_id     varchar(255) comment '数据创建用户',
    create_admin_name   varchar(255) comment '数据创建用户名称',
    modified_admin_name varchar(255) comment '数据更新用户名称',
    modified_admin_id   varchar(255) comment '数据更新用户',
    deleted             tinyint(1) default 0 comment '是否逻辑删除 0否 1是 默认否'
) comment '品牌分类关联';