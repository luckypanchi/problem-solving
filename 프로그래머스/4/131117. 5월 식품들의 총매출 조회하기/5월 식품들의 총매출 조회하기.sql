SELECT a.product_id, a.product_name, SUM(a.price * b.amount) total_sales
FROM food_product a JOIN food_order b USING (product_id)
WHERE DATE_FORMAT(b.produce_date, '%Y-%m') = "2022-05"
GROUP BY a.product_id
ORDER BY total_sales DESC, product_id