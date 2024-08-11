WITH 2021_year_join AS (
    SELECT user_id
    FROM user_info
    WHERE YEAR(joined) = 2021
)

SELECT YEAR(sales_date) year, MONTH(sales_date) month, COUNT(DISTINCT user_id) purchased_users, ROUND(COUNT(DISTINCT user_id) / (SELECT COUNT(*) FROM 2021_year_join), 1) purchased_ratio
FROM online_sale
WHERE user_id IN (SELECT user_id FROM 2021_year_join)
GROUP BY year, month
ORDER BY year, month;