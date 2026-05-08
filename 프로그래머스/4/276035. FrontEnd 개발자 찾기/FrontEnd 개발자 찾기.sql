-- 코드를 작성해주세요
select d.ID,	d.EMAIL,	d.FIRST_NAME,	d.LAST_NAME
from SKILLCODES s join DEVELOPERS d on s.code & d.SKILL_CODE
where s.category = 'Front End'
group by d.id
order by d.id