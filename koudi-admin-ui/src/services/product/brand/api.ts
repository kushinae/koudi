// @ts-ignore
/* eslint-disable */
import { BrandSearch } from '@/interface/param/Search';
import { request } from 'umi';

/** 获取树状分类列表 POST /brand/list */
export async function listWithPage(payload: BrandSearch) {
  return request<APIResponse.Page<APIResponse.Brand>>(`${API}/api/product/brand/list`, {
    method: 'POST',
    data: {
      ...payload
    },
  });
}

/** 编辑品牌 POST /brand/editor */
export async function editor(payload: APIResponse.Brand) {
  return request<APIResponse.R<number>>(`${API}/api/product/brand/editor`, {
    method: 'POST',
    data: {
      ...payload
    },
  });
}

/** 品牌详情 GET /brand/detail?id=${id} */
export async function detail(id: number) {
  return request<APIResponse.R<APIResponse.Brand>>(`${API}/api/product/brand/detail?id=${id}`, {
    method: 'GET',
  });
}

/** 删除分类 DELETE /category/remove */
export async function remove(id: number) {
  return request<APIResponse.R<number>>(`${API}/api/product/brand/remove?id=${id}`, {
    method: 'DELETE',
  });
}