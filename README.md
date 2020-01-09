## springboot社区  

## 资料  
[Spring 文档](https://spring.io/guides)  
[Spring Web](https://spring.io/guides/gs/serving-web-content/)  
[es](https://elasticsearch.cn/explore)  
[Github OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)  
[Markdown 插件](https://pandao.github.io/editor.md/)  
[UFile SDK](https://github.com/ucloud/ufile-sdk-java)  


## 工具  
[Git Website](https://git-scm.com/download)  
[VP](https://www.visual-paradigm.com)  
[Flyway](https://flywaydb.org/getstarted/firststeps/maven)

## 脚本  
```sql
create table USER
(
    ID           INTEGER auto_increment,
    ACCOUNT_ID   VARCHAR(100),
    NAME         VARCHAR(50),
    TOKEN        CHAR(36),
    GMT_CREATE   BIGINT,
    GMT_MODIFIED BIGINT,
    constraint USER_PK
        primary key (ID)
);
```  
```bash
mvn flyway:migrate  
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```
