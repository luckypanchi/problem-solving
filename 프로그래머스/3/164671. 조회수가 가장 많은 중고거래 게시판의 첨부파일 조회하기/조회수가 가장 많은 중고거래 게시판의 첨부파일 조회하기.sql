WITH max_view AS (
    SELECT board_id
    FROM used_goods_board
    ORDER BY views DESC
    LIMIT 1
)

SELECT CONCAT('/home/grep/src/', a.board_id, '/', a.file_id, a.file_name, a.file_ext) FILE_PATH
FROM used_goods_file a JOIN max_view b ON a.board_id = b.board_id
ORDER BY a.file_id DESC;
