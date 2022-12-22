create table products(
product_id int NOT NULL AUTO_INCREMENT,
name varchar(50),
description varchar(50),
price varchar(50),                             
quantity int,
primary key(product_id)
);


insert into products(name,description,price,quantity) Values('AC','Dust Fliter 3','45,000','1000'),('Camera','1080F Full HD','80,000','1000'),('Cooler','34 liter','55,000','1000'),('Celling Fan','High Speed 3 Blades','7,000','1000'),('Laptop','Core i5 10th generation','68,000','1000'),('LED TV','52 INCH 4K','50,000','1000'),('Mobile','6GB RAM 128 GB Storage','15,000','1000'),('Oven','180w Temperature Control','15,000','1000'),('Refrigerator','Double Door 5','35,000','1000'),('Washing Machine ','Front Door','42,000','1000');
