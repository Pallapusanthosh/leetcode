# Write your MySQL query statement below

 

select s.name as name from SalesPerson s where  s.sales_id not in (select o.sales_id from Company c , Orders o where c.com_id = o.com_id and c.name = "RED"
) 