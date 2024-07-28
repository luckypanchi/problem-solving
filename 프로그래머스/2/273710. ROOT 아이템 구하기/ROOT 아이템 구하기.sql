SELECT b.item_id, a.item_name
FROM item_info a JOIN item_tree b USING (item_id)
WHERE b.parent_item_id IS NULL