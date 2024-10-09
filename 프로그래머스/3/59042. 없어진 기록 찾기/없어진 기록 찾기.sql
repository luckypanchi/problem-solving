SELECT a.animal_id, a.name
FROM animal_outs a LEFT OUTER JOIN animal_ins b ON a.animal_id = b.animal_id
WHERE b.animal_id IS NULL
ORDER BY a.animal_id;