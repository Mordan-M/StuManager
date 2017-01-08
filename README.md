# 学生信息管理系统

## 说明
本系统后端由SSH集成框架所构而成，前端主要使用layui等前端框架，主要用于学生基本信息的查看与管理。

## 开始

* 配置好你的java环境，JDK + Tomcat + Mysql + Eclipse开发工具
* 将stu_manager.sql中的数据库以及一些模拟数据导入你的数据库
* 修改 applicationContext.xml 文件，更改数据库用户名和密码
然后导入该项目就可以使用了！

## 插件
* [echarts](http://echarts.baidu.com/)： 一款强大的绘图工具
* [jquery](http://jquery.com/)：最常用的js框架
* [layui](http://www.layui.com/): 一个大牛独自开发的经典框架，其中[layer](http://layer.layui.com/)是一款非常好用的web弹层组件
* [Font-Awesome](http://fontawesome.io/) 开源免费的图标字体库

## 用户使用手册
1. 进入首页，选择用户类别进行登入
2. 学生用户:
	* 查看自己的个人信息，并且可以修改自己的基本信息
	* 修改个人密码
3. 管理员用户
	* 查看所有用户的学生信息，并可以对学生进行修改或者删除
	* 添加新学生用户
	* 查看学生信息统计，将会以统计图形式展示出来


