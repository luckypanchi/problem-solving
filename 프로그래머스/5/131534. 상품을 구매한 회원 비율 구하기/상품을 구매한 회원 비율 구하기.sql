WITH join2021 AS (
	SELECT user_id
    FROM user_info
    WHERE YEAR(joined) = 2021
)

SELECT YEAR(b.sales_date) year, MONTH(b.sales_date) month, COUNT(distinct a.user_id) purchased_users, ROUND(COUNT(distinct a.user_id) / (SELECT COUNT(*) FROM join2021), 1) purchased_ratio
FROM join2021 a JOIN online_sale b ON a.user_id = b.user_id
GROUP BY year, month
ORDER BY year, month 