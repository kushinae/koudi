import { Button } from 'antd';
import React, { useEffect } from 'react';

/**
 *
 * @author bnyte
 * @since
 */
const Index: React.FC = () => {
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
      <Button type="primary">点击我吧</Button>
    </>
  );
};
export default Index;
