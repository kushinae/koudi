import React, { useEffect, useState } from 'react';
import { ProCard, ProForm, ProFormText } from '@ant-design/pro-components';
import { spuSubmitterFormat } from '@/utils/spu';
import { EditorStepFormItemProps } from '@/interface/props/GalobalProps';
import { Button, Card, Select, SelectProps, Space } from 'antd';

const options: SelectProps['options'] = [];
for (let i = 10; i < 36; i++) {
  options.push({
    value: i.toString(36) + i,
    label: i.toString(36) + i,
  });
}

/**
 * 规格参数编辑
 * @author bnyte
 * @since 1.0.0
 */
const EditorSpecifications: React.FC<EditorStepFormItemProps> = ({
  id, onNext, onPre, last, first
}) => {

  const [attrGroups, setAttrGroups] = useState<string[]>([]);

  const handleChange = (value: string | string[]) => {
    console.log(`Selected: ${value}`);
    setAttrGroups(attrGroups.concat(value));
  };

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
      {/* <Space direction="vertical" size="large"> */}
      <Card>
        <Select
          mode="tags"
          size='middle'
          placeholder="Please select"
          onChange={handleChange}
          style={{ width: '100%' }}
          options={options}
        />
      </Card>
      <Card>
        <ProForm
          submitter={{
            render: (props) => {
              return spuSubmitterFormat(first, props, last, onNext, onPre);
            }
          }}
        >
          {attrGroups?.map(e => {
            return (
              <ProCard
                extra={
                  <Button onClick={(event) => {
                    // 阻止事件冒泡
                    event.stopPropagation();
                  }}>添加一列</Button>
                }
                bordered
                headerBordered
                collapsible
                title={e}
                style={{
                  marginBlockEnd: 16,
                  maxWidth: '100%',
                }}
              >
                <ProFormText label={e} />
              </ProCard>
            )
          })}

        </ProForm>
      </Card>
      {/* </Space> */}

    </>
  )
}
export default EditorSpecifications;