CREATE TABLE IF NOT EXISTS customer(
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name varchar(20),
    last_name varchar(20),
    username varchar(20),
    password varchar(20),
    email varchar(20)
);