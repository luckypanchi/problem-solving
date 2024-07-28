SELECT dept_id, a.dept_name_en, ROUND(AVG(b.sal)) AVG_SAL
FROM hr_department a JOIN hr_employees b USING (dept_id)
GROUP BY dept_id
ORDER BY AVG_SAL DESC;
