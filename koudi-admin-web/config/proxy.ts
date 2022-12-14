/**
 * 在生产环境 代理是无法生效的，所以这里没有生产环境的配置
 * -------------------------------
 * The agent cannot take effect in the production environment
 * so there is no configuration of the production environment
 * For details, please see
 * https://pro.ant.design/docs/deploy
 */
export default {
  // localhost:8000/api/** -> https://preview.pro.ant.design/api/**
  '/api/': {
    // 要代理的地址
    // target: 'https://preview.pro.ant.design',
    // 家里
    // target: 'http://koudi:9080',
    // 没有网关的环境 要把路径重写加上
    target: 'http://127.0.0.1:5186',
    // 公司
    // target: 'http://koudi:8181',
    // 配置了这个可以从 http 代理到 https
    // 依赖 origin 的功能可能需要这个，比如 cookie
    changeOrigin: true,
    pathRewrite: { '^/api': '' },
  },
};
