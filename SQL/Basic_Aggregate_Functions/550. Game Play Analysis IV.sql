Create table If Not Exists Activity (player_id int, device_id int, event_date date, games_played int);

# https://leetcode.com/problems/game-play-analysis-iv/description/?envType=study-plan-v2&envId=top-sql-50
SELECT ROUND(COUNT(*) / (SELECT COUNT(DISTINCT player_id) FROM Activity), 2) AS fraction
FROM Activity
WHERE (player_id, event_date) IN (
    SELECT player_id, DATE_ADD(MIN(event_date), INTERVAL 1 DAY) AS next_day
    FROM Activity
    GROUP BY player_id
    );

#
select IFNULL(round(count(distinct(Result.player_id)) / count(distinct(Activity.player_id)), 2), 0) as fraction
from Activity, (
         select Activity.player_id as player_id
         from (
                  select player_id, DATE_ADD(MIN(event_date), INTERVAL 1 DAY) as second_date
                  from Activity
                  group by player_id
              ) as Expected, Activity
         where Activity.event_date = Expected.second_date and Activity.player_id = Expected.player_id
     ) as Result







