Create table If Not Exists Users (user_id int, user_name varchar(20));
Create table If Not Exists Register (contest_id int, user_id int);

# https://leetcode.com/problems/percentage-of-users-attended-a-contest/?envType=study-plan-v2&envId=top-sql-50
select contest_id, ROUND(times / total * 100, 2) AS percentage
from (
         select contest_id, count(contest_id) AS times
         from Register
         group by contest_id
     ) grouped
cross join (
    select count(*) AS total
    from Users
) countUsers
order by percentage desc, contest_id
