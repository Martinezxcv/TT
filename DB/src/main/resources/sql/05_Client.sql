--liquibase formatted sql
--changeset marcin:1
CREATE TABLE Client (
    Id INT PRIMARY KEY,
    Login_id INT,
    Address_id INT,
    Cart_id INT,
    Firstname VARCHAR(255),
    Lastname VARCHAR(255),
    Phone VARCHAR(20),
    Email VARCHAR(255),
    FOREIGN KEY (Login_id) REFERENCES Login(Id),
    FOREIGN KEY (Address_id) REFERENCES Address(Id),
    FOREIGN KEY (Cart_id) REFERENCES Cart(Id)
);