import { Brand } from '@/interface/entity/brand';
import { BrandSearch } from '@/interface/param/Search';
import { listWithPage, removeById } from '@/services/product/ServerBrandController';
import {
  ActionType,
  PageContainer,
  ProColumns,
  ProTable,
} from '@ant-design/pro-components';
import { Button, Popconfirm, Switch, Image } from 'antd';
import React, { useEffect, useRef } from 'react';
import Editor from './Editor';

/**
 * 品牌页面
 * @author bnyte
 * @since 1.0.0
 */
const List: React.FC = () => {

  const tableRef = useRef<ActionType>();

  const columns: ProColumns<Brand>[] = [
    {
      title: 'logo',
      render: (_, item: Brand) => {
        return (
          <>
            <Image width='64px' src={item.logo} />
          </>
        );
      },
      key: 'logo',
    },
    {
      title: '名称',
      dataIndex: 'name',
      key: 'name',
    },
    {
      title: '显示状态',
      render: (_, item: Brand) => {
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
      title: '介绍',
      dataIndex: 'description',
      key: 'description',
    },
    {
      title: '检索首字母',
      dataIndex: 'firstLetter',
      key: 'firstLetter',
    },
    {
      title: '操作',
      render: (_, item: Brand) => {
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
            <Popconfirm title='你真的要删除此品牌吗?' okText='确认' cancelText='取消' onConfirm={async () => {
              const {success} = await removeById({id: item.id});
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
        <br />
        <ProTable<Brand>
          request={async (payload: BrandSearch) => {
            const { records, success, pageSize, current, total } = await listWithPage({
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
              title='编辑品牌' 
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
