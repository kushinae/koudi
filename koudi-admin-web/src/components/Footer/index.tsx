import { GithubOutlined } from '@ant-design/icons';
import { DefaultFooter } from '@ant-design/pro-components';
const Footer: React.FC = () => {
  const defaultMessage = 'Kushinae开源组织出品';
  const currentYear = new Date().getFullYear();
  return (
    <DefaultFooter
      copyright={`${currentYear} ${defaultMessage}`}
      links={[
        {
          key: 'Kushinae',
          title: 'Kushinae',
          href: 'https://github.com/kushinae',
          blankTarget: true,
        },
        {
          key: 'github',
          title: <GithubOutlined />,
          href: 'https://github.com/kushinae/koudi',
          blankTarget: true,
        },
        {
          key: 'blog',
          title: 'Blog',
          href: 'https://blog.bnyte.com',
          blankTarget: true,
        },
      ]}
    />
  );
};
export default Footer;
