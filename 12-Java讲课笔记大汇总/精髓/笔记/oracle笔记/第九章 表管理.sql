--DDL：创建 create，修改 alter，删除drop 数据库对象

--创建表
/*
CREATE TABLE 表名
(
   列名1 数据类型 [DEFAULT 默认值],
   列名2 数据类型 [DEFAULT 默认值],
   ……
);
*/

--创建学生表
CREATE TABLE student
(
sid    NUMBER(6),
sname  VARCHAR2(50),
sex    CHAR(2),
hiredate DATE
);

--删除表
DROP TABLE student;

--创建学生表（默认值）
CREATE TABLE student
(
sid    NUMBER(6),
sname  VARCHAR2(50),
sex    CHAR(2) DEFAULT '男',
hiredate DATE DEFAULT sysdate
);

/*修改表*/

--增加列
ALTER TABLE student
ADD (phone VARCHAR2(50),address VARCHAR2(100));

--修改列类型
ALTER TABLE student
MODIFY (address VARCHAR2(200));

--删除列
ALTER TABLE student
DROP (address);

--设置列不可用
ALTER TABLE student
SET UNUSED (phone);

--删除不可用列
ALTER TABLE student
DROP UNUSED COLUMNS;

--清空表
TRUNCATE TABLE student;

/*
               DELETE语句       TRUNCATE语句
               可以回退         不可回退
               不释放空间       释放空间
               记录日志         不记录日志
*/

--查询回收站数据字典
SELECT * FROM user_recyclebin;

--还原表
FLASHBACK TABLE student TO BEFORE DROP;
FLASHBACK TABLE books TO BEFORE DROP;

--清空回收站 
PURGE RECYCLEBIN;

