// @ts-ignore
/* eslint-disable */
import { request } from 'umi';

/** 删除属性 DELETE /product/attr/delete */
export async function deleteUsingDELETE(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: API.deleteUsingDELETEParams,
  options?: { [key: string]: any },
) {
  return request<API.Rboolean>('/product/attr/delete', {
    method: 'DELETE',
    params: {
      ...params,
    },
    ...(options || {}),
  });
}

/** 获取属性详情 GET /product/attr/detail */
export async function detail(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: API.detailParams,
  options?: { [key: string]: any },
) {
  return request<API.RAttrVO>('/product/attr/detail', {
    method: 'GET',
    params: {
      ...params,
    },
    ...(options || {}),
  });
}

/** 编辑属性 POST /product/attr/editor */
export async function editor(
  body: API.AttrVO,
  options?: { [key: string]: any },
) {
  return request<API.Rlong>('/product/attr/editor', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}

/** 分页搜索获取所有属性 POST /product/attr/page/search */
export async function searchWithPage(
  body: API.AttrSearch,
  options?: { [key: string]: any },
) {
  return request<API.RPageAttrVO>('/product/attr/page/search', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}

/** 转换当前属性的开启状态 POST /product/attr/switch/${param0} */
export async function switchTarget(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: API.switchTargetParams,
  options?: { [key: string]: any },
) {
  const { target: param0, ...queryParams } = params;
  return request<API.Rboolean>(`/product/attr/switch/${param0}`, {
    method: 'POST',
    params: {
      ...queryParams,
    },
    ...(options || {}),
  });
}
