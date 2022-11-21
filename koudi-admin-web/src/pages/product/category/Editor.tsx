import type { EditorFormProps } from '@/interface/props/GalobalProps';
import { detail, editor, tree } from '@/services/product/ServerCategoryController';
import { ModalForm, ProFormDigit, ProFormInstance, ProFormSwitch, ProFormText, ProFormTreeSelect } from '@ant-design/pro-components';
import React, { useEffect, useRef } from 'react';
import { Category } from '@/interface/entity/category';

/**
 * 编辑表单
 * @author bnyte
 * @since 1.0.0
 */
const Editor: React.FC<EditorFormProps> = ({
  trigger, title, id, onSuccess
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
      <ModalForm<Category | undefined>
         trigger={trigger}
         title={title}
         formRef={formRef}
         request={async () => {
          if (id) {
            const { data } = await detail({id});
            return data;
          }
          const data: Category = {
            sort: 0,
          };
          return data;
        }}
        onFinish={async (payload?: Category) => {
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
            }
          }}
          request={async () => {
            const {data} = await tree({skip_lowest_level: true, skip_root: false});
            if (data) {
              return data;
            }
            return [];
          }}
          required
          placeholder='请选择上级分类'
          label="上级分类"
          rules={[{ required: true, message: '上级分类不能为空' }]}
          name="parentId" />
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
        <ProFormText
          label='计量单位'
          name='productUnit'
          placeholder='当前分类的计量单位' 
          width='md'/>
        <ProFormText
          label='商品数量'
          name='productCount'
          placeholder='当前分类商品的数量' 
          width='md'/>
      </ModalForm>
    </>
  )
}
export default Editor;