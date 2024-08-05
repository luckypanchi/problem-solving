SELECT a.emp_no EMP_NO, a.emp_name EMP_NAME, CASE 
                                WHEN AVG(b.score) >= 96 THEN 'S'
                                WHEN AVG(b.score) >= 90 THEN 'A'
                                WHEN AVG(b.score) >= 80 THEN 'B'
                                ELSE 'C' END GRADE
                            , CASE
                                WHEN AVG(b.score) >= 96 THEN a.sal * 0.2
                                WHEN AVG(b.score) >= 90 THEN a.sal * 0.15
                                WHEN AVG(b.score) >= 80 THEN a.sal * 0.1
                                ELSE 0 END BONUS
FROM hr_employees a JOIN hr_grade b ON a.emp_no = b.emp_no
GROUP BY a.emp_no
ORDER BY a.emp_no