SELECT a.item_id, a.item_name, a.rarity
FROM item_info a LEFT OUTER JOIN item_tree b ON a.item_id = b.parent_item_id
WHERE b.parent_item_id IS NULL
ORDER BY a.item_id DESC;