CREATE TABLE IF NOT EXISTS location(
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_address int,
    name varchar(20),
    CONSTRAINT FK_LOCATION_ADDRESS FOREIGN KEY(id_address) references address(id)
);