--子查询：嵌套查询，在查询语句中又包含查询语句，（主查询和子查询，外查询和内查询）
--如果一个功能既可以用连接查询实现，也可以用子查询实现，尽量用连接查询（效率高）

SELECT *
FROM   employees
WHERE  salary > (SELECT salary
                 FROM   employees
                 WHERE  last_name = 'Abel');                 
                 
--查询和149号员工同一个部门的其他员工信息
SELECT *
FROM   employees
WHERE  department_id = (SELECT department_id
                        FROM   employees
                        WHERE  employee_id = 149)
AND    employee_id <> 149;

--查询最低的员工信息
SELECT *
FROM   employees
WHERE  salary = (SELECT MIN(salary)
                 FROM   employees);

--查询比202号员工所在的部门的部门经理的工资还高的员工信息
SELECT *
FROM   employees
WHERE  salary > (SELECT salary
                 FROM   employees
                 WHERE  employee_id =
                        (SELECT manager_id
                         FROM   departments
                         WHERE  department_id =
                                (SELECT department_id
                                 FROM   employees
                                 WHERE  employee_id = 202)));
                                 
/*
子查询出现的位置：
在WHERE或HAVING条件中：单行单列，多行单列
在SELECT列列表中：单行单列
在FROM后：多行多列
在ORDER BY中：单行单列
*/

--
SELECT employee_id,last_name,(SELECT sum(salary) FROM employees) sum_sal
FROM employees;

--查询工资最高的前5名员工数据(TOP N)
SELECT * FROM (SELECT * FROM employees ORDER BY salary DESC) e
WHERE rownum<=5;

--查询员工表的第6到第10条数据
SELECT *
FROM   (SELECT rownum rnum,e.* FROM employees e)
WHERE  rnum BETWEEN 6 AND 10;
--用户输入
SELECT *
FROM   (SELECT rownum rnum,e.* FROM employees e)
WHERE  rnum BETWEEN &start AND &end;

--查询所有是部门经理的员工信息
SELECT *
FROM   employees
WHERE  employee_id IN (SELECT manager_id
                       FROM   departments);
                       
--查询所有不是部门经理的员工信息
SELECT *
FROM   employees
WHERE  employee_id NOT IN (SELECT nvl(manager_id,-1)
                           FROM   departments);
                           
--ANY和ALL必须配合单行比较运算符： >ANY  <ALL
--ANY 逻辑或比较
--ALL 逻辑与比较
SELECT *
FROM   employees
WHERE  salary > ANY (SELECT salary
        FROM   employees
        WHERE  department_id = 60);

SELECT *
FROM   employees
WHERE  salary > ALL (SELECT salary
        FROM   employees
        WHERE  department_id = 60);
        
/*
               标准子查询                      内外交互的相关子查询
执行次数       执行1次                         执行次数=主查询的记录数
执行顺序       子先主后                        主先子后
使用结果       主查询使用子查询结果            子查询和主查询互相使用对方的查询结果
*/
        
--查询每个员工编号，姓名，工资，部门编号，这个员工本部门的工资总额
SELECT e.employee_id,
       e.last_name,
       e.salary,
       e.department_id,
       (SELECT SUM(salary)
        FROM   employees
        WHERE  department_id = e.department_id) 部门工资总和
FROM   employees e

--查询每个部门入职最早但不是部门经理的员工信息
SELECT *
FROM   employees e
WHERE  hire_date = (SELECT MIN(hire_date)
                    FROM   employees
                    WHERE  department_id = e.department_id)
AND    employee_id NOT IN (SELECT nvl(manager_id,-1)
                           FROM   departments);
                           
                           
--exists(子查询)：如果子查询返回有数据，返回真，否则返回假
SELECT *
FROM   employees
WHERE  EXISTS(SELECT 'X' FROM departments);  

--查询所有是部门经理的员工信息
SELECT *
FROM   employees e
WHERE  EXISTS (SELECT 'X' FROM departments WHERE manager_id=e.employee_id);
                

                           
--1.查询部门人数不少于3人的部门信息
SELECT *
FROM   departments
WHERE  department_id IN (SELECT department_id
                         FROM   employees
                         GROUP  BY department_id
                         HAVING COUNT(employee_id) >= 3);

--2.查询员工编号，姓名，工资，部门编号，员工工资所占部门工资总额的百分比
--只返回员工工资高于本部门平均工资的
SELECT e.employee_id,
       e.last_name,
       e.salary,
       e.department_id,
       trunc(e.salary /
             (SELECT SUM(em.salary)
              FROM   employees em
              WHERE  em.department_id = e.department_id) * 100,2) || '%'
FROM   employees e
WHERE  e.salary > (SELECT AVG(salary)
                   FROM   employees
                   WHERE  department_id = e.department_id);
--
SELECT e.employee_id,
       e.last_name,
       e.salary,
       d.department_id,
       trunc(salary / d.sum_sal * 100,2) || '%'
FROM   employees e,
       (SELECT department_id,
               SUM(salary) sum_sal,
               AVG(salary) avg_sal
        FROM   employees
        GROUP  BY department_id) d
WHERE  e.department_id = d.department_id
AND    e.salary>d.avg_sal;

--3.显示平均工资的最高的部门编号和这个部门的平均工资
SELECT department_id,avg(salary)
FROM   employees
GROUP BY department_id
HAVING  avg(salary)= (SELECT MAX(AVG(salary))
                     FROM employees
                     GROUP BY department_id);

--4.查询所有是部门经理的员工信息（连接查询实现）
SELECT e.*
FROM   employees   e,
       departments d
WHERE  e.employee_id = d.manager_id;

--5.查询所有不是部门经理的员工信息（连接查询实现）
SELECT e.*
FROM   employees   e,
       departments d
WHERE  e.department_id = d.department_id(+)
AND    e.employee_id <> nvl(d.manager_id,-1);
--
SELECT e.*
FROM   employees   e,
       departments d
WHERE  e.employee_id = d.manager_id(+)
AND    d.manager_id IS NULL;

--6.查询日期，收入，支出，余额
SELECT x.my_date AS 查询日期,
       x.in_money AS 收入,
       x.out_money AS 支出,
       (SELECT SUM(in_money - out_money)
        FROM  money WHERE my_date<=x.my_date) 余额
FROM    money x;

--删除重复行
CREATE TABLE dept2
AS
SELECT * FROM departments
UNION ALL
SELECT * FROM departments
UNION ALL
SELECT * FROM departments
UNION ALL
SELECT * FROM departments
UNION ALL
SELECT * FROM departments;

--如果相同的department_id的，仅保留其中一行，其他的删除
DELETE FROM dept2 d
WHERE  ROWID <> (SELECT MAX(ROWID)
                 FROM   dept2
                 WHERE  department_id = d.department_id);