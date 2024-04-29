CREATE DATABASE exercice1jdbc;

USE exercice1jdbc;

CREATE TABLE student (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  class_number INT,
  date_degree DATE
);
select * from student;