WITH RECURSIVE generation AS (
    SELECT id, 1 AS gen
    FROM ecoli_data
    WHERE parent_id IS NULL
    
    UNION ALL
    
    SELECT a.id, b.gen + 1
    FROM ecoli_data a JOIN generation b ON a.parent_id = b.id
)

SELECT COUNT(*) count, a.gen generation
FROM generation a LEFT JOIN ecoli_data b ON a.id = b.parent_id
WHERE b.id IS NULL
GROUP BY a.gen
ORDER BY a.gen