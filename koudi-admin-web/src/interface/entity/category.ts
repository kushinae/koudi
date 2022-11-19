import { BaseEntity } from '../base';

export interface Category extends BaseEntity {
  /**
   * 当前分类的子分类
   */
  children?: Category[];
  /**
   * 图标地址
   */
  icon?: string;
  /**
   * 层级
   */
  level?: number;
  /**
   * 分类名称
   */
  name?: string;
  /**
   * 父分类id
   */
  parentId?: number;
  /**
   * 商品数量
   */
  productCount?: number;
  /**
   * 计量单位
   */
  productUnit?: string;
  /**
   * 当前分类是否选中
   */
  selector?: boolean;
  /**
   * 是否显示[0-不显示，1显示]
   */
  show?: boolean;
  /**
   * 排序
   */
  sort?: number;
}
