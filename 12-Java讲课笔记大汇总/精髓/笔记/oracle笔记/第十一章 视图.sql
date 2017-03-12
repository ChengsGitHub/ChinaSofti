--视图：作用保存查询结果，但是视图仅保存查询语句，而不是数据本身，是一种虚拟表

/*
CREATE [OR REPLACE] VIEW 视图名称
AS
查询语句

如果查询语句中有衍生列计算列，必须起别名
*/

--查询员工编号，姓名，工资，保存为视图
CREATE OR REPLACE VIEW v_emp
AS
SELECT employee_id,last_name,salary
FROM   employees;

--删除视图
DROP VIEW v_emp;

--查询视图
SELECT *
FROM   v_emp;

--创建视图v_dept，保存每个部门的编号，部门名称，部门人数，部门工资总和
CREATE OR REPLACE VIEW v_dept
AS
SELECT d.department_id,
       d.department_name,
       COUNT(e.employee_id) emp_count,
       SUM(e.salary) sal_sum
FROM   employees   e,
       departments d
WHERE  e.department_id = d.department_id
GROUP  BY d.department_id,
          d.department_name;

--查询人数不少于3人的部门
SELECT * FROM v_dept WHERE emp_count>=3;

--只读视图
CREATE OR REPLACE VIEW v_emp
AS
SELECT employee_id,last_name,salary
FROM   employees
WITH READ ONLY;