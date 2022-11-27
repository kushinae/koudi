import { Spu } from '@/interface/entity/commodity';
import { searchWithPage } from '@/services/product/SpuController';
import { ActionType, PageContainer, ProColumns, ProTable } from '@ant-design/pro-components';
import { Button } from 'antd';
import React, { useEffect, useRef } from 'react';
import { SpuSearch } from '../../../interface/param/Search';

/**
 * 商品管理首页
 * @author bnyte
 * @since 1.0.0
 */
const Index: React.FC = () => {

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
      title: '成长值',
      dataIndex: 'growth',
      key: 'growth',
    },
    {
      title: '积分',
      dataIndex: 'integral',
      key: 'integral',
    },
    {
      title: '状态',
      dataIndex: 'status',
      key: 'status',
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
          toolBarRender={() => {
            return [
              <Button type='primary'>新增商品</Button>
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