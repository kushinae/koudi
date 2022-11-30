import type { UserInfoProps } from '@/interface/props/HeaderProps';
import { Avatar, Button, theme } from 'antd';
import React, { useEffect } from 'react';

const { useToken } = theme;

/**
 * 用户信息
 * @author bnyte
 * @since 1.0.0
 */
const UserInfo: React.FC<UserInfoProps> = ({ currentUser }) => {

  const { token } = useToken();

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
      <Avatar src={currentUser.avatar} />
      <Button style={{color: token.colorPrimary}} type='link'>{currentUser.username}</Button>
    </>
  );
};
export default UserInfo;
