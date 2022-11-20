interface Search {
  current?: number;
  pageSize?: number;
  key?: string;
}

export interface CategorySearch extends Search {
  disabled?: boolean;
  brandId?: number;
}

export interface BrandSearch extends Search {
  firstLetter?: string;
  description?: string;
}

export interface AttrGroupSearch extends Search {
  categoryName?: string;
}