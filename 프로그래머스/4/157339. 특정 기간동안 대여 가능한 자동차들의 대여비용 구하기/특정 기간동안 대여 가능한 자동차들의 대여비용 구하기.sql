WITH car_info AS (
    SELECT car_id, car_type, daily_fee * 30 * (
        CASE
            WHEN car_type = '세단' THEN (SELECT (100 - discount_rate) * 0.01 FROM car_rental_company_discount_plan WHERE car_type = '세단' AND duration_type = '30일 이상')
            WHEN car_type = 'SUV' THEN (SELECT (100 - discount_rate) * 0.01 FROM car_rental_company_discount_plan WHERE car_type = 'SUV' AND duration_type = '30일 이상') END
) fee
    FROM car_rental_company_car
    WHERE car_type IN ('세단', 'SUV')
),
rent_possible AS (
    SELECT car_id, SUM(
        CASE WHEN end_date < '2022-11-01' OR '2022-11-30' < start_date THEN 0
        ELSE 1 END
    ) possible
    FROM car_rental_company_rental_history
    GROUP BY car_id
)



SELECT a.car_id, a.car_type, ROUND(a.fee) fee
FROM car_info a JOIN rent_possible b ON a.car_id = b.car_id
WHERE b.possible = 0
    AND 500000 <= a.fee AND a.fee < 2000000
ORDER BY fee DESC, a.car_type, a.car_id DESC;