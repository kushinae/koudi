import { Card, Col, Row, Space, Steps } from 'antd';
import React, { useEffect, useState } from 'react';
import EditorSpu from './EditorSpu';

/**
 * 编辑商品
 * @author bnyte
 * @since 1.0.0
 */
const Editor: React.FC = ({
}) => {

  const [ current, setCurrent ] = useState<number>(0);

  const items = [
    {
      title: '编辑商品基本信息',
    },
    {
      title: '编辑商品销售单元',
    },
    {
      title: '编辑商品详细信息',
    },
  ]

  const forms = [

    <EditorSpu 
      first={current === 0} 
      last={current === items.length - 1} 
      onPre={() => {setCurrent(current - 1)}}  
      onNext={() => {setCurrent(current + 1)}} />,
    <EditorSpu 
      first={current === 0} 
      last={current === items.length - 1} 
      onPre={() => {setCurrent(current - 1)}}  
      onNext={() => {setCurrent(current + 1)}} />,
    <EditorSpu 
      first={current === 0} 
      last={current === items.length - 1} 
      onPre={() => {setCurrent(current - 1)}} 
      onNext={() => {setCurrent(current + 1)}} />,
  ]

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
      <Space direction="vertical" size="middle" style={{ display: 'flex' }}>
        
        <Card>
          <Steps current={current} items={items} />
        </Card>


        <Row>
          <Col span={18}>
            <Card>{forms[current]}</Card>
          </Col>
          <Col>
            <Card>预览</Card>
          </Col>
        </Row>
      </Space>
    </>
  )
}
export default Editor;