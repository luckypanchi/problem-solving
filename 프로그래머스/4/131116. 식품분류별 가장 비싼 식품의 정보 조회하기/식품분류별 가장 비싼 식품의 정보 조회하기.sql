SELECT category, price, product_name
FROM (
    SELECT category, price, product_name, RANK() OVER(PARTITION BY category ORDER BY price DESC) AS rnk
    FROM food_product
    WHERE category in ('과자', '국', '김치', '식용유')
) a
WHERE rnk = 1
ORDER BY price DESC;