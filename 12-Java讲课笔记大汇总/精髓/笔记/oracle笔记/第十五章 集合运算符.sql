--�������㣺�Ѷ����ѯ�������Ϊһ�����

--������1
CREATE TABLE set1
(
  id          NUMBER,
  name       VARCHAR2(50)
);

--������2
CREATE TABLE set2
(
  id          NUMBER,
  name       VARCHAR2(50)
);

--����union
SELECT id,name FROM set1
UNION
SELECT id,name FROM set2;

--����union all
SELECT id,name FROM set1
UNION ALL
SELECT id,name FROM set2
UNION ALL
SELECT id,name FROM set2;

--����intersect
SELECT id,name FROM set1
INTERSECT
SELECT id,name FROM set2;

--����minus
SELECT id,name FROM set1
MINUS
SELECT id,name FROM set2;