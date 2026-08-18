# Write your MySQL query statement below
select a.name as name from Employee a inner join Employee b on a.id = b.managerId group by a.id, a.name having count(*) >= 5;