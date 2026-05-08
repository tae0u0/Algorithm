-- 코드를 작성해주세요
select ID,	FISH_NAME,	LENGTH
from FISH_NAME_INFO fni join
    FISH_INFO fi using (FISH_TYPE)
where (fi.FISH_TYPE, fi.LENGTH) IN (
    SELECT 
        FISH_TYPE,
        MAX(LENGTH)
    FROM FISH_INFO
    GROUP BY FISH_TYPE
)
order by ID