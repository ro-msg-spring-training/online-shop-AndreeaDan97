INSERT INTO customer(first_name, last_name, username, password, email)
VALUES ('Ana', 'Pop', 'anapop', 'anapop', 'ana.pop25');
INSERT INTO customer(first_name, last_name, username, password, email)
VALUES ('Andreea', 'Dan', 'andreeadan', 'andreeadan', 'andreea.dan24');
INSERT INTO customer(first_name, last_name, username, password, email)
VALUES ('Maria', 'Doru', 'mariadoru', 'mariadoru', 'maria.doru23');
INSERT INTO customer(first_name, last_name, username, password, email)
VALUES('Alex', 'Mincu', 'alexmincu', 'alexmincu', 'alex.mincu20');
INSERT INTO customer(first_name, last_name, username, password, email)
VALUES('Dorin', 'Tebre', 'dorintebre', 'dorintebre', 'dorin.tebre50');

INSERT INTO supplier(name)
VALUES ('Verdino');
INSERT INTO supplier(name)
VALUES ('Alpro');
INSERT INTO supplier(name)
VALUES ('Take it veggie');
INSERT INTO supplier(name)
VALUES ('Danone');
INSERT INTO supplier(name)
VALUES ('Panemar');
INSERT INTO supplier(name)
VALUES ('Dove');

INSERT INTO product_category(name, description)
VALUES ('lactate', 'vegetale, iaurt, de cafea');
INSERT INTO product_category(name, description)
VALUES ('paine', 'neagra, alba, integrala');
INSERT INTO product_category(name, description)
VALUES ('ciocolata', 'neagra');
INSERT INTO product_category(name, description)
VALUES ('legume', '');

INSERT INTO address(country,city,county,street)
VALUES ('Romania','Cluj-Napoca','Cluj','Gr.Alexandrescu 20');
INSERT INTO address(country,city,county,street)
VALUES ('Romania','Cluj-Napoca','Cluj','Plopilor 120');
INSERT INTO address(country,city,county,street)
VALUES ('Romania','Cluj-Napoca','Cluj','Observatorului 50');
INSERT INTO address(country,city,county,street)
VALUES ('Romania','Cluj-Napoca','Cluj','Emil Isac 15');
INSERT INTO address(country,city,county,street)
VALUES ('Romania','Cluj-Napoca','Cluj','Aleea Padin 73');

INSERT INTO product(name, description, price, weight, id_product_category, id_supplier, imageURL)
VALUES ('paine', 'integrala', 120, 500, 1, 5, 'paine1.png');
INSERT INTO product(name, description, price, weight, id_product_category, id_supplier, imageURL)
VALUES ('paine', 'alba', 120, 700, 1, 5, 'paine2.png');
INSERT INTO product(name, description, price, weight, id_product_category, id_supplier, imageURL)
VALUES ('paine', 'neagra', 120, 5700, 1, 5, 'paine3.png');

INSERT INTO location(id_address, name)
VALUES (1, 'Depozit Cluj 1');
INSERT INTO location(id_address, name)
VALUES (2, 'Depozit Cluj 2');
INSERT INTO location(id_address, name)
VALUES (3, 'Depozit Cluj 3');
INSERT INTO location(id_address, name)
VALUES (4, 'Depozit Cluj 4');
INSERT INTO location(id_address, name)
VALUES (5, 'Depozit Cluj 5');

INSERT INTO stock(id_product, id_location, quantity)
VALUES(1,1,5000);
INSERT INTO stock(id_product, id_location, quantity)
VALUES(1,2,15000);
INSERT INTO stock(id_product, id_location, quantity)
VALUES(1,4,200);
INSERT INTO stock(id_product, id_location, quantity)
VALUES(2,4,5400);
INSERT INTO stock(id_product, id_location, quantity)
VALUES(2,2,7000);
INSERT INTO stock(id_product, id_location, quantity)
VALUES(3,1,7600);
INSERT INTO stock(id_product, id_location, quantity)
VALUES(3,5,5600);
INSERT INTO stock(id_product, id_location, quantity)
VALUES(1,3,2200);
INSERT INTO stock(id_product, id_location, quantity)
VALUES(1,5,3332);
INSERT INTO stock(id_product, id_location, quantity)
VALUES(2,1,6700);

