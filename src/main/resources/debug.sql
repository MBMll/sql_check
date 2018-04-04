CREATE DATABASE IF NOT EXISTS `crm`;
USE crm;

DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  id INT PRIMARY KEY AUTO_INCREMENT
)
  COMMENT 'test table';
SELECT *
FROM test;

SHOW VARIABLES LIKE '%type%';

SHOW SCHEMAS;
SELECT * FROM notnullcolumnmapper;
# 通过 order by 加速 索引列列名加速
SELECT count(id) FROM notnullcolumnmapper;
SELECT count(id) FROM notnullcolumnmapper ORDER BY id;
SELECT count(1) FROM notnullcolumnmapper ORDER BY id;

TRUNCATE notnullcolumnmapper;
DROP TABLE notnullcolumnmapper;