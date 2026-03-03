CREATE DATABASE ProductManagement;

-- 1. Tạo bảng Product
CREATE TABLE Product (
    Product_Id SERIAL PRIMARY KEY,
    Product_Name VARCHAR(100) NOT NULL UNIQUE,
    Product_Price FLOAT NOT NULL CHECK (Product_Price > 0),
    Product_Title VARCHAR(200) NOT NULL,
    Product_created DATE NOT NULL,
    Product_catalog VARCHAR(100) NOT NULL,
    Product_Status BIT(1) DEFAULT '1'
);

-- 2. Procedure thêm mới sản phẩm
CREATE OR REPLACE PROCEDURE add_product(
    p_name VARCHAR, p_price FLOAT, p_title VARCHAR, 
    p_created DATE, p_catalog VARCHAR, p_status BIT
)
LANGUAGE plpgsql AS $$
BEGIN
    INSERT INTO Product (Product_Name, Product_Price, Product_Title, Product_created, Product_catalog, Product_Status)
    VALUES (p_name, p_price, p_title, p_created, p_catalog, p_status);
END;
$$;

-- 3. Procedure cập nhật sản phẩm
CREATE OR REPLACE PROCEDURE update_product(
    p_id INT, p_name VARCHAR, p_price FLOAT, p_title VARCHAR, 
    p_catalog VARCHAR, p_status BIT
)
LANGUAGE plpgsql AS $$
BEGIN
    UPDATE Product SET 
        Product_Name = p_name, Product_Price = p_price, 
        Product_Title = p_title, Product_catalog = p_catalog, 
        Product_Status = p_status
    WHERE Product_Id = p_id;
END;
$$;

-- 4. Procedure xóa sản phẩm
CREATE OR REPLACE PROCEDURE delete_product(p_id INT)
LANGUAGE plpgsql AS $$
BEGIN
    DELETE FROM Product WHERE Product_Id = p_id;
END;
$$;

-- 5. Function lấy tất cả sản phẩm (để JDBC dễ gọi)
CREATE OR REPLACE FUNCTION get_all_products() 
RETURNS SETOF Product LANGUAGE sql AS $$
    SELECT * FROM Product;
$$;