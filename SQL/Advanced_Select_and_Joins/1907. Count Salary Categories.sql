Create table If Not Exists Accounts (account_id int, income int);

# https://leetcode.com/problems/count-salary-categories/?envType=study-plan-v2&envId=top-sql-50
SELECT 'Low Salary' AS category, IFNULL(COUNT(*), 0) AS accounts_count
FROM Accounts
WHERE income < 20000
UNION
SELECT 'Average Salary' AS category, IFNULL(COUNT(*), 0) AS accounts_count
FROM Accounts
WHERE income BETWEEN 20000 AND 50000
UNION
SELECT 'High Salary' AS category, IFNULL(COUNT(*), 0) AS accounts_count
FROM Accounts
WHERE income > 50000