# Write your MySQL query statement below
select firstName , lastName ,city , state
        from person p LEFT JOIN Address a
        on p.personId = a.personId

