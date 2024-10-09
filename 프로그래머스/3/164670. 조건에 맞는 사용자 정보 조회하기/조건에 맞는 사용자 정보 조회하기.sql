SELECT user_id, nickname, CONCAT(city, ' ', street_address1, ' ', street_address2) '전체주소', CONCAT(SUBSTRING(TLNO, 1, 3), '-', SUBSTRING(TLNO, 4, 4), '-', SUBSTRING(TLNO, 8, 4)) '전화번호'
FROM used_goods_user
WHERE user_id IN (
    SELECT writer_id
    FROM used_goods_board
    GROUP BY writer_id
    HAVING count(*) >= 3
)
ORDER BY user_id DESC;


