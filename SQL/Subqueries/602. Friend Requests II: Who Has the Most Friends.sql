Create table If Not Exists RequestAccepted (requester_id int not null, accepter_id int null, accept_date date null);

# https://leetcode.com/problems/friend-requests-ii-who-has-the-most-friends/description/?envType=study-plan-v2&envId=top-sql-50
WITH t1 AS (
    SELECT COUNT(requester_id) AS counts, requester_id AS id
    FROM RequestAccepted
    GROUP BY requester_id
),
t2 AS (
    SELECT COUNT(accepter_id) AS counts, accepter_id AS id
    FROM RequestAccepted
    GROUP BY accepter_id
    )
SELECT t1.id, (t1.counts + IFNULL(t2.counts, 0)) AS num
FROM t1
LEFT JOIN t2 ON t1.id = t2.id
UNION
SELECT id, counts AS num
FROM t2
WHERE id NOT IN (SELECT id FROM t1)
ORDER BY num DESC
LIMIT 1;

#
select id, sum(num) as num
from
    (select accepter_id as id, count(*)as num
     from RequestAccepted
     group by accepter_id

     union all

     select requester_id as id,count(*) asnum
     from  RequestAccepted
     group by requester_id
     ) as t
group by id
order by num desc
limit 1




