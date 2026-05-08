-- 코드를 입력하세요
SELECT PRODUCT_ID,	PRODUCT_NAME, sum(PRICE * AMOUNT) as TOTAL_SALES
from FOOD_PRODUCT fp join FOOD_ORDER fo using (PRODUCT_ID)
where date_format(PRODUCE_DATE, '%Y-%m') = '2022-05'
group by PRODUCT_ID
order by TOTAL_SALES desc, PRODUCT_ID asc;
