--liquibase formatted sql
--changeset marcin:1
CREATE TABLE Orders (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    OrderDate DATE
);
