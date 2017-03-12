--RDBMS（关系型数据库管理系统）

--表和表之间的三种关系：
--一对多：主表的一条记录匹配从表中的多条记录
--一对一：主表的一条记录仅匹配从表的一条记录
--多对多：一个表的多条记录匹配另一个表的多条记录（实际上都是由两个一对多关系间接形成）

--数据库设计三范式：
/*
1.任何列都不可再分割
2.每一条记录都必须由不可重复的标识（主键）
3.在从表中不需要出现引用的主表的主键列之外的列
*/

--SQL1992标准的表连接查询语法

--查询每个员工编号，姓名，部门名称(笛卡尔集)
SELECT employee_id,last_name,department_name
FROM   departments,employees;

--查询每个员工编号，姓名，部门名称
SELECT employee_id,last_name,department_name
FROM   departments,employees
WHERE  employees.department_id=departments.department_id;

--查询每个员工编号，姓名，部门编号，部门名称
SELECT employee_id,last_name,departments.department_id,department_name
FROM   departments,employees
WHERE  employees.department_id=departments.department_id;

--查询每个员工编号，姓名，部门编号，部门名称（表别名，表名前缀可以提高效率）
SELECT e.employee_id,e.last_name,d.department_id,d.department_name
FROM   departments d,employees e
WHERE  e.department_id=d.department_id;

--查询每个员工编号，姓名，部门编号，部门名称，职务编号，职务名称
SELECT e.employee_id,e.last_name,e.salary,d.department_id,d.department_name,
       j.job_id,j.job_title
FROM   departments d,employees e,jobs j
WHERE  e.department_id=d.department_id
AND    e.job_id=j.job_id
AND    e.salary>5000
ORDER BY e.salary DESC;

--查询每个部门的部门编号，部门名称，部门经理的姓名，部门地址编号，部门所在的城市名称，州名
--国家名称，地区名称
SELECT d.department_id,d.department_name,e.last_name mgr_name,
       l.location_id,l.city,l.state_province,c.country_name,
       r.region_name
FROM  departments d,employees e,locations l,countries c,regions r
WHERE d.manager_id=e.employee_id
AND   d.location_id=l.location_id
AND   l.country_id=c.country_id
AND   c.region_id=r.region_id;

--查询员工职务变更记录：员工编号，姓名，起始日期，终止日期，职务名称，所在部门名称
SELECT e.employee_id,e.last_name,h.start_date,h.end_date,
       j.job_id,j.job_title,d.department_name
FROM employees e,job_history h,jobs j,departments d
WHERE h.employee_id=e.employee_id
AND   h.job_id=j.job_id
AND   h.department_id=d.department_id;

--查询员工编号，姓名，工资，工资级别(非等值连接)
SELECT e.employee_id,e.last_name,e.salary,
       g.grade_level 
FROM employees e,job_grades g
WHERE e.salary BETWEEN g.lowest_sal AND g.highest_sal
ORDER BY e.employee_id;

--内连接：仅返回满足连接条件的结果
--外连接：查询返回满足连接条件的结果，不满足连接条件的也返回
--自连接：把一个表看成两个表，自己连接自己

--查询每个员工编号，姓名，部门编号，部门名称（外连接，没有部门的员工也返回）
SELECT e.employee_id,e.last_name,d.department_id,d.department_name
FROM   departments d,employees e
WHERE  e.department_id=d.department_id(+);

--查询每个员工编号，姓名，部门编号，部门名称（外连接，没有员工的部门也返回）
SELECT e.employee_id,e.last_name,d.department_id,d.department_name
FROM   departments d,employees e
WHERE  e.department_id(+)=d.department_id;

--查询每个员工编号，姓名，部门编号，部门名称，职务名称，部门所在的城市（外连接，没有部门的员工也返回）
SELECT e.employee_id,e.last_name,d.department_id,d.department_name,l.city,j.job_title
FROM   departments d,employees e,locations l,jobs j
WHERE  e.department_id=d.department_id(+)
AND    d.location_id=l.location_id(+)
AND    e.job_id=j.job_id(+);

--查询员工编号，姓名，上级编号，上级姓名（自连接）
SELECT e.employee_id,e.last_name,m.employee_id,m.last_name
FROM   employees e,employees m
WHERE  e.manager_id=m.employee_id(+);

--SQL1999连接查询语法

--内连接：inner join 
--外连接：
          --左外连接 left outer join
          --右外连接 right outer join
          --满外连接 full outer join

--查询每个员工编号，姓名，部门编号，部门名称，职务编号，职务名称
SELECT e.employee_id,e.last_name,d.department_id,d.department_name,
       j.job_id,j.job_title
FROM employees e
INNER JOIN departments d ON e.department_id=d.department_id
INNER JOIN jobs j ON e.job_id=j.job_id
WHERE e.salary>=5000
ORDER BY d.department_id;

--查询每个员工编号，姓名，部门编号，部门名称
SELECT e.employee_id,e.last_name,d.department_id,d.department_name       
FROM employees e 
LEFT OUTER JOIN departments d ON e.department_id=d.department_id;

--查询每个员工编号，姓名，部门编号，部门名称
SELECT e.employee_id,e.last_name,d.department_id,d.department_name       
FROM employees e 
RIGHT OUTER JOIN departments d ON e.department_id=d.department_id;

--查询每个员工编号，姓名，部门编号，部门名称
SELECT e.employee_id,e.last_name,d.department_id,d.department_name       
FROM employees e 
FULL OUTER JOIN departments d ON e.department_id=d.department_id;

/*
查询员工编号，姓名，工资，上级编号，上级姓名，部门编号，部门名称，部门经理编号，部门经理姓名
职务编号，职务名称，部门所在的城市，所在国家，所在地区
返回所有员工
*/
SELECT e.employee_id,e.last_name,e.salary,m.employee_id mgr_id,m.last_name mgr_name
       ,d.department_id,d.department_name,dm.employee_id dm_id,dm.last_name dm_name
       ,j.job_id,j.job_title,l.location_id,l.city,l.state_province,c.country_name,
       r.region_name
FROM   employees e,employees m,employees dm,departments d,jobs j,locations l,countries c,regions r
WHERE  e.manager_id=m.employee_id(+)
AND    d.manager_id=dm.employee_id(+)
AND    d.department_id(+)=e.department_id
AND    e.job_id=j.job_id
AND    d.location_id=l.location_id(+)
AND    l.country_id=c.country_id(+)
AND    c.region_id=r.region_id(+);

--查询所有工资比Abel高的员工（编号，姓名，工资）
SELECT e.employee_id 编号,
       e.last_name   姓名,
       e.salary      工资
FROM   employees e,
       employees m
WHERE  e.salary > m.salary
AND    m.last_name = 'Abel';

--查询所有是合著的书的作者1，作者2，合著书号
/*
tom  king  1001
jack john  1002
tom  tom   1001  错误
king tom   1001  错误
*/
SELECT b1.author,b2.author,b1.book
FROM books b1,books b2
WHERE b1.book=b2.book
AND   b1.author<b2.author;