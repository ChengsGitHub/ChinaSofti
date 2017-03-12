--RDBMS����ϵ�����ݿ����ϵͳ��

--��ͱ�֮������ֹ�ϵ��
--һ�Զࣺ�����һ����¼ƥ��ӱ��еĶ�����¼
--һ��һ�������һ����¼��ƥ��ӱ��һ����¼
--��Զࣺһ����Ķ�����¼ƥ����һ����Ķ�����¼��ʵ���϶���������һ�Զ��ϵ����γɣ�

--���ݿ��������ʽ��
/*
1.�κ��ж������ٷָ�
2.ÿһ����¼�������ɲ����ظ��ı�ʶ��������
3.�ڴӱ��в���Ҫ�������õ������������֮�����
*/

--SQL1992��׼�ı����Ӳ�ѯ�﷨

--��ѯÿ��Ա����ţ���������������(�ѿ�����)
SELECT employee_id,last_name,department_name
FROM   departments,employees;

--��ѯÿ��Ա����ţ���������������
SELECT employee_id,last_name,department_name
FROM   departments,employees
WHERE  employees.department_id=departments.department_id;

--��ѯÿ��Ա����ţ����������ű�ţ���������
SELECT employee_id,last_name,departments.department_id,department_name
FROM   departments,employees
WHERE  employees.department_id=departments.department_id;

--��ѯÿ��Ա����ţ����������ű�ţ��������ƣ������������ǰ׺�������Ч�ʣ�
SELECT e.employee_id,e.last_name,d.department_id,d.department_name
FROM   departments d,employees e
WHERE  e.department_id=d.department_id;

--��ѯÿ��Ա����ţ����������ű�ţ��������ƣ�ְ���ţ�ְ������
SELECT e.employee_id,e.last_name,e.salary,d.department_id,d.department_name,
       j.job_id,j.job_title
FROM   departments d,employees e,jobs j
WHERE  e.department_id=d.department_id
AND    e.job_id=j.job_id
AND    e.salary>5000
ORDER BY e.salary DESC;

--��ѯÿ�����ŵĲ��ű�ţ��������ƣ����ž�������������ŵ�ַ��ţ��������ڵĳ������ƣ�����
--�������ƣ���������
SELECT d.department_id,d.department_name,e.last_name mgr_name,
       l.location_id,l.city,l.state_province,c.country_name,
       r.region_name
FROM  departments d,employees e,locations l,countries c,regions r
WHERE d.manager_id=e.employee_id
AND   d.location_id=l.location_id
AND   l.country_id=c.country_id
AND   c.region_id=r.region_id;

--��ѯԱ��ְ������¼��Ա����ţ���������ʼ���ڣ���ֹ���ڣ�ְ�����ƣ����ڲ�������
SELECT e.employee_id,e.last_name,h.start_date,h.end_date,
       j.job_id,j.job_title,d.department_name
FROM employees e,job_history h,jobs j,departments d
WHERE h.employee_id=e.employee_id
AND   h.job_id=j.job_id
AND   h.department_id=d.department_id;

--��ѯԱ����ţ����������ʣ����ʼ���(�ǵ�ֵ����)
SELECT e.employee_id,e.last_name,e.salary,
       g.grade_level 
FROM employees e,job_grades g
WHERE e.salary BETWEEN g.lowest_sal AND g.highest_sal
ORDER BY e.employee_id;

--�����ӣ��������������������Ľ��
--�����ӣ���ѯ�����������������Ľ��������������������Ҳ����
--�����ӣ���һ�������������Լ������Լ�

--��ѯÿ��Ա����ţ����������ű�ţ��������ƣ������ӣ�û�в��ŵ�Ա��Ҳ���أ�
SELECT e.employee_id,e.last_name,d.department_id,d.department_name
FROM   departments d,employees e
WHERE  e.department_id=d.department_id(+);

