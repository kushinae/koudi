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
