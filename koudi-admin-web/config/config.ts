import { defineConfig } from '@umijs/max';
import routes from './routes';
import proxy from './proxy';

export default defineConfig({
  antd: {},
  access: {},
  model: {},
  initialState: {},
  request: {},
  layout: {
    title: '@umijs/max',
  },
  proxy,
  routes,
  npmClient: 'yarn',
  define: {
    // 主题色
    colorPrimary: '#a259ff',
    // 请求前缀
    apiURIPrepath: '/api',
  },
});
