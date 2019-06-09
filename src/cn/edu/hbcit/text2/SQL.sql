CREATE DATABASE stuManager DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE stumanager;
DESCRIBE student;
INSERT INTO student
VALUES ('3001', '张三', '2000-05-11', '男', '81', '100', '80'),
       ('3002', '李四', '1998-08-07', '男', '100', '80', '99'),
       ('3003', '王五', '2001-01-08', '男', '90', '77', '60'),
       ('3004', '赵六', '1997-02-09', '女', '50', '80', '100'),
       ('3005', '刘七', '1998-10-02', ' 女', '88', '40', '67');
SELECT * FROM student;
SELECT sum(javascore+sqlscore+cscore) AS '总分' FROM student;
SELECT avg(javascore+sqlscore+cscore) AS '平均分' FROM student;
SELECT * FROM student WHERE sname LIKE "张三";
SELECT * FROM student WHERE javascore<60 OR sqlscore<60 OR cscore<60;