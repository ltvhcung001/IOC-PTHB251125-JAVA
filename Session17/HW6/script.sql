CREATE DATABASE school_db;

CREATE TABLE Student (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE Course (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    credits INT NOT NULL
);

CREATE TABLE Enrollment (
    student_id INT,
    course_id INT,
    grade DECIMAL(5, 2) DEFAULT NULL,
    PRIMARY KEY (student_id, course_id),
    FOREIGN KEY (student_id) REFERENCES Student(id),
    FOREIGN KEY (course_id) REFERENCES Course(id)
);