SELECT a.flavor
FROM first_half a JOIN july b ON a.flavor = b.flavor
GROUP BY a.flavor
ORDER BY SUM(a.total_order + b.total_order) DESC
LIMIT 3;