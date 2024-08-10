WITH row_number_table AS (
    SELECT id, ROW_NUMBER() OVER (ORDER BY size_of_colony DESC) row_num
    FROM ecoli_data
)

SELECT a.id, CASE 
    WHEN (b.row_num / (SELECT COUNT(*) FROM ecoli_data)) * 100 <= 25 THEN 'CRITICAL'
    WHEN (b.row_num / (SELECT COUNT(*) FROM ecoli_data)) * 100 <= 50 THEN 'HIGH'
    WHEN (b.row_num / (SELECT COUNT(*) FROM ecoli_data)) * 100 <= 75 THEN 'MEDIUM'
    WHEN (b.row_num / (SELECT COUNT(*) FROM ecoli_data)) * 100 <= 100 THEN 'LOW' END colony_name
FROM ecoli_data a JOIN row_number_table b ON a.id = b.id
ORDER BY a.id;