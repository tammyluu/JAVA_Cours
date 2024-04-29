CREATE DATABASE compteBancaire_jdbc;

USE compteBancaire_jdbc;
CREATE TABLE Client (
    id_Client INT  AUTO_INCREMENT PRIMARY KEY,
    first_Name VARCHAR(50),
    last_Name VARCHAR(50),
    phoneNumber VARCHAR(20)
    
);

CREATE TABLE Operation (
    operation_Num VARCHAR(50) PRIMARY KEY,
    amount DOUBLE,
    status VARCHAR(20),
    id_Account INT,
    FOREIGN KEY (id_Account) REFERENCES Account(id_Account)
);

CREATE TABLE Account (
id_Account INT AUTO_INCREMENT PRIMARY KEY,
 balance DOUBLE,
id_Client INT,
FOREIGN KEY (id_Client) REFERENCES Client(id_Client)

);
/*CREATE TABLE Account_Operation (
    id_Account INT,
    operationNum VARCHAR(50),
    PRIMARY KEY (id_Account, operationNum),
    FOREIGN KEY (id_Account) REFERENCES Account(id_Account),
    FOREIGN KEY (operation_Num) REFERENCES Operation(operation_Num)
);*/

select * from client;