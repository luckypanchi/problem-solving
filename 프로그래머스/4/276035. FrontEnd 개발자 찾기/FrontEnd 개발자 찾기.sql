SELECT DISTINCT b.id id, b.email email, b.first_name first_name, b.last_name last_name
FROM skillcodes a JOIN developers b ON a.code & b.skill_code
WHERE a.category = 'Front End'
ORDER BY b.id;