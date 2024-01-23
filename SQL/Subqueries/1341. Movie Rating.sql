Create table If Not Exists Movies (movie_id int, title varchar(30));
Create table If Not Exists Users (user_id int, name varchar(30));
Create table If Not Exists MovieRating (movie_id int, user_id int, rating int, created_at date);

# https://leetcode.com/problems/movie-rating/?envType=study-plan-v2&envId=top-sql-50
(SELECT title AS results
FROM Movies
INNER JOIN MovieRating MR on Movies.movie_id = MR.movie_id
WHERE DATE_FORMAT(created_at, '%Y-%m') = '2020-02'
GROUP BY title
ORDER BY AVG(rating) DESC, title
LIMIT 1)

UNION ALL

(SELECT name AS results
 FROM Users
          INNER JOIN MovieRating MR on Users.user_id = MR.user_id
 GROUP BY name
 ORDER BY COUNT(MR.user_id) DESC, name
 LIMIT 1)