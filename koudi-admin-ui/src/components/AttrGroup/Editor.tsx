import { ModalForm, ProFormText } from '@ant-design/pro-components';
import { Button, message } from 'antd';
import React, { useEffect } from 'react';

interface EditorAttrGroupProps {
  open: boolean;
  onSuccess: (payload: APIResponse.AttrGroup) => void;
  onCancel: () => void;
}

/**
 * Editor编辑属性组
 * @author bnyte
 * @since 1.0.0
 */
const Editor: React.FC<EditorAttrGroupProps> = ({
  open, onSuccess, onCancel
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
      <ModalForm
        // onOpenChange={onCancel}
        open={open}
        title="编辑属性分组"
        submitter={{
          searchConfig: {
            submitText: '确认',
            resetText: '取消',
          },
          render: (props) => {
            console.log(props);
            return [
              <Button key="rest" onClick={() => {
                props.form?.resetFields();
                onCancel();
              }}>
                取消
              </Button>,
              <Button key="submit" type='primary' onClick={() => props.form?.submit?.()}>
                提交
              </Button>,
            ];
          },
        }}
        onFinish={async (values: APIResponse.AttrGroup) => {
          console.log(values);
          message.success('提交成功');
          onSuccess(values);
          return true;
        }}
      >
        <ProFormText
          width="md"
          name="name"
          label="签约客户名称"
          tooltip="最长为 24 位"
          placeholder="请输入名称"
        />

        <ProFormText width="md" name="company" label="我方公司名称" placeholder="请输入名称" />
      </ModalForm>
    </>
  )
}
export default Editor;