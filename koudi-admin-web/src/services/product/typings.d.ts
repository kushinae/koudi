declare namespace API {
  type AttrGroupduixiang = {
    /** 所属分类id */
    categoryId?: number;
    /** 分类名称 */
    categoryName?: string;
    /** 数据创建用户 */
    createAdminId?: string;
    /** 数据创建用户名称 */
    createAdminName?: string;
    /** 数据创建时间 */
    createTime?: string;
    /** 是否逻辑删除 0否 1是 默认否 */
    deleted?: boolean;
    /** 描述 */
    description?: string;
    /** 组图标 */
    icon?: string;
    /** 分组id */
    id?: number;
    /** 数据更新用户 */
    modifiedAdminId?: string;
    /** 数据更新用户名称 */
    modifiedAdminName?: string;
    /** 数据更新时间 */
    modifiedTime?: string;
    /** 组名 */
    name?: string;
    /** 排序 数值越高排序优先级越高 */
    sort?: number;
  };

  type AttrGroupduixiang0 = {
    /** 所属分类id */
    categoryId?: number;
    /** 分类名称 */
    categoryName?: string;
    /** 数据创建用户 */
    createAdminId?: string;
    /** 数据创建用户名称 */
    createAdminName?: string;
    /** 数据创建时间 */
    createTime?: string;
    /** 是否逻辑删除 0否 1是 默认否 */
    deleted?: boolean;
    /** 描述 */
    description?: string;
    /** 组图标 */
    icon?: string;
    /** 分组id */
    id?: number;
    /** 数据更新用户 */
    modifiedAdminId?: string;
    /** 数据更新用户名称 */
    modifiedAdminName?: string;
    /** 数据更新时间 */
    modifiedTime?: string;
    /** 组名 */
    name?: string;
    /** 排序 数值越高排序优先级越高 */
    sort?: number;
  };

  type AttrGroupSearch = {
    categoryId?: number;
    /** 当前页码 */
    current?: number;
    /** 全局通用搜索关键词 */
    key?: string;
    /** 查询记录数 */
    pageSize?: number;
  };

  type AttrSearch = {
    /** 当前页码 */
    current?: number;
    enableSearch?: boolean;
    /** 全局通用搜索关键词 */
    key?: string;
    multiple?: boolean;
    /** 查询记录数 */
    pageSize?: number;
    type?: number[];
  };

  type AttrVO = {
    /** 所属分组id */
    attrGroupId?: number;
    /** 所属分类 */
    categoryId?: number[];
    categoryName?: string;
    /** 数据创建用户 */
    createAdminId?: string;
    /** 数据创建用户名称 */
    createAdminName?: string;
    /** 数据创建时间 */
    createTime?: string;
    /** 是否逻辑删除 0否 1是 默认否 */
    deleted?: boolean;
    /** 是否需要检索[0-false-不需要，1-true-需要] */
    enableSearch?: boolean;
    groupName?: string;
    /** 属性图标 */
    icon?: string;
    id?: number;
    /** 数据更新用户 */
    modifiedAdminId?: string;
    /** 数据更新用户名称 */
    modifiedAdminName?: string;
    /** 数据更新时间 */
    modifiedTime?: string;
    /** 值类型[0-false-为单个值，1-true-可以选择多个值] */
    multiple?: boolean;
    /** 可选值列表 */
    multipleValue?: string[];
    /** 属性名 */
    name?: string;
    /** 快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整 */
    quickShow?: boolean;
    /** 属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性] */
    type?: number;
  };

  type Brandduixiang = {
    /** 品牌分类列表 */
    category?: Categoryduixiang0[];
    /** 数据创建用户 */
    createAdminId?: string;
    /** 数据创建用户名称 */
    createAdminName?: string;
    /** 数据创建时间 */
    createTime?: string;
    /** 介绍 */
    description?: string;
    /** 检索首字母 */
    firstLetter?: string;
    /** 品牌id */
    id?: number;
    /** 品牌logo地址 */
    logo?: string;
    /** 数据更新用户 */
    modifiedAdminId?: string;
    /** 数据更新用户名称 */
    modifiedAdminName?: string;
    /** 数据更新时间 */
    modifiedTime?: string;
    /** 品牌名 */
    name?: string;
    /** 显示状态[0-不显示；1-显示] */
    show?: boolean;
    /** 排序数字越大排序越高 */
    sort?: number;
  };

  type Brandduixiang0 = {
    /** 品牌分类列表 */
    category?: Categoryduixiang[];
    /** 数据创建用户 */
    createAdminId?: string;
    /** 数据创建用户名称 */
    createAdminName?: string;
    /** 数据创建时间 */
    createTime?: string;
    /** 是否逻辑删除 0否 1是 默认否 */
    deleted?: boolean;
    /** 介绍 */
    description?: string;
    /** 检索首字母 */
    firstLetter?: string;
    /** 品牌id */
    id?: number;
    /** 品牌logo地址 */
    logo?: string;
    /** 数据更新用户 */
    modifiedAdminId?: string;
    /** 数据更新用户名称 */
    modifiedAdminName?: string;
    /** 数据更新时间 */
    modifiedTime?: string;
    /** 品牌名 */
    name?: string;
    /** 显示状态[0-不显示；1-显示] */
    show?: boolean;
    /** 排序数字越大排序越高 */
    sort?: number;
  };

  type BrandSearch = {
    /** 当前页码 */
    current?: number;
    /** 全局通用搜索关键词 */
    key?: string;
    /** 查询记录数 */
    pageSize?: number;
  };

  type Categoryduixiang = {
    /** 当前分类的子分类 */
    children?: Categoryduixiang[];
    /** 数据创建用户 */
    createAdminId?: string;
    /** 数据创建用户名称 */
    createAdminName?: string;
    /** 数据创建时间 */
    createTime?: string;
    /** 是否逻辑删除 0否 1是 默认否 */
    deleted?: boolean;
    /** 是否禁用 */
    disabled?: boolean;
    /** 图标地址 */
    icon?: string;
    /** 分类id */
    id?: number;
    /** 层级 */
    level?: number;
    /** 数据更新用户 */
    modifiedAdminId?: string;
    /** 数据更新用户名称 */
    modifiedAdminName?: string;
    /** 数据更新时间 */
    modifiedTime?: string;
    /** 分类名称 */
    name?: string;
    /** 父分类id */
    parentId?: number;
    /** 商品数量 */
    productCount?: number;
    /** 计量单位 */
    productUnit?: string;
    /** 当前分类是否选中 */
    selector?: boolean;
    /** 是否显示[0-不显示，1显示] */
    show?: boolean;
    /** 排序 */
    sort?: number;
  };

  type Categoryduixiang0 = {
    /** 当前分类的子分类 */
    children?: Categoryduixiang0[];
    /** 数据创建用户 */
    createAdminId?: string;
    /** 数据创建用户名称 */
    createAdminName?: string;
    /** 数据创建时间 */
    createTime?: string;
    /** 是否逻辑删除 0否 1是 默认否 */
    deleted?: boolean;
    /** 图标地址 */
    icon?: string;
    /** 分类id */
    id?: number;
    /** 层级 */
    level?: number;
    /** 数据更新用户 */
    modifiedAdminId?: string;
    /** 数据更新用户名称 */
    modifiedAdminName?: string;
    /** 数据更新时间 */
    modifiedTime?: string;
    /** 分类名称 */
    name?: string;
    /** 父分类id */
    parentId?: number;
    /** 商品数量 */
    productCount?: number;
    /** 计量单位 */
    productUnit?: string;
    /** 当前分类是否选中 */
    selector?: boolean;
    /** 是否显示[0-不显示，1显示] */
    show?: boolean;
    /** 排序 */
    sort?: number;
  };

  type deleteUsingDELETEParams = {
    /** id */
    id: number;
  };

  type detail1Params = {
    /** id */
    id: number;
  };

  type detailParams = {
    /** id */
    id: number;
  };

  type detailWithAttrGroupParams = {
    /** id */
    id: number;
  };

  type editor1Params = {
    /** id */
    id: number;
  };

  type fenleihepinpaibangdingxiangqing = {
    /** 分类列表 */
    category?: Categoryduixiang0[];
    /** 绑定的分类列表 */
    relations?: Categoryduixiang0[];
  };

  type levelHierarchyParams = {
    /** node_id */
    node_id: number;
  };

  type pinpaibangdingfenleiqingqiucanshu = {
    /** 分类列表 */
    categories?: number[];
    /** brand主键 */
    id?: number;
  };

  type RAttrGroupduixiang = {
    code?: number;
    data?: AttrGroupduixiang;
    message?: string;
    success?: boolean;
  };

  type RAttrVO = {
    code?: number;
    data?: AttrVO;
    message?: string;
    success?: boolean;
  };

  type Rboolean = {
    code?: number;
    data?: boolean;
    message?: string;
    success?: boolean;
  };

  type RBrandduixiang = {
    code?: number;
    data?: Brandduixiang;
    message?: string;
    success?: boolean;
  };

  type RCategoryduixiang = {
    code?: number;
    data?: Categoryduixiang;
    message?: string;
    success?: boolean;
  };

  type removeById1Params = {
    /** id */
    id: number;
  };

  type removeByIdParams = {
    /** id */
    id: number;
  };

  type removeNodeParams = {
    /** node_id */
    node_id: number;
  };

  type Rfenleihepinpaibangdingxiangqing = {
    code?: number;
    data?: fenleihepinpaibangdingxiangqing;
    message?: string;
    success?: boolean;
  };

  type RListAttrGroupduixiang = {
    code?: number;
    data?: AttrGroupduixiang[];
    message?: string;
    success?: boolean;
  };

  type RListCategoryduixiang = {
    code?: number;
    data?: Categoryduixiang0[];
    message?: string;
    success?: boolean;
  };

  type Rlong = {
    code?: number;
    data?: number;
    message?: string;
    success?: boolean;
  };

  type RPageAttrGroupduixiang = {
    code?: number;
    count?: number;
    current?: number;
    message?: string;
    records?: AttrGroupduixiang[];
    success?: boolean;
    total?: number;
  };

  type RPageAttrVO = {
    code?: number;
    count?: number;
    current?: number;
    message?: string;
    records?: AttrVO[];
    success?: boolean;
    total?: number;
  };

  type RPageBrandduixiang = {
    code?: number;
    count?: number;
    current?: number;
    message?: string;
    records?: Brandduixiang[];
    success?: boolean;
    total?: number;
  };

  type RUploadVO = {
    code?: number;
    data?: UploadVO;
    message?: string;
    success?: boolean;
  };

  type RVoid = {
    code?: number;
    message?: string;
    success?: boolean;
  };

  type switchTargetParams = {
    /** target */
    target: 'multiple' | 'search' | 'show';
    /** id */
    id: number;
  };

  type treeParams = {
    /** disabled */
    disabled?: boolean;
  };

  type treeWithBrandParams = {
    /** brand_id */
    brand_id: number;
  };

  type UploadVO = {
    filepath?: string;
  };
}
