--�����û�
create user hb identified by hb;
--���迪��Ȩ��
grant connect,resource to hb;

--����Ա����
create table emp
(
    emp_id           number(6) primary key, 
    emp_name         varchar2(50),
    emp_salary       number(6),
    emp_hiredate     date    
);

--��Ʒ��
create table product
(
   prod_id number(6) primary key,
   prod_name varchar2(50),
   prod_price number(6,2)
);

--��������
create sequence emp_seq start with 100;

--���������ĳɼ���
CREATE TABLE score
(
    sid NUMBER(6),
    cid NUMBER(6),
    result NUMBER(3),
    CONSTRAINTS score_id_pk PRIMARY KEY (sid,cid)
);