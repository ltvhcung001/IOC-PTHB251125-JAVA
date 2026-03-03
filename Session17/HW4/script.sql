CREATE DATABASE sales_management;
CREATE TABLE Product (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         price DECIMAL(10,2) NOT NULL
);

CREATE TABLE Customer (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          email VARCHAR(255) UNIQUE
);

CREATE TABLE Orders (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        customer_id INT,
                        order_date DATE NOT NULL,
                        total_amount DECIMAL(10,2) NOT NULL,
                        FOREIGN KEY (customer_id) REFERENCES Customer(id)
);