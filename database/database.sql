Create database tanashop;
use tanashop;
-- drop database tanashop;

-- ============= USERS =============
CREATE TABLE Users (
    userID INT AUTO_INCREMENT,
    username VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    fullName VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(20),
    address VARCHAR(255),
    avatar VARCHAR(255),
    userCreatedDate DATE,
    userUpdatedDate DATE,
    userStatus ENUM('active', 'suspended') DEFAULT 'active',
    userRole ENUM('admin', 'manager', 'employee', 'customer') DEFAULT 'customer',
    PRIMARY KEY (userID)
);

INSERT INTO Users (username, password, fullName, email, phone, address, avatar, userCreatedDate, userUpdatedDate, userStatus, userRole)
VALUES ("admin", "admin", "ADMIN", "admin@gmail.com", "0123456789", "Thủ Đức", "https://img.hoidap247.com/picture/question/20201024/large_1603547313777.jpg?v=0", "2024-11-11", "2024-11-11", "active", "admin");

INSERT INTO Users (username, password, fullName, email, phone, address, avatar, userCreatedDate, userUpdatedDate, userStatus, userRole)
VALUES ("admin1", "admin", "ADMIN1", "admin1@gmail.com", "012345678910", "Thủ Đức", "https://img.hoidap247.com/picture/question/20201024/large_1603547313777.jpg?v=0", "2024-11-11", "2024-11-11", "active", "admin");

INSERT INTO Users (username, password, fullName, email, phone, address, avatar, userCreatedDate, userUpdatedDate, userStatus, userRole)
VALUES ("tan", "tan", "Tân", "tan@gmail.com", "0999888777", "Thủ Đức", "https://img.hoidap247.com/picture/question/20201024/large_1603547313777.jpg?v=0", "2024-11-11", "2024-11-11", "active", "manager");

INSERT INTO Users (username, password, fullName, email, phone, address, avatar, userCreatedDate, userUpdatedDate, userStatus, userRole)
VALUES ("congnguyen", "congnguyen", "Nguyễn Công", "congnguyen@gmail.com", "09998887776", "Thủ Đức", "https://img.hoidap247.com/picture/question/20201024/large_1603547313777.jpg?v=0", "2024-11-11", "2024-11-11", "active", "manager");

INSERT INTO Users (username, password, fullName, email, phone, address, avatar, userCreatedDate, userUpdatedDate, userStatus, userRole)
VALUES ("tane", "tan", "Tân", "tane@gmail.com", "011223344", "Thủ Đức", "https://img.hoidap247.com/picture/question/20201024/large_1603547313777.jpg?v=0", "2024-11-11", "2024-11-11", "active", "employee");

INSERT INTO Users (username, password, fullName, email, phone, address, avatar, userCreatedDate, userUpdatedDate, userStatus, userRole)
VALUES ("congnguyene", "congnguyen", "congnguyen", "congnguyene@gmail.com", "0112233443", "Thủ Đức", "https://img.hoidap247.com/picture/question/20201024/large_1603547313777.jpg?v=0", "2024-11-11", "2024-11-11", "active", "employee");

INSERT INTO Users (username, password, fullName, email, phone, address, avatar, userCreatedDate, userUpdatedDate, userStatus, userRole)
VALUES ("tanc", "tan", "Tân", "tanc@gmail.com", "044556677", "Thủ Đức", "https://img.hoidap247.com/picture/question/20201024/large_1603547313777.jpg?v=0", "2024-11-11", "2024-11-11", "active", "customer");

INSERT INTO Users (username, password, fullName, email, phone, address, avatar, userCreatedDate, userUpdatedDate, userStatus, userRole)
VALUES ("congnguyenc", "congnguyen", "congnguyen", "congnguyenc@gmail.com", "0445566773", "Thủ Đức", "https://img.hoidap247.com/picture/question/20201024/large_1603547313777.jpg?v=0", "2024-11-11", "2024-11-11", "active", "customer");

-- ============= CATEGORIES =============
CREATE TABLE Categories (
    categories_id INT AUTO_INCREMENT,
    categories_name VARCHAR(50) NOT NULL unique,
    categories_img varchar(255),
	categories_createdDate DATE,
    categories_updatedDate DATE,
    PRIMARY KEY (categories_id)
);

insert into Categories (categories_name, categories_img, categories_createdDate, categories_updatedDate) 
values ('ASUS', 'https://e7.pngegg.com/pngimages/508/154/png-clipart-asus-logo-computer-brands-brand-logo-thumbnail.png',
 '2024-01-12', '2024-01-12');

