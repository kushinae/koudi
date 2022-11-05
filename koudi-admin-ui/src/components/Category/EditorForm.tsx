import React, { useEffect } from 'react';
import { Form, Input, Modal, Cascader, InputNumber, Switch } from 'antd';

interface EditorFormProps {
  open: boolean;
  onSuccess: (values: APIResponse.Category) => void;
  onCancel: () => void;
  data: APIResponse.Category | undefined;
  tree: APIResponse.Category[] | undefined;
}

const formInit: APIResponse.Category = {
  id: -1,
  name: '',
  parentId: -1,
  level: 0,
  show: true,
  sort: 0,
  icon: undefined,
  productUnit: undefined,
  productCount: undefined,
  createTime: undefined,
  modifiedTime: undefined,
  createAdminName: undefined,
  modifiedAdminName: undefined,
  deleted: undefined,
  children: undefined,
  disabled: undefined
}

/**
 * Editor
 * @author bnyte
 * @since 1.0.0
 */
const EditorForm: React.FC<EditorFormProps> = ({
  open, onSuccess, onCancel, data, tree
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
        title="编辑分类"
        okText="完成"
        cancelText="取消"
        onCancel={onCancel}
        forceRender
        onOk={() => {
          form
            .validateFields()
            .then((values: APIResponse.Category) => {
              form.resetFields();
              if (Array.isArray(values.parentId)) {
                values.parentId = values.parentId.at(values.parentId.length - 1);
              }
              onSuccess(values);
            });
        }}
      >
        <Form
          initialValues={formInit}
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
            <Input placeholder='请输入分类名称' />
          </Form.Item>
          <Form.Item
            name="parentId"
            label="上级分类"
          // rules={[{ required: true, message: '请输入分类名称' }]}
          >
            <Cascader
              changeOnSelect
              placeholder='请选择上级分类'
              fieldNames={
                { label: "name", value: "id", children: "children" }
              }
              options={tree} />
          </Form.Item>
          <Form.Item
            name="level"
            label='分类等级'
            hidden
          >
            <InputNumber />
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
            <InputNumber />
          </Form.Item>
        </Form>
      </Modal>
    </>
  )
}
export default EditorForm;