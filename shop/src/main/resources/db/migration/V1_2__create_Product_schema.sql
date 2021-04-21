CREATE TABLE IF NOT EXISTS product(
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(20),
    description varchar(50),
    price decimal,
    weight double,
    imageURL varchar(50),
    id_product_category int,
    id_supplier int,
    CONSTRAINT FK_PRODUCT_PRODUCT_CATEGORY FOREIGN KEY(id_product_category) references product_category(id),
    CONSTRAINT FK_PRODUCT_SUPPLIER FOREIGN KEY(id_supplier) references supplier(id)
);
