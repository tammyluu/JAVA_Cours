CREATE DATABASE gestion_employee;
USE gestion_employee;


CREATE TABLE Employee (
                          id INT PRIMARY KEY AUTO_INCREMENT,  
                          firstName VARCHAR(50) NOT NULL,
                          lastName VARCHAR(50) NOT NULL,
                          departmentId INT NOT NULL,
                          role ENUM('employee', 'RH', 'manager'),  -- Define possible roles as an ENUM
                          FOREIGN KEY (departmentId) REFERENCES Department(id)  
);

INSERT INTO Employee (firstName, lastName, departmentId, role)
VALUES ('John', 'Doe', 1, 'employee');

INSERT INTO Employee (firstName, lastName, departmentId, role)
VALUES ('Jane', 'Smith', 2, 'RH');

INSERT INTO Employee (firstName, lastName, departmentId, role)
VALUES ('Michael', 'Jones', 3, 'manager');

CREATE TABLE Department(
                id            INT PRIMARY KEY AUTO_INCREMENT,
                position_name VARCHAR(255) NOT NULL
);

INSERT INTO Department (position_name)
VALUES ('Manager');

INSERT INTO Department (position_name)
VALUES ('RH');

INSERT INTO Department (position_name)
VALUES ('Employee');

select * from Department;
select * from Employee;
