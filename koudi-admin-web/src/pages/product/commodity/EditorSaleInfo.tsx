import {FC, useRef} from "react";
import {ProForm, ProFormDigit, ProFormInstance, ProFormText} from "@ant-design/pro-components";
import {EditorStepFormItemProps} from "@/interface/props/GalobalProps";
import Style from './index.less';
import {Tooltip} from "antd";
import {GiConvergenceTarget} from "react-icons/all";
import {Spu} from "@/interface/entity/commodity";
import {spuSubmitterFormat} from "@/utils/spu";

const EditorSaleInfo: FC<EditorStepFormItemProps> = ({
  id, onNext, onPre, last, first, spuInfo
}) => {

  const formRef = useRef<ProFormInstance<Spu>>();

  return (
    <>
      <ProForm
        formRef={formRef}
        submitter={{
          render: (props) => {
            return spuSubmitterFormat(first, props, last, onNext, onPre)
          }
        }}
        layout='horizontal'
        grid={true}
        rowProps={{
          // gutter: [16, formLayoutType === 'inline' ? 16 : 0],
           gutter: [16, 0],
        }}>
        <ProFormText
          width="md"
          required
          colProps={{ md: 12, xl: 8 }}
          fieldProps={{
            suffix: (
              <Tooltip placement='top' title='映射商品主标题'>
                <GiConvergenceTarget onClick={() => {
                  formRef.current?.setFieldValue('title', spuInfo?.title);
                }} className={Style.icon_hover} />
              </Tooltip>
            )
          }}
          label="主标题"
          tooltip="商品主标题"
          placeholder="请输入主标题"
          // addonAfter={<Button>使用商品标题</Button>}
          rules={[{ required: true, message: '商品主标题不能为空' }]}
          name="title" />

        <ProFormText
          width="md"
          required
          // colProps={{
          //   span: 8,
          // }}
          fieldProps={{
            suffix: (
              <Tooltip placement='top' title='映射商品副标题'>
                <GiConvergenceTarget onClick={() => {
                  formRef.current?.setFieldValue('subTitle', spuInfo?.subTitle);
                }} className={Style.icon_hover} />
              </Tooltip>
            )
          }}
          colProps={{ md: 12, xl: 8 }}
          label="副标题"
          tooltip="商品副标题"
          placeholder="请输入副标题"
          rules={[{ required: true, message: '商品副标题不能为空' }]}
          name="subTitle" />
        <ProFormDigit
          width="md"
          required
          colProps={{ md: 12, xl: 8 }}
          label="商品价格"
          tooltip="商品价格: 单位分"
          placeholder="请输入价格,单位分"
          rules={[{ required: true, message: '商品副标题不能为空' }]}
          // addonAfter="分"
          initialValue={1}
          name="price" />
        <ProFormDigit
          width="md"
          required
          colProps={{ md: 12, xl: 8 }}
          label="商品重量"
          tooltip="商品重量: 单位克"
          placeholder="请输入重量,单位克"
          rules={[{ required: true, message: '商品重量不能为空' }]}
          // addonAfter="克"
          initialValue={1}
          name="weight" />

        <ProFormDigit
          width="md"
          required
          colProps={{ md: 12, xl: 8 }}
          label="商品库存"
          tooltip="商品库存"
          placeholder="请输入库存数量"
          rules={[{ required: true, message: '商品库存不能为空' }]}
          initialValue={0}
          name="stock" />

        <ProFormDigit
          width="md"
          required
          colProps={{ md: 12, xl: 8 }}
          label="商品库存告警"
          tooltip="商品剩余库存告警, 当库存不够时会通过钉钉/企业微信的方式进行告警"
          placeholder="商品剩余数量库存告警"
          rules={[{ required: true, message: '商品库存不能为空' }]}
          initialValue={0}
          name="alertStock" />

        <ProFormDigit
          hidden
          width="md"
          required
          colProps={{ md: 12, xl: 8 }}
          label="销售参数所属商品"
          tooltip="销售参数所属商品"
          placeholder="销售参数所属商品"
          rules={[{ required: true, message: '商品不能为空' }]}
          name="spuId" />

      </ProForm>
    </>
  )

}

export default EditorSaleInfo;