import { ModalForm } from '@ant-design/pro-components';
import React, { useEffect } from 'react';
import type { BrnadRelationCategoryProps } from '@/interface/props/Props';

/**
 * Relation品牌关联表单
 * @author bnyte
 * @since 1.0.0
 */
const Relation: React.FC<BrnadRelationCategoryProps> = ({
  open, onCancel, onSuccess
}) => {
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
      <ModalForm
        open={open}
        onFinish={async (payload) => {
          console.log('editor relation', payload);
          onSuccess();
        }}
        modalProps={{
          maskClosable: true,
          keyboard: true,
          onCancel: () => onCancel()
        }}
        title='编辑品牌关联' />
    </>
  )
}
export default Relation;