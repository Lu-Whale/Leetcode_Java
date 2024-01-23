Create table If Not Exists Products (product_id int, product_name varchar(40), product_category varchar(40));
Create table If Not Exists Orders (product_id int, order_date date, unit int);

# https://leetcode.com/problems/list-the-products-ordered-in-a-period/?envType=study-plan-v2&envId=top-sql-50
SELECT product_id, SUM(unit) AS unit
FROM Orders
WHERE DATE_FORMAT(order_date, '%Y-%m') = '2020-02'
GROUP BY product_id;

SELECT product_name, unit
FROM Products p
INNER JOIN (
    SELECT product_id, SUM(unit) AS unit
    FROM Orders
    WHERE DATE_FORMAT(order_date, '%Y-%m') = '2020-02'
    GROUP BY product_id
) t ON p.product_id = t.product_id
WHERE t.unit >= 100