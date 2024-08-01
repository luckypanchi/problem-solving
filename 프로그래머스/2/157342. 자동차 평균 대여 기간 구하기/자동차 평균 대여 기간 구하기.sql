WITH avg_duration AS (
    SELECT car_id CAR_ID, ROUND(AVG(DATEDIFF(end_date, start_date) + 1), 1) AVERAGE_DURATION
    FROM car_rental_company_rental_history
    GROUP BY car_id    
)

SELECT CAR_ID, AVERAGE_DURATION
FROM avg_duration
WHERE AVERAGE_DURATION >= 7
ORDER BY AVERAGE_DURATION DESC, car_id DESC;

# SELECT car_id CAR_ID, ROUND(AVG(DATEDIFF(end_date, start_date) + 1), 1) AVERAGE_DURATION
# FROM car_rental_company_rental_history
# GROUP BY car_id
# HAVING AVERAGE_DURATION >= 7
# ORDER BY AVERAGE_DURATION DESC, car_id DESC;