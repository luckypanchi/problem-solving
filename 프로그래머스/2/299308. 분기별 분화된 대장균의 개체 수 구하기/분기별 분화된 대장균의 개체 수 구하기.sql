WITH quarter_table AS (
    SELECT id, CASE 
                    WHEN MONTH(differentiation_date) IN (1, 2, 3) THEN '1Q'
                    WHEN MONTH(differentiation_date) IN (4, 5, 6) THEN '2Q'
                    WHEN MONTH(differentiation_date) IN (7, 8, 9) THEN '3Q'
                    WHEN MONTH(differentiation_date) IN (10, 11, 12) THEN '4Q'
                    END quarter
    FROM ecoli_data
)

SELECT quarter, COUNT(*) ecoli_count
FROM quarter_table
GROUP BY quarter
ORDER BY quarter