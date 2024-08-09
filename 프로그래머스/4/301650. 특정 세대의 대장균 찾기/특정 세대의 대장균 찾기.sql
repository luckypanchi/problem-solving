WITH first_gen AS (
    SELECT id
    FROM ecoli_data
    WHERE parent_id IS NULL
), 
second_gen AS (
    SELECT id
    FROM ecoli_data
    WHERE parent_id IN (SELECT id FROM first_gen)
),
third_gen AS (
    SELECT id
    FROM ecoli_data
    WHERE parent_id IN (SELECT id FROM second_gen)
)

SELECT id
FROM third_gen
ORDER BY id