import { Attr } from '@/interface/type/Type';
import { ProForm, ProFormText } from '@ant-design/pro-components';
import React, { useEffect } from 'react';

/**
 * 编辑属性
 * @author bnyte
 * @since 1.0.0
 */
const Editor: React.FC = () => {
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
      <ProForm<Attr>>
        <ProFormText
          width="md"
          required
          label="名称"
          tooltip="最长为 12 位"
          placeholder="请输入名称"
          rules={[{ required: true, message: '这是必填项' }]}
          name="name" />
      </ProForm>
    </>
  )
}
export default Editor;