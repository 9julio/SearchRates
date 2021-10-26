DROP TABLE IF EXISTS prices;

CREATE TABLE prices (
    price_id INT AUTO_INCREMENT,
    brand_id INT,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    price_list VARCHAR(256),
    product_id INT,
    priority INT,
    price DOUBLE,
    currency VARCHAR(256),
    last_update TIMESTAMP,
    last_update_by VARCHAR(256)
);