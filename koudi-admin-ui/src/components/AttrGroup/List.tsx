import { listWithPage } from '@/services/product/attrGroup/api';
import { PlusOutlined } from '@ant-design/icons';
import { ProTable } from '@ant-design/pro-table';
import { Button } from 'antd';
import React, { useEffect, useState } from 'react';
import type { AttrGroupSearch } from '../../interface/param/Search';
import Editor from '@/components/AttrGroup/Editor';

interface AttrGroupListProps {
  selectCategory?: APIResponse.Category;
}

/**
 * List 销售属性列表
 * @author bnyte
 * @since 1.0.0
 */
const List: React.FC<AttrGroupListProps> = ({
  selectCategory
}) => {

  const [dataSource, setDataSource] = useState<APIResponse.AttrGroup[]>();
  const [search, setSearch] = useState<AttrGroupSearch>({
    current: 1,
    queryCount: 20,
    key: undefined,
    categoryId: selectCategory?.id,
  });
  const [openEditor, setOpenEditor] = useState<boolean>(false);

  const onSuccessEditor = (payload: APIResponse.AttrGroup) => {
    console.log('payload', payload);
    setOpenEditor(false);

  }

  const onCancelEditor = () => {
    setOpenEditor(false);
  }

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
    listWithPage(search).then(response => {
      setDataSource(response.records);
    });
    return () => {
      // return出来的函数本来就是更新前，销毁前执行的函数，现在不监听任何状态，所以只在销毁前执行
    };
  }, [search]);
  return (
    <>
      <ProTable
        request={async (
          // 第一个参数 params 查询表单和 params 参数的结合
          // 第一个参数中一定会有 pageSize 和  current ，这两个参数是 antd 的规范
          params: APIResponse.AttrGroup & {
            pageSize: number;
            current: number;
          },
          // sort,
          // filter,
        ) => {
          setSearch({
            current: params.current,
            queryCount: params.pageSize,
            key: params?.name,
            categoryId: selectCategory?.id
          })
          const response = await listWithPage(search);
          return {
            data: response.records,
            success: response.status,
            total: response.total,
          }
        }}
        toolBarRender={() => [
          <Button key="button" onClick={() => { setOpenEditor(true) }} icon={<PlusOutlined />} type="primary">
            添加
          </Button>,
        ]}
        dataSource={dataSource}
        columns={columns} />

      <Editor onSuccess={(payload: APIResponse.AttrGroup) => onSuccessEditor(payload)} onCancel={onCancelEditor} open={openEditor} />
    </>
  )
}
export default List;