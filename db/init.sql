-- 系统管理员表
drop table if exists system_admin;
create table system_admin(
   id int not null auto_increment,
   login_name varchar(100) not null,
   password varchar(100) not null,
   encrypt varchar(100) not null,
   last_login_ip varchar(100) default null,
   mobile varchar(100) default null,
   nack_name varchar(100) default null,
   create_at datetime default null,
   update_at datetime default null,
   admin_type tinyint(2) default 0,
   disabled_flag tinyint(1) default 0,
   mail varchar(100) default null,
   last_login_time datetime default null,
   login_count int default 0,
   loing_error int default 0,
   primary key(id)
)engine=innodb charset=utf8 collate=utf8_general_ci;

-- 角色表
drop table if exists system_role;
create table system_role(
  id int not null auto_increment,
  role_name varchar(100) not null,
  remark varchar(100) default null,
  primary key(id)
)engine=innodb charset=utf8 collate=utf8_general_ci;

-- 用户角色关联表
drop table if exists system_user_role_ref;
create table system_user_role_ref(
   id int not null auto_increment,
   admin_id int not null,
   role_id int not null,
   primary key(id)
)engine=innodb charset=utf8 collate=utf8_general_ci;

-- 权限操作表
drop table if exists system_function;
create table system_function(
   id int not null auto_increment,
   function_name varchar(100) not null,
   function_code varchar(100) default null,
   primary key(id)
)engine=innodb charset=utf8 collate=utf8_general_ci;

-- 角色权限关联表
drop table if exists system_role_function;
create table system_role_function(
  id int not null auto_increment,
  role_id int not null,
  function_id int not null,
  primary key(id)
)engine=innodb charset=utf8 collate=utf8_general_ci;

drop table if exists system_log;
create table system_log(
   id int not null auto_increment,
   admin_id int not null,
   oper_name varchar(100) not null,
   oper_ip varchar(100) default null,
   oper_desc varchar(1024) default null,
   oper_time datetime default null,
   login_type tinyint(2) default 1,
   primary key(id)
)engine=innodb charset=utf8 collate=utf8_general_ci;

-- 学生信息表
drop table  if exists student_info;
create table student_info(
  id int not null auto_increment,
  name varchar(100) not null,
  age int not null,
  sex tinyint not null,
  tel varchar(100) default null,
  address text default null,
  grade int not null,
  class int not null,
  join_time datetime default null,
  create_at datetime default null,
  primary key(id)
)engine=innodb charset=utf8 collate=utf8_general_ci;



insert into system_admin(login_name,password,encrypt) values("admin","9b05732f4b50b86a18e48b982c83bba3","d6f6ccb41d6403f2adeb98d6db97814a4b07594c");
