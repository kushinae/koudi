// @ts-ignore
/* eslint-disable */
import { Page, Response } from '@/interface/base';
import { Attr } from '@/interface/entity/attr';
import { AttrSearch } from '@/interface/param/Search';
import { ESwitchTarget } from '@/interface/type/product/enums';
import { request } from 'umi';

/** 删除属性 DELETE /product/attr/delete */
export async function deleteById(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: {id?: number | string},
) {
  return request<API.Rboolean>('/product/attr/delete', {
    method: 'DELETE',
    params: {
      ...params,
    },
  });
}

/** 获取属性详情 GET /product/attr/detail */
export async function detail(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: {id: number | string},
) {
  return request<Response<Attr>>('/product/attr/detail', {
    method: 'GET',
    params: {
      ...params,
    },
  });
}

/** 编辑属性 POST /product/attr/editor */
export async function editor(
  body: Attr,
) {
  return request<Response<number>>('/product/attr/editor', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: {
      ...body
    },
  });
}

/** 分页搜索获取所有属性 POST /product/attr/page/search */
export async function searchWithPage(
  body: AttrSearch,
) {
  return request<Page<Attr>>('/product/attr/page/search', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: {
      ...body
    },
  });
}

/** 转换当前属性的开启状态 POST /product/attr/switch/${param0} */
export async function switchTarget(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: {
    target: ESwitchTarget,
    id?: number | string,
  }
) {
  const { target: target, ...queryParams } = params;
  return request<Response<boolean>>(`/product/attr/switch/${target}`, {
    method: 'POST',
    params: {
      ...queryParams,
    }
  });
}
