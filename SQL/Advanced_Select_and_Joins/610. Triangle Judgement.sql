Create table If Not Exists Triangle (x int, y int, z int);

# https://leetcode.com/problems/triangle-judgement/?envType=study-plan-v2&envId=top-sql-50
SELECT x, y, z, IF(x + y > z AND x + z > y AND y + z > x, 'Yes', 'No') AS triangle
FROM Triangle

