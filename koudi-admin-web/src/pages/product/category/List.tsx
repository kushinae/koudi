import { Category } from '@/interface/entity/category';
import { CategorySearch } from '@/interface/param/Search';
import { removeNode, treeWithPage } from '@/services/product/ServerCategoryController';
import {
  ActionType,
  PageContainer,
  ProColumns,
  ProTable,
} from '@ant-design/pro-components';
import { Alert, Button, notification, Popconfirm, Switch } from 'antd';
import React, { useEffect, useRef } from 'react';
import Editor from './Editor';

/**
 * 分类页面
 * @author bnyte
 * @since 1.0.0
 */

const List: React.FC = () => {

  const tableRef = useRef<ActionType>();

  const columns: ProColumns<Category>[] = [
    {
      title: '名称',
      dataIndex: 'name',
      key: 'name',
    },
    {
      title: '显示状态',
      render: (_, item: Category) => {
        return (
          <>
            <Switch checked={item.show} />
          </>
        );
      },
      key: 'show',
    },
    {
      title: '排序',
      dataIndex: 'sort',
      key: 'sort',
    },
    {
      title: 'icon',
      dataIndex: 'icon',
      key: 'icon',
    },
    {
      title: '计量单位',
      dataIndex: 'productUnit',
      key: 'productUnit',
    },
    {
      title: '商品数量',
      dataIndex: 'productCount',
      key: 'productCount',
    },
    {
      title: '操作',
      render: (_, item: Category) => {
        return (
          <>
            <Editor
              onSuccess={() => {
                tableRef.current?.reload();
              }}
              id={item.id}
              title='编辑分类' 
              trigger={<Button>编辑</Button>} />
            &nbsp;
            <Button
              disabled={item.level && item.level < 3 ? false : true}
              type="default"
              onClick={() => {
                notification.warning({
                  message: '当前功能暂未实现,可点击创建以新建分类'
                })
              }}
            >
              添加下级
            </Button>
            &nbsp;
            <Popconfirm title='你真的要删除此分类吗?' okText='确认' cancelText='取消' onConfirm={async () => {
              const {success} = await removeNode({node_id: item.id});
              if (success) {
                tableRef.current?.reload();
              }
              return success;
            }}>
              <Button danger type="link">
                删除
              </Button>
            </Popconfirm>
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
            const { records, success, pageSize, current, total } = await treeWithPage({
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
          toolBarRender={() => {
            return [
            <Editor
              onSuccess={() => {
                tableRef.current?.reload();
              }}
              title='编辑分类' 
              trigger={<Button type="primary">创建</Button>} />
            
          ]}}
          actionRef={tableRef}
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
export default List;
