create database cc2;
use cc2;
CREATE TABLE Product (
    productId INT PRIMARY KEY,
    productName VARCHAR(255),
    description VARCHAR(255),
    price DOUBLE,
    quantityInStock INT,
    type VARCHAR(20) CHECK (type IN ('Electronics', 'Clothing'))
);
-- Inserting values into the Product table
INSERT INTO Product (productId, productName, description, price, quantityInStock, type)
VALUES
  (1, 'Smartphone', 'High-end smartphone with advanced features', 599.99, 50, 'Electronics'),
  (2, 'Laptop', 'Powerful laptop for gaming and productivity', 1299.99, 30, 'Electronics'),
  (3, 'T-shirt', 'Casual cotton T-shirt', 19.99, 100, 'Clothing'),
  (4, 'LED TV', 'Ultra HD LED TV with smart features', 899.99, 20, 'Electronics'),
  (5, 'Jeans', 'Classic blue denim jeans', 39.99, 80, 'Clothing'),
  (6, 'Headphones', 'Wireless over-ear headphones with noise cancellation', 129.99, 40, 'Electronics'),
  (7, 'Sweater', 'Warm and cozy sweater for cold weather', 49.99, 60, 'Clothing'),
  (8, 'Tablet', 'Portable tablet for entertainment and productivity', 299.99, 25, 'Electronics'),
  (9, 'Dress Shirt', 'Formal dress shirt for professional occasions', 29.99, 75, 'Clothing'),
  (10, 'Digital Camera', 'High-resolution digital camera for photography enthusiasts', 449.99, 15, 'Electronics'),
   (11, 'Sneakers', 'Comfortable sneakers for everyday wear', 79.99, 40, 'Clothing'),
  (12, 'Winter Jacket', 'Waterproof winter jacket for cold weather', 129.99, 25, 'Clothing'),
  (13, 'Formal Pants', 'Classic formal pants for men', 49.99, 60, 'Clothing'),
  (14, 'Summer Dress', 'Light and airy dress for summer days', 39.99, 50, 'Clothing'),
  (15, 'Athletic Shorts', 'Breathable shorts for sports and workouts', 24.99, 70, 'Clothing');
  CREATE TABLE Electronics (
    productId INT PRIMARY KEY REFERENCES Product(productId),
    brand VARCHAR(255),
    warrantyPeriod INT,
    FOREIGN KEY (productId) REFERENCES Product(productId)
);

INSERT INTO Electronics (productId, brand, warrantyPeriod)
VALUES
  (1, 'Apple', 1),
  (2, 'Dell', 2),
  (4, 'Samsung', 3),
  (6, 'Sony', 2),
  (8, 'Microsoft', 1);
  
  CREATE TABLE Clothing (
    productId INT PRIMARY KEY REFERENCES Product(productId),
    size VARCHAR(10),
    color VARCHAR(50),
    FOREIGN KEY (productId) REFERENCES Product(productId)
);

INSERT INTO Clothing (productId, size, color)
VALUES
  (5, '38', 'blue denim'),
  (7,"L","red-white"),
  (11, '8', 'White'),
  (12, 'M', 'Black'),
  (13, '32', 'Gray'),
  (14, 'S', 'Blue'),
  (15, 'L', 'Red');
CREATE TABLE User (
    userId INT PRIMARY KEY,
    username VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    role VARCHAR(20) CHECK (role IN ('Admin', 'User'))
);
-- Inserting values into the User table
INSERT INTO User (userId, username, password, role)
VALUES
  (1, 'admin1', 'admin_password1', 'Admin'),
  (2, 'user1', 'user_password1', 'User'),
  (3, 'admin2', 'admin_password2', 'Admin'),
  (4, 'user2', 'user_password2', 'User'),
  (5, 'admin3', 'admin_password3', 'Admin'),
  (6, 'user3', 'user_password3', 'User'),
  (7, 'admin4', 'admin_password4', 'Admin'),
  (8, 'user4', 'user_password4', 'User'),
  (9, 'admin5', 'admin_password5', 'Admin'),
  (10, 'user5', 'user_password5', 'User');
  CREATE TABLE Orders1 (
    orderId INT PRIMARY KEY,
    o_date DATE,
    productId INT,
    userId INT,
    FOREIGN KEY (productId) REFERENCES Product(productId),
    FOREIGN KEY (userId) REFERENCES User(userId)
); 
INSERT INTO Orders1 (orderId, o_date, productId, userId)
VALUES
    (1, '2023-01-01', 1, 2),
    (2, '2023-01-02', 2, 1),
    (3, '2023-01-03', 3, 3),
    (4, '2023-01-04', 4, 2),
    (5, '2023-01-05', 5, 1),
    (6, '2023-01-06', 1, 3),
    (7, '2023-01-07', 2, 1),
    (8, '2023-01-08', 3, 2),
    (9, '2023-01-09', 4, 3),
    (10, '2023-01-10', 5, 1);
select * from orders1; 



