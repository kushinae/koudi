// @ts-ignore
/* eslint-disable */
import { request } from 'umi';

/** 获取树状分类列表 GET /category/tree */
export async function tree() {
  return request('/category/tree', {
    method: 'GET',
  });
}
