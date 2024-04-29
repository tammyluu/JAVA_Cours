CREATE DATABASE demo_jdbc;

USE demo_jdbc;

CREATE TABLE person (
id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(200),
last_name VARCHAR(200)
);

-- toto

-- DROP TABLE person;

select * from person;