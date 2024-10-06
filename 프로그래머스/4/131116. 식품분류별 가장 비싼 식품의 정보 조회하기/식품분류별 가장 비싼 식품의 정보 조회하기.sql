SELECT filtered.category CATEGORY, filtered.price MAX_PRICE, filtered.product_name PRODUCT_NAME
FROM (
    SELECT category, price, product_name, RANK() OVER(PARTITION BY category ORDER BY price DESC) AS rnk
    FROM food_product
    WHERE category IN ('과자', '국', '김치', '식용유')
) filtered
WHERE filtered.rnk = 1
ORDER BY filtered.price DESC;
