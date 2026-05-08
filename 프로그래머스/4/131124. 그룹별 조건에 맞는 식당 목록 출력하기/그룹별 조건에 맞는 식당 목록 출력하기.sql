-- 코드를 입력하세요
SELECT mi.MEMBER_NAME,	rr.REVIEW_TEXT, rr.REVIEW_DATE
from REST_REVIEW rr join 
(   select *
    from MEMBER_PROFILE join REST_REVIEW using (MEMBER_ID)
    group by member_id
    order by count(review_id) desc
    limit 1
) mi on rr.member_id = mi.member_id 
order by REVIEW_DATE asc, REVIEW_TEXT asc