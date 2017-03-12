--查询从上到下结构
SELECT LEVEL,e.employee_id,e.last_name,e.manager_id
FROM employees e
START WITH employee_id=101
CONNECT BY PRIOR employee_id=manager_id;

--查询从下到上结构
SELECT LEVEL,e.employee_id,e.last_name,e.manager_id
FROM employees e
START WITH employee_id=206
CONNECT BY PRIOR manager_id=employee_id;

--留言板
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
诸位大神，请问西安路坐什么车？

   202路直接到
   
   404路直接到
      404路不到西安路！！
         你最好查一查最新的路线图
         
我女朋友要和我分手，怎么办？
   去死
   跳楼
       跳楼太高，可以喝毒药
*/