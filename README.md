# springsecurity
**介绍**

本项目主要是使用springsecurity+jwt来实现系统的登陆认证和权限认证

**运行**

jdk1.8、mysql8.0、redis6.2.6

1、将本目录下sql文件夹中的sql文件在数据库中执行

2、修改项目中application.yml文件中的mysql和redis修改为自己的地址

3、修改com.example.springsecurity.support.schedduler目录下的RoleJob文件，修改其中保存权限的定时任务的执行时间，改为可以马上执行的时间

4、运行项目，等定时任务先执行，执行完后，角色权限会保存到redis中，之后可以开始正常的测试了

![1670379148860](https://user-images.githubusercontent.com/55084217/206070836-6ad0229d-7b0d-48f6-931c-30ddcdbbc372.png)

**测试相关**

表中的密码是加密的，想要知道明文密码，看用户表的avatar字段，明文密码我暂时存放在了这里

下面演示一个登录接口和需要权限认证的接口

![1670379410173](https://user-images.githubusercontent.com/55084217/206071397-37d6a66f-0420-407a-92af-5ed4ab331907.png)

![1670379464828](https://user-images.githubusercontent.com/55084217/206071508-8f3ab631-746a-4bd0-a29b-85a8325c2275.png)

![1670379488185](https://user-images.githubusercontent.com/55084217/206071553-1a57176a-73dd-4214-999a-69451452e6e9.png)

![1670379511772](https://user-images.githubusercontent.com/55084217/206071605-25ad6ef7-6c4a-4abd-9534-00b5bcc9c125.png)
