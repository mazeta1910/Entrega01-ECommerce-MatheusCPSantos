--import.sql
insert into tb_category (name) values ('Informática');
insert into tb_category (name) values ('UD');
insert into tb_category (name) values ('Cozinha');
insert into tb_category (name) values ('Móveis');
insert into tb_category (name) values ('Eletrônico');

insert into tb_product (name, description, price, category_id) values ('Refrigerador 429L','Refrigerador 429L Branco, duplex....',1990.0,2);
insert into tb_product (name, description, price, category_id) values ('Notebook Arus 15.6','Notebook Arus 15.6 Core I7, 16Gb Ram...',2449.0,1);
insert into tb_product (name, description, price, category_id) values ('Monitor 27pol','Monitor Gamer 27pol 144Hz, 1ms',1129.99,1);
insert into tb_product (name, description, price, category_id) values ('Kit Teclado e Mouse','Kit com teclado ABNT e mouse com 5 botões',199.0,1);
insert into tb_product (name, description, price, category_id) values ('Smartphone XYZ','Smatphone com tela de 9pol, 12GB....',9999.0,5);
insert into tb_product (name, description, price, category_id) values ('TV LCD 75pol','TV LCD 75pol, 5 HDMI...',7555.0,5);
insert into tb_product (name, description, price, category_id) values ('Fogão 6 Bocas','Fogão 6 Bocas em aço inox, ...', 799.99,3);
insert into tb_product (name, description, price, category_id) values ('Roteador Wi-Fi 5.4GhZ','Roteador Wi-Fi 5.4GhZ, 6 antenas...',1299.0,1);

INSERT INTO tb_user(display_name, username, password, email, cpf, phone) VALUES ('Administrador', 'admin','$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem', 'admin@nexus.com.br', '000.000.000-00', '(46) 99999-9999');
INSERT INTO tb_user(display_name, username, password, email, cpf, phone) VALUES ('Teste', 'test','$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem', 'teste@nexus.com.br', '111.111.111-11', '(46) 98888-8888');

-- ==========================================
-- POPULANDO A TABELA DE CUPONS (tb_coupon)
-- ==========================================
INSERT INTO tb_coupon (code, discount_value, discount_type, start_date, end_date, target_type, target_id, min_purchase_value, active, first_purchase_only) VALUES ('NEXUS10', 10.00, 'PERCENTAGE', '2026-01-01', '2026-12-31', 'ALL', NULL, 100.00, TRUE, FALSE);
INSERT INTO tb_coupon (code, discount_value, discount_type, start_date, end_date, target_type, target_id, min_purchase_value, active, first_purchase_only) VALUES ('BEMVINDO20', 20.00, 'PERCENTAGE', '2026-01-01', '2026-12-31', 'ALL', NULL, NULL, TRUE, TRUE);
INSERT INTO tb_coupon (code, discount_value, discount_type, start_date, end_date, target_type, target_id, min_purchase_value, active, first_purchase_only) VALUES ('GAMES50', 50.00, 'FIXED', '2026-04-01', '2026-12-31', 'CATEGORY', 1, 200.00, TRUE, FALSE);
INSERT INTO tb_coupon (code, discount_value, discount_type, start_date, end_date, target_type, target_id, min_purchase_value, active, first_purchase_only) VALUES ('PROMO30', 30.00, 'FIXED', '2026-04-01', '2026-12-31', 'PRODUCT', 1, NULL, TRUE, FALSE);

-- ==========================================
-- POPULANDO A TABELA DE TRANSPORTADORAS (tb_carrier)
-- ==========================================
INSERT INTO tb_carrier(name, base_rate, estimated_delivery_days, is_active) VALUES ('Correios PAC', 15.00, 5, true);
INSERT INTO tb_carrier(name, base_rate, estimated_delivery_days, is_active) VALUES ('Correios SEDEX', 35.00, 2, true);
INSERT INTO tb_carrier(name, base_rate, estimated_delivery_days, is_active) VALUES ('Jadlog Transportes', 22.00, 4, true);