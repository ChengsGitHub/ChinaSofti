--DML���ݲ������ԣ����룬�޸ģ�ɾ������

--�����﷨
--INSERT INTO ���� [(����1������2������)] VALUES (ֵ1��ֵ2������);
--���б�ʡ��Ĭ�Ͼ��Ǳ��е�������
--�к�ֵ���������˳������Ҫ��ͬ

--�����²���
INSERT INTO departments (department_id,department_name,manager_id,location_id)
VALUES (111,'NEC',206,1700);
--
INSERT INTO departments 
VALUES (111,'NEC',206,1700);
--
INSERT INTO departments (department_id,department_name,manager_id)
VALUES (111,'NEC',206);
--
INSERT INTO departments 
VALUES (111,'NEC',206,NULL);

--��ѯ
select * from departments t

--���в��룺INSERT INTO ���� [(����1������2������)] ��ѯ���;

--�Ѳ�ѯ�������ɱ�
CREATE TABLE dept2
AS
SELECT * FROM departments WHERE 1=0;

INSERT INTO dept2 SELECT * FROM departments;

--�������ݣ�UPDATE ���� SET ��1=ֵ����2=ֵ������ [WHERE�Ӿ�]
CREATE TABLE emp2
AS
SELECT * FROM employees;

--��100Ա����������Ϊ����
UPDATE emp2 SET first_name='��',last_name='��' WHERE employee_id=100;

--��50�Ų��ŵ�Ա������ÿ����5��Ǯ
UPDATE emp2 SET salary=salary+5 WHERE department_id=50;

--ɾ�����ݣ�DELETE FROM ���� [WHERE�Ӿ�]

--ɾ��90�Ų��ŵ�Ա��
DELETE FROM emp2 WHERE department_id=90;


--����ACID�ĸ����ԣ�
--ԭ���ԣ��κ����񶼲��ɷָҪôһ��ɹ�ִ�У�Ҫô����ִ��
--һ���ԣ������һ����ȷ��״ֱ̬��ת������һ����ȷ��״̬
--�����ԣ�һ���Ự��������һ���Ựδ�ύ���������
--�־��ԣ�����ύ������ô���������־û������ݿ��У�������������ɻ��ˣ������Ự���Կ�������������

--�ύ�ͻ��˶��������ǰ����
  --�ύ����1.commit 2 ddl��dcl����Զ��ύ���� 3 �����˳��ͻ��˳���
  --��������1.rollback 2 �ͻ��˳����쳣�˳�

--�����������ݵĲ�������
--�������Ȼ��֣��м���  ����

--���ռ�����ʱ������ʽ�����ֶ����� ��ʽ�����Զ�����

--���ռ����ķ�ʽ��
--��������S���������һ����Դ���л�����˹���������ô�����Ự���Ը�ͬһ����ԴҲ�ӹ����������ǲ��ܼӶ�ռ��
--��ռ����X���������һ����Դ���л�����˶�ռ������ô�����Ự���ܸ�ͬһ����Դ���κ���

--�Զ������������
--DML��䣺�ж�ռ����
--DDL��䣺���ռ��
--��ѯ��䣺Ĭ�ϲ����κ���

--�ֶ������������
--��ѯ����������ѯ��� FOR UPDATE; �ж�ռ����
--���ռ����
            --�ֹ�������lock table ���� in share mode; 
            --����������lock table ���� in exclusive mode; 