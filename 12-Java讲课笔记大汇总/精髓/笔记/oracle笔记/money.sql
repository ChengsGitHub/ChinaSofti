CREATE TABLE money
(
  my_date date,
  in_money number,
  out_money number
);

INSERT INTO money VALUES (to_date('2005-6-7','yyyy-mm-dd'),100,80);
INSERT INTO money VALUES (to_date('2005-6-9','yyyy-mm-dd'),70,50);
INSERT INTO money VALUES (to_date('2005-7-12','yyyy-mm-dd'),120,100);
INSERT INTO money VALUES (to_date('2005-7-22','yyyy-mm-dd'),40,70);

COMMIT;