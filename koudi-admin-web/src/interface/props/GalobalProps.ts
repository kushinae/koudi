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
  onNext: (id: number | string) => void;
  last: boolean;
  first: boolean;
}