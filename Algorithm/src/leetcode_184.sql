SELECT B.name AS Department, A.name AS Employee, Salary
FROM Employee AS A
INNER JOIN Department AS B ON A.departmentId = B.id
WHERE (departmentId, A.salary) IN (
    SELECT departmentId, MAX(salary)
    FROM Employee
    GROUP BY departmentId
);
