# springsecurity
**介绍**

本项目主要是使用springsecurity+jwt来实现系统的登陆认证和权限认证

**运行**

jdk1.8、mysql8.0、redis6.2.6

1、将本目录下sql文件夹中的sql文件在数据库中执行

2、修改项目中application.yml文件中的mysql和redis修改为自己的地址

3、运行项目

![1670379148860](https://user-images.githubusercontent.com/55084217/206070836-6ad0229d-7b0d-48f6-931c-30ddcdbbc372.png)

**测试相关**

表中的密码是加密的，想要知道明文密码，看用户表的avatar字段，明文密码我暂时存放在了这里

下面演示一个登录接口和需要权限认证的接口

![1670379410173](https://user-images.githubusercontent.com/55084217/206071397-37d6a66f-0420-407a-92af-5ed4ab331907.png)
