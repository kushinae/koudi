export interface EditorFormProps {
  trigger: JSX.Element;
  title: string;
  id?: number | string;
  onSuccess: () => void;
}