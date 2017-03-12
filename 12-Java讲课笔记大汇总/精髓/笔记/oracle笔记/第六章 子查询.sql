--�Ӳ�ѯ��Ƕ�ײ�ѯ���ڲ�ѯ������ְ�����ѯ��䣬������ѯ���Ӳ�ѯ�����ѯ���ڲ�ѯ��
--���һ�����ܼȿ��������Ӳ�ѯʵ�֣�Ҳ�������Ӳ�ѯʵ�֣����������Ӳ�ѯ��Ч�ʸߣ�

SELECT *
FROM   employees
WHERE  salary > (SELECT salary
                 FROM   employees
                 WHERE  last_name = 'Abel');                 
                 
--��ѯ��149��Ա��ͬһ�����ŵ�����Ա����Ϣ
SELECT *
FROM   employees
WHERE  department_id = (SELECT department_id
                        FROM   employees
                        WHERE  employee_id = 149)
AND    employee_id <> 149;

--��ѯ��͵�Ա����Ϣ
SELECT *
FROM   employees
WHERE  salary = (SELECT MIN(salary)
                 FROM   employees);

--��ѯ��202��Ա�����ڵĲ��ŵĲ��ž���Ĺ��ʻ��ߵ�Ա����Ϣ
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
�Ӳ�ѯ���ֵ�λ�ã�
��WHERE��HAVING�����У����е��У����е���
��SELECT���б��У����е���
��FROM�󣺶��ж���
��ORDER BY�У����е���
*/

--
SELECT employee_id,last_name,(SELECT sum(salary) FROM employees) sum_sal
FROM employees;

--��ѯ������ߵ�ǰ5��Ա������(TOP N)
SELECT * FROM (SELECT * FROM employees ORDER BY salary DESC) e
WHERE rownum<=5;

--��ѯԱ����ĵ�6����10������
SELECT *
FROM   (SELECT rownum rnum,e.* FROM employees e)
WHERE  rnum BETWEEN 6 AND 10;
--�û�����
SELECT *
FROM   (SELECT rownum rnum,e.* FROM employees e)
WHERE  rnum BETWEEN &start AND &end;

--��ѯ�����ǲ��ž����Ա����Ϣ
SELECT *
FROM   employees
WHERE  employee_id IN (SELECT manager_id
                       FROM   departments);
                       
--��ѯ���в��ǲ��ž����Ա����Ϣ
SELECT *
FROM   employees
WHERE  employee_id NOT IN (SELECT nvl(manager_id,-1)
                           FROM   departments);
                           
--ANY��ALL������ϵ��бȽ�������� >ANY  <ALL
--ANY �߼���Ƚ�
--ALL �߼���Ƚ�
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
               ��׼�Ӳ�ѯ                      ���⽻��������Ӳ�ѯ
ִ�д���       ִ��1��                         ִ�д���=����ѯ�ļ�¼��
ִ��˳��       ��������                        �����Ӻ�
ʹ�ý��       ����ѯʹ���Ӳ�ѯ���            �Ӳ�ѯ������ѯ����ʹ�öԷ��Ĳ�ѯ���
*/
        
--��ѯÿ��Ա����ţ����������ʣ����ű�ţ����Ա�������ŵĹ����ܶ�
SELECT e.employee_id,
       e.last_name,
       e.salary,
       e.department_id,
       (SELECT SUM(salary)
        FROM   employees
        WHERE  department_id = e.department_id) ���Ź����ܺ�
FROM   employees e

--��ѯÿ��������ְ���絫���ǲ��ž����Ա����Ϣ
SELECT *
FROM   employees e
WHERE  hire_date = (SELECT MIN(hire_date)
                    FROM   employees
                    WHERE  department_id = e.department_id)
AND    employee_id NOT IN (SELECT nvl(manager_id,-1)
                           FROM   departments);
                           
                           
--exists(�Ӳ�ѯ)������Ӳ�ѯ���������ݣ������棬���򷵻ؼ�
SELECT *
FROM   employees
WHERE  EXISTS(SELECT 'X' FROM departments);  

--��ѯ�����ǲ��ž����Ա����Ϣ
SELECT *
FROM   employees e
WHERE  EXISTS (SELECT 'X' FROM departments WHERE manager_id=e.employee_id);
                

                           
--1.��ѯ��������������3�˵Ĳ�����Ϣ
SELECT *
FROM   departments
WHERE  department_id IN (SELECT department_id
                         FROM   employees
                         GROUP  BY department_id
                         HAVING COUNT(employee_id) >= 3);

--2.��ѯԱ����ţ����������ʣ����ű�ţ�Ա��������ռ���Ź����ܶ�İٷֱ�
--ֻ����Ա�����ʸ��ڱ�����ƽ�����ʵ�
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

--3.��ʾƽ�����ʵ���ߵĲ��ű�ź�������ŵ�ƽ������
SELECT department_id,avg(salary)
FROM   employees
GROUP BY department_id
HAVING  avg(salary)= (SELECT MAX(AVG(salary))
                     FROM employees
                     GROUP BY department_id);

--4.��ѯ�����ǲ��ž����Ա����Ϣ�����Ӳ�ѯʵ�֣�
SELECT e.*
FROM   employees   e,
       departments d
WHERE  e.employee_id = d.manager_id;

--5.��ѯ���в��ǲ��ž����Ա����Ϣ�����Ӳ�ѯʵ�֣�
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

--6.��ѯ���ڣ����룬֧�������
SELECT x.my_date AS ��ѯ����,
       x.in_money AS ����,
       x.out_money AS ֧��,
       (SELECT SUM(in_money - out_money)
        FROM  money WHERE my_date<=x.my_date) ���
FROM    money x;

--ɾ���ظ���
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

--�����ͬ��department_id�ģ�����������һ�У�������ɾ��
DELETE FROM dept2 d
WHERE  ROWID <> (SELECT MAX(ROWID)
                 FROM   dept2
                 WHERE  department_id = d.department_id);