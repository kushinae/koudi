export default [
  {
    path: '/user',
    layout: false,
    routes: [
      { name: '登录', path: '/user/login', component: './user/Login' },
      { component: './404' },
    ],
  },
  { path: '/welcome', icon: 'smile', component: './Welcome' },
  {
    path: '/productmanage',
    icon: 'ShoppingCartOutlined',
    name: "商品管理",
    routes: [
      { path: '/productmanage/category', name:'分类管理', icon: 'AppstoreOutlined', component: './category' },
      { path: '/productmanage/brand', name:'品牌管理', icon: 'GlobalOutlined', component: './Brand' },
      { path: '/productmanage/attrgroup', name:'属性分组管理', icon: 'GlobalOutlined', component: './AttrGroup', },
      { component: './404' },
    ],
  },
  { path: '/', redirect: '/welcome' },
  { component: './404' },
];
