// @ts-ignore
/* eslint-disable */
import { request } from 'umi';

/** 通过属性分组id获取详情 GET /product/attr/group/category/detail */
export async function detailWithAttrGroup(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: API.detailWithAttrGroupParams,
  options?: { [key: string]: any },
) {
  return request<API.RCategoryduixiang>('/product/attr/group/category/detail', {
    method: 'GET',
    params: {
      ...params,
    },
    ...(options || {}),
  });
}

/** 属性组详情 GET /product/attr/group/detail */
export async function editor1(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: API.editor1Params,
  options?: { [key: string]: any },
) {
  return request<API.RAttrGroupduixiang>('/product/attr/group/detail', {
    method: 'GET',
    params: {
      ...params,
    },
    ...(options || {}),
  });
}

/** 编辑属性组 POST /product/attr/group/editor */
export async function listWithPage(
  body: API.AttrGroupduixiang0,
  options?: { [key: string]: any },
) {
  return request<API.Rlong>('/product/attr/group/editor', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}

/** 分页搜索获取属性列表 POST /product/attr/group/list */
export async function listWithPage1(
  body: API.AttrGroupSearch,
  options?: { [key: string]: any },
) {
  return request<API.RPageAttrGroupduixiang>('/product/attr/group/list', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}

/** 删除属性组 DELETE /product/attr/group/remove */
export async function removeById(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: API.removeByIdParams,
  options?: { [key: string]: any },
) {
  return request<API.Rboolean>('/product/attr/group/remove', {
    method: 'DELETE',
    params: {
      ...params,
    },
    ...(options || {}),
  });
}

/** 搜索获取属性列表 POST /product/attr/group/search */
export async function listWithSearch(
  body: API.AttrGroupSearch,
  options?: { [key: string]: any },
) {
  return request<API.RListAttrGroupduixiang>('/product/attr/group/search', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}
