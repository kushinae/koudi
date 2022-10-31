// @ts-ignore
/* eslint-disable */
import { request } from 'umi';

/** 获取树状分类列表 GET /category/tree */
export async function tree() {
  return request<APIResponse.R<APIResponse.Category[]>>(`${API}/api/product/category/tree`, {
    method: 'GET',
  });
}
