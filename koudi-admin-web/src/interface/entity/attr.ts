import { BaseEntity } from '../base';
/**
 * AttrGroup对象，规格组
 */
 export interface AttrGroup extends BaseEntity {
  /**
   * 所属分类id
   */
  categoryId?: number;
  /**
   * 分类名称
   */
  categoryName?: string;
  /**
   * 描述
   */
  description?: string;
  /**
   * 组图标
   */
  icon?: string;
  /**
   * 组名
   */
  name?: string;
  /**
   * 排序 数值越高排序优先级越高
   */
  sort?: number;
}

export interface Attr extends BaseEntity {
  // 分组类名
  name: string;
  // 开启搜索
  enableSearch: boolean;
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
  // 分组id
  attrGroupId?: number;
}