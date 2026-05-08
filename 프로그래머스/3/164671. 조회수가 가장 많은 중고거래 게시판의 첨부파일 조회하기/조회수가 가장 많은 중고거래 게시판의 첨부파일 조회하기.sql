-- 코드를 입력하세요
SELECT CONCAT(
    '/home/grep/src/',
    ugf.BOARD_ID,
    '/',
    FILE_ID,
    FILE_NAME,
    FILE_EXT
) as FILE_PATH
from USED_GOODS_FILE ugf
    join 
    (
        select BOARD_ID
        from USED_GOODS_BOARD
        order by VIEWS desc
        limit 1
    ) as ugb on ugf.BOARD_ID = ugb.board_id
order by FILE_ID desc;
