import type { AttrGroupSearch } from '@/interface/param/Search';
import { request } from 'umi';

/** 获取树状分类列表 POST /attr/group/list */
export async function listWithPage(payload: AttrGroupSearch) {
  return request<APIResponse.Page<APIResponse.AttrGroup>>(`${API}/api/product/attr/group/list`, {
    method: 'POST',
    data: {
      ...payload
    },
  });
}

/** 编辑属性组 POST /attr/group/editor */
export async function editor(payload: APIResponse.AttrGroup) {
  return request<APIResponse.R<number>>(`${API}/api/product/attr/group/editor`, {
    method: 'POST',
    data: {
      ...payload
    },
  });
}

/** 属性组详情 GET /attr/group/detail?id=${id} */
export async function detail(id: number) {
  return request<APIResponse.R<APIResponse.AttrGroup>>(`${API}/api/product/attr/group/detail?id=${id}`, {
    method: 'GET',
  });
}

/** 删除属性组 DELETE /attr/group/remove */
export async function remove(id: number) {
  return request<APIResponse.R<number>>(`${API}/api/product/attr/group/remove?id=${id}`, {
    method: 'DELETE',
  });
}