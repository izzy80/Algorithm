-- 코드를 작성해주세요
SELECT ID, (select count(*) from ECOLI_DATA where ed.ID = PARENT_ID) as CHILD_COUNT
FROM ECOLI_DATA ed
order by ID
