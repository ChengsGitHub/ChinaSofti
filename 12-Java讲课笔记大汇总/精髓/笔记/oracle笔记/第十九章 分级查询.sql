--��ѯ���ϵ��½ṹ
SELECT LEVEL,e.employee_id,e.last_name,e.manager_id
FROM employees e
START WITH employee_id=101
CONNECT BY PRIOR employee_id=manager_id;

--��ѯ���µ��Ͻṹ
SELECT LEVEL,e.employee_id,e.last_name,e.manager_id
FROM employees e
START WITH employee_id=206
CONNECT BY PRIOR manager_id=employee_id;

--���԰�
CREATE TABLE bbs
(
  bbs_id NUMBER(6) PRIMARY KEY,
  bbs_txt VARCHAR2(1000),
  bbs_answer NUMBER(6)
);

SELECT level,bbs_id,bbs_txt,bbs_answer
FROM   bbs
START WITH bbs_id=6
CONNECT BY PRIOR bbs_id=bbs_answer;


/*
��λ������������·��ʲô����

   202·ֱ�ӵ�
   
   404·ֱ�ӵ�
      404·��������·����
         ����ò�һ�����µ�·��ͼ
         
��Ů����Ҫ���ҷ��֣���ô�죿
   ȥ��
   ��¥
       ��¥̫�ߣ����Ժȶ�ҩ
*/