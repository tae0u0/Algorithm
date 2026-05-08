-- 코드를 작성해주세요
select ITEM_ID,	ITEM_NAME,	RARITY
from ITEM_INFO 
where item_id not in (
    select distinct if(parent_item_id is null, -1, parent_item_id) as item_id
    from ITEM_TREE
)  
order by item_id desc