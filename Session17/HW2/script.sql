-- 0. Tạo DB
CREATE DATABASE ToDoListDB;

-- 1. Tạo bảng tasks
CREATE TABLE tasks (
                       id SERIAL PRIMARY KEY,
                       task_name VARCHAR(255) NOT NULL,
                       status VARCHAR(50) DEFAULT 'chưa hoàn thành'
);

-- 2. Procedure thêm công việc
CREATE OR REPLACE PROCEDURE add_task(p_name VARCHAR, p_status VARCHAR)
LANGUAGE plpgsql
AS $$
BEGIN
        INSERT INTO tasks (task_name, status) VALUES (p_name, p_status);
END;
$$;

-- 3. Procedure cập nhật trạng thái
CREATE OR REPLACE PROCEDURE update_task_status(p_id INT, p_status VARCHAR)
LANGUAGE plpgsql
AS $$
BEGIN
        UPDATE tasks SET status = p_status WHERE id = p_id;
END;
$$;

-- 4. Procedure xóa công việc
CREATE OR REPLACE PROCEDURE delete_task(p_id INT)
LANGUAGE plpgsql
AS $$
BEGIN
        DELETE FROM tasks WHERE id = p_id;
END;
$$;

-- 5. Các Function để lấy dữ liệu (PostgreSQL dùng Function trả về Table cho việc liệt kê/tìm kiếm)
CREATE OR REPLACE FUNCTION list_tasks()
RETURNS TABLE(id INT, task_name VARCHAR, status VARCHAR)
AS $$
BEGIN
        RETURN QUERY SELECT * FROM tasks ORDER BY tasks.id;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION search_task_by_name(p_name VARCHAR)
RETURNS TABLE(id INT, task_name VARCHAR, status VARCHAR)
AS $$
BEGIN
       RETURN QUERY SELECT * FROM tasks WHERE tasks.task_name ILIKE '%' || p_name || '%';
END;
$$ LANGUAGE plpgsql;

-- 6. Function thống kê
CREATE OR REPLACE FUNCTION task_statistics()
RETURNS TABLE(status VARCHAR, total BIGINT)
AS $$
BEGIN
        RETURN QUERY SELECT tasks.status, COUNT(*) FROM tasks GROUP BY tasks.status;
END;
$$ LANGUAGE plpgsql;