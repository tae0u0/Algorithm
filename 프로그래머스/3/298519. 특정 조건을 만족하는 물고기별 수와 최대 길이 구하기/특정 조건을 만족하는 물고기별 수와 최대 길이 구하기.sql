-- 코드를 작성해주세요
select av.cnt as FISH_COUNT, max(fi.length) as MAX_LENGTH,	fi.FISH_TYPE
from FISH_INFO fi join (
        select count(*) as cnt, fish_type, avg(coalesce(length, 10))as avg_len
        from FISH_INFO
        group by fish_type
        having avg_len >= 33
    ) av on fi.fish_type = av.fish_type
where fi.length >= av.avg_len
group by FISH_TYPE
order by fish_type