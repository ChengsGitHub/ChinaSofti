--单行函数：传入一行列值，返回一个结果
SELECT last_name,lower(last_name),upper(last_name) FROM employees;

--多行函数：传入多行列值，返回一个结果
SELECT count(last_name) FROM employees;

--字符型函数：
SELECT length('abcdefg') FROM dual;--字符长度
SELECT substr('abcdefg',3) FROM dual;--截取字符串cdefg
SELECT substr('abcdefg',3,3) FROM dual;--从第3位开始，截取3个
SELECT instr('abcdefg','cd') FROM dual;--3，查找字符串下标，如果没有返回0
SELECT instr('abcdefgabcdefg','cd',4) FROM dual;--从第4位开始查找
SELECT instr('abcdefgabcdefg','cd',1,2) FROM dual;--从左边第一位查找第2次出现的cd的位置
SELECT instr('abcdefgabcdefg','cd',-1) FROM dual;--起始位置如果是负数，则从右向左查找

--数字型函数：
SELECT round(3.7465,2) FROM dual;--3.75四舍五入
SELECT trunc(3.7465,2) FROM dual;--3.74 截断
SELECT floor(-3.7465) FROM dual;-- -4 不大于本身的最大整数
SELECT mod(100,3) FROM dual; --1求模

--日期型函数：
SELECT sysdate FROM dual;--当前系统时间

--日期运算：两个日期相减返回的两个日期间隔的天数
SELECT sysdate-hire_date FROM employees;

--日期运算：两个日期相减返回的两个日期间隔的月数
SELECT hire_date,months_between(sysdate,hire_date) FROM employees;

--（类型）转换函数：
--to_char(日期，模式)：按照指定模式把一个日期格式化为字符串
SELECT 'now=' || to_char(sysdate,'yyyy-mm-dd') FROM dual;
SELECT 'now=' || to_char(sysdate,'mm/dd/yyyy') FROM dual;
SELECT 'now=' || to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') FROM dual;
SELECT 'now=' || to_char(sysdate,'mm/dd/yyyy d') FROM dual;--d代表数字星期几 1~7代表日~六

--to_date(字符串，模式)：按照指定模式把一个字符串解析为日期
--查询在1990年以前入职的员工
SELECT * 
FROM   employees
WHERE  hire_date<to_date('1990-1-1','yyyy-mm-dd');

--通用函数
--nvl(参数1，参数2)：如果参数1不为空，那么返回参数1，否则返回参数2
SELECT nvl(1,2) FROM dual;--1
SELECT nvl(null,2) FROM dual;--2

--nvl2(参数1，参数2，参数3)：如果参数1不为空，返回参数2，否则返回参数3
SELECT nvl2(1,2,3) FROM dual;--2
SELECT nvl2(null,2,3) FROM dual;--3

--decode(表达式,值1，返回值1，值2，返回值2，……，……[，默认返回值])
/*
部门编号
50 NEC
60 GE
80 HSW
90 USO
其他 ICSS
*/
SELECT employee_id,last_name,salary,department_id,
       decode(department_id,50,'NEC',60,'GE',80,'HSW',90,'USO','ICSS') 部门名称
FROM   employees;

--非等值条件比较：case 表达式
/*
case
    when 条件1 then 返回值1
    when 条件2 then 返回值2
    ……
    [else 默认返回值]
end
*/

/*
工资
>=15000 A
>=8000  B
>=4000  C
<4000   D
*/
SELECT employee_id,last_name,salary,
       case
           when salary>=15000 then 'A'
           when salary>=8000 then 'B'
           when salary>=4000 then 'C'
           else 'D'
       end AS 工资级别
FROM   employees;


--1.查询last_name超过4个字符的员工
SELECT *
FROM employees
WHERE length(last_name)>4;

--2.查询last_name包含en的员工（不用like实现）
SELECT *
FROM   employees
WHERE  instr(last_name,'en')<>0;

--3.查询电话号码中至少包含4个'4'的员工
SELECT *
FROM employees
WHERE instr(phone_number,'4',1,4)<>0;

--4.查询last_name以s结尾的员工（不用like实现）
SELECT *
FROM employees
WHERE instr(last_name,'s',-1)= length(last_name);
--
SELECT *
FROM employees
WHERE substr(last_name,length(last_name))='s';
--
SELECT *
FROM employees
WHERE substr(last_name,-1)='s';

--5.查询工龄超过15年的员工
SELECT *
FROM employees
WHERE months_between(sysdate,hire_date)/12>=15;

--6.查询所有是17号入职的员工
SELECT *
FROM employees
WHERE to_char(hire_date,'dd')=17;

--7.查询入职日期是入职当月的第一个星期三的员工
SELECT *
FROM employees
WHERE to_char(hire_date,'d')=4
AND   to_char(hire_date,'dd')<=7;

--8.查询7月或8月入职的员工
SELECT *
FROM employees
WHERE to_char(hire_date,'mm') IN (7,8); 

--9.查询员工编号，姓名，工资，奖金金额，实发工资（工资+奖金）
SELECT employee_id,last_name,salary,salary*nvl(commission_pct,0) AS comm,
       salary + salary*nvl(commission_pct,0) AS money
FROM  employees;

--10.查询10,20号和没有部门的员工（不用IS NULL 和IS NOT NULL）
SELECT last_name,department_id
FROM  employees
WHERE nvl(department_id,0) IN (10,20,0);

/*
11.查询员工编号，姓名，入职日期，入职级别
90以前  开国功臣
90~94   资深元老
95~99   普通员工
2000~   新人
*/
SELECT employee_id,last_name,hire_date,  
         case
              when  to_char(hire_date,'yyyy')<1990 then '开国功臣'
              when  to_char(hire_date,'yyyy')<=1994 then '资深元老'
              when  to_char(hire_date,'yyyy')<=1999 then '普通员工'
              else '新人'
         end AS 员工级别
FROM employees;
