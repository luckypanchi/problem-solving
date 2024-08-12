WITH grade_cte AS (
    SELECT 
        CASE
            WHEN skill_code & (SELECT SUM(code) FROM skillcodes WHERE category = 'Front End') != 0
                AND skill_code & (SELECT code FROM skillcodes WHERE name = 'Python') != 0 THEN 'A'
            WHEN skill_code & (SELECT code FROM skillcodes WHERE name = 'C#') != 0 THEN 'B'
            WHEN skill_code & (SELECT SUM(code) FROM skillcodes WHERE category = 'Front End') != 0 THEN 'C' END grade,
        id
    FROM developers
)

SELECT b.grade, a.id, a.email
FROM developers a JOIN grade_cte b ON a.id = b.id
WHERE b.grade IS NOT NULL
ORDER BY b.grade, a.id;