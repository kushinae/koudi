import React, { useEffect, useState } from 'react';
import type { UploadProps, UploadFile } from 'antd';
import { Modal, Form, Input, InputNumber, Switch, Upload, message } from 'antd';
import { useForm } from 'antd/es/form/Form';
import TextArea from 'antd/lib/input/TextArea';
import { LoadingOutlined, PlusOutlined } from '@ant-design/icons';
import { PRODUCT_UPLOAD_API } from '../../services/product/upload';
import type { UploadChangeParam, RcFile } from 'antd/lib/upload';

interface EditorProps {
  open: boolean;
  onCancel: () => void;
  onSuccess: (values: APIResponse.Brand) => void;
  data: APIResponse.Brand | undefined;
}

const formInit: APIResponse.Brand = {
  id: undefined,
  name: '',
  logo: '',
  description: '',
  show: true,
  firstLetter: '',
  sort: 0,
  createTime: undefined,
  modifiedTime: undefined,
  createAdminName: undefined,
  modifiedAdminName: undefined,
  deleted: undefined
}

const beforeUpload = (file: RcFile) => {
  const isJpgOrPng = file.type === 'image/jpeg' || file.type === 'image/png';
  if (!isJpgOrPng) {
    message.error('You can only upload JPG/PNG file!');
  }
  const isLt2M = file.size / 1024 / 1024 < 2;
  if (!isLt2M) {
    message.error('Image must smaller than 2MB!');
  }
  return isJpgOrPng && isLt2M;
};
/**
 * Editor编辑表单 新增修改合一
 * @author bnyte
 * @since 1.0.0
 */
const Editor: React.FC<EditorProps> = ({
  open, onCancel, onSuccess, data
}) => {

  const [loading, setLoading] = useState<boolean>();
  const [logoUrl, setLogoUrl] = useState<string>();

  const [form] = useForm<APIResponse.Brand>();

  const handleChange: UploadProps['onChange'] = (info: UploadChangeParam<UploadFile>) => {


    if (info.file.status === 'uploading') {
      setLoading(true);
      return;
    }
    if (info.file.status === 'done') {
      const filepath = info.file.response.data.filepath;
      setLoading(false);
      setLogoUrl(filepath);
      form.setFieldValue('logo', filepath);
    }
  };

  const uploadButton = (
    <div>
      {loading ? <LoadingOutlined /> : <PlusOutlined />}
      <div style={{ marginTop: 8 }}>上传</div>
    </div>
  );

  /**
   * 钩子函数
   */
  useEffect(() => {
    // 创建之前等
    if (data) {
      form.setFieldsValue(data);
      setLogoUrl(data.logo);
    } else {
      form.resetFields();
      setLogoUrl(undefined);
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
              onSuccess(values);
              form.resetFields();
              setLogoUrl(undefined);
            });
        }}
      >
        <Form
          form={form}
          initialValues={formInit}
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
            valuePropName='logo'
          >
            <Upload
              listType="picture-card"
              showUploadList={false}
              action={PRODUCT_UPLOAD_API}
              beforeUpload={beforeUpload}
              onChange={handleChange}
              name="file">
              {logoUrl ? <img src={logoUrl} alt="avatar" style={{ width: '100%' }} /> : uploadButton}
            </Upload>
          </Form.Item>

          <Form.Item
            name="firstLetter"
            label="检索首字母"
          // rules={[{ required: true, message: '请输入分类名称' }]}
          >
            <Input placeholder='需要检索的首字母' />
          </Form.Item>
          <Form.Item
            name="description"
            label='描述'
          >
            <TextArea placeholder='为该品牌做一段简单的描述' />
          </Form.Item>
          <Form.Item
            name="show"
            label='是否显示'
            valuePropName='checked'
            required
          >
            <Switch />
          </Form.Item>
          <Form.Item
            name="sort"
            label='排序'
            required
          >
            <InputNumber />
          </Form.Item>
        </Form>
      </Modal>
    </>
  )
}
export default Editor;