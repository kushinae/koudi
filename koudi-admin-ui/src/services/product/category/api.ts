// @ts-ignore
/* eslint-disable */
import { request } from 'umi';

/** 获取树状分类列表 GET /category/tree */
export async function tree(disabled: false | boolean) {
  return request<APIResponse.R<APIResponse.Category[]>>(`${API}/api/product/category/tree?disabled=${disabled}`, {
    method: 'GET',
  });
}

/** 获取节点层级关系id列表 GET /category/level/hierarchy?node_id=${id} */
export async function levelHierarchy(id: number) {
  return request<APIResponse.R<APIResponse.Category[]>>(`${API}/api/product/category/level/hierarchy?node_id=${id}`, {
    method: 'GET',
  });
}

/** 编辑分类 POST /category/editor */
export async function editor(payload: APIResponse.Category) {
  return request<APIResponse.R<number>>(`${API}/api/product/category/editor`, {
    method: 'POST',
    data: {
      ...payload
    },
  });
}

/** 删除分类 DELETE /category/remove */
export async function remove(id: number) {
  return request<APIResponse.R<number>>(`${API}/api/product/category/remove?node_id=${id}`, {
    method: 'DELETE',
  });
}