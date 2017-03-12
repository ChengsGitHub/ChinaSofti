--�����Ӿ䣺��ѯ��� where �������ʽ

--��ѯ90�Ų��ŵ�Ա��
SELECT * 
FROM   employees
WHERE  department_id=90;

--��ѯ���ʳ���7000��Ա��
SELECT * 
FROM   employees
WHERE  salary>=7000;

--��ѯlast_name����King��Ա��
SELECT * 
FROM   employees
WHERE  last_name='King';

--
SELECT * 
FROM   employees
WHERE  last_name>'King';

--��ѯ��1990����ǰ��ְ��Ա��
SELECT * 
FROM   employees
WHERE  hire_date<'1-1��-90';

--��Oracle����������û�г���������ʱ����ַ�Ĭ�ϱ�ʾ����DD-MON-RR��ʽ

--��ѯ����50�Ų��ŵ�Ա�� <> != ^=
SELECT *
FROM   employees
WHERE  department_id<>50;

--������ֵ�ıȽ�������һ��Ϊ��

/*��ѯԱ����ţ����������ʣ��¹��ʣ���������ֱ�Ӳ�������*/
SELECT employee_id,last_name,salary,salary*1.25 AS newsal
FROM   employees
WHERE  salary*1.25>=10000;

--���ʽ between Сֵ and ��ֵ��ר�Ų�ѯһ����Χ

--��ѯ����5000~10000��Ա��
SELECT *
FROM   employees
WHERE  salary BETWEEN 5000 AND 10000;

--��ѯ���ʲ���5000~10000��Ա��
SELECT *
FROM   employees
WHERE  salary NOT BETWEEN 5000 AND 10000;

--���ʽ in (ֵ1��ֵ2������)

--��ѯ10�ţ�20�ţ�50���������ŵ�Ա��
SELECT *
FROM   employees
WHERE  department_id IN (10,20,50);

--��ѯ����10�ţ�20�ţ�50���������ŵ�Ա��
SELECT *
FROM   employees
WHERE  department_id NOT IN (10,20,50);

--���ʽ is null ���� ���ʽ is not null
SELECT *
FROM   employees
WHERE  department_id IS NULL;

--
SELECT *
FROM   employees
WHERE  department_id IS NOT NULL;

--likeģ����ѯ�� ͨ���:%ƥ���������������ַ�  _ƥ��һ�������ַ�

--��ѯ����last_name��s��β��Ա��
SELECT *
FROM   employees
WHERE  last_name LIKE '%s';

--��ѯemail����EN��Ա��
SELECT *
FROM   employees
WHERE  email LIKE '%EN%';

--��ѯlast_name��M��ͷ�ҵ�������ĸ��u��Ա��
SELECT *
FROM   employees
WHERE  last_name LIKE 'M_u%';

--��ѯlast_name��������ĸ��a��a�ĺ������en��Ա��
SELECT *
FROM   employees
WHERE  last_name LIKE '__a%en%';

--��ѯemail������5����ĸ��R��Ա��
SELECT *
FROM   employees
WHERE  email LIKE '%R____';

--�κ���ϰ��

--���ʳ���6000��last_name��s��β��Ա��
SELECT *
FROM   employees
WHERE  salary>=6000
AND    last_name LIKE '%s';

--��ѯ10��,20�Ż���û�в��ŵ�Ա��
SELECT *
FROM   employees
WHERE  department_id IN (10,20)
OR     department_id IS NULL;

1.	��ѯ���ʴ���12000��Ա�������͹���
2.	��ѯԱ����Ϊ176��Ա���������Ͳ��ź�
3.	ѡ���ʲ���5000��12000��Ա���������͹���
4.	ѡ�����ʱ����1998-02-01��1998-05-01֮���Ա��������job_id�͹���ʱ��
5.	ѡ����20��50�Ų��Ź�����Ա�������Ͳ��ź�
6.	ѡ����1994����õ�Ա���������͹���ʱ��
7.	ѡ��˾��û�й����ߵ�Ա��������job_id
8.	ѡ��˾���н����Ա�����������ʺͽ��𼶱�
9.	ѡ��Ա�������ĵ�������ĸ��a��Ա������
10.	ѡ������������ĸa��e��Ա������

--��ѯjob_id������6λ��ĸ���»��ߵ�Ա����ͨ�������ת�壩
SELECT *
FROM   employees
WHERE  job_id LIKE '%\______' escape '\';

--��ѯlast_name����King's��Ա�������ַ��������е����ű���������������ת��
SELECT *
FROM   employees
WHERE  last_name='King''s';

SELECT 'hello''world' FROM dual;

--�����Ӿ䣺��ѯ��� order by ������ʽ1 [asc|desc]��������ʽ2 [asc|desc]������

--��ѯԱ����ţ����������ʣ��¹��ʣ��ϸ�25%��
--�����ʽ���
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

--��ѯԱ����ţ����������ʣ���ְ���ڣ����ű��
--���������򣬰����ʽ��򣬰���ְ�������򣬰�Ա���������
SELECT employee_id,last_name,salary,hire_date,department_id
FROM   employees
ORDER BY department_id,salary desc,hire_date,employee_id;

--������֮ǰһ��Ҫ�����ݿ��Ż���

SELECT e1.last_name FROM employees e1,employees,employees,employees,employees,employees
ORDER BY e1.last_name;

--��ѯ50�Ų��ŵ�Ա���������ʽ�������
SELECT *
FROM   employees
WHERE  department_id=50
ORDER BY salary DESC;

--α��rownum����ѯ����е��Զ����
--�������� rownum>n  rownum>=n  rownum=1֮�������  ���һ��Ϊ�٣�
SELECT rownum,employee_id,last_name,salary,hire_date,department_id
FROM   employees;

--��ѯԱ�����ǰ5������
SELECT rownum,employees.*
FROM   employees
WHERE  rownum<=5;

--��ѯԱ����ĵ�6����10������

--��ѯ������ߵ�ǰ5��Ա������(TOP N)

--α��rowid���������ַ
SELECT rownum,rowid,employees.*
FROM   employees;