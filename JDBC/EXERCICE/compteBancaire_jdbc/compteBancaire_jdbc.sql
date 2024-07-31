create database compteBancaire_jdbc;
use compteBancaire_jdbc;
-- Table Customer
    CREATE TABLE customer(
        id INT AUTO_INCREMENT PRIMARY KEY ,
        first_name VARCHAR(50) NOT NULL ,
        last_name VARCHAR(50) NOT NULL ,
        phone VARCHAR(10)
    );


-- Table bank account
    CREATE TABLE bank_account (
        id INT AUTO_INCREMENT PRIMARY KEY ,
        total_amount DECIMAL(15,2) DEFAULT 0,
        customer_id INT REFERENCES customer(id)
    );


-- Table operation
CREATE TABLE operation (
        id INT AUTO_INCREMENT PRIMARY KEY ,
        amount DECIMAL(15,2) NOT NULL,
        status VARCHAR(10) NOT NULL,
        account_id INT REFERENCES bank_account(id)
);