# Write your MySQL query statement below
select employee.name , Bonus.bonus from Employee left join Bonus on Employee.empId = Bonus.empId where Bonus.bonus < 1000 or Bonus.empId is null;
