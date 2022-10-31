import {useEffect} from 'react';

/**
 * 分类页面
 * @author bnyte
 * @since 1.0.0
 */
const Category: React.FC = () => {
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
    <div>
      Category
    </div>
  )
}
export default Category;
