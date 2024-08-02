SELECT b.author_id AUTHOR_ID, a.author_name AUTHOR_NAME, b.category CATEGORY, SUM(c.sales * b.price) TOTAL_SALES
FROM book b
    JOIN author a ON b.author_id = a.author_id
    JOIN book_sales c ON b.book_id = c.book_id
WHERE DATE_FORMAT(c.sales_date, '%Y-%m') = '2022-01'
GROUP BY b.author_id, b.category
ORDER BY AUTHOR_ID, CATEGORY DESC;
