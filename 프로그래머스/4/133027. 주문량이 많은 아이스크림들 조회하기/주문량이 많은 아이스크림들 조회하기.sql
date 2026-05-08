-- 코드를 입력하세요
SELECT fh.FLAVOR
from FIRST_HALF fh 
join (select FLAVOR, sum(TOTAL_ORDER) as TOTAL_ORDER
        from JULY 
      group by FLAVOR) j on fh.flavor = j.flavor
group by fh.flavor
order by fh.TOTAL_ORDER + j.TOTAL_ORDER desc
limit 3;
     