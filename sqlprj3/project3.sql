CREATE DATABASE prj3 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE prj3;

-- sản phầm --
CREATE TABLE category (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    image VARCHAR(500),
    price DOUBLE,
    description TEXT,
    category_id INT,
    CONSTRAINT fk_product_category 
        FOREIGN KEY (category_id) REFERENCES category(id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

ALTER TABLE product ADD COLUMN tag VARCHAR(50);

 select * from product
 
INSERT INTO category (name) VALUES
('Gấu Teddy'),
('Thú bông'),
('Hoa gấu bông'),
('BlindBox'),
('Phụ kiện'),
('Thiệp viết tay');

DELETE FROM product;

INSERT INTO product (name, image, price, description, category_id)
VALUES
('Teddy Classic 50cm', 'teddy50.jpg', 199000, 'Gấu Teddy mềm, cao 50cm', 1),
('Thú bông Pikachu', 'pikachu.jpg', 159000, 'Thú bông Pikachu cực dễ thương', 2),
('Hoa gấu bông màu hồng', 'hoagau.jpg', 249000, 'Bó hoa gấu bông tặng bạn gái', 3),
('BlindBox Series 2', 'blindbox2.jpg', 89000, 'BlindBox ngẫu nhiên', 4),
('Móc khóa gấu mini', 'mockhoa.jpg', 59000, 'Phụ kiện nhỏ xinh', 5);


-- đơn hàng --

CREATE TABLE orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(150) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    address VARCHAR(255) NOT NULL,
    note VARCHAR(500),
    total_amount DOUBLE NOT NULL,
    status VARCHAR(30) NOT NULL,
    created_at DATETIME NOT NULL
);

ALTER TABLE orders 
ADD COLUMN user_id BIGINT NULL,
ADD CONSTRAINT fk_order_user FOREIGN KEY (user_id) REFERENCES users(id);


CREATE TABLE order_items (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    product_name VARCHAR(255) NOT NULL,
    product_price DOUBLE NOT NULL,
    quantity INT NOT NULL,
    CONSTRAINT fk_orderitems_order
        FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE
    -- FK product_id :
    -- , CONSTRAINT fk_orderitems_product
    --     FOREIGN KEY (product_id) REFERENCES product(id)
);

-- users --

CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    role VARCHAR(20) NOT NULL
);


INSERT INTO users(full_name,email,password,phone,role)
VALUES
('Admin Test','admin@test.com','123','0900000000','ADMIN'),
('Shipper Test','ship@test.com','123','0911111111','SHIPPER');



SELECT id, status FROM orders;


