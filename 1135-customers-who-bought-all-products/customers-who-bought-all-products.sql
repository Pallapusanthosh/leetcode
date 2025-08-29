# Write your MySQL query statement below
select c.customer_id  from customer c ,product p where p.product_key = c.product_key
group by c.customer_id having count(distinct  p.product_key)= (SELECT COUNT(*) FROM product);  