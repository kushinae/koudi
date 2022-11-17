import { PlusOutlined } from '@ant-design/icons';
import type { ProColumns } from '@ant-design/pro-components';
import { ProTable } from '@ant-design/pro-components';
import { Button, Switch } from 'antd';
import React, { useEffect } from 'react';

/**
 * 属性列表
 * @author bnyte
 * @since 1.0.0
 */
const List: React.FC = () => {

  const columns: ProColumns<APIResponse.Attr>[] = [
    {
      title: '属性名',
      dataIndex: 'name',
      key: 'name',
    },
    {
      title: '检索',
      key: 'enableSearch',
      render: (_, item) => (
        <Switch checked={item.enableSearch} />
      ),
    },
    {
      title: '多选值',
      key: 'multiple',
      render: (_, item) => (
        <Switch checked={item.multiple} />
      ),
    },
    {
      title: '属性图标',
      dataIndex: 'icon',
      key: 'icon',
    },
    {
      title: '可选值',
      dataIndex: 'multipleValue',
      key: 'multipleValue',
    },
    {
      title: '属性类型',
      dataIndex: 'type',
      key: 'type',
    },
    {
      title: '快速展示',
      render: (_, item) => (
        <Switch checked={item.quickShow} />
      ),
      key: 'quickShow',
    },
    {
      title: '所属分类',
      dataIndex: 'categoryName',
      key: 'categoryName',
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
      <ProTable<APIResponse.Attr>
        toolBarRender={() => [
          <Button key="created" icon={<PlusOutlined />} type="primary">
            新建
          </Button>
        ]}
        columns={columns} />
    </>
  )
}
export default List;