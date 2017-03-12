/*
组函数：
sum 求和
avg 求平均值
max 求最大值
min 求最小值
count 计数
stddev 方差
*/

--组函数
SELECT sum(salary),avg(salary),max(salary),min(salary),count(salary) 
FROM employees
WHERE department_id=500;

--所有的组函数都忽略空值
SELECT count(commission_pct) FROM employees;

--
SELECT count(*) FROM employees;

--统计没有奖金的人数
SELECT count(*)-count(commission_pct) FROM employees;
SELECT count(*) FROM employees WHERE commission_pct IS NULL;
SELECT sum(nvl2(commission_pct,0,1)) FROM employees;

--统计部门总数（不重复计数）
SELECT count(DISTINCT department_id) FROM employees;

--行数不兼容，错误
--SELECT employee_id,sum(salary) FROM employees;

--分组查询：相同数据为一组，每一组单独执行一个统计计算
--分组查询：查询语句 group by 分组表达式1，分组表达式2，……

--统计每个部门的工资总和，平均工资
SELECT department_id,sum(salary),trunc(avg(salary),2)
FROM   employees
WHERE department_id IS NOT NULL
GROUP BY department_id
ORDER BY 1;

--多个分组表达式
SELECT department_id,job_id,sum(salary)
FROM   employees
GROUP BY department_id,job_id;

--统计每个城市的员工人数（城市名称，人数），显示所有的城市名称
SELECT l.city,
       COUNT(city) AS 人数
FROM   locations   l,
       employees   e,
       departments d
WHERE  l.location_id = d.location_id
AND    e.department_id = d.department_id
GROUP  BY l.city;

--统计每个部门的人数（部门编号，部门名称，人数），显示所有部门
SELECT d.department_id,d.department_name,count(e.employee_id) 人数
FROM departments d,employees e
WHERE e.department_id(+)=d.department_id
GROUP BY d.department_id,d.department_name;

--查询统计每年入职的人数（年份，人数）
/*
1987年  1人
1989年  2人
……    ……
*/
SELECT to_char(hire_date,'yyyy') 年份,count(*) 人数
FROM  employees
GROUP BY to_char(hire_date,'yyyy')
ORDER BY 1;

--查询统计1995,1996,1997三个年份入职的人数
/*
1995  1996  1997
4      3     5
*/
SELECT SUM(case 
            when to_char(e.hire_date,'yyyy')=1995 then 1    
           end    )AS "1995",
       SUM(case
           when to_char(e.hire_date,'yyyy')=1996 then 1
           end   )AS "1996",
       SUM(case
           when to_char(e.hire_date,'yyyy')=1997 then 1
           end   )AS "1997"    
FROM employees e;

--查询统计每个部门的平均工资（保留两位小数）：部门编号，平均工资
--只返回平均工资超过10000的数据
SELECT department_id,avg(salary)
FROM employees
GROUP BY department_id
HAVING avg(salary)>=10000;

--统计每个部门工资超过5000的的人数
SELECT department_id,count(*)
FROM employees
WHERE salary>=5000
GROUP BY department_id;

--WHERE：过滤分组之前的数据
--HAVING：过滤分组之后的数据

--显示平均工资的最大值
SELECT   MAX(AVG(salary))
FROM     employees
GROUP BY department_id;
