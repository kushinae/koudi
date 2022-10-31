import React, { useEffect } from 'react';
import { Tree, Menu, Dropdown } from 'antd';

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
      <Dropdown
        trigger={['contextMenu']}
        overlay={
          (<Menu
            items={[
              {
                label: '1st menu item',
                key: '1',
              },
              {
                label: '2nd menu item',
                key: '2',
              },
              {
                label: '3rd menu item',
                key: '3',
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
        />
      </Dropdown>

    </>
  )
}
export default Category;