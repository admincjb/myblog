# eumji-blog

[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)


这个项目是使用spring boot + thymeleaf 开发个人博客项目.

初期开发已经完成,网站已经上线.

演示站: http://www.eumji025.com

# What do you need?
- JDK 8
- Maven
- MySQL (or other SQL database)

# Main technology

- Spring && Spring security && Spring boot
- Mybatis
- bootstrap
- flavr
- thymeleaf
- editor.md


# Steps
1 - Create the database using the **eumji-blog.sql** file

2 - update the database info in resource/application.yml

3 - compile the modules using the command **mvn package -DskipTests**

4 - start the modules using the command **java -jar target/eumji-blog.jar**

5 - Type **http://localhost:8080/** into your browser


## 后台模块

登陆路径 /login
默认账号 admin
默认密码 admin

修改记录

## 2017年4月19日

1.博客的雏形已经完成,

2.后续的是更多的稳定性和功能性的修改.



## 2017年4月21日

1.将部分前端独立出来

2.追加markdown编辑器的图片上传功能

3.修改移动端兼容问题

## 2017年4月24日
1.修复前端显示的bug

2.修复上一篇和下一篇的问题

3.将静态资源走cdn引用

4.修改网站icon

## 2017年4月25日

1.解决上一篇和下一篇直接为第一篇和最后一篇的问题

2.解决分享到QQ的URL问题

3.解决图片上传的问题 (因为linux下没有d:/image使用java的临时工作空间目录)

4.解决导航栏换行问题
 
5.解决登录时候出现js的问题

## 2017年4月27日

1.解决iframe不能正确被解析的问题

2.解决&+等特殊符号在post请求中被转义的情况

3.添加license

## 2017年5月1日-8日

1.修复异常日志记录的问题

2.修改onclick实践为jquery绑定

3.重构前端js和部分页面

4.重构推送的功能并在添加文章的时候进行推送

5.添加文章按月份归档功能

6.晚上条件搜索功能,目前只支持关键字搜索文章

7.解决分页问题,样式不兼容,换boostrap分页

8.部分静态资源走cdn

## 2017年5月14日

1.修复后台启用和关闭文章的提示框

2.后续计划,将博客引入redis等缓存框架

3.优化

## 2017年5月19日

1.修改原本onclick事件->jquery绑定

## 2017年5月20日

1.zblog改名为eumji-blog 别问我为什么，此名称已存在。


## License
The eumji-blog is released under version 2.0 of the [Apache License](http://www.apache.org/licenses/LICENSE-2.0).
