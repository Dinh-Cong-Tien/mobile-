-- Script tạo database và table cho Inventory App

-- 1. Tạo database
CREATE DATABASE inventory;

-- 2. Kết nối vào database inventory (chạy lệnh này nếu chưa kết nối)
-- \c inventory

-- 3. Tạo table items
CREATE TABLE IF NOT EXISTS items (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 4. (Optional) Thêm vài dữ liệu test
INSERT INTO items (name, price, quantity) VALUES 
    ('Laptop', 999.99, 5),
    ('Mouse', 29.99, 20),
    ('Keyboard', 79.99, 15);

-- Kiểm tra dữ liệu
SELECT * FROM items;
