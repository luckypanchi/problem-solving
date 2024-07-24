SELECT floor(price / 10000) * 10000 AS product_group, count(*) AS products
FROM product
GROUP BY product_group
ORDER BY product_group