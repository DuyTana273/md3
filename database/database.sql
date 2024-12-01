Create database tanashop;
use tanashop;
-- drop database tanashop;

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
    categories_name VARCHAR(50),
    PRIMARY KEY (categories_id)
);

insert into Categories (categories_name) 
values ('ASUS');
insert into Categories (categories_name) 
values ('ACER');
insert into Categories (categories_name) 
values ('MSI');
insert into Categories (categories_name) 
values ('LENOVO');
insert into Categories (categories_name) 
values ('GIGABYTE');

-- ============= PRODUCTS =============
create table Products(
	product_id int auto_increment,
    product_name varchar(50) not null,
    product_description text,
    product_price decimal(10,2) not null,
    product_stock int,
    product_img varchar(255),
    categories_id int,
    primary key (product_id),
    foreign key (categories_id) references Categories (categories_id)
); 

insert into Products (product_name, product_description, product_price, product_stock, product_img, categories_id) 
values ('ASUS TUF', 'Ryzen 7-7735HS, Ram 16GB, SSD 512GB, Màn hình 16" FHD+ 165Hz, Hệ điều hành Win11, RX7700S 8GB', 22890000, 100,
"https://laptopaz.vn/media/product/3284_2984_s_l1600__2_.jpg", 1);


select * from Products;