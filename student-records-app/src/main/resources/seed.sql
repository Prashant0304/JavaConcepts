-- Insert students
INSERT INTO students (name, email) VALUES ('Asha', 'asha@example.test');
INSERT INTO students (name, email) VALUES ('Rahul', 'rahul@example.test');
INSERT INTO students (name, email) VALUES ('Priya', 'priya@example.test');
INSERT INTO students (name, email) VALUES ('Kiran', 'kiran@example.test');
INSERT INTO students (name, email) VALUES ('Ananya', 'ananya@example.test');

-- Insert courses
INSERT INTO courses (title, capacity) VALUES ('Java Programming', 30);
INSERT INTO courses (title, capacity) VALUES ('Database Fundamentals', 25);
INSERT INTO courses (title, capacity) VALUES ('Web Development', 20);

-- Insert enrollments
INSERT INTO enrollments (student_id, course_id) VALUES (1, 1);
INSERT INTO enrollments (student_id, course_id) VALUES (1, 2);
INSERT INTO enrollments (student_id, course_id) VALUES (2, 1);
INSERT INTO enrollments (student_id, course_id) VALUES (3, 3);
INSERT INTO enrollments (student_id, course_id) VALUES (4, 2);
INSERT INTO enrollments (student_id, course_id) VALUES (5, 3);