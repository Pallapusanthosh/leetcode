SELECT 
  ROUND(
IFNULL(count(d.customer_id) * 100.0/NULLIF((select count(distinct customer_id) from delivery),0),0)
,2) as immediate_percentage
FROM delivery d
WHERE d.order_date = d.customer_pref_delivery_date
  AND d.delivery_id = (
      SELECT d2.delivery_id
      FROM delivery d2
      WHERE d2.customer_id = d.customer_id
      ORDER BY d2.order_date ASC
      LIMIT 1
  );
