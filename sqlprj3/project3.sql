CREATE DATABASE prj3 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE prj3;
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

INSERT INTO category (name) VALUES
('Gấu Teddy'),
('Thú bông'),
('Hoa gấu bông'),
('BlindBox'),
('Phụ kiện'),
('Thiệp viết tay');

INSERT INTO product (name, image, price, description, category_id)
VALUES
('Teddy Classic 50cm', '/images/teddy50.jpg', 199000, 'Gấu Teddy mềm, cao 50cm', 1),
('Thú bông Pikachu', '/images/pikachu.jpg', 159000, 'Thú bông Pikachu cực dễ thương', 2),
('Hoa gấu bông màu hồng', '/images/hoagau.jpg', 249000, 'Bó hoa gấu bông tặng bạn gái', 3),
('BlindBox Series 2', '/images/blindbox2.jpg', 89000, 'BlindBox ngẫu nhiên', 4),
('Móc khóa gấu mini', '/images/mockhoa.jpg', 59000, 'Phụ kiện nhỏ xinh', 5);
