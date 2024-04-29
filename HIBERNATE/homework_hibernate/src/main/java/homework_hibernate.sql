CREATE DATABASE homework_Hibernate;
USE homework_Hibernate;
select * from category; 
select * from product; 
select * from manufacturer; 
select * from prod_manufacturer; 
select * from manufacturer_product; 
SELECT C.name, Count(P.id), Max(P.price) , Min(P.price)
FROM Product P RIGHT OUTER JOIN Category C ON P.cat_id= C.id GROUP BY C.name;
SELECT C.name, COUNT(P.id) AS product_count, Max(P.price) , Min(P.price)
FROM Product P
JOIN Category C ON C.id = P.cat_id
GROUP BY C.name;
