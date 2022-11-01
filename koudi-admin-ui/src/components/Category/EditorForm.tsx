import React, { useEffect } from 'react';
import { Form, Input, Modal } from 'antd';

interface EditorFormProps {
  open: boolean;
  onSuccess: (values: APIResponse.Category) => void;
  onCancel: () => void;
  data: APIResponse.Category | undefined;
}

/**
 * Editor
 * @author bnyte
 * @since 1.0.0
 */
const EditorForm: React.FC<EditorFormProps> = ({
  open, onSuccess, onCancel, data
}) => {

  const [form] = Form.useForm<APIResponse.Category>();

  /**
   * 钩子函数
   */
  useEffect(() => {
    // 创建之前等
    if (data) {
      form.setFieldsValue(data);
    } else {
      form.resetFields();
    }
    return () => {
      // return出来的函数本来就是更新前，销毁前执行的函数，现在不监听任何状态，所以只在销毁前执行
    };
  }, [data, form]);
  return (
    <>
      <Modal
        open={open}
        title="Create a new collection"
        okText="Create"
        cancelText="Cancel"
        onCancel={onCancel}
        onOk={() => {
          form
            .validateFields()
            .then((values: APIResponse.Category) => {
              form.resetFields();
              onSuccess(values);
            })
        }}
      >
        <Form
          form={form}
          layout="vertical"
          name="编辑分类"
        >
          <Form.Item
            name="id"
            hidden
          >
            <Input />
          </Form.Item>
          <Form.Item
            name="name"
            label="名称"
            rules={[{ required: true, message: '请输入分类名称' }]}
          >
            <Input />
          </Form.Item>
        </Form>
      </Modal>
    </>
  )
}
export default EditorForm;