CREATE DATABASE billetterie;

USE billetterie;

CREATE TABLE eventLocation (
                         id_location INT AUTO_INCREMENT PRIMARY KEY,
                         location_Name VARCHAR(100) NOT NULL ,
                         adrress  VARCHAR(200) NOT NULL ,
                         capacity int NOT NULL                         

);
CREATE TABLE event (
                           id_event INT  AUTO_INCREMENT PRIMARY KEY,
                           event_Name VARCHAR(100) NOT NULL ,
                           date DATE NOT NULL ,
                           price DOUBLE NOT NULL ,
                           ticket_Sold_Number INT,
                           id_location INT,
                           FOREIGN KEY (id_location) REFERENCES eventLocation(id_location)
);
CREATE TABLE customer (
                        id_customer INT  AUTO_INCREMENT PRIMARY KEY,
                        first_Name VARCHAR(50) NOT NULL ,
                        last_Name VARCHAR(50) NOT NULL ,
                        email VARCHAR(150) NOT NULL

);


CREATE TABLE ticket (
    id_ticket INT AUTO_INCREMENT PRIMARY KEY,
    id_customer INT,
    id_event INT,
    purchased_Ticket_Count INT NOT NULL,
    FOREIGN KEY (id_customer) REFERENCES customer(id_customer),
    FOREIGN KEY (id_event) REFERENCES event(id_event)
);
-- ALTER TABLE event
--    ADD COLUMN ticket_Sold_Number INT;
-- ALTER TABLE ticket
 --   ADD COLUMN purchased_Ticket_Count INT NOT NULL ;
 
 select * from event;
 select * from eventLocation;
 select * from customer;
 select * from ticket;