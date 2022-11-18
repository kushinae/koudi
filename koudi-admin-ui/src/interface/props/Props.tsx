import type { FormInstance } from "antd";
import type { Attr } from "../type/Type";

export interface BrnadRelationCategoryProps {
  open: boolean;
  onSuccess: (categoryIds: number[], brandId: number) => void;
  onCancel: () => void;
  currentBrand?: APIResponse.Brand;
  formInstance?: FormInstance<APIResponse.AttrGroup>;
}

// ReactNode
export interface EditorAttrProps {
  formInstance?: FormInstance<Attr>;
  onSuccess: (id: number) => void;
  triggerElement: JSX.Element;
  id?: number;
  hiddonAttrGroup: boolean;
  setHiddonAttrGroup: (value: boolean) => void;
}