insert into Categories (categories_name, categories_img, categories_createdDate, categories_updatedDate) 
values ('ACER', 'https://www.citypng.com/public/uploads/preview/hd-acer-logo-transparent-png-735811696609567hl5dq9bbwq.png',
 '2024-01-12', '2024-01-12');

insert into Categories (categories_name, categories_img, categories_createdDate, categories_updatedDate) 
values ('MSI', 'https://banner2.cleanpng.com/20180608/yer/kisspng-micro-star-international-graphics-cards-video-ad-microstar-international-co-ltd-5b1b47f8a5c6b8.203243121528514552679.jpg',
 '2024-01-12', '2024-01-12');

insert into Categories (categories_name, categories_img, categories_createdDate, categories_updatedDate) 
values ('LENOVO', 'https://e7.pngegg.com/pngimages/960/901/png-clipart-logo-brand-lenovo-thinkpad-ideapad-strategic-blue-text.png',
 '2024-01-12', '2024-01-12');

insert into Categories (categories_name, categories_img, categories_createdDate, categories_updatedDate) 
values ('GIGABYTE', 'https://banner2.cleanpng.com/20180502/jcq/kisspng-encapsulated-postscript-logo-t600-5ae98fb928dfd4.8342230315252561211674.jpg',
 '2024-01-12', '2024-01-12');

