-- 코드를 입력하세요
SELECT USER_ID,	NICKNAME, 
    concat(CITY, ' ', STREET_ADDRESS1, ' ', STREET_ADDRESS2) as '전체주소',
    concat(left(TLNO,3), '-', substr(TLNO, 4, 4), '-', right(TLNO,4)) as 전화번호
from USED_GOODS_BOARD ugb 
    join USED_GOODS_USER ugu
    on ugb.writer_id = ugu.user_id 
group by ugu.user_id
having count(USER_ID) >= 3
order by ugu.user_id desc