import { Category } from '@/interface/entity/category';
import { CategorySearch } from '@/interface/param/Search';
import { tree } from '@/services/product/ServerCategoryController';
import {
  PageContainer,
  ProColumns,
  ProTable,
} from '@ant-design/pro-components';
import { Alert, Button } from 'antd';
import React, { useEffect } from 'react';

/**
 * 分类页面
 * @author bnyte
 * @since 1.0.0
 */

const Index: React.FC = () => {
  const columns: ProColumns<Category>[] = [
    {
      title: '名称',
      dataIndex: 'name',
      key: 'name',
    },
    {
      title: '操作',
      render: (_, item: Category) => {
        return (
          <>
            <Button type="primary">编辑</Button>
            &nbsp;
            <Button
              disabled={item.level && item.level < 3 ? false : true}
              type="default"
            >
              添加下级
            </Button>
            &nbsp;
            <Button danger type="link">
              删除
            </Button>
          </>
        );
      },
      key: 'caozuo',
    },
  ];

  /**
   * 钩子函数
   */
  useEffect(() => {
    // 创建之前等
    return () => {
      // return出来的函数本来就是更新前，销毁前执行的函数，现在不监听任何状态，所以只在销毁前执行
    };
  }, []);
  return (
    <>
      <PageContainer>
        <Alert
          showIcon
          message="三级分类无法再继续创建下级分类"
          type="warning"
        />
        <br />
        <ProTable<Category>
          request={async (payload: CategorySearch) => {
            const { records, success, pageSize, current, total } = await tree({
              ...payload,
            });
            return {
              ...payload,
              data: records,
              success,
              total,
              current,
              pageSize: pageSize,
            };
          }}
          pagination={{
            pageSize: 5,
          }}
          columns={columns}
          rowKey="id"
        />
      </PageContainer>
    </>
  );
};
export default Index;
