Create table If Not Exists Queries (query_name varchar(30), result varchar(50), position int, rating int);

# https://leetcode.com/problems/queries-quality-and-percentage/?envType=study-plan-v2&envId=top-sql-50
select query_name,round(avg(rating/position), 2) AS quality, round(avg(rating < 3) * 100, 2) AS poor_query_percentage
from Queries
where query_name is not null
group by query_name
