WITH cte AS (
	SELECT food_type, rest_id, rest_name, favorites, DENSE_RANK() OVER(PARTITION BY food_type ORDER BY favorites DESC) rnk
    FROM rest_info
)

SELECT food_type, rest_id, rest_name, favorites
FROM cte
WHERE rnk = 1
ORDER BY food_type DESC;