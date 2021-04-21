CREATE TABLE IF NOT EXISTS product_category(
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(20) unique,
    description varchar(50)
);