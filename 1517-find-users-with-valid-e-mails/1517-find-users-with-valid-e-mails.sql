# Write your MySQL query statement below
select * 
from Users
where mail collate utf8mb3_bin regexp '^[A-Za-z][A-Za-z0-9_\.\-]*@leetcode[.]com$'