import React, { useEffect, useState } from 'react';
import Category from '@/components/Category';
import { Row, Col, Alert } from 'antd';
import List from '@/components/AttrGroup/List';
import { PageContainer } from '@ant-design/pro-layout';
import type { AttrGroupSearch } from '@/interface/param/Search';

/**
 * AttrGroup属性组
 * @author bnyte
 * @since 1.0.0
 */
const AttrGroup: React.FC = () => {
  const [selectNode, setSelectNode] = useState<APIResponse.Category>();
  const [search, setSearch] = useState<AttrGroupSearch>({
    current: 1,
    queryCount: 5,
    key: undefined,
    categoryId: selectNode?.id,
  });

  const clearSelectNode = () => {
    setSelectNode(undefined);
  }

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
        <Alert
          message={'所有操作请基于三级分类操作！！！'}
          type="warning"
          showIcon
          banner
          style={{
            margin: -12,
            marginBottom: 24,
          }}
        />
        <Alert
          message={'请在查询或添加操作时先选择对应三级分类之后再点击[操作]按钮'}
          type="warning"
          showIcon
          banner
          style={{
            margin: -12,
            marginBottom: 24,
          }}
        />
        <Row gutter={16}>
          <Col span={4}>
            <Category onSelect={(value: APIResponse.Category) => {
              setSelectNode(value);
              setSearch({
                ...search,
                categoryId: selectNode?.id
              });
            }} overlay={false} draggable={false} fieldNames={{ title: "name", key: "id", children: "children" }} />
          </Col>
          <Col span={20}>
            <List onSearchChange={setSearch} clearSelectNode={clearSelectNode} search={search} selectCategory={selectNode} />
          </Col>
        </Row>
      </PageContainer>
    </>
  )
}
export default AttrGroup;