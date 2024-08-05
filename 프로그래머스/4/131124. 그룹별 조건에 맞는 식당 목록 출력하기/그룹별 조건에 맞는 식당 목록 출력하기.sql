WITH heavy_reviewer AS (
    SELECT member_id
    FROM rest_review
    GROUP BY member_id
    ORDER BY COUNT(*) DESC
    LIMIT 1
)

SELECT a.member_name, b.review_text, DATE_FORMAT(b.review_date, '%Y-%m-%d') review_date
FROM member_profile a JOIN rest_review b ON a.member_id = b.member_id
WHERE a.member_id IN (SELECT member_id FROM heavy_reviewer)
ORDER BY review_date, review_text
