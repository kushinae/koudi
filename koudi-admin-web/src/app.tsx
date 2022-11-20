import defaultSettings from './defaultSettings';
import { InitialStateType } from '@/interface/type/ApplicationType';
import Content from '@/components/header/right/Content';
import Footer from '@/components/Footer';
import { RuntimeConfig, RunTimeLayoutConfig } from '@umijs/max';
import { SmileOutlined } from '@ant-design/icons';
import { MenuDataItem } from '@ant-design/pro-components';
import AlibabaIcon from '@/components/Icon';
import { RequestConfig } from '@umijs/max';
import { message } from 'antd';
import { BaseResponse } from './interface/base';

const iconMap: {
  [key: string]: JSX.Element;
} = {
  home: <SmileOutlined style={{ color: colorPrimary }} />,
  productManage: (
    <AlibabaIcon style={{ color: colorPrimary }} type="icon-shangpinguanli" />
  ),
};

/**
 * 后续改为从服务端获取路由
 */
const menus = [
  {
    path: '/',
    redirect: '/home',
  },
  {
    name: '首页',
    path: '/home',
    icon: 'home',
  },
  {
    name: '商品管理',
    path: '/product',
    icon: 'productManage',
    routes: [
      {
        name: '分类管理',
        path: '/product/category',
      },
      {
        name: '品牌管理',
        path: '/product/brand',
      },
      {
        name: '属性组管理',
        path: '/product/attrgroup',
      },
    ],
  },
  { component: './404', layout: false },
];

const loopMenuItem = (menus: any[]): MenuDataItem[] => {
  return menus.map(({ icon, routes, ...item }) => {
    const iconValue = iconMap[icon as string];
    return {
      ...item,
      icon: icon && iconValue,
      routes: routes && loopMenuItem(routes),
    };
  });
};

// 运行时配置

// 全局初始化数据配置，用于 Layout 用户信息和权限初始化
// 更多信息见文档：https://next.umijs.org/docs/api/runtime-config#getinitialstate
export async function getInitialState(): Promise<InitialStateType> {
  return {
    currentUser: {
      username: '@umijs/max',
      avatar:
        'https://gw.alipayobjects.com/zos/antfincdn/XAosXuNZyF/BiazfanxmamNRoxxVxka.png',
      productManage: false,
      admin: true,
    },
  };
}

export const layout: RunTimeLayoutConfig | RuntimeConfig = () => {
  return {
    menu: {
      locale: false,
      request: async (params) => {
        console.log('menu async param', params);
        return loopMenuItem(menus);
      },
    },
    // eslint-disable-next-line @typescript-eslint/no-unused-vars
    rightRender: (initialState: InitialStateType) => {
      return <Content />;
    },
    footerRender: () => <Footer />,
    ...defaultSettings,
  };
};

export const request: RequestConfig = {
  timeout: 6000,
  errorConfig: {
    errorHandler: (error: any) => {
      let throwMsg = error.message;
      const response = error?.response;
      if (response) {
        const data: BaseResponse = response.data;
        if (data) {
          const {message} = data;
          throwMsg = message;
        }
      }
      message.error(throwMsg);
      throw new Error(throwMsg); 
    }
  },
  requestInterceptors: [
    (url, options) => {
      // do something
      const newUrl = apiURIPrepath + url;
      return { url: newUrl, options };
    },
  ],
  responseInterceptors: [],
};
