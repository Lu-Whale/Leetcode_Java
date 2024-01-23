Create table If Not Exists Logs (id int, num int);

# https://leetcode.com/problems/consecutive-numbers/?envType=study-plan-v2&envId=top-sql-50
SELECT DISTINCT l1.num AS ConsecutiveNums
FROM Logs l1, Logs l2, Logs l3
WHERE l1.id = l2.id - 1 AND l2.id = l3.id - 1 AND l1.num = l2.num AND l2.num = l3.num;

# lag
SELECT DISTINCT num1 AS ConsecutiveNums
FROM (
    SELECT
        num AS num1,
        LAG(num, 1) over (ORDER BY id) AS num2,
        LAG(num, 2) over (ORDER BY id) AS num3
    FROM Logs
     ) pair
WHERE num1 = num2 AND num2 = num3;

# row_number
select
    distinct t.num as ConsecutiveNums
from
    (
        select
            id,
            num,
            row_number() over(order by id) as rn,
            row_number() over(partition by num order by id) as id_rn
        from Logs
    ) t
group by t.num, (t.rn - t.id_rn)
having count(*) >= 3;
