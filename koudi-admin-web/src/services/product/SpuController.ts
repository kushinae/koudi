// @ts-ignore
/* eslint-disable */
import { Page, Response } from '@/interface/base';
import { Spu } from '@/interface/entity/commodity';
import { SpuSearch } from '@/interface/param/Search';
import { request } from 'umi';

/** 分页获取spu列表 POST /product/spu/search */
export async function searchWithPage(
  search?: SpuSearch,
) {
  return request<Page<Spu>>('/product/spu/search', {
    method: 'POST',
    data: {
      ...search,
    },
  });
}

/** 编辑spu POST /product/spu/editor */
export async function editor(
  payload?: Spu,
) {
  return request<Response<number>>('/product/spu/editor', {
    method: 'POST',
    data: {
      ...payload,
    },
  });
}

/** 获取spu详情 GET /product/spu/detail */
export async function detail(
  payload?: {id?: number | string},
) {
  return request<Response<Spu>>('/product/spu/detail', {
    method: 'GET',
    params: {
      ...payload,
    },
  });
}