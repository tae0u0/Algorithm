-- 코드를 입력하세요
SELECT ugu.USER_ID,	ugu.NICKNAME, sum(ugb.price) as TOTAL_SALES
from USED_GOODS_BOARD ugb join USED_GOODS_USER ugu on ugb.WRITER_ID = ugu.USER_ID
where ugb.STATUS = 'DONE'
group by ugb.WRITER_ID
having TOTAL_SALES >= 700000
order by TOTAL_SALES