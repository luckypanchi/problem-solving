WITH ranked_fish AS (
    SELECT fish_type, id, length,
           RANK() OVER (PARTITION BY fish_type ORDER BY length DESC) as rnk
    FROM fish_info
)

SELECT a.id AS ID, b.fish_name AS FISH_NAME, a.length AS LENGTH
FROM ranked_fish a JOIN fish_name_info b ON a.fish_type = b.fish_type
WHERE a.rnk = 1
ORDER BY a.id;
