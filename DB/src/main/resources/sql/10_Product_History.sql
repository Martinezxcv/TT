--liquibase formatted sql
--changeset marcin:1
CREATE TABLE Product_History (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Product_id INT,
    Employee_id INT,
    OldPrice FLOAT,
    NewPrice FLOAT,
    ChangeDate DATE,
    FOREIGN KEY (Product_id) REFERENCES Product(Id),
    FOREIGN KEY (Employee_id) REFERENCES Employee(Id)
);
