-- 코드를 작성해주세요
SELECT ID, (SELECT COUNT(*) FROM ECOLI_DATA WHERE PARENT_ID = ED.ID) AS CHILD_COUNT
FROM ECOLI_DATA AS ED
ORDER BY ID
