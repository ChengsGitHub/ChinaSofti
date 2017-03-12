--数学运算
SELECT 5+3,100 FROM departments;

--虚表:dual表，用于做输出测试
SELECT 5+3,5-3,5/2,5*2 FROM dual;

/*查询员工编号，姓名，工资，新工资（原始工资上浮25%） 新工资是一个衍生列，计算列*/
SELECT employee_id,last_name,salary,salary*1.25
FROM   employees;

--查询员工编号，姓名，工资，奖金金额，实发工资（工资+奖金）
SELECT employee_id,last_name,salary,salary*commission_pct,
       salary+salary*commission_pct
FROM   employees;

--在Oracle中null和空字符串是等价的，在数据库中字符串常量用单引号括起
--包含空值的数学表达式的结果一定为空
SELECT 5+null-10 FROM dual;
SELECT 5+'' FROM dual;

--给列起别名两种方式：列名 AS 别名   列名 别名
SELECT employee_id AS 编号,last_name,salary,
       salary*commission_pct AS "comm",
       salary+salary*commission_pct "my-money"
FROM   employees;

--双引号的作用：1.强制标识符按原始大小写执行 2.把非法标识符变为可用

-- ||字符串连接符
SELECT 'hello'||'world' FROM dual;
SELECT 'hello'||157 FROM dual;
SELECT 123||157 FROM dual;
SELECT '100'+'50' FROM dual;
SELECT 157||null FROM dual;

--查询消除重复行
SELECT DISTINCT department_id FROM employees;
--
SELECT UNIQUE department_id FROM employees;
--
SELECT department_id FROM employees
GROUP BY department_id;
--
SELECT department_id FROM employees
UNION
SELECT department_id FROM employees;
--
SELECT department_id FROM employees
INTERSECT
SELECT department_id FROM employees;
--
SELECT department_id FROM employees e
WHERE rowid=(SELECT MIN(rowid) FROM employees WHERE nvl(e.department_id,-1)=nvl(department_id,-1));
