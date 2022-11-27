import { EditorFormProps } from '@/interface/props/GalobalProps';
import React, { useEffect, useRef } from 'react';
import { Spu } from '@/interface/entity/commodity';
import { ProFormDigit, ProFormInstance, ProFormSelect, ProFormSwitch, ProFormText, StepsForm } from '@ant-design/pro-components';
import { detail, editor } from '@/services/product/SpuController';

/**
 * 编辑spu
 * @author bnyte
 * @since 
 */
const EditorSpu: React.FC<EditorFormProps> = ({
 title, id, onSuccess
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
      <StepsForm.StepForm<Spu | undefined>
        title={title}
        formRef={formRef}
        onFinish={async (payload) => {
          if (payload) {
            const { success, data } = await editor(payload);
            if (success) {
              onSuccess(data);
              return success;
            } else {
              return false;
            }
          }
          return false;
        }}
        request={async () => {
          if (id) {
            const { data } = await detail({ id: id });
            return data;
          } else {
            const data: Spu = {}
            return data;
          }
        }}>
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
          rules={[{ required: true, message: '这是必填项' }]}
          name="name" />

        <ProFormSwitch
          width="md"
          label="检索"
          tooltip='开启后可搜索到该属性'
          name="enableSearch" />

        <ProFormSwitch
          width="md"
          label="多个值"
          tooltip='开启后该属性在商品详情展示时可使用多个值'
          name="multiple" />

        <ProFormText
          width="md"
          required
          label="属性图标"
          placeholder="属性图标"
          rules={[{ required: true, message: '请输入属性图标' }]}
          name="icon" />

        <ProFormSelect
          width="md"
          mode="tags"
          options={[]}
          required
          label="可选值"
          tooltip='输入预选值之后按回车确认添加'
          placeholder="输入可选值"
          rules={[{ required: true, message: '请输入可选值' }]}
          name="multipleValue" />

        <ProFormSelect
          allowClear
          width="md"
          options={[
            {
              value: 0,
              label: '销售属性'
            },
            {
              value: 1,
              label: '基础属性'
            },
            {
              value: 2,
              label: '全部应用'
            },
          ]}
          required
          label="属性类型"
          tooltip="0-销售属性,1-基本属性,2-既是销售属性又是基本属性"
          placeholder="请选择属性类型"
          rules={[{ required: true, message: '请输入可选值' }]}
          name="type" />

        <ProFormSwitch
          width="md"
          tooltip='开启后会在商品简介中快速展示'
          label="快速展示"
          name="quickShow" />

      </StepsForm.StepForm>
    </>
  )
}
export default EditorSpu;