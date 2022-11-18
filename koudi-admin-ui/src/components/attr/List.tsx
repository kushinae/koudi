import type { Attr } from '@/interface/type/Type';
import { deleteById, searchWithPage, switchByTarget } from '@/services/product/attr/attr';
import type { ActionType, ProColumns } from '@ant-design/pro-components';
import { ProTable } from '@ant-design/pro-components';
import { Button, Popconfirm, Switch, Tag, Tooltip } from 'antd';
import React, { useEffect, useRef, useState } from 'react';
import Editor from './Editor';
import type { AttrSearch } from '../../interface/param/Search';
import { uniqueId } from 'lodash';
import { PlusOutlined, QuestionCircleOutlined } from '@ant-design/icons';

/**
 * 属性列表
 * @author bnyte
 * @since 1.0.0
 */
const List: React.FC = () => {

  const tableAction = useRef<ActionType>();

  const [hiddonAttrGroup, setHiddonAttrGroup] = useState<boolean>(true);

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
        <Switch onClick={() => {
          if (item?.id) {
            switchByTarget("search", item?.id).then(response => {
              if (response.success) {
                tableAction.current?.reload();
              }
            });
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
        <Switch onClick={() => {
          if (item?.id) {
            switchByTarget("multiple", item?.id).then(response => {
              if (response.success) {
                tableAction.current?.reload();
              }
            });
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
        <Switch onClick={() => {
          if (item?.id) {
            switchByTarget("show", item?.id).then(response => {
              if (response.success) {
                tableAction.current?.reload();
              }
            });
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
          <Editor hiddonAttrGroup={hiddonAttrGroup} setHiddonAttrGroup={setHiddonAttrGroup} id={item.id} triggerElement={
            <a key="editor">
              编辑
            </a>
          } onSuccess={() => {
            if (tableAction.current) {
              tableAction.current.reload();
            }
          }} key='editor' />
          <Popconfirm
            onConfirm={() => {
              if (item.id) {
                deleteById(item.id).then(response => {
                  if (response.success) {
                    tableAction.current?.reload();
                  }
                });
              }
            }}
            title="你确定删除该属性吗?"
            okText="确定"
            cancelText="取消">
            <a href="#"> 删除</a>
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
      <ProTable<Attr, Attr>
        rowKey={(item) => {
          return item.id + ''
        }}
        actionRef={tableAction}
        request={async (params: Attr & AttrSearch, sort, filter) => {
          const { success, records, total, current } = await searchWithPage({
            ...params,
            ...filter,
            key: params.name,
            pageSize: 5
          });
          return {
            data: records,
            success: success,
            total: total,
            page: current,
          }
        }}
        toolBarRender={() => [
          <Editor hiddonAttrGroup={hiddonAttrGroup} setHiddonAttrGroup={setHiddonAttrGroup} triggerElement={
            <Button type='primary' icon={<PlusOutlined />}>新建</Button>
          } onSuccess={() => {
            if (tableAction.current) {
              tableAction.current.reload();
            }
          }} key='editor' />
        ]}
        columns={columns} />
    </>
  )
}
export default List;