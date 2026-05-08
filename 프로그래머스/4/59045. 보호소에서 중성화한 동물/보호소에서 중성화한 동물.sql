-- 코드를 입력하세요
SELECT ai.ANIMAL_ID,	ai.ANIMAL_TYPE,	ai.NAME
from (
    select ANIMAL_ID, ANIMAL_TYPE,	NAME
    FROM ANIMAL_INS 
    WHERE SEX_UPON_INTAKE like 'Intact%'
) ai 
join (
    select ANIMAL_ID, ANIMAL_TYPE,	NAME
    FROM ANIMAL_OUTS 
    WHERE SEX_UPON_OUTCOME like 'Neutered%' or SEX_UPON_OUTCOME like 'Spayed%'
) ao 
on ai.animal_id = ao.animal_id
order by ai.ANIMAL_ID;