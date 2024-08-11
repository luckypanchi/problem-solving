SELECT DISTINCT b.id, b.email, b.first_name, b.last_name
FROM skillcodes a JOIN developers b ON a.code & b.skill_code
WHERE a.category = 'Front End'
ORDER BY b.id;