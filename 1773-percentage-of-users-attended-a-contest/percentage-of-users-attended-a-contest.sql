# Write your MySQL query statement below
select  r.contest_id ,
 round(count(s.user_id)/
(select count(u1.user_id) from Users u1)
*100,2) as percentage
from Users s ,Register r where s.user_id = r.user_id
group by r.contest_id order by percentage desc ,r.contest_id asc ;