Create table If Not Exists Followers(user_id int, follower_id int);

# https://leetcode.com/problems/find-followers-count/?envType=study-plan-v2&envId=top-sql-50
SELECT user_id, count(*) AS followers_count
FROM Followers
group by user_id
ORDER BY user_id