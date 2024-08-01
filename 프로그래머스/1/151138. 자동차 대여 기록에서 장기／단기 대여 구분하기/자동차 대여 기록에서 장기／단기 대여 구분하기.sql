SELECT history_id, car_id, DATE_FORMAT(start_date, '%Y-%m-%d'), DATE_FORMAT(end_date, '%Y-%m-%d'), CASE 
                                                    WHEN DATEDIFF(end_date, start_date) + 1 >= 30 THEN '장기 대여'
                                                    ELSE '단기 대여' END RENT_TYPE
FROM car_rental_company_rental_history
WHERE DATE_FORMAT(start_date, '%Y-%m') = '2022-09'
ORDER BY history_id DESC;
