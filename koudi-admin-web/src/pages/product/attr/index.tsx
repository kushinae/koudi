import { Attr } from '@/interface/entity/attr';
import { ESwitchTarget } from '@/interface/type/product/enums';
import { deleteById, switchTarget, searchWithPage } from '@/services/product/ServerAttrController';
import { QuestionCircleOutlined } from '@ant-design/icons';
import { ActionType, PageContainer, ProColumns, ProTable } from '@ant-design/pro-components';
import { Popconfirm, Switch, Tag, Tooltip, Button } from 'antd';
import { uniqueId } from 'lodash';
import React, { useEffect, useRef } from 'react';
import Editor from './Editor';

/**
 * 属性管理 包含平台属性和销售属性
 * @author bnyte
 * @since 1.0.0
 */
const Index: React.FC = () => {

  const tableAction = useRef<ActionType>();

  const columns: ProColumns<Attr>[] = [
    {
      title: '属性名',
      dataIndex: 'name',
      key: 'name',
    },
    {
      title: (
        <>
          开启搜索
          <Tooltip title='开启之后在首页搜索时会将改属性构建到搜索条件中'>
            <QuestionCircleOutlined />
          </Tooltip>
        </>
      ),
      valueType: 'switch',
      key: 'enableSearch',
      render: (_, item) => (
        <Switch onClick={async () => {
          if (item?.id) {
            const { success } = await switchTarget({ target: ESwitchTarget.SEARCH, id: item.id });
            if (success) {
              tableAction.current?.reload();
            }
          }
        }} checked={item.enableSearch} />
      ),
    },
    {
      title: (
        <>
          多选值
          <Tooltip title='开启之后该属性可以同时引用多个值(注意区分和配置多个值不同)'>
            <QuestionCircleOutlined />
          </Tooltip>
        </>
      ),
      valueType: 'switch',
      key: 'multiple',
      render: (_, item) => (
        <Switch onClick={async () => {
          if (item?.id) {
            const { success } = await switchTarget({ target: ESwitchTarget.MYLTIPLE, id: item?.id });
            if (success) {
              tableAction.current?.reload();
            }
          }
        }} checked={item.multiple} />
      ),
    },
    {
      title: '属性图标',
      dataIndex: 'icon',
      key: 'icon',
      search: false,
      hideInSearch: true
    },
    {
      dataIndex: 'multipleValue',
      title: (
        <>
          多选值
          <Tooltip title='当前属性对应可配置的值列表'>
            <QuestionCircleOutlined />
          </Tooltip>
        </>
      ),
      render: (_, item) => (
        <>
          {item.multipleValue.map((e) => {
            return (<Tag key={uniqueId()}>{e}</Tag>)
          })}
        </>
      ),
      key: 'multipleValue',
    },
    {
      title: '属性类型',
      dataIndex: 'type',
      key: 'type',
      onFilter: true,
      filters: true,
      valueType: 'select',
      valueEnum: {
        0: {
          text: '销售属性'
        },
        1: {
          text: '基础属性'
        },
        2: {
          text: '全部应用'
        },
      }
    },
    {
      title: (
        <>
          快速展示
          <Tooltip title='开启之后该属性直接展示在商品概括中'>
            <QuestionCircleOutlined />
          </Tooltip>
        </>
      ),
      render: (_, item) => (
        <Switch onClick={async () => {
          if (item?.id) {
            const { success } = await switchTarget({ target: ESwitchTarget.SHOW, id: item.id });
            if (success) {
              tableAction.current?.reload();
            }
          }
        }} checked={item.quickShow} />
      ),
      key: 'quickShow',
    },
    {
      title: '所属分类',
      dataIndex: 'categoryName',
      key: 'categoryName',
    },
    {
      title: '所属分组',
      dataIndex: 'groupName',
      key: 'groupName',
    },
    {
      title: '操作',
      render: (_, item) => (
        <>
          <Editor id={item.id} trigger={<Button>编辑</Button>}
            onSuccess={() => {
              if (tableAction.current) {
                tableAction.current.reload();
              }
            }} key='editor' title='编辑属性' />
          <Popconfirm
            onConfirm={async () => {
              if (item.id) {
                const { success } = await deleteById({ id: item.id });
                if (success) {
                  tableAction.current?.reload();
                }
              }
            }}
            title="你确定删除该属性吗?"
            okText="确定"
            cancelText="取消">
            <Button danger type='link'>删除</Button>
          </Popconfirm>
        </>
      ),
      key: 'operate',
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
        <ProTable<Attr>
          rowKey='id'
          toolBarRender={() => {
            return [
              <Editor trigger={<Button type='primary'>新增</Button>}
                onSuccess={() => {
                  if (tableAction.current) {
                    tableAction.current.reload();
                  }
                }} key='created' title='新增属性' />
            ]
          }}
          actionRef={tableAction}
          request={async (params, sort, filter) => {
            const { success, records, total, current, pageSize } = await searchWithPage({
              ...params,
              ...filter,
              key: params.name,
              pageSize: 5
            });
            return {
              ...params,
              data: records,
              success,
              total,
              current,
              pageSize,
            }
          }}
          columns={columns} />
      </PageContainer>
    </>
  )
}
export default Index;