# Write your MySQL query statement below
select a.id from Weather a left join Weather b on datediff(a.recordDate , b.recordDate) = 1 where a.temperature > b.temperature; 