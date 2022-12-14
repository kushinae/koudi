import { EditorStepFormItemProps } from '@/interface/props/GalobalProps';
import React, { useEffect, useRef } from 'react';
import { Spu } from '@/interface/entity/commodity';
import { ProForm, ProFormDigit, ProFormInstance, ProFormSelect, ProFormText } from '@ant-design/pro-components';
import { detail } from '@/services/product/SpuController';
import { message } from 'antd';
import { categories as categoriesAPI, list } from '@/services/product/ServerBrandController';
import {spuSubmitterFormat} from "@/utils/spu";

/**
 * 编辑spu
 * @author bnyte
 * @since 
 */
const EditorSpu: React.FC<EditorStepFormItemProps> = ({
 id, onNext, onPre, last, first
}) => {

  const formRef = useRef<ProFormInstance<Spu>>();

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
      <ProForm<Spu | undefined>
        formRef={formRef}
        layout='horizontal'
        grid={true}
        rowProps={{
          // gutter: [16, formLayoutType === 'inline' ? 16 : 0],
          gutter: [16, 0],
        }}
        submitter={{
          render: (props) => {
            return spuSubmitterFormat(first, props, last, onNext, onPre);
          }
        }}
        onFinish={async (payload) => {
          console.log('on finish payload', payload);
          return true;
        }}
        request={async () => {
          if (id) {
            const {success, data} = await detail({id});
            if (success && data) {
              return data;
            } else if (success && !data) {
              message.error('商品不存在');
              return data;
            }
          }
          return {};
        }}>
        <ProFormDigit
          width="xs"
          hidden
          colProps={{
            span: 20,
          }}
          name="id" />

        <ProFormText
          width="md"
          required
          colProps={{
            span: 8,
          }}
          label="主标题"
          tooltip="商品主标题（如果在sku没有设置的话则默认使用spu的标题）"
          placeholder="请输入主标题"
          rules={[{ required: true, message: '商品主标题不能为空' }]}
          name="title" />

        <ProFormText
          width="md"
          required
          colProps={{
            span: 8,
          }}
          label="副标题"
          tooltip="商品副标题（如果在sku没有设置的话则默认使用spu的副标题）"
          placeholder="请输入副标题"
          rules={[{ required: true, message: '商品副标题不能为空' }]}
          name="subTitle" />

        <ProFormText
          width="md"
          required
          label="名称"
          colProps={{ md: 12, xl: 8 }} 
          tooltip="商品的商品名称 如(Apple iPhone 13)"
          placeholder="请输入商品名称如:Apple iPhone 13"
          rules={[{ required: true, message: '商品名称不能为空' }]}
          name="name" />

        <ProFormSelect
          required
          label='品牌'
          tooltip="商品所属品牌"
          name='brandId'
          colProps={{ md: 12, xl: 8 }}
          fieldProps={{
            fieldNames: {
              label: 'name',
              value: 'id',
            }
          }}
          width='md'
          request={async () => {
            const {data} = await list();
            return data ? data : [];
          }}/>

          <ProFormSelect 
            required
            colProps={{ md: 12, xl: 8 }}
            dependencies={['brandId']}
            request={async (params) => {
              if (params?.brandId) {
                const {data} = await categoriesAPI({id: params?.brandId});
                return data ? data : [];
              }
              return [];
            }}
            fieldProps={{
              fieldNames: {
                label: 'name',
                value: 'id',
              }
            }}
            label='分类'
            placeholder='选择品牌后加载分类'
            width='md'
            tooltip="商品所属分类, 该属性值通过选择品牌之后回显"
            name='categoryId'/>

      </ProForm>
    </>
  )
}
export default EditorSpu;