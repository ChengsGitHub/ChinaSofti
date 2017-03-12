--创建新用户（方案）
CREATE USER icss IDENTIFIED BY icss;

--DCL语句：数据控制语言，主要是授权和收权语句

--授权语句
--GRANT 权限1，权限2，…… TO 用户名;

--收权语句
--REVOKE 权限1，权限2，…… FROM 用户名;

--创建会话权限
GRANT CREATE SESSION TO icss;

--角色roles：对应一组权限

--授予开发人员角色
GRANT connect,resource TO icss;

--回收权限
REVOKE connect FROM icss;
REVOKE CREATE SESSION FROM icss;

--对象访问权限
--授权
--GRANT INSERT|UPDATE|DELETE|SELECT|ALL ON 数据库对象名 TO 用户名;
--收权
--REVOKE INSERT|UPDATE|DELETE|SELECT|ALL ON 数据库对象名 FROM 用户名;
GRANT SELECT ON scott.employees TO icss;
GRANT ALL ON scott.employees TO icss;

--修改密码
ALTER USER icss IDENTIFIED BY "123";

--解锁用户
ALTER USER icss ACCOUNT UNLOCK;
--用户锁定
ALTER USER icss ACCOUNT LOCK;

--数据库链接：创建一个远程数据库的链接，使用这个链接引用远程数据库的数据
--创建数据库链接：
--create public database link 链接名称 connect to 远程用户名 identified by 远程密码 using '服务命名';

--管理员创建链接
create public database link link_pc19 connect to scott identified by tiger using 'pc19';

--普通用户使用
CREATE TABLE employees
AS
SELECT * FROM employees@link_pc19;

--删除用户
DROP USER icss CASCADE;