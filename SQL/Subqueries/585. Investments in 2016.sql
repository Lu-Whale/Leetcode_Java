Create Table If Not Exists Insurance (pid int, tiv_2015 float, tiv_2016 float, lat float, lon float);

# https://leetcode.com/problems/investments-in-2016/?envType=study-plan-v2&envId=top-sql-50
SELECT ROUND(SUM(tiv_2016), 2) AS tiv_2016
FROM (
         SELECT tiv_2016
         FROM Insurance i1
         WHERE tiv_2015 IN (
             SELECT tiv_2015
             FROM Insurance i2
             WHERE i1.pid != i2.pid
         ) AND (lat, lon) NOT IN (
             SELECT lat, lon
             FROM Insurance i3
             WHERE i1.pid != i3.pid
         )
     ) t1