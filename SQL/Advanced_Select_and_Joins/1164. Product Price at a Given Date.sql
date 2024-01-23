Create table If Not Exists Products (product_id int, new_price int, change_date date);

# https://leetcode.com/problems/product-price-at-a-given-date/?envType=study-plan-v2&envId=top-sql-50
SELECT p_id.product_id, IFNULL(p_price.new_price, 10) AS price
FROM (
         SELECT DISTINCT product_id
         FROM Products
     ) p_id
         LEFT JOIN (
    SELECT product_id, new_price
    FROM Products
    WHERE (product_id, change_date) IN (
        SELECT product_id, MAX(change_date) AS lastestDate
        FROM (
                 SELECT product_id, new_price, change_date
                 FROM Products
                 WHERE change_date <= '2019-08-16'
             ) legalDate
        GROUP BY product_id
    )
) p_price ON p_id.product_id = p_price.product_id


# optimised solution
SELECT p_id.product_id, IFNULL(p_price.new_price, 10) AS price
FROM (
    SELECT DISTINCT product_id
    FROM Products
     ) p_id
LEFT JOIN (
    SELECT product_id, new_price
    FROM Products
    WHERE (product_id, change_date) IN (
        SELECT product_id, MAX(change_date)
        FROM Products
        WHERE change_date <= '2019-08-16'
        GROUP BY product_id
    )
) p_price ON p_id.product_id = p_price.product_id

# union solution
SELECT product_id,new_price AS price
FROM Products
WHERE (product_id,change_date) IN (
    SELECT product_id,MAX(change_date)
    FROM Products
    WHERE change_date <= '2019-08-16'
    GROUP BY product_id
)
UNION ALL
SELECT DISTINCT product_id,10 AS price -- 10 AS price
FROM Products
WHERE product_id NOT IN (
    SELECT product_id
    FROM Products
    WHERE change_date <= '2019-08-16'
);

# WITH ... AS solution
WITH RecentPrices AS (
    SELECT
        p1.product_id,
        p1.new_price,
        ROW_NUMBER() OVER (PARTITION BY p1.product_id ORDER BY p1.change_date DESC) AS rn
    FROM
        products p1
    WHERE
            p1.change_date <= '2019-08-16'
),
     ProductList AS (
         SELECT DISTINCT
             product_id
         FROM
             products
     )
SELECT
    p.product_id,
    IFNULL(rp.new_price, 10) AS price
FROM
    ProductList p
        LEFT JOIN
    RecentPrices rp ON p.product_id = rp.product_id AND rp.rn = 1;