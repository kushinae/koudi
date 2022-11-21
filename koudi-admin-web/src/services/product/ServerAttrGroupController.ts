// @ts-ignore
/* eslint-disable */
import { Page, Response } from '@/interface/base';
import { AttrGroup } from '@/interface/entity/attr';
import { Category } from '@/interface/entity/category';
import { AttrGroupSearch } from '@/interface/param/Search';
import { request } from 'umi';

/** 通过属性分组id获取详情 GET /product/attr/group/category/detail */
export async function detailWithCategory(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params:{id?: number | string},
) {
  return request<Response<Category>>('/product/attr/group/category/detail', {
    method: 'GET',
    params: {
      ...params,
    },
  });
}

/** 属性组详情 GET /product/attr/group/detail */
export async function detail(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: {id?: string | number},
) {
  return request<Response<AttrGroup>>('/product/attr/group/detail', {
    method: 'GET',
    params: {
      ...params,
    },
  });
}

/** 编辑属性组 POST /product/attr/group/editor */
export async function editor(
  body?: AttrGroup,
) {
  return request<Response<number>>('/product/attr/group/editor', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: {
      ...body
    },
  });
}

/** 分页搜索获取属性列表 POST /product/attr/group/list */
export async function listWithPage(
  body?: AttrGroupSearch,
) {
  return request<Page<AttrGroup>>('/product/attr/group/list', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: {
      body
    },
  });
}

/** 删除属性组 DELETE /product/attr/group/remove */
export async function removeById(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params?: {id?: number | string},
) {
  return request<Response<boolean>>('/product/attr/group/remove', {
    method: 'DELETE',
    params: {
      ...params,
    },
  });
}

/** 搜索获取属性列表 POST /product/attr/group/search */
export async function listWithSearch(
  body?: AttrGroupSearch,
) {
  return request<Response<AttrGroup[]>>('/product/attr/group/search', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: {
      ...body
    },
  });
}
