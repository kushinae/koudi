import React, { useEffect } from 'react';
import { Modal, Form, Input, InputNumber, Switch } from 'antd';
import { useForm } from 'antd/es/form/Form';
import TextArea from 'antd/lib/input/TextArea';

interface EditorProps {
  open: boolean;
  onCancel: () => void;
  onSuccess: (values: APIResponse.Brand) => void;
  data: APIResponse.Brand | undefined;
}
/**
 * Editor编辑表单 新增修改合一
 * @author bnyte
 * @since 1.0.0
 */
const Editor: React.FC<EditorProps> = ({
  open, onCancel, onSuccess, data
}) => {

  const [form] = useForm<APIResponse.Brand>();

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
        title="编辑分类"
        okText="完成"
        cancelText="取消"
        onCancel={onCancel}
        forceRender
        onOk={() => {
          form
            .validateFields()
            .then((values: APIResponse.Brand) => {
              form.resetFields();
              onSuccess(values);
            });
        }}
      >
        <Form
          form={form}
          layout="vertical"
          name="编辑品牌"
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
            <Input placeholder='请输入分类名称' />
          </Form.Item>
          <Form.Item
            name="logo"
            label="品牌logo"
            rules={[{ required: true, message: '请上传品牌Logo' }]}
          >
            <Input />
          </Form.Item>

          <Form.Item
            name="firstLetter"
            label="检索首字母"
          // rules={[{ required: true, message: '请输入分类名称' }]}
          >
            <Input />
          </Form.Item>
          <Form.Item
            name="description"
            label='描述'
          >
            <TextArea />
          </Form.Item>
          <Form.Item
            name="show"
            label='是否显示'
            valuePropName='checked'
          >
            <Switch />
          </Form.Item>
          <Form.Item
            name="sort"
            label='排序'
          >
            <InputNumber defaultValue={0} />
          </Form.Item>
        </Form>
      </Modal>
    </>
  )
}
export default Editor;