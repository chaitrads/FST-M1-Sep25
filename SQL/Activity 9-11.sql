-- Create the customers table
create table customers (
    customer_id int primary key, customer_name varchar(32),
    city varchar(20), grade int, salesman_id int);

-- Insert values into it
INSERT ALL
    INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001)
    INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001)
    INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002)
    INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002)
    INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006)
    INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003)
    INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007)
    INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005)
SELECT 1 FROM DUAL;

-- Activity 9

-- Write an SQL statement to know which salesman are working for which customer.
SELECT c.customer_name, s.salesman_name 
FROM CUSTOMERS c INNER JOIN SALESMAN s
ON c.salesman_id = s.salesman_id; 

-- Write an SQL statement to make a list of customers in ascending order with a salesman that have a grade less than 300.
SELECT c.customer_name, c.city, c.grade, s.salesman_name, s.salesman_city
FROM CUSTOMERS c INNER JOIN SALESMAN s
ON c.salesman_id = s. salesman_id WHERE c.grade<300
ORDER BY c.customer_name; 

-- Write an SQL statement to find the list of customers who appointed a salesman who gets a commission of more than 12%.
SELECT c.customer_name, c.city, c.grade, s.salesman_name,s.commision, s.salesman_city
FROM CUSTOMERS c INNER JOIN SALESMAN s
ON c.salesman_id = s. salesman_id WHERE s.commision >12
ORDER BY c.customer_name; 

-- Write an SQL statement to find the following details of an order - order number, order date, purchase amount of order, 
-- which customer gives the order and which salesman works for that customer and commission rate they get for the order.

SELECT o.order_no, o.order_date, o.purchase_amount, c.customer_id, c.customer_name, c.grade, s.salesman_id, s.salesman_name, s.commision 
FROM ORDERS o INNER JOIN customers c ON o.customer_id = c.customer_id 
INNER JOIN salesman s ON o.salesman_id = s.salesman_id
ORDER BY o.order_no;


--Activity 10

-- Write a query to find all the orders issued against the salesman who may works for customer whose id is 3007.
SELECT * FROM orders o WHERE o.salesman_id =(SELECT salesman_id FROM orders WHERE customer_id =3007) ;

-- Write a query to find all orders attributed to a salesman in New York.
SELECT * FROM orders WHERE salesman_id = (SELECT salesman_id FROM salesman WHERE salesman_city ='New York');

-- Write a query to count the customers with grades above New York's average.
SELECT grade,COUNT(*) FROM customers 
GROUP BY grade HAVING grade> (SELECT AVG(grade) FROM customers WHERE city='New York') ;

-- Write a query to extract the data from the orders table for those salesman who earned the maximum commission

SELECT * FROM orders WHERE salesman_id =(SELECT salesman_id FROM salesman WHERE commision =(SELECT MAX(commision) FROM salesman) );


--Activity 11

-- Write a query that produces the name and number of each salesman and each customer with more than one current order.
--  Put the results in alphabetical order.
SELECT customer_id, customer_name FROM customers a
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.customer_id = b.customer_id)
UNION
SELECT salesman_id, salesman_name FROM salesman a
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.salesman_id = b.salesman_id)
ORDER BY customer_name;



-- Write a query to make a report of which salesman produce the largest and smallest orders on each date. 
-- Also add a column that shows "highest on" and "lowest on" values.
SELECT s.salesman_id, s.salesman_name, o.order_no, 'highest on', o.order_date, o.purchase_amount FROM salesman s, orders o
WHERE s.salesman_id=o.salesman_id
AND o.purchase_amount=(SELECT MAX(purchase_amount) FROM orders c WHERE c.order_date = o.order_date)
UNION
SELECT s.salesman_id, s.salesman_name, o.order_no, 'lowest on', o.order_date, o.purchase_amount FROM salesman s, orders o
WHERE s.salesman_id=o.salesman_id
AND o.purchase_amount=(SELECT MIN(purchase_amount) FROM orders c WHERE c.order_date = o.order_date)
ORDER BY order_date;