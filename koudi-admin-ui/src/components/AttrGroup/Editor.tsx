import { ModalForm, ProFormDigit, ProFormText, ProFormTextArea } from '@ant-design/pro-components';
import { Button, Form, message } from 'antd';
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
  const [form] = Form.useForm();
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
        form={form}
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

        <ProFormDigit width="md" name="id" hidden label="主键" placeholder="主键" />
        <ProFormText
          width="md"
          name="name"
          required
          label="名称"
          tooltip="最长为 24 位"
          placeholder="请输入名称"
        />

        <ProFormDigit
          label="排序"
          name="sort"
          required
        />

        <ProFormTextArea width="md" name="description" label="描述" placeholder="请输入描述" />

        <ProFormText
          width="md"
          name="icon"
          label="icon"
          placeholder="icon地址"
        />

        <ProFormText
          width="md"
          name="categoryName"
          label="所属分类"
          required
          disabled
          placeholder="分类名称"
        />
        <ProFormDigit
          label="所属分类ID"
          name="categoryId"
          hidden
        />
      </ModalForm>
    </>
  )
}
export default Editor;