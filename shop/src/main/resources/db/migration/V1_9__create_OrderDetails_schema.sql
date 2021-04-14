CREATE TABLE IF NOT EXISTS order_details(
    id_order int,
    id_product int,
    quantity int,
    CONSTRAINT FK_ORDER_DETAILS_PRODUCT FOREIGN KEY(id_product) references product(id),
    CONSTRAINT FK_ORDER_DETAILS_ORDER FOREIGN KEY(id_order) references orders(id),
    CONSTRAINT PK_ORDER_PRODUCT PRIMARY KEY(id_order, id_product)
);