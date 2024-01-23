Create table If Not Exists Seat (id int, student varchar(255));

# https://leetcode.com/problems/exchange-seats/?envType=study-plan-v2&envId=top-sql-50
SELECT
    id,
    IF(
        id % 2 = 1,
        LEAD(student, 1, student) over (ORDER BY id),
        LAG(student, 1, student) over (ORDER BY id)
    ) AS student
FROM Seat;

