<h1 align="center">sherly-springboot</h1>
<p align="center">
	<a href='https://gitee.com/guzi499/universal-practice-repository/stargazers'><img src='https://gitee.com/guzi499/universal-practice-repository/badge/star.svg?theme=dark' alt='star'></img></a>
</p>

### 项目简介

本项目是基于 SpringBoot2.x 和 Vue3 / React 的前后端分离的Java多租户权限管理系统。
  
多租户实现方案为 mysql 分库，采用 mybatis-plus 动态表名功能实现。 解决了多租户数据隔离的问题，不同的租户使用不同的数据库，完美做到数据隔离。

其次，多租户分为主租户和购入租户，主租户可以管理其他所有租户的服务和用户量。根据购入租户的购买规模、购买服务来提供支持。

主租户实现功能后，可以根据需求将菜单、权限分给下属购入租户，购入租户拥有这些菜单、权限后，就可以使用对应的菜单、权限功能。

### 反馈交流
<img src=".sherly-springboot/wx.jpg" height="200"/>
添加我的企业微信，邀请您加入企业微信外部交流群

### 特别鸣谢
<img width="120" src="https://resources.jetbrains.com/storage/products/company/brand/logos/jb_beam.png" alt="JetBrains Logo (Main) logo.">

感谢 [jetbrains](https://jb.gg/OpenSourceSupport/?from=sherly-springboot "jetbrains") 为团队提供的免费授权，希望大家能够支持jetbrains及其正版产品。
