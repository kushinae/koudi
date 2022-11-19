// @ts-ignore
/* eslint-disable */
import { request } from 'umi';

/** 获取品牌详情 GET /product/brand/detail */
export async function detail1(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: API.detail1Params,
  options?: { [key: string]: any },
) {
  return request<API.RBrandduixiang>('/product/brand/detail', {
    method: 'GET',
    params: {
      ...params,
    },
    ...(options || {}),
  });
}

/** 编辑品牌 POST /product/brand/editor */
export async function editor2(
  body: API.Brandduixiang0,
  options?: { [key: string]: any },
) {
  return request<API.Rlong>('/product/brand/editor', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}

/** 分页搜索获取品牌列表 POST /product/brand/list */
export async function listWithPage2(
  body: API.BrandSearch,
  options?: { [key: string]: any },
) {
  return request<API.RPageBrandduixiang>('/product/brand/list', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}

/** 关联分类 PUT /product/brand/relation/category */
export async function relationCategory(
  body: API.pinpaibangdingfenleiqingqiucanshu,
  options?: { [key: string]: any },
) {
  return request<API.Rboolean>('/product/brand/relation/category', {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}

/** 通过id删除品牌 DELETE /product/brand/remove */
export async function removeById1(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: API.removeById1Params,
  options?: { [key: string]: any },
) {
  return request<API.Rboolean>('/product/brand/remove', {
    method: 'DELETE',
    params: {
      ...params,
    },
    ...(options || {}),
  });
}
