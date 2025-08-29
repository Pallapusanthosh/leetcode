-- SELECT 
--     CASE 
--         WHEN id % 2 = 1 AND id + 1 <= (SELECT MAX(id) FROM seat) THEN id + 1
--         WHEN id % 2 = 0 THEN id - 1
--         ELSE id
--     END AS id,
--     student
-- FROM seat
-- ORDER BY id;
select 
  case 
    when id %2 =0 then id -1
    when id%2 =1 and id+1 <=(select max(id) from seat) then id +1
    else id
  end as id,

student from seat order by id asc;