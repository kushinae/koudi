declare namespace APIResponse {

  type R<T> = {
    code: number;
    message: string;
    status: boolean;
    data: T;
  }

  type Category = {
    id: number;
    name: string;
    parentId: number;
    level: number;
    show: boolean;
    sort: number;
    icon: string;
    productUnit: string;
    productCount: number;
    createTime: string;
    modifiedTime: string;
    createAdminName: string;
    modifiedAdminName: string;
    deleted: boolean;
    children: APIResponse.Category[];
  }


}