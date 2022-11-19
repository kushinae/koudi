export interface BaseEntity {
  /**
   * 主键id
   */
  id?: number | string;
  /**
   * 数据创建用户
   */
  createAdminId?: string;
  /**
   * 数据创建用户名称
   */
  createAdminName?: string;
  /**
   * 数据创建时间
   */
  createTime?: Date;
  /**
   * 是否逻辑删除 0否 1是 默认否
   */
  deleted?: boolean;
  /**
   * 数据更新用户
   */
  modifiedAdminId?: string;
  /**
   * 数据更新用户名称
   */
  modifiedAdminName?: string;
  /**
   * 数据更新时间
   */
  modifiedTime?: Date;
}

export interface BaseResponse {
  code: number;
  message: string;
  success: boolean;
}

export interface Response<T> extends BaseResponse {
  data?: T;
}

export interface Page<T> extends BaseResponse {
  /**
   * 响应数据
   */
  records: T[];

  /**
   * 当前页码
   */
  current: number;

  /**
   * 请求查询的数量
   */
  pageSize: number;

  /**
   * 当前查询结果的总记录数
   */
  total: number;
}
