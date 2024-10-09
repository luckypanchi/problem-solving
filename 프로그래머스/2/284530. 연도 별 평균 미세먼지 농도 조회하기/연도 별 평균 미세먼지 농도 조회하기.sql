SELECT YEAR(a.ym) year, ROUND(AVG(a.pm_val1), 2) 'pm10', ROUND(AVG(a.pm_val2), 2) 'pm2.5'
FROM (
    SELECT ym, pm_val1, pm_val2
    FROM air_pollution
    WHERE location2 = '수원'
) a
GROUP BY year
ORDER BY year;