--��ѯÿ��Ա����ţ����������ű�ţ��������ƣ������ӣ�û��Ա���Ĳ���Ҳ���أ�
SELECT e.employee_id,e.last_name,d.department_id,d.department_name
FROM   departments d,employees e
WHERE  e.department_id(+)=d.department_id;

--��ѯÿ��Ա����ţ����������ű�ţ��������ƣ�ְ�����ƣ��������ڵĳ��У������ӣ�û�в��ŵ�Ա��Ҳ���أ�
SELECT e.employee_id,e.last_name,d.department_id,d.department_name,l.city,j.job_title
FROM   departments d,employees e,locations l,jobs j
WHERE  e.department_id=d.department_id(+)
AND    d.location_id=l.location_id(+)
AND    e.job_id=j.job_id(+);

--��ѯԱ����ţ��������ϼ���ţ��ϼ������������ӣ�
SELECT e.employee_id,e.last_name,m.employee_id,m.last_name
FROM   employees e,employees m
WHERE  e.manager_id=m.employee_id(+);

--SQL1999���Ӳ�ѯ�﷨

--�����ӣ�inner join 
--�����ӣ�
          --�������� left outer join
          --�������� right outer join
          --�������� full outer join

--��ѯÿ��Ա����ţ����������ű�ţ��������ƣ�ְ���ţ�ְ������
SELECT e.employee_id,e.last_name,d.department_id,d.department_name,
       j.job_id,j.job_title
FROM employees e
INNER JOIN departments d ON e.department_id=d.department_id
INNER JOIN jobs j ON e.job_id=j.job_id
WHERE e.salary>=5000
ORDER BY d.department_id;

--��ѯÿ��Ա����ţ����������ű�ţ���������
SELECT e.employee_id,e.last_name,d.department_id,d.department_name       
FROM employees e 
LEFT OUTER JOIN departments d ON e.department_id=d.department_id;

--��ѯÿ��Ա����ţ����������ű�ţ���������
SELECT e.employee_id,e.last_name,d.department_id,d.department_name       
FROM employees e 
RIGHT OUTER JOIN departments d ON e.department_id=d.department_id;

--��ѯÿ��Ա����ţ����������ű�ţ���������
SELECT e.employee_id,e.last_name,d.department_id,d.department_name       
FROM employees e 
FULL OUTER JOIN departments d ON e.department_id=d.department_id;

/*
��ѯԱ����ţ����������ʣ��ϼ���ţ��ϼ����������ű�ţ��������ƣ����ž����ţ����ž�������
ְ���ţ�ְ�����ƣ��������ڵĳ��У����ڹ��ң����ڵ���
��������Ա��
*/
SELECT e.employee_id,e.last_name,e.salary,m.employee_id mgr_id,m.last_name mgr_name
       ,d.department_id,d.department_name,dm.employee_id dm_id,dm.last_name dm_name
       ,j.job_id,j.job_title,l.location_id,l.city,l.state_province,c.country_name,
       r.region_name
FROM   employees e,employees m,employees dm,departments d,jobs j,locations l,countries c,regions r
WHERE  e.manager_id=m.employee_id(+)
AND    d.manager_id=dm.employee_id(+)
AND    d.department_id(+)=e.department_id
AND    e.job_id=j.job_id
AND    d.location_id=l.location_id(+)
AND    l.country_id=c.country_id(+)
AND    c.region_id=r.region_id(+);

--��ѯ���й��ʱ�Abel�ߵ�Ա������ţ����������ʣ�
SELECT e.employee_id ���,
       e.last_name   ����,
       e.salary      ����
FROM   employees e,
       employees m
WHERE  e.salary > m.salary
AND    m.last_name = 'Abel';

--��ѯ�����Ǻ������������1������2���������
/*
tom  king  1001
jack john  1002
tom  tom   1001  ����
king tom   1001  ����
*/
SELECT b1.author,b2.author,b1.book
FROM books b1,books b2
WHERE b1.book=b2.book
AND   b1.author<b2.author;