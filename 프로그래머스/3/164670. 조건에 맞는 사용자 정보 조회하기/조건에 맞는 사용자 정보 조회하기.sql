SELECT b.user_id AS USER_ID, b.nickname AS NICKNAME, CONCAT(b.city, ' ', b.street_address1, ' ', b.street_address2) AS 전체주소, CONCAT(SUBSTRING(TLNO, 1, 3), '-', SUBSTRING(TLNO, 4, 4), '-', SUBSTRING(TLNO, 8, 4)) AS 전화번호
FROM (
    SELECT writer_id
    FROM used_goods_board
    GROUP BY writer_id
    HAVING count(*) >= 3
) a JOIN used_goods_user b ON a.writer_id = b.user_id
ORDER BY user_id DESC;