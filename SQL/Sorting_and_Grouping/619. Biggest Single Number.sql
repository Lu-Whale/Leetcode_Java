Create table If Not Exists MyNumbers (num int)

# https://leetcode.com/problems/biggest-single-number/description/?envType=study-plan-v2&envId=top-sql-50
SELECT MAX(num) AS num
FROM MyNumbers
WHERE num IN (
    SELECT num
    FROM MyNumbers
    GROUP BY num
    HAVING COUNT(num) = 1
    );

#
SELECT
    MAX(num) AS num
FROM
    (SELECT
         num
     FROM
         MyNumbers
     GROUP BY num
     HAVING COUNT(num) = 1) AS t
;