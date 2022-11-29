import { BaseEntity } from '../base';
/**
 * Spu
 */
 export interface Spu extends BaseEntity {
  /**
   * 品牌表koudi_product.t_brand的主键id
   */
  brandId?: number;
  /**
   * 分类表koudi_product.t_category的主键id
   */
  categoryId?: number;
  /**
   * spu的商品名称 如(Apple iPhone 13)
   */
  name?: string;
  /**
   * 当前商品状态: 0 - 库存中 1 - 提交审核 2 - 审核中 3 - 审核拒绝 4 - 审核通过 5 - 发布中
   */
  status?: number;
  /**
   * 商品副标题（如果在sku没有设置的话则默认使用spu的副标题）
   */
  subTitle?: string;
  /**
   * 商品主标题（如果在sku没有设置的话则默认使用spu的标题）
   */
  title?: string;
}