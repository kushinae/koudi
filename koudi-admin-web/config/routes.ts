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
    access: 'productManage',
    routes: [
      {
        name: '分类管理',
        path: '/product/category',
        component: '@/pages/product/category',
      },
      {
        name: '品牌管理',
        path: '/product/brand',
        component: '@/pages/product/brand',
      },
      {
        name: '属性组管理',
        path: '/product/attrgroup',
        component: '@/pages/product/attrgroup',
      },
      {
        name: '属性管理',
        path: '/product/attr',
        component: '@/pages/product/attr',
      },
    ],
  },
  { component: './404', layout: false },
];
