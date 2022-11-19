// @ts-ignore
/* eslint-disable */
import { Category } from '@/interface/entity/category';
import { CategorySearch } from '@/interface/param/Search';
import { request } from 'umi';
import { Page } from '../../interface/base';

/** 编辑三级分类 POST /product/category/editor */
export async function editor3(
  body: API.Categoryduixiang,
  options?: { [key: string]: any },
) {
  return request<API.Rlong>('/product/category/editor', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
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
  params: API.removeNodeParams,
  options?: { [key: string]: any },
) {
  return request<API.RVoid>('/product/category/remove', {
    method: 'DELETE',
    params: {
      ...params,
    },
    ...(options || {}),
  });
}

/** 获取树装分类列表 GET /product/category/tree */
export async function tree(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  options?: CategorySearch,
) {
  return request<Page<Category>>('/product/category/tree', {
    method: 'POST',
    data: {
      ...options,
    },
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
