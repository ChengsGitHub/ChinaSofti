--集合运算：把多个查询结果整合为一个结果

--创建表1
CREATE TABLE set1
(
  id          NUMBER,
  name       VARCHAR2(50)
);

--创建表2
CREATE TABLE set2
(
  id          NUMBER,
  name       VARCHAR2(50)
);

--并集union
SELECT id,name FROM set1
UNION
SELECT id,name FROM set2;

--并集union all
SELECT id,name FROM set1
UNION ALL
SELECT id,name FROM set2
UNION ALL
SELECT id,name FROM set2;

--交集intersect
SELECT id,name FROM set1
INTERSECT
SELECT id,name FROM set2;

--补集minus
SELECT id,name FROM set1
MINUS
SELECT id,name FROM set2;