# Write your MySQL query statement below


select Max(salary) as SecondHighestSalary from Employee where salary not in (select MAX(salary)  from Employee e )