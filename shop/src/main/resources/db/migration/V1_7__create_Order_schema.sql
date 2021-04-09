CREATE TABLE IF NOT EXISTS orders(
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_shipped_from int,
    id_customer int,
    creation_date timestamp,
    address_country varchar(50),
    address_city varchar(50),
    address_county varchar(50),
    address_street varchar(50),
    CONSTRAINT FK_ORDER_LOCATION FOREIGN KEY(id_shipped_from) references location(id),
    CONSTRAINT FK_ORDER_CUSTOMER FOREIGN KEY(id_customer) references customer(id)
);