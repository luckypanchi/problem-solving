SELECT DATE_FORMAT(sales_date, '%Y-%m-%d') sales_date, product_id, user_id, sales_amount
FROM online_sale
WHERE DATE_FORMAT(sales_date, '%Y-%m') = '2022-03'
UNION ALL
SELECT DATE_FORMAT(sales_date, '%Y-%m-%d') sales_date, product_id, null, sales_amount
FROM offline_sale
WHERE DATE_FORMAT(sales_date, '%Y-%m') = '2022-03'
ORDER BY sales_date, product_id, user_id