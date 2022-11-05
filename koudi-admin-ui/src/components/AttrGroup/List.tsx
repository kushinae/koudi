import { ProTable } from '@ant-design/pro-table';
import { Button } from 'antd';
import React, { useEffect } from 'react';

/**
 * List 销售属性列表
 * @author bnyte
 * @since 1.0.0
 */
const List: React.FC = () => {

  const columns = [
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
      render: (_: any, item: APIResponse.AttrGroup) => {
        <>
          <Button onClick={() => {
            console.log('editor id', item.id);
          }}>编辑</Button>
          <Button danger>删除</Button>
        </>
      },
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
      <ProTable columns={columns} />
    </>
  )
}
export default List;