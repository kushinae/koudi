import { ProSettings as LayoutSettings } from '@ant-design/pro-layout';

const Settings: LayoutSettings & {
  pwa?: boolean;
  logo?: string;
} = {
  navTheme: 'light',
  // 绿色主题色
  colorPrimary: '#a259ff',

  layout: 'mix',
  // splitMenus: true,
  contentWidth: 'Fluid',
  fixedHeader: false,
  fixSiderbar: true,
  colorWeak: true,
  title: '@umi/max',
  pwa: false,
  logo: 'https://img.alicdn.com/tfs/TB1YHEpwUT1gK0jSZFhXXaAtVXa-28-27.svg',
  iconfontUrl: '',
};

export default Settings;
