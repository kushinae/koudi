import { AttrGroup } from '@/interface/entity/attr';
import { EditorFormProps } from '@/interface/props/CategoryProps';
import { detail, editor } from '@/services/product/ServerAttrGroupController';
import { tree } from '@/services/product/ServerCategoryController';
import { ModalForm, ProFormDigit, ProFormInstance, ProFormText, ProFormTextArea, ProFormTreeSelect } from '@ant-design/pro-components';
import React, { useEffect, useRef } from 'react';

/**
 * 销售组编辑表单
 * @author bnyte
 * @since 1.0.0
 */
const Editor: React.FC<EditorFormProps> = ({
  trigger, title, id, onSuccess
}) => {

  const formRef = useRef<ProFormInstance<AttrGroup>>();
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
      <ModalForm<AttrGroup | undefined> 
        title={title}
        formRef={formRef}
        request={async () => {
          if (id) {
            const { data } = await detail({id});
            return data;
          }
          const data: AttrGroup = {
            sort: 0,
          };
          return data;
        }}
        onFinish={async (payload?: AttrGroup) => {
          // console.log('editor brand payload', payload);
          const {success} = await editor(payload);
          if (success) {
            onSuccess();
            return true;
          }
          return false;
        }}
        trigger={trigger}>
          <ProFormDigit width="md" name="id" hidden label="主键" placeholder="主键" />
          <ProFormText
            width="md"
            name="name"
            required
            label="名称"
            tooltip="最长为 24 位"
            placeholder="请输入名称"
            rules={[{ required: true, message: '请输入属性组名称' }]}
          />

          <ProFormDigit
            label="排序"
            name="sort"
            width='md'
            required
          />

          <ProFormTextArea width="md" name="description" label="描述" placeholder="请输入描述" />

          <ProFormText
            width="md"
            name="icon"
            label="icon"
            placeholder="icon地址"
          />

          <ProFormTreeSelect
            width="md"
            fieldProps={{
              fieldNames: {
                label: 'name',
                value: 'id',
              },
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
            name="categoryId" />
        </ModalForm>
    </>
  )
}
export default Editor;