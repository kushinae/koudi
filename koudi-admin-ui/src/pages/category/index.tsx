import React, { useState, useEffect } from 'react';
import Category from '@/components/Category';
import { tree } from '@/services/product/category/api';

/**
 * 分类页面
 * @author bnyte
 * @since 1.0.0
 */
const CategoryPage: React.FC = () => {

  const [categoryTree, setCategoryTree] = useState<APIResponse.Category[]>();

  /**
   * 钩子函数
   */
  useEffect(() => {

    // 创建之前等
    tree().then(response => {
      setCategoryTree(response.data)
    })
    return () => {
      // return出来的函数本来就是更新前，销毁前执行的函数，现在不监听任何状态，所以只在销毁前执行
    };
  }, []);
  return (
    <>
      <Category treeData={categoryTree} draggable={true} fieldNames={{ title: "name", key: "id", children: "children" }} />
    </>
  )
}
export default CategoryPage;
