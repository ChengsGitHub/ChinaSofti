--DML数据操纵语言：插入，修改，删除数据

--插入语法
--INSERT INTO 表名 [(列名1，列名2，……)] VALUES (值1，值2，……);
--列列表省略默认就是表中的所有列
--列和值必须个数，顺序，类型要相同

--插入新部门
INSERT INTO departments (department_id,department_name,manager_id,location_id)
VALUES (111,'NEC',206,1700);
--
INSERT INTO departments 
VALUES (111,'NEC',206,1700);
--
INSERT INTO departments (department_id,department_name,manager_id)
VALUES (111,'NEC',206);
--
INSERT INTO departments 
VALUES (111,'NEC',206,NULL);

--查询
select * from departments t

--多行插入：INSERT INTO 表名 [(列名1，列名2，……)] 查询语句;

--把查询结果保存成表
CREATE TABLE dept2
AS
SELECT * FROM departments WHERE 1=0;

INSERT INTO dept2 SELECT * FROM departments;

--更新数据：UPDATE 表名 SET 列1=值，列2=值，…… [WHERE子句]
CREATE TABLE emp2
AS
SELECT * FROM employees;

--把100员工的姓名改为张三
UPDATE emp2 SET first_name='三',last_name='张' WHERE employee_id=100;

--给50号部门的员工工资每人涨5块钱
UPDATE emp2 SET salary=salary+5 WHERE department_id=50;

--删除数据：DELETE FROM 表名 [WHERE子句]

--删除90号部门的员工
DELETE FROM emp2 WHERE department_id=90;


--事务ACID四个特性：
--原子性：任何事务都不可分割，要么一起成功执行，要么都不执行
--一致性：必须从一个正确的状态直接转换到另一个正确的状态
--隔离性：一个会话看不见另一个会话未提交的事务操作
--持久性：如果提交事务，那么事务操作会持久化到数据库中，事务结束，不可回退，其他会话可以看到这个事务操作

--提交和回退都会结束当前事务
  --提交事务：1.commit 2 ddl或dcl语句自动提交事务 3 正常退出客户端程序
  --回退事务：1.rollback 2 客户端程序异常退出

--锁：控制数据的并发访问
--按照粒度划分：行级锁  表级锁

--按照加锁的时机：显式锁（手动锁） 隐式锁（自动锁）

--按照加锁的方式：
--共享锁（S锁）：如果一个资源（行或表）加了共享锁，那么其他会话可以给同一个资源也加共享锁，但是不能加独占锁
--独占锁（X锁）：如果一个资源（行或表）加了独占锁，那么其他会话不能给同一个资源加任何锁

--自动加锁的情况：
--DML语句：行独占表共享
--DDL语句：表独占锁
--查询语句：默认不加任何锁

--手动加锁的情况：
--查询语句加锁：查询语句 FOR UPDATE; 行独占表共享
--表独占锁：
            --乐观锁定：lock table 表名 in share mode; 
            --悲观锁定：lock table 表名 in exclusive mode; 