import { BaseEntity } from '../base';

/**
 * Brand对象，品牌分类
 */
 export interface Brand extends BaseEntity {
  /**
   * 品牌分类列表
   */
   categories?: number[];
  /**
   * 介绍
   */
  description?: string;
  /**
   * 检索首字母
   */
  firstLetter?: string;
  /**
   * 品牌id
   */
  id?: number;
  /**
   * 品牌logo地址
   */
  logo?: string;
  /**
   * 品牌名
   */
  name?: string;
  /**
   * 显示状态[0-不显示；1-显示]
   */
  show?: boolean;
  /**
   * 排序数字越大排序越高
   */
  sort?: number;
}