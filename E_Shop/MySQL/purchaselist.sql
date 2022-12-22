create table purchaselist(
mobile_number varchar(100) NOT NULL,
LED_TV int DEFAULT NULL,
Refrigerator int DEFAULT NULL,
Washing_Machine int DEFAULT NULL,
Laptop int DEFAULT NULL,
Oven int DEFAULT NULL,
AC int DEFAULT NULL,
Mobile int  DEFAULT NULL, 
Celling_Fan int DEFAULT NULL,
Cooler int DEFAULT NULL,
Camera int DEFAULT NULL,
foreign key(mobile_number) references user(mobile_number) 
);