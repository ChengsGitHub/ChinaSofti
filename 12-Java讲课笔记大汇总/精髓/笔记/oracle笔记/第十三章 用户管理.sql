--�������û���������
CREATE USER icss IDENTIFIED BY icss;

--DCL��䣺���ݿ������ԣ���Ҫ����Ȩ����Ȩ���

--��Ȩ���
--GRANT Ȩ��1��Ȩ��2������ TO �û���;

--��Ȩ���
--REVOKE Ȩ��1��Ȩ��2������ FROM �û���;

--�����ỰȨ��
GRANT CREATE SESSION TO icss;

--��ɫroles����Ӧһ��Ȩ��

--���迪����Ա��ɫ
GRANT connect,resource TO icss;

--����Ȩ��
REVOKE connect FROM icss;
REVOKE CREATE SESSION FROM icss;

--�������Ȩ��
--��Ȩ
--GRANT INSERT|UPDATE|DELETE|SELECT|ALL ON ���ݿ������ TO �û���;
--��Ȩ
--REVOKE INSERT|UPDATE|DELETE|SELECT|ALL ON ���ݿ������ FROM �û���;
GRANT SELECT ON scott.employees TO icss;
GRANT ALL ON scott.employees TO icss;

--�޸�����
ALTER USER icss IDENTIFIED BY "123";

--�����û�
ALTER USER icss ACCOUNT UNLOCK;
--�û�����
ALTER USER icss ACCOUNT LOCK;

--���ݿ����ӣ�����һ��Զ�����ݿ�����ӣ�ʹ�������������Զ�����ݿ������
--�������ݿ����ӣ�
--create public database link �������� connect to Զ���û��� identified by Զ������ using '��������';

--����Ա��������
create public database link link_pc19 connect to scott identified by tiger using 'pc19';

--��ͨ�û�ʹ��
CREATE TABLE employees
AS
SELECT * FROM employees@link_pc19;

--ɾ���û�
DROP USER icss CASCADE;