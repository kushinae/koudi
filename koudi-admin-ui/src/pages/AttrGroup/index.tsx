import React, { useEffect } from 'react';
import Category from '@/components/Category';
import { Row, Col } from 'antd';
import List from '@/components/AttrGroup/List';
import { PageContainer } from '@ant-design/pro-layout';

/**
 * AttrGroup属性组
 * @author bnyte
 * @since 1.0.0
 */
const AttrGroup: React.FC = () => {
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
        <Row gutter={16}>
          <Col span={4}>
            <Category overlay={false} draggable={false} fieldNames={{ title: "name", key: "id", children: "children" }} />
          </Col>
          <Col span={20}>
            <List />
          </Col>
        </Row>
      </PageContainer>
    </>
  )
}
export default AttrGroup;