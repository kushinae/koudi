import { request } from 'umi';

/** 获取品牌分类列表 GET /category/tree */
export async function tree(disabled: false | boolean) {
  return request<APIResponse.R<APIResponse.Category[]>>(`${API}/api/product/category/tree?disabled=${disabled}`, {
    method: 'GET',
  });
}