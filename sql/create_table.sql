# 数据库初始化
-- 切换库
use yang_oj;

-- 用户表
create table if not exists yang_oj.user
(
    id            bigint auto_increment comment 'id'
    primary key,
    userName      varchar(256)                           null comment '用户昵称',
    userAccount   varchar(256)                           not null comment '账号',
    userPassword  varchar(512)                           not null comment '密码',
    userAvatar    varchar(1024)                          null comment '用户头像',
    userSignature varchar(256)                           null comment '座右铭',
    userPhone     varchar(26)                            null comment '手机号',
    tags          varchar(1024)                          null comment '标签 json 列表',
    userRole      varchar(256) default 'user'            not null comment '用户角色：user/admin/ban',
    updateTime    datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    createTime    datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    isDelete      tinyint      default 0                 not null comment '是否删除'
    )
    comment '用户';


create table if not exists yang_oj.user_blog
(
    id              bigint                             not null comment 'id'
    primary key,
    userId          bigint                             not null comment '用户id',
    avatar          varchar(516)                       null comment '文章图标',
    title           varchar(126)                       not null comment '标题',
    blogDescription varchar(1024)                      null comment '文章简述',
    content         text                               null comment '内容',
    createTime      datetime default CURRENT_TIMESTAMP null,
    updateTime      datetime default CURRENT_TIMESTAMP null comment '更新时间',
    isDelete        tinyint  default 0                 null comment '0:未删除,1:删除'
    )
    comment '我的博客';
