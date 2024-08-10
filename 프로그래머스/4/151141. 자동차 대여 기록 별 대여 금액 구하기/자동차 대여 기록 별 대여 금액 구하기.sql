WITH truck_discount AS (
    SELECT (100 - discount_rate) * 0.01 discount, CASE 
                                                    WHEN duration_type = '7일 이상' THEN 7 
                                                    WHEN duration_type = '30일 이상' THEN 30 
                                                    WHEN duration_type = '90일 이상' THEN 90 END type
    FROM car_rental_company_discount_plan 
    WHERE car_type = '트럭'
)

SELECT b.history_id, 
    ROUND(a.daily_fee * (DATEDIFF(b.end_date, b.start_date) + 1) * 
    CASE
        WHEN DATEDIFF(b.end_date, b.start_date) + 1 >= 90 THEN (SELECT discount FROM truck_discount WHERE type = 90)
        WHEN DATEDIFF(b.end_date, b.start_date) + 1 >= 30 THEN (SELECT discount FROM truck_discount WHERE type = 30)
        WHEN DATEDIFF(b.end_date, b.start_date) + 1 >= 7 THEN (SELECT discount FROM truck_discount WHERE type = 7)
    ELSE 1 END) fee
FROM car_rental_company_car a JOIN car_rental_company_rental_history b ON a.car_id = b.car_id
WHERE a.car_type = '트럭'
ORDER BY fee DESC, b.history_id DESC
