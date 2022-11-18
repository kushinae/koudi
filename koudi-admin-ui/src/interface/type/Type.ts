export interface Attr {
  // id
  id?: number;
  // 分组类名
  name: string;
  // 开启搜索
  enableSearch?: boolean;
  // 值类型[0-false-为单个值，1-true-可以选择多个值]
  multiple: boolean;
  // 属性图标
  icon: string;
  // 可选值列表[用逗号分隔]
  multipleValue: string[];
  // 属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]
  type: number;
  // 分类id
  categoryId?: number[];
  // 快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整
  quickShow?: boolean;
  // 数据创建时间
  createTime: string | undefined;
  // 数据修改时间
  modifiedTime: string | undefined;
  // 数据创建用户名
  createAdminName: string | undefined;
  // 数据更新用户名
  modifiedAdminName: string | undefined;
  // 是否删除
  deleted: boolean | undefined;
  // 分组id
  attrGroupId?: number;
}