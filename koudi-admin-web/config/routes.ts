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
        component: '@/pages/product/category/List',
      },
      {
        name: '品牌管理',
        path: '/product/brand',
        component: '@/pages/product/brand/List',
      },
      {
        name: '属性组管理',
        path: '/product/attrgroup',
        component: '@/pages/product/attrgroup/List',
      },
    ],
  },
  { component: './404', layout: false },
];
