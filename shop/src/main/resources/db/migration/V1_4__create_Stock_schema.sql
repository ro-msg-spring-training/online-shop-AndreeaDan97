CREATE TABLE IF NOT EXISTS stock(
    id_product int,
    id_location int,
    quantity int,
    CONSTRAINT FK_STOCK_LOCATION FOREIGN KEY(id_location) references location(id),
    CONSTRAINT FK_STOCK_PRODUCT FOREIGN KEY(id_product) references product(id),
    CONSTRAINT PK_PRODUCT_LOCATION PRIMARY KEY(id_product, id_location)
);