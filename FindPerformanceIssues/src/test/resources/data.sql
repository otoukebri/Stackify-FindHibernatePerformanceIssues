INSERT INTO purchase_order (id, version) VALUES (1, 0);
INSERT INTO purchase_order (id, version) VALUES (2, 0);

INSERT INTO orderitem(id, version, name, fk_order) VALUES (1, 0, 'item 1', 1);
INSERT INTO orderitem(id, version, name, fk_order) VALUES (2, 0, 'item 2', 1);
INSERT INTO orderitem(id, version, name, fk_order) VALUES (3, 0, 'item 3', 1);
INSERT INTO orderitem(id, version, name, fk_order) VALUES (4, 0, 'item 1', 2);
INSERT INTO orderitem(id, version, name, fk_order) VALUES (5, 0, 'item 4', 2);
INSERT INTO orderitem(id, version, name, fk_order) VALUES (6, 0, 'item 5', 2);