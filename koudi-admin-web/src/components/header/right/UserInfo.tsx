import type { UserInfoProps } from '@/interface/props/HeaderProps';
import { Avatar } from 'antd';
import React, { useEffect } from 'react';

/**
 * 用户信息
 * @author bnyte
 * @since 1.0.0
 */
const UserInfo: React.FC<UserInfoProps> = ({ currentUser }) => {
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
      <span style={{ color: colorPrimary }}>{currentUser.username}</span>
    </>
  );
};
export default UserInfo;
