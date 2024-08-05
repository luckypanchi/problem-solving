SELECT a.id ID, COUNT(b.id) CHILD_COUNT
FROM ecoli_data a LEFT JOIN ecoli_data b ON a.id = b.parent_id
GROUP BY a.id
ORDER BY a.id