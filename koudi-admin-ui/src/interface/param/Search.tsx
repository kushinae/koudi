export interface Search {
  // 当前页码
  current?: number;
  // 查询总数
  pageSize?: number;
  // 查询关键词
  key?: string | null;
  // 总计路数
  total?: number;
}

export interface BrandSearch extends Search {
}

export interface AttrGroupSearch extends Search {
  categoryId?: number;
}

export interface AttrSearch extends Search {
  attrGroupId?: number;
  enableSearch?: boolean;
}