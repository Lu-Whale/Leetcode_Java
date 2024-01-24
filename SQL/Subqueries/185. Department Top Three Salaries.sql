Create table If Not Exists Employee (id int, name varchar(255), salary int, departmentId int);
Create table If Not Exists Department (id int, name varchar(255));

# https://leetcode.com/problems/department-top-three-salaries/?envType=study-plan-v2&envId=top-sql-50
SELECT d.name AS Department, e.name AS Employee, e.salary AS Salary
FROM Department d
JOIN Employee e on d.id = e.departmentId
WHERE 3 > (
        SELECT COUNT(DISTINCT e2.salary)
        FROM Employee e2
        WHERE e2.salary > e.salary AND e.departmentId = e2.departmentId
    );

#
SELECT Department, Employee, Salary
FROM (
         SELECT
             d.name AS Department,
             e.name AS Employee,
             e.salary AS Salary,
             DENSE_RANK() OVER (PARTITION BY e.departmentId ORDER BY e.salary DESC ) AS ranks
         FROM Employee e
                  LEFT JOIN Department d ON d.id = e.departmentId
     ) t
WHERE ranks <= 3
