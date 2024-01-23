Create table If Not Exists Queue (person_id int, person_name varchar(30), weight int, turn int);

# https://leetcode.com/problems/last-person-to-fit-in-the-bus/?envType=study-plan-v2&envId=top-sql-50


SELECT person_name
FROM (
    SELECT *, SUM(weight) OVER (ORDER BY turn) AS Total_Weight
    FROM Queue
     ) as t
WHERE Total_Weight <= 1000
ORDER BY Total_Weight DESC
LIMIT 1;

# self join
SELECT a.person_name
FROM Queue a, Queue b
WHERE a.turn >= b.turn
GROUP BY a.person_id HAVING SUM(b.weight) <= 1000
ORDER BY a.turn DESC
LIMIT 1;

