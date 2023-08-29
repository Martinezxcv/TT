--liquibase formatted sql
--changeset marcin:1
CREATE TABLE Employee (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Login_id INT,
    Role_id INT,
    ProductHistory_id INT,
    Firstname VARCHAR(255),
    Lastname VARCHAR(255),
    Phone VARCHAR(20),
    Email VARCHAR(255),
    FOREIGN KEY (Login_id) REFERENCES Login(Id),
    FOREIGN KEY (Role_id) REFERENCES Roles(Id)
);
