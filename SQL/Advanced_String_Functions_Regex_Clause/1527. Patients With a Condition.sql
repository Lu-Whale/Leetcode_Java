Create table If Not Exists Patients (patient_id int, patient_name varchar(30), conditions varchar(100));

# https://leetcode.com/problems/patients-with-a-condition/?envType=study-plan-v2&envId=top-sql-50
SELECT *
FROM Patients
WHERE conditions LIKE ('DIB1%') OR conditions LIKE ('% DIAB1%');

#
SELECT *
FROM PATIENTS
WHERE CONDITIONS REGEXP '^DIAB1|\\sDIAB1';

# not a solution for this problem
SELECT *
FROM Patients
WHERE INSTR(conditions, 'DIAB1') > 0;
