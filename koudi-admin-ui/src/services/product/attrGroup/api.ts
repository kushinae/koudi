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