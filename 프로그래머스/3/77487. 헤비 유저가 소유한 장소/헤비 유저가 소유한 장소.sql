WITH heavy_user AS (
    SELECT host_id
    FROM places
    GROUP BY host_id
    HAVING COUNT(DISTINCT id) >= 2
)

SELECT id, name, host_id
FROM places JOIN heavy_user USING (host_id)
ORDER BY id;