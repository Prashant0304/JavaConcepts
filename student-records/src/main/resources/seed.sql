INSERT INTO students(name,email) VALUES
('Asha Rao', 'asha@example.test'),
('John Doe', 'john@example.test'),
('Jane Smith', 'jane@example.test'),
('Rahul Sharma', 'rahul@example.test'),
('Maria Garcia', 'maria@example.test');

INSERT INTO courses(title, capacity) VALUES
('Java Foundations', 30),
('Web Development', 25),
('Database Design', 20);

INSERT INTO enrollments(student_id,course_id) VALUES
(1, 1), (1, 2),
(2, 1),
(3, 2), (3, 3),
(4, 1);