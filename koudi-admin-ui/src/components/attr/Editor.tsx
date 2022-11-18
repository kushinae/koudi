import type { Attr } from '@/interface/type/Type';
import { detailWithCategoryInfo, listWithSearch } from '@/services/product/attrGroup/api';
import type { ProFormInstance } from '@ant-design/pro-components';
import { ProFormCascader } from '@ant-design/pro-components';
import { ModalForm, ProFormSelect, ProFormSwitch, ProFormText, ProFormDigit } from '@ant-design/pro-components';
import React, { useEffect, useRef } from 'react';
import type { EditorAttrProps } from '../../interface/props/Props';
import { detail, editor } from '@/services/product/attr/attr';
import { tree } from '@/services/product/category/api';

const attrTypes = [
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
]

/**
 * 编辑属性
 * @author bnyte
 * @since 1.0.0
 */
const Editor: React.FC<EditorAttrProps> = ({
  onSuccess, triggerElement, id, hiddonAttrGroup, setHiddonAttrGroup
}) => {

  const formRef = useRef<ProFormInstance<Attr>>();

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
      <ModalForm<Attr>
        title="编辑属性"
        formRef={formRef}
        onValuesChange={async (params: Attr) => {
          const type = params.type;
          if (type) {
            if (type + '' !== '0') {
              setHiddonAttrGroup(false);
            } else {
              setHiddonAttrGroup(true);
            }
          }
        }}
        onFinish={async (payload) => {
          console.log(payload);
          // if (payload) {
          //   const { success, data } = await editor(payload);
          //   if (success) {
          //     onSuccess(data);
          //     return success;
          //   } else {
          //     return false;
          //   }
          // }
          return false;
        }}
        request={async () => {
          if (id) {
            const { data } = await detail(id);
            return data;
          } else {
            const data: Attr = {
              name: '',
              multiple: false,
              icon: '',
              multipleValue: [],
              type: 0,
              categoryId: undefined,
              createTime: undefined,
              modifiedTime: undefined,
              createAdminName: undefined,
              modifiedAdminName: undefined,
              deleted: undefined,
              attrGroupId: undefined
            }
            return data;
          }
        }}
        trigger={
          triggerElement
        }>
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
          required
          label="可选值"
          tooltip='输入预选值之后按回车确认添加'
          placeholder="输入可选值"
          rules={[{ required: true, message: '请输入可选值' }]}
          name="multipleValue" />

        <ProFormSelect
          allowClear
          width="md"
          options={attrTypes}
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

        <ProFormSelect
          width="md"
          hidden={hiddonAttrGroup}
          request={async (params) => {
            const { data } = await listWithSearch(params);
            return data.map(e => {
              return {
                label: e.name,
                value: e.id,
              }
            })
          }}
          fieldProps={{
            onSelect: (attrId: number) => {
              detailWithCategoryInfo(attrId).then(response => {
                if (response.success) {
                  formRef.current?.setFieldValue('categoryName', response.data.name);
                }
              });
            },
          }}
          required
          label="所属分组"
          tooltip="标记当前属性所属分组"
          placeholder="选择属性分组"
          rules={hiddonAttrGroup ? [] : [{ required: true, message: '请选择属性分组' }]}
          name="attrGroupId" />

        <ProFormText
          width="md"
          label="所属分类"
          hidden={hiddonAttrGroup}
          disabled
          readonly
          tooltip='选中分组之后自动回显'
          name="categoryName" />

        <ProFormCascader
          width="md"
          request={async () => {
            const { data } = await tree(false);
            return data;
          }}
          fieldProps={{
            fieldNames: {
              label: 'name',
              value: 'id'
            }
          }}
          label="所属分类"
          hidden={!hiddonAttrGroup}
          tooltip='选中分组之后自动回显'
          rules={!hiddonAttrGroup ? [] : [{ required: true, message: '请选择属性分组' }]}
          name="categoryId" />

      </ModalForm>
    </>
  )
}
export default Editor;