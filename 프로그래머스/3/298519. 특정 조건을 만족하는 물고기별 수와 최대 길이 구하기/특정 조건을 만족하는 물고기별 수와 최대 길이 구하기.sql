WITH avg_33 AS (
    SELECT fish_type
    FROM fish_info
    GROUP BY fish_type
    HAVING AVG(
        CASE WHEN length IS NULL THEN 10
        ELSE length END
    ) >= 33
)

SELECT COUNT(*) FISH_COUNT, MAX(length) MAX_LENGTH, fish_type FISH_TYPE
FROM fish_info a 
WHERE fish_type in (SELECT fish_type FROM avg_33)
GROUP BY fish_type
ORDER BY fish_type;