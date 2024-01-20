# https://leetcode.com/problems/fix-names-in-a-table/?envType=study-plan-v2&envId=top-sql-50
SELECT user_id, CONCAT(UPPER(substring(name, 1, 1)), LOWER(substring(name, 2))) AS name
FROM Users
ORDER BY user_id