create database koudi_product;

use koudi_product;

create table if not exists t_category
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

create table if not exists  t_brand
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

create table if not exists  t_attr_group
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

create table if not exists  t_category_brand_relation
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

create table t_attr
(
    id                  bigint not null auto_increment primary key,
    `name`              char(30) comment '属性名',
    enable_search       tinyint(1) default 0 comment '是否需要检索[0-false-不需要，1-true-需要]',
    multiple            tinyint(1)   default 0 comment '值类型[0-false-为单个值，1-true-可以选择多个值]',
    icon              varchar(255) default null comment '属性图标',
    multiple_value      varchar(255)    default null comment  '可选值列表[用逗号分隔]',
    type         int   default null comment  '属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]',
    category_id          bigint comment '所属分类',
    quick_show           tinyint(1) comment '快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整',
    create_time         datetime     default now() comment '数据创建时间',
    modified_time       datetime     default now() comment '数据更新时间',
    create_admin_id     varchar(255) comment '数据创建用户',
    create_admin_name   varchar(255) comment '数据创建用户名称',
    modified_admin_name varchar(255) comment '数据更新用户名称',
    modified_admin_id   varchar(255) comment '数据更新用户',
    deleted             tinyint(1)   default 0 comment '是否逻辑删除 0否 1是 默认否'
) comment '商品、规格与包装的属性key及值,值可以多个 使用英文逗号分隔';

create table t_attr_attr_group_relation
(
    id                  bigint not null auto_increment primary key,
    attr_group_id bigint comment '属性规格分组id',
    category_id          bigint comment '所属分类',
    sort        int default 0 comment '排序方式，数值越高优先级越高 默认为0',
    create_time         datetime     default now() comment '数据创建时间',
    modified_time       datetime     default now() comment '数据更新时间',
    create_admin_id     varchar(255) comment '数据创建用户',
    create_admin_name   varchar(255) comment '数据创建用户名称',
    modified_admin_name varchar(255) comment '数据更新用户名称',
    modified_admin_id   varchar(255) comment '数据更新用户',
    deleted             tinyint(1)   default 0 comment '是否逻辑删除 0否 1是 默认否'
) comment '属性键值和属性分组中间关联表';