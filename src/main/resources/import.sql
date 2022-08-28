INSERT INTO TB_CUSTOMER (fiscal_number, name, email) VALUES ('02366655588', 'John Lenon', 'jo@sky.com');
INSERT INTO TB_CUSTOMER (fiscal_number, name, email) VALUES ('02766655599', 'Paul MacCartney', 'paul@music.com');
INSERT INTO TB_CUSTOMER (fiscal_number, name, email) VALUES ('02866655511', 'Ringo Star', 'ringo@sky.com');
INSERT INTO TB_CUSTOMER (fiscal_number, name, email) VALUES ('05566655511', 'Jorge Harison', 'haris@rock.com');


INSERT INTO TB_ORDER (customer_id, code, date, total_value) VALUES (1, '000001', '2022-01-01', 2000);
INSERT INTO TB_ORDER (customer_id, code, date, total_value) VALUES (2, '000002', '2022-02-28', 2300);
INSERT INTO TB_ORDER (customer_id, code, date, total_value) VALUES (1, '000003', '2022-03-18', 8525.2);
INSERT INTO TB_ORDER (customer_id, code, date, total_value) VALUES (3, '000004', '2022-05-26', 3455.5);
INSERT INTO TB_ORDER (customer_id, code, date, total_value) VALUES (1, '000005', '2022-06-04', 8025.75);


INSERT INTO TB_PRODUCT (code, name, category, sale_price) VALUES ('0100200', 'Guitar OAZ', 'MUSIC', 1025.32);
INSERT INTO TB_PRODUCT (code, name, category, sale_price) VALUES ('0100201', 'Violin 5 Star', 'MUSIC', 3220);
INSERT INTO TB_PRODUCT (code, name, category, sale_price) VALUES ('0100202', 'Piano 32 key', 'MUSIC', 10185);


INSERT INTO TB_ORDER_ITEMS (id, order_id, status, product_code, amount, price, value) VALUES (1, 1, 'CLOSED', '0100201', 2, 3220, 6440);
INSERT INTO TB_ORDER_ITEMS (id, order_id, status, product_code, amount, price, value) VALUES (2, 1, 'CLOSED', '0100200', 2, 4500, 9000);
INSERT INTO TB_ORDER_ITEMS (id, order_id, status, product_code, amount, price, value) VALUES (3, 1, 'CLOSED', '0100202', 3, 15024, 30048);

INSERT INTO TB_ORDER_ITEMS (id, order_id, status, product_code, amount, price, value) VALUES (4, 2, 'CLOSED', '0100201', 1, 3220, 3200);
INSERT INTO TB_ORDER_ITEMS (id, order_id, status, product_code, amount, price, value) VALUES (5, 2, 'CLOSED', '0100200', 2, 4500, 9000);

INSERT INTO TB_ORDER_ITEMS (id, order_id, status, product_code, amount, price, value) VALUES (6, 3, 'CLOSED', '0100202', 5, 4500, 22500);
