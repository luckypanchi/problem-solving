SELECT a.apnt_no, b.pt_name, b.pt_no, a.mcdp_cd, c.dr_name, a.apnt_ymd
FROM appointment a, patient b, doctor c
WHERE a.pt_no = b.pt_no 
    and a.mddr_id = c.dr_id
    and DATE_FORMAT(a.apnt_ymd, '%Y-%m-%d') = '2022-04-13'
    and a.apnt_cncl_yn = 'N'
    and a.mcdp_cd = 'CS'
ORDER BY a.apnt_ymd;