# Write your MySQL query statement below
-- select (case when income < 20000 then 'Low Salary' when income >= 20000 and income <= 50000 then 'Average Salary' when income > 50000 then 'High Salary' end) as category , (count(account_id)) as accounts_count from Accounts group by category;

select 'Low Salary' as category , count(account_id) as accounts_count from Accounts where income < 20000
union
select 'Average Salary' as category , count(account_id) as accounts_count from Accounts where income >= 20000 and income <= 50000
union
select 'High Salary' as category , count(account_id) as accounts_count from Accounts where income > 50000