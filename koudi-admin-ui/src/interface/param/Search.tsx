export interface Search {
  // 当前页码
  current: number;
  // 查询总数
  queryCount: number;
}

export interface BrandSearch extends Search {
  // 名称
  name?: string;
}