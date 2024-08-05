WITH rental_count AS (
    SELECT car_id
    FROM car_rental_company_rental_history
    GROUP BY car_id
    HAVING SUM(
        CASE WHEN start_date BETWEEN '2022-08-01' AND '2022-10-31' THEN 1 ELSE 0 END
    ) >= 5
)

SELECT MONTH(a.start_date) MONTH, a.car_id CAR_ID, count(*) RECORDS
FROM car_rental_company_rental_history a JOIN rental_count b ON a.car_id = b.car_id
WHERE a.start_date BETWEEN '2022-08-01' AND '2022-10-31'
GROUP BY MONTH, CAR_ID
HAVING RECORDS != 0
ORDER BY MONTH, CAR_ID DESC;