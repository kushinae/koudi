import type { AttrSearch } from '@/interface/param/Search';
import type { Attr } from '@/interface/type/Type';
import { request } from 'umi';

/** 编辑属性 POST /attr/editor */
export async function editor(payload: Attr) {
  return request<APIResponse.R<number>>(`${API}/api/product/attr/editor`, {
    method: 'POST',
    data: {
      ...payload
    },
  });
}

/** 分页搜索获取所有属性 POST /attr/page/search */
export async function searchWithPage(payload: AttrSearch) {
  return request<APIResponse.Page<Attr>>(`${API}/api/product/attr/page/search`, {
    method: 'POST',
    data: {
      ...payload
    },
  });
}

/** 修改指定属性的目标值 POST /attr/switch/{target} */
export async function switchByTarget(target: string, id: number) {
  return request<APIResponse.Page<Attr>>(`${API}/api/product/attr/switch/${target}`, {
    method: 'POST',
    params: {
      id
    },
  });
}

/** 获取属性详情 POST /attr/detail */
export async function detail(id: number) {
  return request<APIResponse.R<Attr>>(`${API}/api/product/attr/detail`, {
    method: 'GET',
    params: {
      id
    },
  });
}

/** 删除属性 DELETE /attr/delete */
export async function deleteById(id: number) {
  return request<APIResponse.R<boolean>>(`${API}/api/product/attr/delete`, {
    method: 'DELETE',
    params: {
      id
    },
  });
}