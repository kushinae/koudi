export interface Search {
  // 当前页码
  current: number;
  // 查询总数
  queryCount: number;
  // 查询关键词
  key?: string;
  // 总计路数
  total?: number;
}

export interface BrandSearch extends Search {
}

export interface AttrGroupSearch extends Search {
  categoryId?: number;
}