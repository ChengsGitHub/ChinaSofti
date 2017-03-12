--��ѧ����
SELECT 5+3,100 FROM departments;

--���:dual���������������
SELECT 5+3,5-3,5/2,5*2 FROM dual;

/*��ѯԱ����ţ����������ʣ��¹��ʣ�ԭʼ�����ϸ�25%�� �¹�����һ�������У�������*/
SELECT employee_id,last_name,salary,salary*1.25
FROM   employees;

--��ѯԱ����ţ����������ʣ������ʵ�����ʣ�����+����
SELECT employee_id,last_name,salary,salary*commission_pct,
       salary+salary*commission_pct
FROM   employees;

--��Oracle��null�Ϳ��ַ����ǵȼ۵ģ������ݿ����ַ��������õ���������
--������ֵ����ѧ���ʽ�Ľ��һ��Ϊ��
SELECT 5+null-10 FROM dual;
SELECT 5+'' FROM dual;

--������������ַ�ʽ������ AS ����   ���� ����
SELECT employee_id AS ���,last_name,salary,
       salary*commission_pct AS "comm",
       salary+salary*commission_pct "my-money"
FROM   employees;

--˫���ŵ����ã�1.ǿ�Ʊ�ʶ����ԭʼ��Сдִ�� 2.�ѷǷ���ʶ����Ϊ����

-- ||�ַ������ӷ�
SELECT 'hello'||'world' FROM dual;
SELECT 'hello'||157 FROM dual;
SELECT 123||157 FROM dual;
SELECT '100'+'50' FROM dual;
SELECT 157||null FROM dual;

--��ѯ�����ظ���
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
