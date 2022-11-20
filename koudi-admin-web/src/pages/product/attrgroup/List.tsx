import { AttrGroup } from '@/interface/entity/attr';
import { AttrGroupSearch } from '@/interface/param/Search';
import { listWithPage, removeById } from '@/services/product/ServerAttrGroupController';
import { ActionType, PageContainer, ProColumns, ProTable } from '@ant-design/pro-components';
import { Button, Popconfirm } from 'antd';
import React, { useEffect, useRef } from 'react';
import Editor from './Editor';

/**
 * 属性页面
 * @author bnyte
 * @since 1.0.0
 */
const List: React.FC = () => {

  const tableRef = useRef<ActionType>();

  const columns: ProColumns<AttrGroup>[] = [
    {
      title: '名称',
      dataIndex: 'name',
      key: 'name',
    },
    {
      title: '排序',
      dataIndex: 'sort',
      key: 'sort',
    },
    {
      title: '描述',
      dataIndex: 'description',
      key: 'description',
      ellipsis: true,
    },
    {
      title: '组图标',
      dataIndex: 'icon',
      key: 'icon',
    },
    {
      title: '分类名称',
      dataIndex: 'categoryName',
      key: 'categoryName',
    },
    {
      title: '操作',
      key: 'operate',
      render: (_, item: AttrGroup) => {
        return (
          <>
            <Editor title='编辑属性分组' id={item.id} trigger={<Button>编辑</Button>} onSuccess={() => {
              tableRef.current?.reload();
            }} />
            &nbsp;
            <Popconfirm title='你确定删除吗?' okText='确认' cancelText='取消' onConfirm={async () => {
              const {success} = await removeById({id: item.id});
              if (success) {
                tableRef.current?.reload();
              }
              return success;
            }}>
              <Button danger>删除</Button>
            </Popconfirm>
          </>

        )
      }
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
        <ProTable<AttrGroup>
          request={async (payload: AttrGroupSearch) => {
            const { records, success, pageSize, current, total } = await listWithPage({
              ...payload
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
          actionRef={tableRef}
          pagination={{
            pageSize: 5,
          }}
          columns={columns}
          rowKey="id"
          toolBarRender={() => {
            return [
              <Editor title='编辑属性分组' trigger={<Button type='primary'>新增</Button>} onSuccess={() => {
                tableRef.current?.reload();
              }}/>
            ]
          }}
        />
      </PageContainer>
    </>
  )
}
export default List;