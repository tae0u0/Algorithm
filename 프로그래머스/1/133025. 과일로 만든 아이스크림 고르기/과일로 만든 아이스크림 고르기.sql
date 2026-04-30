-- 코드를 입력하세요
SELECT flavor
from FIRST_HALF fh join ICECREAM_INFO ii using (flavor)
where ii.ingredient_type like 'fruit%' and fh.TOTAL_ORDER > 3000
order by fh.TOTAL_ORDER desc;
