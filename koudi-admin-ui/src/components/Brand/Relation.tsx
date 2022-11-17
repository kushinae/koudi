import { ModalForm, ProFormDigit, ProFormTreeSelect } from '@ant-design/pro-components';
import React, { useEffect } from 'react';
import type { BrnadRelationCategoryProps } from '@/interface/props/Props';
import { Form } from 'antd';
import { detail } from '@/services/product/brand/api';
import { tree, treeWithBrand } from '@/services/product/category/api';

/**
 * Relation品牌关联表单
 * @author bnyte
 * @since 1.0.0
 */
const Relation: React.FC<BrnadRelationCategoryProps> = ({
  open, onCancel, onSuccess, currentBrand
}) => {

  const [relationForm] = Form.useForm();

  /**
   * 钩子函数
   */
  useEffect(() => {
    // 创建之前等
    if (currentBrand && currentBrand.id) {
      detail(currentBrand.id).then(response => {
        relationForm.setFieldsValue(response.data);
      });

    }
    return () => {
      // return出来的函数本来就是更新前，销毁前执行的函数，现在不监听任何状态，所以只在销毁前执行
    };
  }, [currentBrand, relationForm]);
  return (
    <>
      <ModalForm
        form={relationForm}
        open={open}
        onFinish={async (params) => {
          relationForm.validateFields();
          onSuccess(params.selectCategory, params.id);
        }}
        modalProps={{
          maskClosable: true,
          keyboard: true,
          onCancel: () => onCancel()
        }}
        title='编辑品牌关联'>

        <ProFormDigit width="md" name="id" hidden label="主键" placeholder="主键" />

        <ProFormTreeSelect
          name='selectCategory'
          required
          label="品牌分类"
          debounceTime={1000000}
          rules={[{ required: true, message: '请输入选择分类' }]}
          request={async () => {
            if (currentBrand?.id) {
              const { data } = await treeWithBrand(currentBrand?.id);

              const { category, relations } = data;

              if (relations) {
                relationForm.setFieldValue('selectCategory', relations.map(e => {
                  return e.id;
                }));
              }

              return category;
            }
            const { data } = await tree(false);
            return data;
          }}
          width='md'
          fieldProps={{
            allowClear: true,
            fieldNames: {
              value: "id", children: "children", label: 'name'
            },
            treeExpandAction: 'doubleClick',
            multiple: true,
            placeholder: '请选择分类',
          }}
        />
      </ModalForm>
    </>
  )
}
export default Relation;