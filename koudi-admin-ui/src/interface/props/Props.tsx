import type { FormInstance } from "antd";

export interface BrnadRelationCategoryProps {
  open: boolean;
  onSuccess: (categoryIds: number[], brandId: number) => void;
  onCancel: () => void;
  currentBrand?: APIResponse.Brand;
  formInstance?: FormInstance<APIResponse.AttrGroup>;
}