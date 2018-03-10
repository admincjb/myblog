# eumji-blog
  
 [![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)

这个项目是使用spring boot + thymeleaf 开发个人博客项目.

演示站下线了.太烧钱了.....<br>
大家看看就好了,如果有毅力自己部署上线也是可以的.

# 用户部分说明

作者抽空已经将用户修改，用户图像修改，密码修改等已经做了。
不过对裁剪图片的插件研究不深。做的比较粗糙。

此外需要注意的是，因为讲大部分公共信息已经封装在userinfo表中，所以此表不能为空。默认值作者已经给出了。

# 运行环境
- JDK 8
- Maven
- MySQL (or other SQL database)

# 主要技术

- Spring && Spring security && Spring boot
- Mybatis
- bootstrap
- flavr
- thymeleaf
- editor.md
- [展示页面模板icarus](https://github.com/ppoffice/hexo-theme-icarus)



# 安装步骤

0 - clone或者下载本项目

1 - 创建数据库zblog并导入跟目录eumji-blog.sql文件到数据库

2 - 更新 resources/application.yml中数据库连接配置和百度推送,七牛云的上次图片信息

3 - 编译项目: **mvn package -DskipTests** 或者导入ide,然后运行blogApplication.java

4 - 如果是编译项目,则使用 **java -jar target/eumji-blog.jar**

5 - http://localhost:8080/ 访问你的主页


## 后台模块

登陆路径 http://localhost:8080/login

默认账号 admin<br>
默认密码 admin

剩下的自己玩吧!

##注意事项

1.文章添加后默认是关闭的需要开启(关闭表示不展示)

2.如果运行有问题，请先检查查看一下错误的原因，一般来说是不会有大问题。

3.请自己配置百度推送的相关信息和骑牛云上传图片的相关配置(因为推送给我太多无用的链接了!!!)
百度站长工具: http://ziyuan.baidu.com/dashboard/index <br>
七牛云: https://portal.qiniu.com/

```yml
##七牛云的key
qiniu:
  accessKey:
  secretKey:
  bucketName:
  basePath:

## 百度推送
baidu:
  task:
    postUrl:
    baseUrl:


```

## 修改记录
修改记录请参见 [修改记录](https://github.com/eumji025/EumJi-blog/tree/dev/update-record.md)

## 声明
由于近期的一系列侵权抄袭事件,本项目使用了开源的hexo主题[hexo-theme-icarus](https://github.com/ppoffice/hexo-theme-icarus)并加以改造. 也发邮件请教了[程序猿DD-翟永超](https://github.com/dyc87112).
后端的模板来源于开源项目,本项目的开源协议若有不当的地方,请告知!

另外最近发现某些开源项目,植入挖矿代码,十分鄙视!!!
本项目不存在任何植入行为,除非是我自己被某些开源的组件欺骗了. 
另外也将之前自己做的baidu推送和google推送全部注释掉(需要的请自行配置,千万不要用我默认的!!!)


**净化开源环境人人有责!!!!**

## License

The eumji-blog is released under version 2.0 of the [Apache License](http://www.apache.org/licenses/LICENSE-2.0).

