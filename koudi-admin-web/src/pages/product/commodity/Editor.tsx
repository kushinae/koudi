import React, { useEffect } from 'react';

/**
 * 编辑商品
 * @author bnyte
 * @since 1.0.0
 */
const Editor: React.FC = () => {
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
      Editor
    </>
  )
}
export default Editor;