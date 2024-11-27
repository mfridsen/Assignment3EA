-- Table for Students
CREATE TABLE students (
                          student_id INT AUTO_INCREMENT PRIMARY KEY,
                          student_name VARCHAR(100) NOT NULL,
                          personnummer VARCHAR(13) UNIQUE NOT NULL,
                          username VARCHAR(8) UNIQUE NOT NULL
);

-- Table for Courses
CREATE TABLE courses (
                         course_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         course_name VARCHAR(100) NOT NULL,
                         course_code VARCHAR(10) UNIQUE NOT NULL
);

-- Table for Modules
CREATE TABLE modules (
                         module_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         module_name VARCHAR(100) NOT NULL,
                         module_code VARCHAR(10) NOT NULL,
                         course_id BIGINT NOT NULL,
                         UNIQUE (module_code, course_id),
                         FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

-- Table for Results
CREATE TABLE results (
                         result_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         date DATE NOT NULL,
                         grade VARCHAR(5) NOT NULL,
                         status VARCHAR(20) DEFAULT 'pending',
                         student_id INT NOT NULL,
                         module_id BIGINT NOT NULL,
                         FOREIGN KEY (student_id) REFERENCES students(student_id) ON DELETE CASCADE,
                         FOREIGN KEY (module_id) REFERENCES modules(module_id) ON DELETE CASCADE
);
