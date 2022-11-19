export default [
  {
    path: '/',
    redirect: '/home',
  },
  {
    name: '首页',
    path: '/home',
    component: '@/pages/index',
  },
  {
    name: '商品管理',
    path: '/product',
    component: '@/pages/product/category',
    access: 'productManage',
    routes: [
      {
        name: '分类管理',
        path: '/product/category',
        component: '@/pages/product/category',
      },
    ],
  },
  { component: './404', layout: false },
];
