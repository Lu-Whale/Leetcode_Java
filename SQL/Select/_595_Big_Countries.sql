# https://leetcode.com/problems/big-countries/?envType=study-plan-v2&envId=top-sql-50
SELECT name, population, area
FROM World
WHERE population >= 25000000 OR area >= 3000000

# faster solution
select name, population, area from World where area>=3000000
union
select name, population, area from World where population>=25000000