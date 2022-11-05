import React, { useEffect } from 'react';
import Category from '@/components/Category';
import { PageContainer } from '@ant-design/pro-layout';

/**
 * 分类页面
 * @author bnyte
 * @since 1.0.0
 */
const CategoryPage: React.FC = () => {

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
        <Category overlay={true} draggable={false} fieldNames={{ title: "name", key: "id", children: "children" }} />
      </PageContainer>
    </>
  )
}
export default CategoryPage;
