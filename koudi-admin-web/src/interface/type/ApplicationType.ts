export interface InitialStateType {
  currentUser: CurrentUser;
}

export interface CurrentUser {
  username: string;
  avatar: string;
  productManage: boolean;
  admin: boolean;
}
