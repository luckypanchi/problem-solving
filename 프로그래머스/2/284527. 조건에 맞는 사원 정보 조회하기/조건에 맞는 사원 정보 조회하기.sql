SELECT SUM(c.score) SCORE, c.emp_no EMP_NO, a.emp_name EMP_NAME, a.position POSITION, a.email EMAIL
FROM hr_employees a 
    JOIN hr_department b USING (dept_id)
    JOIN hr_grade c USING (emp_no)
GROUP BY c.emp_no
ORDER BY SCORE DESC 
LIMIT 0, 1;