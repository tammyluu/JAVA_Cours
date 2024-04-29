CREATE DATABASE jdbc1;

USE jdbc1;

CREATE TABLE etudiant (
id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(200),
last_name VARCHAR(200),
num_class VARCHAR(10),
date_diplome DATE
);
INSERT INTO etudiant (first_name, last_name, num_class, date_diplome  )
values
("Richard"," Clayderman","CL123","1998-12-12"),
("Tammy","Nguyen","CDA1707","2024-08-12"),
("Pierre","Dubois","DWWM01","2022-08-25"),
("Julie","Cartier","BANK17","2021-06-30");
INSERT INTO etudiant (first_name, last_name, num_class, date_diplome  )
values
("Lyli","Lolo","CDA1707","2024-08-12");