// @ts-ignore
/* eslint-disable */
import { request } from 'umi';

/** 上传资源 POST /product/upload/sso */
export async function resource(body: string, options?: { [key: string]: any }) {
  return request<API.RUploadVO>('/product/upload/sso', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}
