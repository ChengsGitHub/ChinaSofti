--DDL������ create���޸� alter��ɾ��drop ���ݿ����

--������
/*
CREATE TABLE ����
(
   ����1 �������� [DEFAULT Ĭ��ֵ],
   ����2 �������� [DEFAULT Ĭ��ֵ],
   ����
);
*/

--����ѧ����
CREATE TABLE student
(
sid    NUMBER(6),
sname  VARCHAR2(50),
sex    CHAR(2),
hiredate DATE
);

--ɾ����
DROP TABLE student;

--����ѧ����Ĭ��ֵ��
CREATE TABLE student
(
sid    NUMBER(6),
sname  VARCHAR2(50),
sex    CHAR(2) DEFAULT '��',
hiredate DATE DEFAULT sysdate
);

/*�޸ı�*/

--������
ALTER TABLE student
ADD (phone VARCHAR2(50),address VARCHAR2(100));

--�޸�������
ALTER TABLE student
MODIFY (address VARCHAR2(200));

--ɾ����
ALTER TABLE student
DROP (address);

--�����в�����
ALTER TABLE student
SET UNUSED (phone);

--ɾ����������
ALTER TABLE student
DROP UNUSED COLUMNS;

--��ձ�
TRUNCATE TABLE student;

/*
               DELETE���       TRUNCATE���
               ���Ի���         ���ɻ���
               ���ͷſռ�       �ͷſռ�
               ��¼��־         ����¼��־
*/

--��ѯ����վ�����ֵ�
SELECT * FROM user_recyclebin;

--��ԭ��
FLASHBACK TABLE student TO BEFORE DROP;
FLASHBACK TABLE books TO BEFORE DROP;

--��ջ���վ 
PURGE RECYCLEBIN;

