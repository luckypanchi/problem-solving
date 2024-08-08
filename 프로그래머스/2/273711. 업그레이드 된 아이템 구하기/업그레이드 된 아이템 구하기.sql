WITH rare_item AS (
    SELECT item_id
    FROM item_info
    WHERE rarity = 'RARE'
)

SELECT a.item_id, a.item_name, a.rarity
FROM item_info a JOIN item_tree b ON a.item_id = b.item_id
WHERE b.parent_item_id IN (
    SELECT item_id
    FROM rare_item
)
ORDER BY a.item_id DESC;