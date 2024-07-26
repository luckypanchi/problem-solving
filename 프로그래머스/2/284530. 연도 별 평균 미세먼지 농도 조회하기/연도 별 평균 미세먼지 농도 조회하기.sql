SELECT YEAR(YM) YEAR, ROUND(AVG(pm_val1), 2) PM10, ROUND(AVG(pm_val2), 2) 'PM2.5'
FROM air_pollution
WHERE location2 = '수원'
GROUP BY YEAR
ORDER BY YEAR;