--��ͼ�����ñ����ѯ�����������ͼ�������ѯ��䣬���������ݱ�����һ�������

/*
CREATE [OR REPLACE] VIEW ��ͼ����
AS
��ѯ���

�����ѯ������������м����У����������
*/

--��ѯԱ����ţ����������ʣ�����Ϊ��ͼ
CREATE OR REPLACE VIEW v_emp
AS
SELECT employee_id,last_name,salary
FROM   employees;

--ɾ����ͼ
DROP VIEW v_emp;

--��ѯ��ͼ
SELECT *
FROM   v_emp;

--������ͼv_dept������ÿ�����ŵı�ţ��������ƣ��������������Ź����ܺ�
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

--��ѯ����������3�˵Ĳ���
SELECT * FROM v_dept WHERE emp_count>=3;

--ֻ����ͼ
CREATE OR REPLACE VIEW v_emp
AS
SELECT employee_id,last_name,salary
FROM   employees
WITH READ ONLY;