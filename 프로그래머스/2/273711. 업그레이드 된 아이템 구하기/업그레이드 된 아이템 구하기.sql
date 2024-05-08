-- 코드를 작성해주세요
-- ITEM_INFO : 아이템 정보를 담음
-- ITEM_TREE : ITEM_INFO테이블과 아이템 관계를 나타냄
SELECT IT.ITEM_ID,II.ITEM_NAME,II.RARITY
FROM ITEM_INFO as II
JOIN ITEM_TREE AS IT
ON II.ITEM_ID = IT.ITEM_ID
WHERE IT.PARENT_ITEM_ID IN (SELECT ITEM_ID 
                                      FROM ITEM_INFO
                                      WHERE RARITY='RARE')
ORDER BY IT.ITEM_ID DESC