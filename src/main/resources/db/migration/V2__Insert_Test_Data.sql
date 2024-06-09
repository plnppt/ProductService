-- Заполнение таблицы категорий
INSERT INTO categories (id, name, description) VALUES
                                                   (1, 'Ноутбуки', 'Легкие и мощные ноутбуки'),
                                                   (2, 'Смартфоны', 'Современные смартфоны и мобильные телефоны'),
                                                   (3, 'Телевизоры', 'Ультрасовременные телевизоры высокого разрешения');

-- Заполнение таблицы брендов
INSERT INTO brands (id, name, description) VALUES
                                               (1, 'Apple', 'Производитель премиальной электроники'),
                                               (2, 'Samsung', 'Производитель электроники и бытовой техники'),
                                               (3, 'Sony', 'Производитель аудио и видео техники');

-- Заполнение таблицы продуктов
INSERT INTO products (id, name, description, sku, category_id, brand_id) VALUES
                                                                             (1, 'MacBook Pro 13"', 'Ноутбук для профессионалов от Apple', 'SKU123456', 1, 1),
                                                                             (2, 'iPhone 13', 'Последняя модель смартфона от Apple', 'SKU654321', 2, 1),
                                                                             (3, 'Samsung Galaxy S21', 'Флагманский смартфон от Samsung', 'SKU987654', 2, 2),
                                                                             (4, 'Телевизор Sony Bravia 55"', 'Ультра HD телевизор с поддержкой Smart TV', 'SKU192837', 3, 3);

-- Заполнение таблицы инвентаря
INSERT INTO inventory (id, product_id, quantity, last_updated) VALUES
                                                                   (1, 1, 30, NOW()),
                                                                   (2, 2, 50, NOW()),
                                                                   (3, 3, 40, NOW()),
                                                                   (4, 4, 20, NOW());

-- Заполнение таблицы цен
INSERT INTO prices (id, product_id, price, price_type, start_date, end_date) VALUES
                                                                                 (1, 1, 129999.99, 'REGULAR', '2023-01-01', NULL),
                                                                                 (2, 2, 79999.99, 'REGULAR', '2023-01-01', NULL),
                                                                                 (3, 3, 69999.99, 'REGULAR', '2023-01-01', NULL),
                                                                                 (4, 4, 99999.99, 'REGULAR', '2023-01-01', NULL);

-- Заполнение таблицы атрибутов продуктов
INSERT INTO product_attributes (id, product_id, attribute_name, attribute_value) VALUES
                                                                                     (1, 1, 'Процессор', 'Intel Core i5'),
                                                                                     (2, 1, 'Объем памяти', '512 ГБ SSD'),
                                                                                     (3, 2, 'Цвет', 'Синий'),
                                                                                     (4, 2, 'Объем памяти', '256 ГБ'),
                                                                                     (5, 3, 'Цвет', 'Черный'),
                                                                                     (6, 3, 'Объем памяти', '128 ГБ'),
                                                                                     (7, 4, 'Диагональ экрана', '55 дюймов'),
                                                                                     (8, 4, 'Разрешение экрана', '4K Ultra HD');

-- Заполнение таблицы изображений продуктов
INSERT INTO product_images (id, product_id, image_url) VALUES
                                                           (1, 1, 'https://example.com/images/macbook_pro_13.jpg'),
                                                           (2, 2, 'https://example.com/images/iphone_13.jpg'),
                                                           (3, 3, 'https://example.com/images/samsung_galaxy_s21.jpg'),
                                                           (4, 4, 'https://example.com/images/sony_bravia_55.jpg');