import { PageContainer } from '@ant-design/pro-components';
import { useParams } from '@umijs/max';
import { Card, Col, Row, Space, Steps } from 'antd';
import React, { useEffect, useState } from 'react';
import EditorSpu from './EditorSpu';
import EditorSaleInfo from "@/pages/product/commodity/EditorSaleInfo";
import {Spu} from "@/interface/entity/commodity";

/**
 * 编辑商品
 * @author bnyte
 * @since 1.0.0
 */
const Editor: React.FC = ({
}) => {

  const params = useParams();
  const [ current, setCurrent ] = useState<number>(0);
  const [spuInfo, setSpuInfo] = useState<Spu>({
    id: params?.id
  });

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
      id={spuInfo.id}
      spuId={spuInfo.id}
      first={current === 0} 
      last={current === items.length - 1}
      spuInfo={spuInfo}
      onPre={() => {setCurrent(current - 1)}}  
      onNext={(payload) => {
        setSpuInfo(payload);
        setCurrent(current + 1)
      }} />,

    <EditorSaleInfo
      spuId={spuInfo.id}
      first={current === 0}
      spuInfo={spuInfo}
      last={current === items.length - 1}
      onPre={() => {setCurrent(current - 1)}}
      onNext={(payload) => {
        console.log('当前id', payload.id);
        setCurrent(current + 1)
      }} />,

    <EditorSpu
      id={spuInfo.id}
      spuInfo={spuInfo}
      first={current === 0}
      last={current === items.length - 1}
      onPre={() => {setCurrent(current - 1)}}
      onNext={(payload) => {
        console.log('当前id', payload.id);
        setCurrent(current + 1)
      }} />,

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
      <PageContainer title='发布商品'>
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
      </PageContainer>
    </>
  )
}
export default Editor;