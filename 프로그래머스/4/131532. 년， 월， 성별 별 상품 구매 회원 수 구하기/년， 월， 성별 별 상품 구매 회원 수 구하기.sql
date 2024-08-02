SELECT YEAR(b.sales_date) YEAR, MONTH(b.sales_date) MONTH, a.gender GENDER, count(DISTINCT b.user_id) USERS
FROM user_info a JOIN online_sale b ON a.user_id = b.user_id
WHERE a.gender IS NOT NULL
GROUP BY YEAR, MONTH, GENDER
ORDER BY YEAR, MONTH, GENDER;