import {Button, message} from "antd";
import {editor} from "@/services/product/SpuController";
import React from "react";
import {Spu} from "@/interface/entity/commodity";

export function spuSubmitterFormat (first: boolean, props: any, last: boolean, onNext: (spuInfo: Spu) => void, onPre: () => void): React.ReactNode[] | React.ReactNode | false {
  return [
    first ? null : <Button key='preStep' onClick={() => onPre()}>上一步</Button>,
    <Button key='submit' onClick={async () => {
      try {
        await props.form?.validateFields?.();
        props.form?.submit?.();
        const {data, success} = await editor(props.form?.getFieldsValue());
        if (success && data) {
          onNext({
            id: data,
            title: props.form.getFieldValue('title'),
            subTitle: props.form.getFieldValue('subTitle'),
          });
        }
      } catch (e: any) {
        console.log(e);
        const errorFields = e?.errorFields;
        if (errorFields) {
          const error = errorFields[0].errors;
          for(let i = 0; i < error.length; i++) {
            message.warning(error[i]);
          }
        }
      }
    }} type='primary'>{last ? '提交' : '下一步'}</Button>,
      <Button key='reset' onClick={() => props.form?.resetFields()}>重置</Button>
  ]
}