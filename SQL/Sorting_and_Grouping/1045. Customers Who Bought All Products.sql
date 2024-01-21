Create table If Not Exists Customer (customer_id int, product_key int);
Create table Product (product_key int);

# https://leetcode.com/problems/customers-who-bought-all-products/?envType=study-plan-v2&envId=top-sql-50
SELECT customer_id
FROM Customer
GROUP BY customer_id
# One customer could buy same product many times, thus we need to use DISTINCT product_key to count
HAVING COUNT(DISTINCT product_key) = (
    SELECT COUNT(product_key)
    FROM Product
    )

