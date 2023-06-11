CREATE TABLE employees (
id INT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
email VARCHAR(100) UNIQUE
);

DROP TABLE employees;

INSERT INTO employees (id, name, email)
VALUES 
(1, 'Joe Banks', 'joebanks@yahoo.com'), 
(2, 'Jane Smith', 'janesmith@aol.com'), 
(3, 'Mike Johnson', 'mikejohnson@gmail.com'), 
(4, 'Sarah Williams', 'sarahwilliams@revature.net');

SELECT * FROM employees;