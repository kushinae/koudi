declare namespace APIResponse {

  type R<T> = {
    code: number;
    message: string;
    success: boolean;
    data: T;
  }

  type Page<T> = {
    code: number;
    message: string;
    success: boolean;
    records: T[];
    /** 当前页码 */
    current: number;
    /** 当前页记录数 */
    count: number;
    /** 总记录数 */
    total: number;
  }

  type BaseData = {
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
  }

  type Category = {
    id: number;
    name: string;
    parentId: number;
    level: number;
    show: boolean;
    sort: number;
    icon: string | undefined;
    productUnit: string | undefined;
    productCount: number | undefined;
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
    children: APIResponse.Category[] | undefined;
    disabled: boolean | false | undefined;
    selector?: boolean | false;
  }

  type Brand = {
    // id
    id?: number;
    // 品牌名
    name: string;
    // 品牌logo地址
    logo?: string;
    // 介绍
    description: string;
    // 显示状态
    show: boolean;
    // 检索首字母
    firstLetter: string;
    // 排序数字越大排序越高
    sort: number;
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
  }

  type AttrGroup = {
    // id
    id?: number;
    // 分组类名
    name: string;
    // 品牌icon地址
    icon?: string;
    // 介绍
    description: string;
    // 显示状态
    show: boolean;
    // 排序数字越大排序越高
    sort: number;
    // 分类名称
    categoryName: string;
    // 分类id
    categoryId: number;
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
  }


}