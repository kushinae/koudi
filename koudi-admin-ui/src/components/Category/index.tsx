import React, { useEffect, useState } from 'react';
import { Tree, Menu, Dropdown } from 'antd';
import EditorForm from '@/components/Category/EditorForm';

interface CategoryPops {
  treeData: APIResponse.Category[] | undefined;
  draggable: boolean;
  fieldNames: { title: string, key: string, children: string };
}

/**
 * Category
 * @author bnyte
 * @since 1.0.0
 */
const Category: React.FC<CategoryPops> = ({
  treeData,
  draggable,
  fieldNames
}) => {

  const [rightClickNode, setRightClickNode] = useState<APIResponse.Category>();
  const [openEditorForm, setOpenEditorForm] = useState<boolean>(false);


  const handlerTreeRightClick = (event: any) => {
    setRightClickNode(event.node);
  }

  const handlerEditorSuccess = (values: APIResponse.Category) => {
    console.log(values, "values");
  }

  /**
   * 钩子函数
   */
  useEffect(() => {
    // 创建之前等
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
                  setOpenEditorForm(true);
                })
              },
              {
                label: '删除',
                key: 'deleted',
              },
              {
                label: '新增子节点',
                key: 'added_sub_node',
                onClick: (() => {
                  setRightClickNode(undefined);
                  setOpenEditorForm(true);
                })
              },
            ]}
          />)
        }
      >
        <Tree
          className="draggable-tree"
          draggable={draggable}
          blockNode
          treeData={treeData}
          fieldNames={fieldNames}
          onRightClick={handlerTreeRightClick}
        />
      </Dropdown>

      {/* 编辑分类列表 */}
      <EditorForm
        open={openEditorForm}
        data={rightClickNode}
        onSuccess={handlerEditorSuccess}
        onCancel={() => {
          setOpenEditorForm(false);
          setRightClickNode(undefined);
          console.log(rightClickNode);
        }} />
    </>
  )
}
export default Category;