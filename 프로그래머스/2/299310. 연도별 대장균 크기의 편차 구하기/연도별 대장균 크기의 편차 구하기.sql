WITH max_size_per_year AS (
    SELECT YEAR(differentiation_date) year, MAX(size_of_colony) max_size
    FROM ecoli_data
    GROUP BY year
)

SELECT b.year YEAR, b.max_size - a.size_of_colony YEAR_DEV, a.id ID
FROM ecoli_data a JOIN max_size_per_year b ON YEAR(a.differentiation_date) = b.year
ORDER BY year, year_dev;