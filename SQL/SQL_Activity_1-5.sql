-- For full Reset 
Drop TABLE salesman;
--Activity 1
-- Create the Salesman table
CREATE TABLE salesman(salesman_id int PRIMARY KEY, salesman_name VARCHAR(20) NOT NULL UNIQUE, salesman_city VARCHAR(20), commision int);
-- To View the table schema
DESCRIBE salesman;

--Activity2
-- Insert one row
INSERT INTO salesman VALUES(5001, 'James Hoog', 'New York', 15);
INSERT INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13);

-- Insert multiple rows at once
INSERT ALL
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11)
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14)
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13)
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12)
SELECT 1 FROM DUAL;

-- More data
INSERT ALL
    INTO salesman VALUES(5008, 'Pitt Bull', 'Hamunaputra', 20)
    INTO salesman VALUES(5009, 'Lion King', 'Saudi', 4)
    INTO salesman VALUES(5010, 'Adam Sandleer', 'Racoon City', 32)
    INTO salesman VALUES(5004, 'Han Solo', 'Santa Monica', 12)
SELECT 1 FROM DUAL;

-- beyond limits will fail
INSERT INTO salesman VALUES(5002, 'Nail Knite wing gaurdian leviaosa', 'Paris in the city of france in europe', 13);

-- View data from all columns
SELECT * FROM salesman;

-- Activity 3

-- Show data from the salesman_id and salesman_city columns
SELECT salesman,salesman_city FROM salesman;

--Show data of salesman from Paris
SELECT * FROM salesman WHERE salesman_city ='Paris';
--Show salesman_id and commission of Paul Adam
SELECT salesman_id,commision FROM salesman WHERE LOWER (salesman_name) = LOWER('Paul Adam');

-- Activity 4
-- add a new grade column 
ALTER TABLE salesman Add grade int;

--Set the grade column's value to 100
UPDATE salesman SET grade = 100;

SELECT * FROM salesman;

-- Activity 5

-- Update the grade score of salesmen from Rome to 200.
UPDATE salesman SET grade= 200 WHERE salesman_city ='Rome'; 
-- Update the grade score of James Hoog to 300.
UPDATE salesman SET grade = 300 WHERE salesman_name = 'James Hoog';
-- Update the name McLyon to Pierre.
UPDATE salesman SET salesman_name = 'Pierre' WHERE salesman_name= 'McLyon'

-- To view all the results
SELECT * FROM salesman;