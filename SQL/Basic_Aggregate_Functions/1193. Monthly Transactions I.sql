Create table If Not Exists Transactions (id int, country varchar(4), state enum('approved', 'declined'), amount int, trans_date date);

# https://leetcode.com/problems/monthly-transactions-i/?envType=study-plan-v2&envId=top-sql-50
SELECT
    DATE_FORMAT(trans_date, '%Y-%m') AS month,
    country,
    COUNT(*) AS trans_count,
    IFNULL(SUM(Transactions.state = 'approved'), 0) AS approved_count,
    IFNULL(SUM(Transactions.amount), 0) AS trans_total_amount,
    IFNULL(SUM(selected.amount), 0) AS approved_total_amount
FROM Transactions
LEFT JOIN (
    select id, state, amount
    from Transactions
    where state = 'approved'
) selected on selected.id = Transactions.id
group by DATE_FORMAT(trans_date, '%Y-%m'), country;

# better solution
SELECT
    DATE_FORMAT(trans_date, '%Y-%m') AS month,
    country,
    COUNT(*) AS trans_count,
    SUM(IF(state = 'approved', 1, 0)) AS approved_count,
    SUM(amount) AS trans_total_amount,
    SUM(IF(state = 'approved', amount, 0)) AS approved_total_amount
FROM Transactions
GROUP BY month, country


