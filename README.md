1）执行 `sql/create_table.sql` 中的数据库语句，自动创建库表

2）启动项目，访问 `http://localhost:8900/api/doc.html` 即可打开接口文档，不需要写前端就能在线调试接口了~
### Elasticsearch 搜索引擎

1）修改 `application.yml` 的 Elasticsearch 配置为你自己的：

```yml
spring:
  elasticsearch:
    uris: http://localhost:9200
    username: root
    password: 123456
```

2）复制 `sql/post_es_mapping.json` 文件中的内容，通过调用 Elasticsearch 的接口或者 Kibana Dev Tools 来创建索引（相当于数据库建表）

```
PUT post_v1
{
 参数见 sql/post_es_mapping.json 文件
}
```

3）开启同步任务，将数据库的帖子同步到 Elasticsearch

找到 job 目录下的 `FullSyncPostToEs` 和 `IncSyncPostToEs` 文件，取消掉 `@Component` 注解的注释，再次执行程序即可触发同步：

```java
// todo 取消注释开启任务
//@Component
```
4）取消注释 ,并开启服务器mq监控台
取消
```yaml
#  rabbitmq:
#    host: 192.168.161.128
#    port: 5672
    #更安全使用stream，用哈希值存储密码
#    stream:
#      password:
#      username:

```
