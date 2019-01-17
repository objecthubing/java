-- auto-generated definition
create table user (
  id  int auto_increment primary key,
  username varchar(32)  not null comment '用户名称',
  birthday datetime     null comment '生日',
  sex      char         null comment '性别',
  address  varchar(256) null  comment '地址'
);

INSERT INTO user (id, username, birthday, sex, address) VALUES (41, '老王', '2018-02-27 17:47:08', '男', '北京');
INSERT INTO user (id, username, birthday, sex, address) VALUES (42, '小二王', '2018-03-02 15:09:37', '女', '北京金燕龙');
INSERT INTO user (id, username, birthday, sex, address) VALUES (43, '小二王', '2018-03-04 11:34:34', '女', '北京金燕龙');
INSERT INTO user (id, username, birthday, sex, address) VALUES (45, '张无忌', '2018-09-04 14:57:18', '男', '金融港');
INSERT INTO user (id, username, birthday, sex, address) VALUES (46, '老王', '2018-03-07 17:37:26', '男', '北京');
INSERT INTO user (id, username, birthday, sex, address) VALUES (49, '赵敏', '2018-09-04 14:57:04', '男', '金融港');