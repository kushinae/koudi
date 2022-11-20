// @ts-ignore
/* eslint-disable */
import { Page, Response } from '@/interface/base';
import { Brand } from '@/interface/entity/brand';
import { BrandSearch } from '@/interface/param/Search';
import { request } from 'umi';

/** 获取品牌详情 GET /product/brand/detail */
export async function detail(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: {id: string | number},
) {
  return request<Response<Brand>>('/product/brand/detail', {
    method: 'GET',
    params: {
      ...params,
    },
  });
}

/** 编辑品牌 POST /product/brand/editor */
export async function editor(
  body?: Brand,
) {
  return request<API.Rlong>('/product/brand/editor', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: {
      ...body
    },
  });
}

/** 分页搜索获取品牌列表 POST /product/brand/list */
export async function listWithPage(
  body?: BrandSearch,
) {
  return request<Page<Brand>>('/product/brand/list', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: {
      ...body
    },
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
export async function removeById(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: {id?: string | number},
) {
  return request<API.Rboolean>('/product/brand/remove', {
    method: 'DELETE',
    params: {
      ...params,
    },
  });
}
