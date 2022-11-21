import type { EditorFormProps } from '@/interface/props/GalobalProps';
import { ModalForm, ProFormDigit, ProFormInstance, ProFormSwitch, ProFormText, ProFormTextArea, ProFormTreeSelect, ProFormUploadButton } from '@ant-design/pro-components';
import React, { useEffect, useRef, useState } from 'react';
import { Brand } from '@/interface/entity/brand';
import { detail, editor } from '@/services/product/ServerBrandController';
import { tree } from '@/services/product/ServerCategoryController';
import { UploadFile } from 'antd';
import { UploadChangeParam } from 'antd/es/upload';
import { Response } from '@/interface/base';
import { UploadVO } from '@/interface/entity/upload';

/**
 * 编辑表单
 * @author bnyte
 * @since 1.0.0
 */
const Editor: React.FC<EditorFormProps> = ({
  trigger, title, id, onSuccess
}) => {

  const formRef = useRef<ProFormInstance<Brand>>();

  const [ fileList, setFileList ] = useState<UploadFile[]>([]);

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
      <ModalForm<Brand | undefined>
         trigger={trigger}
         title={title}
         formRef={formRef}
         request={async () => {
          if (id) {
            const { data } = await detail({id});
            if (data) {
              const files: UploadFile[] = [
                {
                  url: data?.logo,
                  uid: '1',
                  name: ''
                }
              ]
              setFileList(files);
            }
            return data;
          }
          const data: Brand = {
            sort: 0,
          };
          return data;
        }}
        onFinish={async (payload?: Brand) => {
          // console.log('editor brand payload', payload);
          const {success} = await editor(payload);
          if (success) {
            onSuccess();
            return true;
          }
          return false;
        }}
      >
        <ProFormDigit
          width="md"
          hidden
          name="id" />
        <ProFormText
          width="md"
          required
          label="名称"
          tooltip="最长为 12 位"
          placeholder="请输入名称"
          rules={[{ required: true, message: '名称不能为空' }]}
          name="name" />
        <ProFormTreeSelect
          width="md"
          fieldProps={{
            fieldNames: {
              label: 'name',
              value: 'id',
            },
            multiple: true
          }}
          request={async () => {
            const {data} = await tree({skip_lowest_level: false, skip_root: true});
            if (data) {
              return data;
            }
            return [];
          }}
          required
          placeholder='请选择分类'
          label="上级分类"
          rules={[{ required: true, message: '分类不能为空' }]}
          name="categories" />
        <ProFormDigit
          width="md"
          label='排序'
          placeholder='请输入排序'
          tooltip="数值越高优先级越高"
          name="sort" />
        <ProFormSwitch
          label='是否显示'
          name='show'
          tooltip='如果关闭则不会显示在首页分类列表' 
          width='md'/>
        <ProFormUploadButton
          label='品牌logo'
          max={1}
          name='logo'
          required
          rules={[{ required: true, message: '品牌logo不能为空' }]}
          placeholder='品牌logo'
          action="/api/product/upload/sso"
          fieldProps={{
            fileList: fileList,
            name: 'file',
            onRemove: () => {
              setFileList([]);
              return true;
            },
            onChange: (info: UploadChangeParam<UploadFile>) => {
              let {fileList} = info;
              // debugger
              if (info.file.status === 'done') {
                const response: Response<UploadVO> = info.file.response;
                setFileList([{
                  url: response.data?.filepath,
                  name: info.file.name,
                  uid: '1'
                }]);
                formRef.current?.setFieldValue('logo', response.data?.filepath);
              } else if (info.file.status === 'error') {
                setFileList(fileList);
              } else {
                setFileList(fileList);
              }
            }
          }}
          width='md'/>
        <ProFormTextArea
          label='介绍'
          name='description'
          placeholder='品牌介绍' 
          width='md'/>
        <ProFormText
          label='检索首字母'
          name='firstLetter'
          placeholder='请输入检索首字母' 
          width='md'/>
      </ModalForm>
    </>
  )
}
export default Editor;