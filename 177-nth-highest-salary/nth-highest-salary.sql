CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  DECLARE result INT;
  SET N = N-1;
  select distinct salary as getNthHighestSalary INTO result
  from Employee
  order by salary DESC
  LIMIT N,1;
  RETURN result;
END