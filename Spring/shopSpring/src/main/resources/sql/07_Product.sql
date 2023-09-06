--liquibase formatted sql
--changeset marcin:1
CREATE TABLE Product (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(255),
    Price FLOAT,
    Available INT,
    Quantity INT,
    Description VARCHAR(255)
);

CREATE TABLE Product_Cart (
    Product_id INT,
    Cart_id INT,
    PRIMARY KEY (Product_id, Cart_id),
    FOREIGN KEY (Product_id) REFERENCES Product(Id),
    FOREIGN KEY (Cart_id) REFERENCES Cart(Id)
);

CREATE TABLE Product_Order (
    Product_id INT,
    Order_id INT,
    Price FLOAT,
    Quantity INT,
    PRIMARY KEY (Product_id, Order_id),
    FOREIGN KEY (Product_id) REFERENCES Product(Id),
    FOREIGN KEY (Order_id) REFERENCES Orders(Id)
);

