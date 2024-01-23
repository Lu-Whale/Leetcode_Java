Create table If Not Exists Customer (customer_id int, name varchar(20), visited_on date, amount int);

# https://leetcode.com/problems/restaurant-growth/?envType=study-plan-v2&envId=top-sql-50
SELECT visited_on, amount, ROUND(amount / 7, 2) AS average_amount
FROM (
         SELECT
             visited_on,
             SUM(daily_amount) OVER (ORDER BY visited_on ROWS BETWEEN 6 PRECEDING AND CURRENT ROW ) AS amount,
             ROW_NUMBER() over (ORDER BY visited_on) AS id
         FROM (
                  SELECT
                      visited_on,
                      SUM(amount) AS daily_amount
                  FROM Customer
                  GROUP BY visited_on
                  ORDER BY visited_on
              ) t
     ) results
WHERE id >= 7;

#
-- 参考：开窗函数： 之前的 - preceding
select distinct visited_on, total as amount, ROUND(total/7, 2) as average_amount
from (
         select visited_on,
                SUM(amount) OVER (ORDER BY visited_on RANGE INTERVAL 6 DAY PRECEDING) as total
         from Customer
     ) as a
where visited_on >= (select MIN(visited_on) from Customer) + 6;

