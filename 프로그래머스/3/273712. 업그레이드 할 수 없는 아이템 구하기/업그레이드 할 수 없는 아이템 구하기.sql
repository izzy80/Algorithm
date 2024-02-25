-- 코드를 작성해주세요
select ii.ITEM_ID, ii.ITEM_NAME, ii.RARITY
from ITEM_INFO as ii
join ITEM_TREE as it
on ii.ITEM_ID=it.ITEM_ID
where ii.ITEM_ID NOT IN (select PARENT_ITEM_ID from ITEM_TREE where PARENT_ITEM_ID IS NOT NULL)
order by ii.ITEM_ID DESC;