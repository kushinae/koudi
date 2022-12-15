import React, { useEffect } from 'react';
import { ProForm } from '@ant-design/pro-components';
import { spuSubmitterFormat } from '@/utils/spu';
import { EditorStepFormItemProps } from '@/interface/props/GalobalProps';

/**
 * 规格参数编辑
 * @author bnyte
 * @since 1.0.0
 */
const EditorSpecifications: React.FC<EditorStepFormItemProps> = ({
  id, onNext, onPre, last, first
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
      <ProForm submitter={{
        render: (props) => {
          return spuSubmitterFormat(first, props, last, onNext, onPre);
        }
      }} />
    </>
  )
}
export default EditorSpecifications;