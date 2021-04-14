CREATE TABLE IF NOT EXISTS orders(
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_shipped_from int,
    id_customer int,
    id_address int,
    creation_date timestamp,
    CONSTRAINT FK_ORDER_LOCATION FOREIGN KEY(id_shipped_from) references location(id),
    CONSTRAINT FK_ORDER_CUSTOMER FOREIGN KEY(id_customer) references customer(id),
    CONSTRAINT FK_ORDER_ADDRESS FOREIGN KEY(id_address) references address(id)
);