-- ============= PRODUCTS =============
CREATE TABLE Products (
    product_id INT AUTO_INCREMENT,
    product_name VARCHAR(50) NOT NULL,
    product_description TEXT,
    product_price DECIMAL(10 , 2 ) NOT NULL,
    product_stock INT DEFAULT 0 not null,
    product_img VARCHAR(255),
    product_createdDate date,
    product_updateDate date,
    categories_id INT NOT NULL,
    PRIMARY KEY (product_id),
    FOREIGN KEY (categories_id) REFERENCES Categories (categories_id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    INDEX idx_categories_id (categories_id)
); 

insert into Products (product_name, product_description, product_price, product_stock, product_img, product_createdDate, product_updateDate, categories_id) 
values 
  ('MSI Bravo 15 B7ED 010VN', 'AMD R5 7535HSH, Ram 16GB, SSD 512GB, Màn hình 15.6" FHD 144Hz, VGA RX6550M 4GB, Hệ điều hành Win11', 15490000, 10, 'https://laptopaz.vn/media/product/3039_msi_bravo_15_b7ed_010vn.jpg', '2024-12-09', '2024-12-09', 3),
  ('MSI GF63 12UCX-841VN', 'AMD R5 7535HS, Ram 8GB, SSD 512GB, Màn hình 15.6" FHD 144Hz, RTX 2050 4GB, Hệ điều hành Win11', 15690000, 10, 'https://laptopaz.vn/media/product/3215_3029_laptop_msi_gf63_thin_12ucx_841vn_fd16fbe6.jpg', '2024-12-09', '2024-12-09', 3),
  ('MSI Cyborg 15 A12VF 267VN', 'Intel Core i5-12450H, Ram 8GB, SSD 512GB, Màn hình 15.6" FHD 144Hz, VGA RTX 4060 8GB, Hệ điều hành Win11', 27690000, 10, 'https://laptopaz.vn/media/product/2976_12429_msi_cyborg_15_a12v__3.jpg', '2024-12-09', '2024-12-09', 3),

  ('Asus ROG Zephyrus G16 2023 GU603VU N3898W', 'Intel Core i7-13620H, Ram 16GB, SSD 512GB, Màn hình 15.6" FHD+ 165Hz, Hệ điều hành Win11', 41790000, 10, 'https://laptopaz.vn/media/product/2962_12172_asus_rog_zephyrus_g16_gu603__1.jpg', '2024-12-09', '2024-12-09', 1),
  ('Asus Vivobook S14 OLED S5406 2024', 'Intel Core Ultra 5 125H, Ram 16GB, SSD 1TB, Màn hình 14" 3k OLED, Hệ điều hành Win11', 24990000, 10, 'https://laptopaz.vn/media/product/3218_asus_vivobook_s_14_oled_2024.jpg', '2024-12-09', '2024-12-09', 1),
  ('Asus Gaming Vivobook K3605ZU-RP296W', 'Intel Core i5-12500H, Ram 16GB, SSD 512GB, Màn hình 16" FHD+ 144Hz, VGA RTX 4050 6GB, Hệ điều hành Win10', 24790000, 10, 'https://laptopaz.vn/media/product/3364_asus_gaming_vivobook_k3605.jpg', '2024-12-09', '2024-12-09', 1),

  ('Lenovo ThinkPad P16', 'Intel Core i7-12850HX, Ram 64GB, SSD 1TB, Màn hình 16" 2K+, Hệ điều hành Win11', 48490000, 10, 'https://laptopaz.vn/media/product/3206_2719_6.png', '2024-12-09', '2024-12-09', 4),
  ('Lenovo Legion Y9000P 2024', 'Intel Core i9-14900HX, Ram 16GB, SSD 1TB, Màn hình 16" 2K+ 240Hz, Hệ điều hành Win11', 41890000, 10, 'https://laptopaz.vn/media/product/3146_legion_y9000p_2024.jpg', '2024-12-09', '2024-12-09', 4),
  ('Lenovo Legion 5 2024 82Y300X0VN', 'Intel Core i7-14650HX, Ram 16GB, SSD 1TB, Màn hình 16" 2K+ 165Hz, Hệ điều hành Win11', 40690000, 10, 'https://laptopaz.vn/media/product/3369_legion_5_2024.jpg', '2024-12-09', '2024-12-09', 4),

  ('Acer Predator Helios Neo 2024 PHN16-72-91RF', 'Intel Core i9-14900HX, Ram 16GB, SSD 1TB, Màn hình 16" 2K+ 240Hz, Hệ điều hành Win11', 33990000, 10, 'https://laptopaz.vn/media/product/3229_acer_predator_helios_neo_16_2024_front_thumbnail.png', '2024-12-09', '2024-12-09', 2),
  ('Acer Predator Helios 16 2023 PH16-71-74UU', 'Intel Core i7-13700HX, Ram 16GB, SSD 1TB, Màn hình 16" 2K+ 165Hz, Hệ điều hành Win11', 32890000, 10, 'https://laptopaz.vn/media/product/3110_2782_2764_5.png', '2024-12-09', '2024-12-09', 2),
  ('Acer Nitro 5 Tiger 2022 AN515-58', 'Intel Core i7 - 12650H, Ram 16GB, SSD 1TB, Màn hình 15.6" FHD 144Hz, VGA RTX 4060 6GB, Hệ điều hành Win11', 25890000, 20, 'https://laptopaz.vn/media/product/3121_3081_2978_2687_2321_5.jpg', '2024-12-09', '2024-12-09', 2),

  ('Gigabyte G5 KE-52VN263SH', 'Intel Core i5-12500H, Ram 16GB, SSD 1TB, Màn hình 15.6" FHD 140Hz, VGA RTX 3060, Hệ điều hành Win11', 25990000, 10, 'https://laptopaz.vn/media/product/2670_thi___t_k____ch__a_c___t__n__5_.png', '2024-12-09', '2024-12-09', 5),
  ('Gigabyte G5 MF-E3VN313SH', 'Intel Core i5-12500H, Ram 16GB, SSD 512GB, Màn hình 15.6" FHD 144Hz, VGA RTX 4060 8GB, Hệ điều hành Win11', 25990000, 7, 'https://laptopaz.vn/media/product/2868_giga_g5_12th_1.jpg', '2024-12-09', '2024-12-09', 5),
  ('Gigabyte G5 MF-E3VN333SH', 'Intel Core i5-12500H, Ram 16GB, SSD 512GB, Màn hình 15.6" FHD 144Hz, VGA RTX 4060 8GB, Hệ điều hành Win11', 25790000, 9, 'https://laptopaz.vn/media/product/2869_13253_gigabyte_g5_kf_3.jpg', '2024-12-09', '2024-12-09', 5);

-- ============= CART =============
CREATE TABLE Cart (
    cartId INT AUTO_INCREMENT,
    cartCreate DATE,
    cartUpdate DATE,
    totalAmount DECIMAL(10, 2) DEFAULT 0.0,
    userID INT NOT NULL,
    PRIMARY KEY (cartId),
    FOREIGN KEY (userID) REFERENCES Users (userID) ON DELETE CASCADE
);

INSERT INTO Cart (cartCreate, cartUpdate, totalAmount, userID) 
VALUES ('2024-12-09', '2024-12-09', 0.0, 1);

-- ============= CART ITEM =============
CREATE TABLE CartItem (
    cartItemId INT AUTO_INCREMENT,
    quantity INT NOT NULL DEFAULT 1,
    cartPrice DECIMAL(10, 2) NOT NULL,
    cartTotal DECIMAL(10, 2) NOT NULL,
    cartId INT NOT NULL,
    product_id INT NOT NULL,
    PRIMARY KEY (cartItemId),
    FOREIGN KEY (cartId) REFERENCES Cart (cartId) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES Products (product_id) ON DELETE CASCADE
);
INSERT INTO CartItem (quantity, cartPrice, cartTotal, cartId, product_id) 
VALUES (2, 100.00, 200.00, 1, 1);

