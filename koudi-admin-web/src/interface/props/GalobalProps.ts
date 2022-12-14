import {Spu} from "@/interface/entity/commodity";

/** 编辑表单props */
export interface EditorFormProps {
  trigger: JSX.Element;
  title: string;
  id?: number | string;
  onSuccess: (id?: number | string) => void;
}

/** 编辑步骤表单的表单项的props */
export interface EditorStepFormItemProps {
  id?: number | string;
  onPre: () => void;
  onNext: (spuInfo: Spu) => void;
  last: boolean;
  first: boolean;
  spuInfo?: Spu;
  spuId?: number | string;
}

/** 编辑步骤表单的表单项的props */
export interface EditorStepFormProps {
  id?: number | string;
  open?: false | boolean;
  onClose?: () => void;
}