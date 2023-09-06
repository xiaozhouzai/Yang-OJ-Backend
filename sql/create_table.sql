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

use yang_oj;
-- 题目表
create table if not exists question
(
    id          bigint auto_increment comment 'id' primary key,
    title       varchar(512)                       null comment '标题',
    content     text                               null comment '内容',
    tags        varchar(1024)                      null comment '标签列表（json 数组）',
    answer      text                               null comment '题目答案',
    submitNum   int      default 0                 not null comment '题目提交数',
    acceptedNum int      default 0                 not null comment '题目通过数',
    judgeCase   text                               null comment '判题用例（json 数组）',
    judgeConfig text                               null comment '判题配置（json 对象）',
    thumbNum    int      default 0                 not null comment '点赞数',
    favourNum   int      default 0                 not null comment '收藏数',
    userId      bigint                             not null comment '创建用户 id',
    createTime  datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime  datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete    tinyint  default 0                 not null comment '是否删除',
    index idx_userId (userId)
    ) comment '题目' collate = utf8mb4_unicode_ci;

-- 题目提交表
create table if not exists question_submit
(
    id         bigint auto_increment comment 'id' primary key,
    language   varchar(32)                       not null comment '编程语言',
    code       text                               not null comment '用户代码',
    judgeInfo  text                               null comment '判题信息（json 对象）',
    status     int      default 0                 not null comment '判题状态（0 - 待判题、1 - 判题中、2 - 成功、3 - 失败）',
    questionId bigint                             not null comment '题目 id',
    userId     bigint                             not null comment '创建用户 id',
    createTime datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete   tinyint  default 0                 not null comment '是否删除',
    index idx_questionId (questionId),
    index idx_userId (userId)
    ) comment '题目提交';
