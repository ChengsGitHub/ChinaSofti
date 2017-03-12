/*
�麯����
sum ���
avg ��ƽ��ֵ
max �����ֵ
min ����Сֵ
count ����
stddev ����
*/

--�麯��
SELECT sum(salary),avg(salary),max(salary),min(salary),count(salary) 
FROM employees
WHERE department_id=500;

--���е��麯�������Կ�ֵ
SELECT count(commission_pct) FROM employees;

--
SELECT count(*) FROM employees;

--ͳ��û�н��������
SELECT count(*)-count(commission_pct) FROM employees;
SELECT count(*) FROM employees WHERE commission_pct IS NULL;
SELECT sum(nvl2(commission_pct,0,1)) FROM employees;

--ͳ�Ʋ������������ظ�������
SELECT count(DISTINCT department_id) FROM employees;

--���������ݣ�����
--SELECT employee_id,sum(salary) FROM employees;

--�����ѯ����ͬ����Ϊһ�飬ÿһ�鵥��ִ��һ��ͳ�Ƽ���
--�����ѯ����ѯ��� group by ������ʽ1��������ʽ2������

--ͳ��ÿ�����ŵĹ����ܺͣ�ƽ������
SELECT department_id,sum(salary),trunc(avg(salary),2)
FROM   employees
WHERE department_id IS NOT NULL
GROUP BY department_id
ORDER BY 1;

--���������ʽ
SELECT department_id,job_id,sum(salary)
FROM   employees
GROUP BY department_id,job_id;

--ͳ��ÿ�����е�Ա���������������ƣ�����������ʾ���еĳ�������
SELECT l.city,
       COUNT(city) AS ����
FROM   locations   l,
       employees   e,
       departments d
WHERE  l.location_id = d.location_id
AND    e.department_id = d.department_id
GROUP  BY l.city;

--ͳ��ÿ�����ŵ����������ű�ţ��������ƣ�����������ʾ���в���
SELECT d.department_id,d.department_name,count(e.employee_id) ����
FROM departments d,employees e
WHERE e.department_id(+)=d.department_id
GROUP BY d.department_id,d.department_name;

--��ѯͳ��ÿ����ְ����������ݣ�������
/*
1987��  1��
1989��  2��
����    ����
*/
SELECT to_char(hire_date,'yyyy') ���,count(*) ����
FROM  employees
GROUP BY to_char(hire_date,'yyyy')
ORDER BY 1;

--��ѯͳ��1995,1996,1997���������ְ������
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

--��ѯͳ��ÿ�����ŵ�ƽ�����ʣ�������λС���������ű�ţ�ƽ������
--ֻ����ƽ�����ʳ���10000������
SELECT department_id,avg(salary)
FROM employees
GROUP BY department_id
HAVING avg(salary)>=10000;

--ͳ��ÿ�����Ź��ʳ���5000�ĵ�����
SELECT department_id,count(*)
FROM employees
WHERE salary>=5000
GROUP BY department_id;

--WHERE�����˷���֮ǰ������
--HAVING�����˷���֮�������

--��ʾƽ�����ʵ����ֵ
SELECT   MAX(AVG(salary))
FROM     employees
GROUP BY department_id;
