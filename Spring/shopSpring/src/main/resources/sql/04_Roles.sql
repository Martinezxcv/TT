--liquibase formatted sql
--changeset marcin:1
CREATE TABLE Roles (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Role VARCHAR(255)
);
