import { detail, editor, listWithPage, remove } from '@/services/product/attrGroup/api';
import { PlusOutlined } from '@ant-design/icons';
import { ProTable } from '@ant-design/pro-table';
import { Button, Form, message, Popconfirm } from 'antd';
import React, { useEffect, useState } from 'react';
import Editor from '@/components/AttrGroup/Editor';
import type { AttrGroupSearch } from '@/interface/param/Search';

interface AttrGroupListProps {
  selectCategory?: APIResponse.Category;
  search: AttrGroupSearch;
  clearSelectNode: () => void;
  onSearchChange: (search: AttrGroupSearch) => void;
}

/**
 * List 销售属性列表
 * @author bnyte
 * @since 1.0.0
 */
const List: React.FC<AttrGroupListProps> = ({
  selectCategory, search, onSearchChange
}) => {

  /**
   * 列表表单数据
   */
  const [dataSource, setDataSource] = useState<APIResponse.AttrGroup[]>();

  /**
   * 是否打开编辑框
   */
  const [openEditor, setOpenEditor] = useState<boolean>(false);

  /**
   * 编辑框中的属性对象
   */
  const [editorForm] = Form.useForm();

  /**
   * 编辑之后点击完成处理函数
   * @param payload 编辑完成之后的参数收集
   */
  const onSuccessEditor = (payload: APIResponse.AttrGroup) => {
    let total = 0;
    editor(payload).then(response => {
      if (response.success) {
        listWithPage({
          current: search.current,
          queryCount: search.queryCount,
          key: search?.key,
          categoryId: search?.categoryId
        }).then(page => {
          if (page.success) {
            setDataSource(page.records);
            total = page.total;
          }
        });

        onSearchChange({
          ...search,
          total
        });
      }
    });
    setOpenEditor(false);
  }

  /**
   * 取消编辑
   */
  const onCancelEditor = () => {
    setOpenEditor(false);
    // clearSelectNode();
  }

  /**
   * 编辑属性组
   */
  const onEditorAttrGroup = (item: APIResponse.AttrGroup) => {
    setOpenEditor(true);
    if (item.id) {
      detail(item.id).then(response => {
        editorForm.setFieldsValue(response.data);
      });
    }
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
      render: (_: any, item: APIResponse.AttrGroup) => {
        return (<>
          <Button onClick={() => onEditorAttrGroup(item)}>编辑</Button>
          <Popconfirm
            okText="确认"
            cancelText="取消"
            onConfirm={() => {
              if (item?.id) {
                remove(item.id).then(response => {
                  if (response.success) {
                    listWithPage({
                      current: search.current,
                      queryCount: search.queryCount,
                      key: search?.key,
                      categoryId: search?.categoryId
                    }).then(page => {
                      if (page.success) {
                        setDataSource(page.records);
                      }
                    });
                  }
                });
              }
            }}
            title="你确定删除这个属性组吗?">
            <Button danger>删除</Button>
          </Popconfirm>
        </>)
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
      <ProTable
        pagination={{
          current: search.current,
          pageSize: search.queryCount,
          total: search.total,
          onChange: (page: number, pageSize: number) => {
            onSearchChange({
              current: page,
              queryCount: pageSize,
              categoryId: selectCategory?.id,
              key: search?.key
            });
          }
        }}
        rowKey={(item: APIResponse.AttrGroup) => item.id ? item.id : ''}
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
          const response = await listWithPage({
            current: params.current,
            queryCount: params.pageSize,
            key: params?.name,
            categoryId: selectCategory?.id
          });
          setDataSource(response.records);
          return {
            data: response.records,
            success: response.success,
            total: response.total,
          }
        }}
        toolBarRender={() => [
          <Button key="button" onClick={() => {
            if (!selectCategory) {
              message.warn('请在左侧选择分类');
              return;
            }
            editorForm.setFieldValue('categoryName', selectCategory?.name);
            editorForm.setFieldValue('categoryId', selectCategory?.id);
            editorForm.setFieldValue('sort', 0);
            setOpenEditor(true)
          }} icon={<PlusOutlined />} type="primary">
            添加
          </Button>,
        ]}
        dataSource={dataSource}
        columns={columns} />

      <Editor formInstance={editorForm} currentCategory={selectCategory} onSuccess={(payload: APIResponse.AttrGroup) => onSuccessEditor(payload)} onCancel={onCancelEditor} open={openEditor} />
    </>
  )
}
export default List;