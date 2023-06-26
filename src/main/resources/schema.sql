-- table
DROP TABLE IF EXISTS tbl_product CASCADE;
DROP SEQUENCE IF EXISTS seq_product CASCADE;
CREATE SEQUENCE seq_product;
CREATE TABLE tbl_product (
    product_id BIGINT PRIMARY KEY DEFAULT nextval('seq_product'),
    product_name VARCHAR(50) NOT NULL,
    price INT NOT NULL,
    quantity INT NOT NULL
);