# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)

华日运检项目
-hr                                         根目录
|----core                                   config、entity、公共domain、鉴权
    |----common                             公共接口
        |----hsys                           账号、角色、权限管理
            |----hafter                     售后模块
            |   |----hbasic                 基础信息模块（台站、设备）
            |       |-----hmoudl            模板模块
            |            |----hpatrol       巡查模块
            |----hcensus     |              统计模块（数据大屏、统计）
            |----------------+---server     项目入口、静态页面

分页规范，系统默认每页10条
无参数查询，/api/v1/find/{current}
单参数查询，/api/v1/find/{current}?parameter=参数
多参数查询，/api/v1/find/{current}?parameters={...（json字符串）}

返回值
使用 ResultUtil















