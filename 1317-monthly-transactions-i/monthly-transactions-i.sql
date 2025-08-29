# Write your MySQL query statement below
SELECT DATE_FORMAT(trans_date, '%Y-%m') as month, country ,count(*) as trans_count ,
COUNT(CASE WHEN state = 'approved' THEN 1 END)
as approved_count

, sum(amount)trans_total_amount 
, IFNULL(sum(case when state = 'approved' then amount END ),0)as approved_total_amount
from
Transactions group by YEAR(trans_date), month(trans_date) , country;