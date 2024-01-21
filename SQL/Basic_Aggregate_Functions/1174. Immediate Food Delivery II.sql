Create table If Not Exists Delivery (delivery_id int, customer_id int, order_date date, customer_pref_delivery_date date);

# https://leetcode.com/problems/immediate-food-delivery-ii/?envType=study-plan-v2&envId=top-sql-50
SELECT
    ROUND(SUM(IF(order_date = customer_pref_delivery_date, 1, 0)) / COUNT(*) * 100, 2) AS immediate_percentage
FROM Delivery
WHERE (customer_id, order_date) in (
    select customer_id, MIN(order_date)
    from Delivery
    group by customer_id
    )