CREATE DATABASE IF NOT EXISTS management_db;

CREATE TABLE Employee (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          department VARCHAR(255) NOT NULL,
                          salary DECIMAL(10, 2) NOT NULL
);

CREATE TABLE Project (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         budget DECIMAL(10, 2) NOT NULL
);

CREATE TABLE Assignment (
                            employee_id INT,
                            project_id INT,
                            role VARCHAR(255) NOT NULL,
                            PRIMARY KEY (employee_id, project_id),
                            FOREIGN KEY (employee_id) REFERENCES Employee(id),
                            FOREIGN KEY (project_id) REFERENCES Project(id)
);