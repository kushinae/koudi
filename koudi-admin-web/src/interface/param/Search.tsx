interface Search {
  current?: number;
  pageSize?: number;
  key?: string;
}

export interface CategorySearch extends Search {
  disabled?: boolean;
  brandId?: number;
}
