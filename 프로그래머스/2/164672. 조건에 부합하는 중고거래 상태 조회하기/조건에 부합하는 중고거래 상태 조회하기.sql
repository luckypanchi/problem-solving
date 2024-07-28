SELECT board_id, writer_id, title, price, (
    CASE status 
        WHEN 'SALE' THEN '판매중'
        WHEN 'RESERVED' THEN '예약중'
        WHEN 'DONE' THEN '거래완료'
    end
) status
FROM used_goods_board
WHERE DATE_FORMAT(created_date, '%Y-%m-%d') = '2022-10-05'
ORDER BY board_id DESC