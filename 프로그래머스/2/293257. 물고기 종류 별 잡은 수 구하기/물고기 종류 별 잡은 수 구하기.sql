SELECT count(*) FISH_COUNT, fish_name FISH_NAME
FROM fish_info a JOIN fish_name_info b USING (fish_type)
GROUP BY fish_name
ORDER BY FISH_COUNT DESC;