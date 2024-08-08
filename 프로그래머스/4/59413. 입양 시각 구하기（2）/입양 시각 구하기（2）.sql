WITH RECURSIVE cte AS (
    SELECT 0 AS h
    UNION ALL
    SELECT h + 1
    FROM cte
    WHERE h < 23
)

SELECT cte.h HOUR, COUNT(HOUR(a.datetime)) COUNT
FROM cte LEFT OUTER JOIN animal_outs a ON cte.h = HOUR(a.datetime)
GROUP BY cte.h