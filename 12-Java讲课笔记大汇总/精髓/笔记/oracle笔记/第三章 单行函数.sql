--���к���������һ����ֵ������һ�����
SELECT last_name,lower(last_name),upper(last_name) FROM employees;

--���к��������������ֵ������һ�����
SELECT count(last_name) FROM employees;

--�ַ��ͺ�����
SELECT length('abcdefg') FROM dual;--�ַ�����
SELECT substr('abcdefg',3) FROM dual;--��ȡ�ַ���cdefg
SELECT substr('abcdefg',3,3) FROM dual;--�ӵ�3λ��ʼ����ȡ3��
SELECT instr('abcdefg','cd') FROM dual;--3�������ַ����±꣬���û�з���0
SELECT instr('abcdefgabcdefg','cd',4) FROM dual;--�ӵ�4λ��ʼ����
SELECT instr('abcdefgabcdefg','cd',1,2) FROM dual;--����ߵ�һλ���ҵ�2�γ��ֵ�cd��λ��
SELECT instr('abcdefgabcdefg','cd',-1) FROM dual;--��ʼλ������Ǹ�����������������

--�����ͺ�����
SELECT round(3.7465,2) FROM dual;--3.75��������
SELECT trunc(3.7465,2) FROM dual;--3.74 �ض�
SELECT floor(-3.7465) FROM dual;-- -4 �����ڱ�����������
SELECT mod(100,3) FROM dual; --1��ģ

--�����ͺ�����
SELECT sysdate FROM dual;--��ǰϵͳʱ��

--�������㣺��������������ص��������ڼ��������
SELECT sysdate-hire_date FROM employees;

--�������㣺��������������ص��������ڼ��������
SELECT hire_date,months_between(sysdate,hire_date) FROM employees;

--�����ͣ�ת��������
--to_char(���ڣ�ģʽ)������ָ��ģʽ��һ�����ڸ�ʽ��Ϊ�ַ���
SELECT 'now=' || to_char(sysdate,'yyyy-mm-dd') FROM dual;
SELECT 'now=' || to_char(sysdate,'mm/dd/yyyy') FROM dual;
SELECT 'now=' || to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') FROM dual;
SELECT 'now=' || to_char(sysdate,'mm/dd/yyyy d') FROM dual;--d�����������ڼ� 1~7������~��

--to_date(�ַ�����ģʽ)������ָ��ģʽ��һ���ַ�������Ϊ����
--��ѯ��1990����ǰ��ְ��Ա��
SELECT * 
FROM   employees
WHERE  hire_date<to_date('1990-1-1','yyyy-mm-dd');

--ͨ�ú���
--nvl(����1������2)���������1��Ϊ�գ���ô���ز���1�����򷵻ز���2
SELECT nvl(1,2) FROM dual;--1
SELECT nvl(null,2) FROM dual;--2

--nvl2(����1������2������3)���������1��Ϊ�գ����ز���2�����򷵻ز���3
SELECT nvl2(1,2,3) FROM dual;--2
SELECT nvl2(null,2,3) FROM dual;--3

--decode(���ʽ,ֵ1������ֵ1��ֵ2������ֵ2������������[��Ĭ�Ϸ���ֵ])
/*
���ű��
50 NEC
60 GE
80 HSW
90 USO
���� ICSS
*/
SELECT employee_id,last_name,salary,department_id,
       decode(department_id,50,'NEC',60,'GE',80,'HSW',90,'USO','ICSS') ��������
FROM   employees;

--�ǵ�ֵ�����Ƚϣ�case ���ʽ
/*
case
    when ����1 then ����ֵ1
    when ����2 then ����ֵ2
    ����
    [else Ĭ�Ϸ���ֵ]
end
*/

/*
����
>=15000 A
>=8000  B
>=4000  C
<4000   D
*/
SELECT employee_id,last_name,salary,
       case
           when salary>=15000 then 'A'
           when salary>=8000 then 'B'
           when salary>=4000 then 'C'
           else 'D'
       end AS ���ʼ���
FROM   employees;


--1.��ѯlast_name����4���ַ���Ա��
SELECT *
FROM employees
WHERE length(last_name)>4;

--2.��ѯlast_name����en��Ա��������likeʵ�֣�
SELECT *
FROM   employees
WHERE  instr(last_name,'en')<>0;

--3.��ѯ�绰���������ٰ���4��'4'��Ա��
SELECT *
FROM employees
WHERE instr(phone_number,'4',1,4)<>0;

--4.��ѯlast_name��s��β��Ա��������likeʵ�֣�
SELECT *
FROM employees
WHERE instr(last_name,'s',-1)= length(last_name);
--
SELECT *
FROM employees
WHERE substr(last_name,length(last_name))='s';
--
SELECT *
FROM employees
WHERE substr(last_name,-1)='s';

--5.��ѯ���䳬��15���Ա��
SELECT *
FROM employees
WHERE months_between(sysdate,hire_date)/12>=15;

--6.��ѯ������17����ְ��Ա��
SELECT *
FROM employees
WHERE to_char(hire_date,'dd')=17;

--7.��ѯ��ְ��������ְ���µĵ�һ����������Ա��
SELECT *
FROM employees
WHERE to_char(hire_date,'d')=4
AND   to_char(hire_date,'dd')<=7;

--8.��ѯ7�»�8����ְ��Ա��
SELECT *
FROM employees
WHERE to_char(hire_date,'mm') IN (7,8); 

--9.��ѯԱ����ţ����������ʣ������ʵ�����ʣ�����+����
SELECT employee_id,last_name,salary,salary*nvl(commission_pct,0) AS comm,
       salary + salary*nvl(commission_pct,0) AS money
FROM  employees;

--10.��ѯ10,20�ź�û�в��ŵ�Ա��������IS NULL ��IS NOT NULL��
SELECT last_name,department_id
FROM  employees
WHERE nvl(department_id,0) IN (10,20,0);

/*
11.��ѯԱ����ţ���������ְ���ڣ���ְ����
90��ǰ  ��������
90~94   ����Ԫ��
95~99   ��ͨԱ��
2000~   ����
*/
SELECT employee_id,last_name,hire_date,  
         case
              when  to_char(hire_date,'yyyy')<1990 then '��������'
              when  to_char(hire_date,'yyyy')<=1994 then '����Ԫ��'
              when  to_char(hire_date,'yyyy')<=1999 then '��ͨԱ��'
              else '����'
         end AS Ա������
FROM employees;
