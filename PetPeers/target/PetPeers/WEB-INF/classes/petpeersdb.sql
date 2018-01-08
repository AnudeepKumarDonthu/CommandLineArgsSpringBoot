conn system/admin;

create user petsdb identified by petsdb;
grant resource,connect to petsdb;
conn petsdb/petsdb;
create table pets(id number(30) not null,pet_name varchar(20) not null,pet_age number(30) not null,pet_place varchar(20) not null,pet_type varchar(20) not null,pet_sex varchar(1) not null,pet_size varchar(20) not null,avl_qty number(30) not null);
create table usertable(user_id number(30) not null,login_name varchar(20) not null,login_pwd varchar(20) not null,user_name varchar(20) not null);
create table pet_transactions(trn_id number(30) not null,pet_type varchar(20) not null,owner_id number(30) not null,pur_qty number(30) not null,pur_date date not null);
commit