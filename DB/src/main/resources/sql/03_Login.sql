--liquibase formatted sql
--changeset marcin:1
CREATE TABLE Login (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Login VARCHAR(255),
    Password VARCHAR(255)
);
