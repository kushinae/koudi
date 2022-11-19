import { getInitialState } from '@/app';
import { Dropdown } from 'antd';
import { ItemType } from 'antd/es/menu/hooks/useItems';
import React, { useEffect } from 'react';
import UserInfo from './UserInfo';

const { currentUser } = await getInitialState();

/**
 * 用户信息下拉菜单组件
 * @author bnyte
 * @since 1.0.0
 */
const UserDropdown: React.FC = () => {
  const items: ItemType[] = [
    {
      label: '个人中心',
      key: 'my',
    },
    {
      label: <a>退出登录</a>,
      key: 'logout',
    },
  ];

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
    <Dropdown menu={{ items }}>
      <a>
        <UserInfo
          currentUser={{
            ...currentUser,
          }}
        />
      </a>
    </Dropdown>
  );
};
export default UserDropdown;
