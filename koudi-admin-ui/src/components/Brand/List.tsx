import React, { useCallback, useEffect, useState } from 'react';
import type { ColumnsType } from 'antd/lib/table';
import { Space, Table, Button, Switch } from 'antd';
import { detail, editor, listWithPage } from '@/services/product/brand/api';
import type { BrandSearch } from '@/interface/param/Search';
import Editor from '@/components/Brand/Editor';

interface DataType {
  // id
  id: number;
  // 品牌名
  name: string;
  // 品牌logo地址
  logo: string;
  // 介绍
  description: string;
  // 显示状态
  show: boolean;
  // 检索首字母
  firstLetter: string;
  // 排序数字越大排序越高
  sort: number;
  // 数据创建时间
  createTime: string | undefined;
  // 数据修改时间
  modifiedTime: string | undefined;
  // 数据创建用户名
  createAdminName: string | undefined;
  // 数据更新用户名
  modifiedAdminName: string | undefined;
  // 是否删除
  deleted: boolean | undefined;
}

/**
 * 品牌列表
 * @author bnyte
 * @since 1.0.0
 */
const List: React.FC = () => {

  const [tableLoading, setTableLoading] = useState<boolean>(true);
  const [brands, setBrands] = useState<APIResponse.Brand[]>();
  const [openEditor, setOpenEditor] = useState<boolean>(false);
  const [search, setSearch] = useState<BrandSearch>({
    current: 1,
    queryCount: 20,
    name: undefined,
  });

  const [tableTotal, setTableTotal] = useState<number>(0);
  const [editorData, setEditorData] = useState<APIResponse.Brand>();

  const columns: ColumnsType<DataType> = [
    {
      title: '名称',
      dataIndex: 'name',
      key: 'name',
    },
    {
      title: 'Logo',
      dataIndex: 'logo',
      key: 'logo1',
    },
    {
      title: '是否显示',
      key: 'show',
      render: (_, item) => (
        <Switch checked={item.show} />
      ),
    },
    {
      title: '描述',
      render: (_, item) => (
        <>{item.description ? item.description : '无'}</>
      ),
      key: 'description',
    },
    // 
    {
      title: '检索首字母',
      render: (_, item) => (
        <>{item.firstLetter ? item.firstLetter : '无'}</>
      ),
      key: 'firstLetter',
    },
    {
      title: '排序',
      dataIndex: 'sort',
      key: 'sort',
    },
    {
      title: '操作',
      key: 'action',
      render: (_, item) => (
        <Space size="middle">
          <Button type='primary' onClick={() => {
            detail(item.id).then(response => {
              setOpenEditor(true);
              setEditorData(response.data);
            });
          }} >编辑</Button>
          <Button danger type='primary'>删除</Button>
        </Space>
      ),
    },
  ];

  /**
   * 处理取消编辑表单方法
   */
  const onCancelEditor = () => {
    setEditorData(undefined);
    setOpenEditor(false);
  }

  /**
   * 刷新当前页面数据
   */
  const rerfrshBrands = useCallback(() => {
    listWithPage(search).then(response => {
      setBrands(response.records);
      setTableLoading(response.status);
      setSearch({
        current: response.current,
        queryCount: response.count
      });
      setTableTotal(response.total);
    });
  }, [search]);


  /**
   * 处理表单编辑成功
   */
  const onSuccessEditor = (payload: APIResponse.Brand) => {
    if (!payload.sort) {
      payload.sort = 0;
    }
    editor(payload).then(() => {
      rerfrshBrands();
      setOpenEditor(false);
    });
  }

  /**
   * 当分页切换时
   * @param current 当前页码
   * @param queryCount 查询记录数
   */
  const onPageChange = (current: number, queryCount: number) => {
    setSearch({
      current,
      queryCount,
    })
  }

  /**
   * 钩子函数
   */
  useEffect(() => {
    // 创建之前等
    // rerfrshBrands();
    listWithPage(search).then(response => {
      setBrands(response.records);
      setTableLoading(response.status);
    });
    return () => {
      // return出来的函数本来就是更新前，销毁前执行的函数，现在不监听任何状态，所以只在销毁前执行
    };
  }, [rerfrshBrands, search]);
  return (
    <>
      <Button onClick={() => setOpenEditor(true)} style={{ float: 'right', margin: '0 0 20px 0' }} type="primary">
        添加
      </Button>
      <Table
        columns={columns}
        loading={tableLoading}
        pagination={{
          position: ['bottomRight'],
          current: search.current,
          pageSize: search.queryCount,
          total: tableTotal,
          onChange: (current: number, queryCount: number) => onPageChange(current, queryCount)
        }}
        dataSource={brands}
      />

      <Editor
        onSuccess={onSuccessEditor}
        onCancel={onCancelEditor}
        open={openEditor}
        data={editorData}
      />

    </>
  )
}
export default List;