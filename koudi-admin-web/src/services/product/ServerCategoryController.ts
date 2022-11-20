// @ts-ignore
/* eslint-disable */
import { Category } from '@/interface/entity/category';
import { CategorySearch } from '@/interface/param/Search';
import { request } from 'umi';
import { Page, Response } from '@/interface/base';

/** 编辑三级分类 POST /product/category/editor */
export async function editor(
  body?: Category,
) {
  return request<Response<number>>('/product/category/editor', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: {
      ...body
    },
  });
}

/** 获取当前分类等级层级 GET /product/category/level/hierarchy */
export async function levelHierarchy(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: API.levelHierarchyParams,
  options?: { [key: string]: any },
) {
  return request<API.RListCategoryduixiang>(
    '/product/category/level/hierarchy',
    {
      method: 'GET',
      params: {
        ...params,
      },
      ...(options || {}),
    },
  );
}

/** 删除分类 DELETE /product/category/remove */
export async function removeNode(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  options?: { node_id?: string | number },
) {
  return request<Response<void>>('/product/category/remove', {
    method: 'DELETE',
    params: {
      ...options,
    }
  });
}

/** 获取树装分类列表 GET /product/category/tree */
export async function treeWithPage(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  options?: CategorySearch,
) {
  return request<Page<Category>>('/product/category/tree_page', {
    method: 'POST',
    data: {
      ...options,
    },
  });
}

/** 获取树装分类列表 GET /product/category/tree */
export async function tree(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  options?: {skip_lowest_level: boolean, skip_root: boolean},
) {
  return request<Response<Category[]>>('/product/category/tree', {
    method: 'GET',
    params: {
      ...options
    }
  });
}

/** 获取树装分类列表并且指定品牌id绑定信息 GET /product/category/tree_with_brand */
export async function treeWithBrand(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: API.treeWithBrandParams,
  options?: { [key: string]: any },
) {
  return request<API.Rfenleihepinpaibangdingxiangqing>(
    '/product/category/tree_with_brand',
    {
      method: 'GET',
      params: {
        ...params,
      },
      ...(options || {}),
    },
  );
}

/** 获取分类详情 GET /product/category/detail */
export async function detail(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  options: {id: number | string},
) {
  return request<Response<Category>>('/product/category/detail', {
    method: 'GET',
    params: {
      ...options,
    },
  });
}
