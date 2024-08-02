WITH check_milk AS (
    SELECT cart_id
    FROM cart_products
    WHERE name = 'Milk'
),
check_yogurt AS (
    SELECT cart_id
    FROM cart_products
    WHERE name = 'Yogurt'
)

SELECT cart_id
FROM check_milk JOIN check_yogurt USING (cart_id)
ORDER BY cart_id;