-- ==========================================
-- 1. POPULANDO CATEGORIAS (tb_category)
-- ==========================================
INSERT INTO tb_category (name) VALUES ('Periféricos Gaming');
INSERT INTO tb_category (name) VALUES ('Jogos Digitais');
INSERT INTO tb_category (name) VALUES ('Hardware');
INSERT INTO tb_category (name) VALUES ('Monitores');
INSERT INTO tb_category (name) VALUES ('Cadeiras Gaming');

-- ==========================================
-- 2. POPULANDO PRODUTOS (tb_product)
-- ==========================================
INSERT INTO tb_product (name, description, price, category_id, is_adult_only, image) VALUES ('Teclado Gaming Redragon', 'Teclado mecânico switch blue com RGB', 350.00, 1, FALSE, 'https://images.unsplash.com/photo-1595225476474-87563907a212?w=500&q=80');
INSERT INTO tb_product (name, description, price, category_id, is_adult_only, image) VALUES ('Mouse Gaming Logitech G203', 'Mouse com sensor ótico de 8000 DPI', 150.00, 1, FALSE, 'https://images.unsplash.com/photo-1615663245857-ac93bb7c39e7?w=500&q=80');
INSERT INTO tb_product (name, description, price, category_id, is_adult_only, image) VALUES ('Project Zomboid', 'Jogo de sobrevivência zombie hardcore (+18)', 100.00, 2, TRUE, 'https://images.unsplash.com/photo-1605901309584-818e25960b8f?w=500&q=80');
INSERT INTO tb_product (name, description, price, category_id, is_adult_only, image) VALUES ('Grand Theft Auto V', 'Ação e aventura em mundo aberto (+18)', 80.00, 2, TRUE, 'https://images.unsplash.com/photo-1605901302628-86d7cb02c385?w=500&q=80');
INSERT INTO tb_product (name, description, price, category_id, is_adult_only, image) VALUES ('Placa Gráfica RTX 4060', 'NVIDIA GeForce RTX 4060 8GB', 2500.00, 3, FALSE, 'https://images.unsplash.com/photo-1591488320449-011701bb6704?w=500&q=80');
INSERT INTO tb_product (name, description, price, category_id, is_adult_only, image) VALUES ('Monitor LG Ultrawide 29', 'Monitor 29 polegadas IPS Full HD', 1200.00, 4, FALSE, 'https://images.unsplash.com/photo-1527443224154-c4a3942d3acf?w=500&q=80');
INSERT INTO tb_product (name, description, price, category_id, is_adult_only, image) VALUES ('Cadeira Gaming DXRacer', 'Cadeira ergonómica reclinável preta', 1500.00, 5, FALSE, 'https://images.unsplash.com/photo-1505843490538-5133c6c7d0e1?w=500&q=80');

-- ==========================================
-- 3. POPULANDO UTILIZADORES (tb_user)
-- A senha padrão é password
-- ==========================================
INSERT INTO tb_user (username, display_name, full_name, birth_date, email, cpf, phone, password, newsletter_subscription, terms_accepted, parent_id) VALUES ('admin', 'Administrador', 'Administrador do Sistema', '1990-01-01', 'admin@nexus.com.br', '06569168007', '46999999999', '$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW', TRUE, TRUE, NULL);
INSERT INTO tb_user (username, display_name, full_name, birth_date, email, cpf, phone, password, newsletter_subscription, terms_accepted, parent_id) VALUES ('enzo15', 'Enzo', 'Enzo da Silva Santos', '2011-05-10', 'enzo@nexus.com.br', '59341647038', '46999998888', '$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW', FALSE, TRUE, 1);
INSERT INTO tb_user (username, display_name, full_name, birth_date, email, cpf, phone, password, newsletter_subscription, terms_accepted, parent_id) VALUES ('maria_gamer', 'Maria', 'Maria Costa Ferreira', '1998-08-20', 'maria@gmail.com', '82645063004', '46988887777', '$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW', TRUE, TRUE, NULL);
INSERT INTO tb_user (username, display_name, full_name, birth_date, email, cpf, phone, password, newsletter_subscription, terms_accepted, parent_id) VALUES ('lucas_pro', 'Lucas', 'Lucas Costa Ferreira', '2013-03-15', 'lucas@gmail.com', '40638513009', '46988887777', '$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW', FALSE, TRUE, 3);

-- ==========================================
-- 4. POPULANDO A TABELA DE CUPÕES E TRANSPORTADORAS
-- ==========================================
INSERT INTO tb_coupon (code, discount_value, discount_type, start_date, end_date, target_type, target_id, min_purchase_value, active, first_purchase_only) VALUES ('NEXUS10', 10.00, 'PERCENTAGE', '2026-01-01', '2026-12-31', 'ALL', NULL, 100.00, TRUE, FALSE);
INSERT INTO tb_coupon (code, discount_value, discount_type, start_date, end_date, target_type, target_id, min_purchase_value, active, first_purchase_only) VALUES ('BEMVINDO20', 20.00, 'PERCENTAGE', '2026-01-01', '2026-12-31', 'ALL', NULL, NULL, TRUE, TRUE);

INSERT INTO tb_carrier(name, base_rate, estimated_delivery_days, is_active) VALUES ('Correios PAC', 15.00, 5, true);
INSERT INTO tb_carrier(name, base_rate, estimated_delivery_days, is_active) VALUES ('Correios SEDEX', 35.00, 2, true);

-- ==========================================
-- 5. POPULANDO MORADAS/ENDEREÇOS (tb_address)
-- Correção aplicada: Alterado 'zipcode' para 'zip_code' para coincidir com a entidade Address.
-- ==========================================
INSERT INTO tb_address (city, neighborhood, number, state, street, zip_code, user_id) VALUES ('Pato Branco', 'Centro', '123', 'PR', 'Rua Guarani', '85501-000', 1);
INSERT INTO tb_address (city, neighborhood, number, state, street, zip_code, user_id) VALUES ('Pato Branco', 'La Salle', '456', 'PR', 'Rua Tapajós', '85501-100', 2);
INSERT INTO tb_address (city, neighborhood, number, state, street, zip_code, user_id) VALUES ('Curitiba', 'Batel', '10', 'PR', 'Avenida do Batel', '80420-090', 3);
INSERT INTO tb_address (city, neighborhood, number, state, street, zip_code, user_id) VALUES ('Curitiba', 'Água Verde', '55A', 'PR', 'Rua Bento Viana', '80240-110', 3);
INSERT INTO tb_address (city, neighborhood, number, state, street, zip_code, user_id) VALUES ('Curitiba', 'Batel', '10', 'PR', 'Avenida do Batel', '80420-090', 4);

-- ==========================================
-- 6. POPULANDO ENCOMENDAS E ITENS DA ENCOMENDA
-- ==========================================
INSERT INTO tb_order (order_date, total, user_id, address_id) VALUES ('2026-04-15', 350.00, 1, 1);
INSERT INTO tb_order (order_date, total, user_id, address_id) VALUES ('2026-04-20', 1350.00, 3, 3);
INSERT INTO tb_order (order_date, total, user_id, address_id) VALUES ('2026-04-22', 80.00, 3, 4);

INSERT INTO tb_order_product (order_id, product_id) VALUES (1, 1);
INSERT INTO tb_order_product (order_id, product_id) VALUES (2, 6);
INSERT INTO tb_order_product (order_id, product_id) VALUES (2, 2);
INSERT INTO tb_order_product (order_id, product_id) VALUES (3, 4);