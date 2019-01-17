create database springmvc_01 ;

use springmvc_01 ;

create table user(
  id int primary key  auto_increment,
  name varchar(20) not null ,
  sex varchar(10),
  age int(3),
  address varchar(20),
  qq varchar(20),
  email varchar(30),
  birthday date
);