CREATE TABLE IF NOT EXISTS address(
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    country varchar(20),
    city varchar(20),
    county varchar(20),
    street varchar(50)
);