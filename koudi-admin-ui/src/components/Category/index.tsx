import React, { useEffect, useState } from 'react';
import { Tree, Menu, Dropdown, message } from 'antd';
import EditorForm from '@/components/Category/EditorForm';
import { editor, remove, tree } from '@/services/product/category/api';

interface CategoryPops {
  draggable: boolean;
  fieldNames: { title: string, key: string, children: string };
}

const defaultParentCategory: APIResponse.Category = {
  id: -1,
  name: '根目录',
  parentId: -1,
  level: 1,
  show: true,
  sort: 0,
  icon: undefined,
  productUnit: undefined,
  productCount: undefined,
  createTime: undefined,
  modifiedTime: undefined,
  createAdminName: undefined,
  modifiedAdminName: undefined,
  deleted: undefined,
  children: undefined,
  disabled: undefined,
}

/**
 * Category
 * @author bnyte
 * @since 1.0.0
 */
const Category: React.FC<CategoryPops> = ({
  draggable,
  fieldNames
}) => {

  const [rightClickNode, setRightClickNode] = useState<APIResponse.Category | undefined>(defaultParentCategory);
  const [openEditorForm, setOpenEditorForm] = useState<boolean>(false);
  const [disableTreeData, setDisableTreeData] = useState<APIResponse.Category[]>([]);
  const [trees, setTrees] = useState<APIResponse.Category[] | undefined>();

  /**
   * 处理编辑分类成功
   * @param values 请求的分类实体参数
   */
  const handlerEditorSuccess = (values: APIResponse.Category) => {
    editor(values);
    setOpenEditorForm(false);
    setRightClickNode(undefined);
    tree(false).then(response => {
      setTrees(response.data);
    });
  }

  const handlerTreeRightClick = (event: any) => {
    setRightClickNode(event.node);
  }

  /**
   * 钩子函数
   */
  useEffect(() => {
    // 创建之前等
    tree(false).then(response => {
      setTrees(response.data);
    });
    return () => {
      // return出来的函数本来就是更新前，销毁前执行的函数，现在不监听任何状态，所以只在销毁前执行
    };
  }, [rightClickNode]);
  return (
    <>
      <Dropdown
        trigger={['contextMenu']}
        overlay={
          (<Menu
            items={[
              {
                label: '编辑',
                key: 'editor',
                onClick: (() => {
                  tree(true).then(response => {
                    setDisableTreeData(response.data)
                  });
                  setOpenEditorForm(true);
                })
              },
              {
                label: '删除',
                key: 'deleted',
                onClick: (() => {
                  if (rightClickNode?.id) {
                    remove(rightClickNode?.id).then(() => {
                      tree(false).then((response) => {
                        setTrees(response.data);
                      });
                    });
                  }
                })
              },
              {
                label: '新增子节点',
                key: 'added_sub_node',
                onClick: (() => {
                  // 创建之前等
                  tree(true).then(response => {
                    setDisableTreeData(response.data)
                  });
                  setRightClickNode(undefined);
                  if (rightClickNode?.level && rightClickNode?.level < 3)
                    setOpenEditorForm(true);
                  else
                    message.warning('当前节点属于三级分类不可再创建子分类')
                })
              },
            ]}
          />)
        }
      >
        <Tree
          draggable={draggable}
          // onTreeExpand={handlerTreeExpand}
          blockNode
          showLine
          treeData={trees}
          fieldNames={fieldNames}
          onRightClick={handlerTreeRightClick}
        />
      </Dropdown>

      {/* 编辑分类列表 */}
      <EditorForm
        open={openEditorForm}
        data={rightClickNode}
        tree={disableTreeData}
        onSuccess={handlerEditorSuccess}
        onCancel={() => {
          setOpenEditorForm(false);
          setRightClickNode(rightClickNode);
        }} />
    </>
  )
}
export default Category;