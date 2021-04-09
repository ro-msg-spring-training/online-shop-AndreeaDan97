CREATE TABLE IF NOT EXISTS location(
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(20),
    address_country varchar(50),
    address_city varchar(50),
    address_county varchar(50),
    address_street varchar(50)
);