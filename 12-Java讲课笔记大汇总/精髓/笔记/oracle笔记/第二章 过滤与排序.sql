--过滤子句：查询语句 where 条件表达式

--查询90号部门的员工
SELECT * 
FROM   employees
WHERE  department_id=90;

--查询工资超过7000的员工
SELECT * 
FROM   employees
WHERE  salary>=7000;

--查询last_name等于King的员工
SELECT * 
FROM   employees
WHERE  last_name='King';

--
SELECT * 
FROM   employees
WHERE  last_name>'King';

--查询在1990年以前入职的员工
SELECT * 
FROM   employees
WHERE  hire_date<'1-1月-90';

--在Oracle中日期类型没有常量，日期时间的字符默认表示法是DD-MON-RR格式

--查询不是50号部门的员工 <> != ^=
SELECT *
FROM   employees
WHERE  department_id<>50;

--包含空值的比较运算结果一定为假

/*查询员工编号，姓名，工资，新工资，别名不能直接参与运算*/
SELECT employee_id,last_name,salary,salary*1.25 AS newsal
FROM   employees
WHERE  salary*1.25>=10000;

--表达式 between 小值 and 大值：专门查询一个范围

--查询工资5000~10000的员工
SELECT *
FROM   employees
WHERE  salary BETWEEN 5000 AND 10000;

--查询工资不是5000~10000的员工
SELECT *
FROM   employees
WHERE  salary NOT BETWEEN 5000 AND 10000;

--表达式 in (值1，值2，……)

--查询10号，20号，50号三个部门的员工
SELECT *
FROM   employees
WHERE  department_id IN (10,20,50);

--查询不是10号，20号，50号三个部门的员工
SELECT *
FROM   employees
WHERE  department_id NOT IN (10,20,50);

--表达式 is null 或者 表达式 is not null
SELECT *
FROM   employees
WHERE  department_id IS NULL;

--
SELECT *
FROM   employees
WHERE  department_id IS NOT NULL;

--like模糊查询： 通配符:%匹配零个到多个任意字符  _匹配一个任意字符

--查询所有last_name以s结尾的员工
SELECT *
FROM   employees
WHERE  last_name LIKE '%s';

--查询email包含EN的员工
SELECT *
FROM   employees
WHERE  email LIKE '%EN%';

--查询last_name以M开头且第三个字母是u的员工
SELECT *
FROM   employees
WHERE  last_name LIKE 'M_u%';

--查询last_name第三个字母是a且a的后面包含en的员工
SELECT *
FROM   employees
WHERE  last_name LIKE '__a%en%';

--查询email倒数第5个字母是R的员工
SELECT *
FROM   employees
WHERE  email LIKE '%R____';

--课后练习：

--工资超过6000且last_name以s结尾的员工
SELECT *
FROM   employees
WHERE  salary>=6000
AND    last_name LIKE '%s';

--查询10号,20号还有没有部门的员工
SELECT *
FROM   employees
WHERE  department_id IN (10,20)
OR     department_id IS NULL;

1.	查询工资大于12000的员工姓名和工资
2.	查询员工号为176的员工的姓名和部门号
3.	选择工资不在5000到12000的员工的姓名和工资
4.	选择雇用时间在1998-02-01到1998-05-01之间的员工姓名，job_id和雇用时间
5.	选择在20或50号部门工作的员工姓名和部门号
6.	选择在1994年雇用的员工的姓名和雇用时间
7.	选择公司中没有管理者的员工姓名及job_id
8.	选择公司中有奖金的员工姓名，工资和奖金级别
9.	选择员工姓名的第三个字母是a的员工姓名
10.	选择姓名中有字母a和e的员工姓名

--查询job_id倒数第6位字母是下划线的员工（通配符本身转义）
SELECT *
FROM   employees
WHERE  job_id LIKE '%\______' escape '\';

--查询last_name等于King's的员工，在字符常量的中单引号必须用两个单引号转义
SELECT *
FROM   employees
WHERE  last_name='King''s';

SELECT 'hello''world' FROM dual;

--排序子句：查询语句 order by 排序表达式1 [asc|desc]，排序表达式2 [asc|desc]，……

--查询员工编号，姓名，工资，新工资（上浮25%）
--按工资降序
SELECT employee_id,last_name,salary,salary*1.25 AS newsal
FROM   employees
ORDER BY salary DESC;
--
SELECT employee_id,last_name,salary,salary*1.25 AS newsal
FROM   employees
ORDER BY newsal DESC;
--
SELECT employee_id,last_name,salary,salary*1.25 AS newsal
FROM   employees
ORDER BY salary*1.25 DESC;
--
SELECT employee_id,last_name,salary,salary*1.25 AS newsal
FROM   employees
ORDER BY 3 DESC;

--查询员工编号，姓名，工资，入职日期，部门编号
--按部门升序，按工资降序，按入职日期升序，按员工编号升序
SELECT employee_id,last_name,salary,hire_date,department_id
FROM   employees
ORDER BY department_id,salary desc,hire_date,employee_id;

--大排序之前一定要做数据库优化！

SELECT e1.last_name FROM employees e1,employees,employees,employees,employees,employees
ORDER BY e1.last_name;

--查询50号部门的员工，按工资降序排列
SELECT *
FROM   employees
WHERE  department_id=50
ORDER BY salary DESC;

--伪列rownum：查询结果行的自动编号
--以下条件 rownum>n  rownum>=n  rownum=1之外的数字  结果一定为假！
SELECT rownum,employee_id,last_name,salary,hire_date,department_id
FROM   employees;

--查询员工表的前5条数据
SELECT rownum,employees.*
FROM   employees
WHERE  rownum<=5;

--查询员工表的第6到第10条数据

--查询工资最高的前5名员工数据(TOP N)

--伪列rowid：行物理地址
SELECT rownum,rowid,employees.*
FROM   employees;