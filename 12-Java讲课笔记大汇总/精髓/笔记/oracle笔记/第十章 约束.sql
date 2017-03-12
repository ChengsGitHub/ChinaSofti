/*
五种约束：约束DML操作对表的数据访问限制
not null：非空
primary key：主键
unique：唯一值
check：检查
foreign key：外键（参照完整性外键检查约束）
*/

CREATE TABLE newdept
AS
SELECT * FROM departments;

CREATE TABLE newemp
AS
SELECT * FROM employees;

--非空约束
ALTER TABLE newemp
MODIFY (first_name NOT NULL);
--
ALTER TABLE newemp
MODIFY (first_name NULL);

/*
增加约束：
ALTER TABLE 表名
ADD CONSTRAINT 约束名称 具体约束设置;

删除约束：
ALTER TABLE 表名
DROP CONSTRAINT 约束名称;
*/

--主键约束：限制列值不允许重复，且不能为空，一个主键可以由多列组成（复合主键）
--一个表只能加一个主键约束
ALTER TABLE newemp
ADD CONSTRAINT newemp_empid_pk PRIMARY KEY (employee_id);

ALTER TABLE newemp
ADD CONSTRAINT newemp_name_pk PRIMARY KEY (first_name,last_name);

--唯一值约束：限制列值不允许重复，但是不限制空值，一个unique约束可以由多列组成
--一个表可以加多个UNIQUE约束
ALTER TABLE newemp
ADD CONSTRAINT newemp_email_uni UNIQUE (email);

--检查约束：限制自定义条件，但忽略空值
ALTER TABLE newemp
ADD CONSTRAINT newemp_salary_chk CHECK (salary>=400);

--外键约束：限制从表的外键列值必须是引用的主表中的主键列值，不限制空值
--前置条件：前提是引用的主表中的主键列已经加上主键约束

ALTER TABLE newdept
ADD CONSTRAINTS newdept_deptid_pk PRIMARY KEY (department_id);

ALTER TABLE newemp
ADD CONSTRAINTS newemp_newdept_deptid_fk FOREIGN KEY (department_id)
REFERENCES newdept (department_id);

--级联删除：删除主表数据自动删除匹配的从表的数据
ALTER TABLE newemp
ADD CONSTRAINTS newemp_newdept_deptid_fk FOREIGN KEY (department_id)
REFERENCES newdept (department_id)
ON DELETE CASCADE;

--级联置空：删除主表数据自动将匹配的外键值设置为空
ALTER TABLE newemp
ADD CONSTRAINTS newemp_newdept_deptid_fk FOREIGN KEY (department_id)
REFERENCES newdept (department_id)
ON DELETE SET NULL;

--创建表的同时增加约束
CREATE TABLE newemp2
(
       emp_id NUMBER(6) PRIMARY KEY,
       emp_name VARCHAR2(50) NOT NULL,
       emp_salary NUMBER(8,2) CHECK (emp_salary>=400),
       dept_id    NUMBER(4) REFERENCES departments (department_id)
);