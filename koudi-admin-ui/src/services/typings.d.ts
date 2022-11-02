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
    icon: string | undefined;
    productUnit: string | undefined;
    productCount: number | undefined;
    createTime: string | undefined;
    modifiedTime: string | undefined;
    createAdminName: string | undefined;
    modifiedAdminName: string | undefined;
    deleted: boolean | undefined;
    children: APIResponse.Category[] | undefined;
    disabled: boolean | false | undefined;
  }


}