CREATE TABLE categories (
                            id BIGINT PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
                            description TEXT
);

CREATE TABLE brands (
                        id BIGINT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        description TEXT
);

CREATE TABLE products (
                          id BIGINT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          description TEXT,
                          sku VARCHAR(255) UNIQUE NOT NULL,
                          category_id BIGINT,
                          brand_id BIGINT,
                          FOREIGN KEY (category_id) REFERENCES categories(id),
                          FOREIGN KEY (brand_id) REFERENCES brands(id)
);

CREATE TABLE inventory (
                           id BIGINT PRIMARY KEY,
                           product_id BIGINT,
                           quantity INT NOT NULL,
                           last_updated TIMESTAMP,
                           FOREIGN KEY (product_id) REFERENCES products(id)
);

CREATE TABLE prices (
                        id BIGINT PRIMARY KEY,
                        product_id BIGINT,
                        price DOUBLE PRECISION NOT NULL,
                        price_type VARCHAR(50) NOT NULL,
                        start_date DATE,
                        end_date DATE,
                        FOREIGN KEY (product_id) REFERENCES products(id)
);

CREATE TABLE product_attributes (
                                    id BIGINT PRIMARY KEY,
                                    product_id BIGINT,
                                    attribute_name VARCHAR(255) NOT NULL,
                                    attribute_value VARCHAR(255) NOT NULL,
                                    FOREIGN KEY (product_id) REFERENCES products(id)
);

CREATE TABLE product_images (
                                id BIGINT PRIMARY KEY,
                                product_id BIGINT,
                                image_url TEXT NOT NULL,
                                FOREIGN KEY (product_id) REFERENCES products(id)
);