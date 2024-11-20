Create database tanashop;
use tanashop;
-- drop database tanashop;

create table Users(
	userID INT AUTO_INCREMENT,
    username VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    fullName VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(20) UNIQUE,
    address VARCHAR(255),
    avatar VARCHAR(255),
    userCreatedDate DATE,
    userUpdatedDate DATE,
    userStatus ENUM('active', 'inactive', 'suspended') DEFAULT 'active',
    userRole ENUM('admin', 'manager', 'employee', 'customer') DEFAULT 'customer',
    PRIMARY KEY(userID)
);

INSERT INTO Users (username, password, fullName, email, phone, address, avatar, userCreatedDate, userUpdatedDate, userStatus, userRole)
VALUES ("admin", "admin", "ADMIN", "admin@gmail.com", "0123456789", "Thủ Đức", "AVATAR", "2024-11-11", "2024-11-11", "active", "admin");

INSERT INTO Users (username, password, fullName, email, phone, address, avatar, userCreatedDate, userUpdatedDate, userStatus, userRole)
VALUES ("tan", "tan", "Tân", "tan@gmail.com", "0368769799", "Thủ Đức", "AVATAR", "2024-11-11", "2024-11-11", "active", "manager");

select * from Users;