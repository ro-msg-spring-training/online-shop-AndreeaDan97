CREATE TABLE IF NOT EXISTS revenue(
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_location int,
    date timestamp,
    sum decimal,
    CONSTRAINT FK_REVENUE_LOCATION FOREIGN KEY(id_location) references location(id)
);