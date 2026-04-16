--import.sql
insert into tb_category (name) values ('Informática');
insert into tb_category (name) values ('UD');
insert into tb_category (name) values ('Cozinha');
insert into tb_category (name) values ('Móveis');
insert into tb_category (name) values ('Eletrônico');


-- ==========================================
-- POPULANDO PRODUTOS (tb_product)
-- ==========================================
INSERT INTO tb_product (name, description, price, category_id, is_adult_only) VALUES ('Teclado Gamer Redragon', 'Teclado mecânico switch blue', 350.00, 1, FALSE);
INSERT INTO tb_product (name, description, price, category_id, is_adult_only) VALUES ('Project Zomboid', 'Jogo de sobrevivência hardcore e violento (+18)', 100.00, 1, TRUE);

-- ==========================================
-- POPULANDO USUÁRIOS (tb_user) - A senha de ambos é 'password'
-- ==========================================
-- Usuário 1 (ID 1): Adulto (Nascido em 1990) -> Acesso Total
INSERT INTO tb_user (username, display_name, full_name, birth_date, email, cpf, phone, password, newsletter_subscription, parent_id) VALUES ('admin', 'Administrador', 'Administrador do Sistema NEXUS', '1990-01-01', 'admin@nexus.com.br', '11122233344', '46999999999', '$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW', TRUE, NULL);

-- Usuário 2 (ID 2): Menor Púbere (15 anos em 2026 - Nascido em 2011) -> Vinculado ao Usuário 1
INSERT INTO tb_user (username, display_name, full_name, birth_date, email, cpf, phone, password, newsletter_subscription, parent_id) VALUES ('enzo15', 'Enzo', 'Enzo da Silva Santos', '2011-05-10', 'enzo@nexus.com.br', '99988877766', '46999998888', '$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW', FALSE, 1);

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