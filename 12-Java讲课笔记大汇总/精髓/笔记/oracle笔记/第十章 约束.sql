/*
����Լ����Լ��DML�����Ա�����ݷ�������
not null���ǿ�
primary key������
unique��Ψһֵ
check�����
foreign key�����������������������Լ����
*/

CREATE TABLE newdept
AS
SELECT * FROM departments;

CREATE TABLE newemp
AS
SELECT * FROM employees;

--�ǿ�Լ��
ALTER TABLE newemp
MODIFY (first_name NOT NULL);
--
ALTER TABLE newemp
MODIFY (first_name NULL);

/*
����Լ����
ALTER TABLE ����
ADD CONSTRAINT Լ������ ����Լ������;

ɾ��Լ����
ALTER TABLE ����
DROP CONSTRAINT Լ������;
*/

--����Լ����������ֵ�������ظ����Ҳ���Ϊ�գ�һ�����������ɶ�����ɣ�����������
--һ����ֻ�ܼ�һ������Լ��
ALTER TABLE newemp
ADD CONSTRAINT newemp_empid_pk PRIMARY KEY (employee_id);

ALTER TABLE newemp
ADD CONSTRAINT newemp_name_pk PRIMARY KEY (first_name,last_name);

--ΨһֵԼ����������ֵ�������ظ������ǲ����ƿ�ֵ��һ��uniqueԼ�������ɶ������
--һ������ԼӶ��UNIQUEԼ��
ALTER TABLE newemp
ADD CONSTRAINT newemp_email_uni UNIQUE (email);

--���Լ���������Զ��������������Կ�ֵ
ALTER TABLE newemp
ADD CONSTRAINT newemp_salary_chk CHECK (salary>=400);

--���Լ�������ƴӱ�������ֵ���������õ������е�������ֵ�������ƿ�ֵ
--ǰ��������ǰ�������õ������е��������Ѿ���������Լ��

ALTER TABLE newdept
ADD CONSTRAINTS newdept_deptid_pk PRIMARY KEY (department_id);

ALTER TABLE newemp
ADD CONSTRAINTS newemp_newdept_deptid_fk FOREIGN KEY (department_id)
REFERENCES newdept (department_id);

--����ɾ����ɾ�����������Զ�ɾ��ƥ��Ĵӱ������
ALTER TABLE newemp
ADD CONSTRAINTS newemp_newdept_deptid_fk FOREIGN KEY (department_id)
REFERENCES newdept (department_id)
ON DELETE CASCADE;

--�����ÿգ�ɾ�����������Զ���ƥ������ֵ����Ϊ��
ALTER TABLE newemp
ADD CONSTRAINTS newemp_newdept_deptid_fk FOREIGN KEY (department_id)
REFERENCES newdept (department_id)
ON DELETE SET NULL;

--�������ͬʱ����Լ��
CREATE TABLE newemp2
(
       emp_id NUMBER(6) PRIMARY KEY,
       emp_name VARCHAR2(50) NOT NULL,
       emp_salary NUMBER(8,2) CHECK (emp_salary>=400),
       dept_id    NUMBER(4) REFERENCES departments (department_id)
);