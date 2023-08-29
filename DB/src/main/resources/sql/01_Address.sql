--liquibase formatted sql
--changeset marcin:1
CREATE TABLE Address (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Country VARCHAR(255),
    City VARCHAR(255),
    Zipcode VARCHAR(20),
    Street VARCHAR(255),
    Number VARCHAR(20),
    BaseAddress BOOLEAN
);