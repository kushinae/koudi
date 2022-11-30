import { Spu } from '@/interface/entity/commodity';
import { searchWithPage } from '@/services/product/SpuController';
import { ActionType, PageContainer, ProColumns, ProTable } from '@ant-design/pro-components';
import { Button, theme } from 'antd';
import React, { useEffect, useRef } from 'react';
import { SpuSearch } from '@/interface/param/Search';
import { history } from '@umijs/max';

const { useToken } = theme;

/**
 * 商品管理首页
 * @author bnyte
 * @since 1.0.0
 */
const Index: React.FC = () => {

  const { token } = useToken();

  const tableRef = useRef<ActionType>();

  const columns: ProColumns<Spu>[] = [
    {
      title: '名称',
      dataIndex: 'name',
      key: 'name',
    },
    {
      title: '标题',
      dataIndex: 'title',
      key: 'title',
    },
    {
      title: '副标题',
      dataIndex: 'subTitle',
      key: 'subTitle',
    },
    {
      title: '状态',
      dataIndex: 'status',
      key: 'status',
      valueEnum: {
        0: {text: '库存中', status: 'Default'},
        1: {text: '提交审核', status: 'Processing'},
        2: {text: '审核中', status: 'Processing'},
        3: {text: '审核拒绝', status: 'Error'},
        4: {text: '审核通过', status: 'Success'},
        5: {text: '发布中', status: 'Success'},
      }
    },
    {
      title: '分类',
      dataIndex: 'categoryName',
      key: 'categoryName',
    },
    {
      title: '品牌',
      dataIndex: 'brandName',
      key: 'brandName',
    },
    {
      title: '操作',
      render: (_, item) => {
        return [
          <Button key='editor' onClick={() => {
            history.push(`/product/commodity/publish/${item?.id}`);
          }} type='link'>编辑</Button>,
          <Button key='publish' style={{color: token.colorPrimary}} type='link'>发布</Button>,
          <Button key='delete' danger type='link'>删除</Button>,
        ];
      },
      key: 'operate',

    },
  ]

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
        <ProTable<Spu>
          request={async (search: SpuSearch) => {
            const { records, success, pageSize, current, total } = await searchWithPage({ ...search });
            return {
              ...search,
              data: records,
              success,
              total,
              current,
              pageSize: pageSize,
            };
          }}
          rowKey='id'
          toolBarRender={() => {
            return [
              <Button type='primary' onClick={() => {
                history.push(`/product/commodity/publish`);
              }}>新增商品</Button>
            ]
          }}
          pagination={{
            pageSize: 5,
          }}
          actionRef={tableRef}
          columns={columns} />
      </PageContainer>
    </>
  )
}
export default Index;