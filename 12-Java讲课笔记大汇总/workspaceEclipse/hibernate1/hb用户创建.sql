--创建用户
create user hb identified by hb;
--授予开发权限
grant connect,resource to hb;

--创建员工表
create table emp
(
    emp_id           number(6) primary key, 
    emp_name         varchar2(50),
    emp_salary       number(6),
    emp_hiredate     date    
);

--产品表
create table product
(
   prod_id number(6) primary key,
   prod_name varchar2(50),
   prod_price number(6,2)
);

--创建序列
create sequence emp_seq start with 100;

--复合主键的成绩表
CREATE TABLE score
(
    sid NUMBER(6),
    cid NUMBER(6),
    result NUMBER(3),
    CONSTRAINTS score_id_pk PRIMARY KEY (sid,cid)
);