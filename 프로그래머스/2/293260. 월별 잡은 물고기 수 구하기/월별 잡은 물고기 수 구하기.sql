SELECT count(*) fish_count, MONTH(time) month
FROM fish_info
GROUP BY month
ORDER BY month