-- 코드를 입력하세요
SELECT YEAR(O.SALES_DATE) AS YEAR, MONTH(O.SALES_DATE) AS MONTH, 
COUNT(DISTINCT O.USER_ID) AS PUCHASED_USERS,
ROUND(COUNT(DISTINCT O.USER_ID) / (SELECT COUNT(DISTINCT USER_ID)
                                  FROM USER_INFO
                                  WHERE DATE_FORMAT(JOINED,"%Y") = '2021'
                                  GROUP BY YEAR(JOINED)),1) AS PUCHASED_RATIO
FROM (SELECT USER_ID
    FROM USER_INFO
    WHERE DATE_FORMAT(JOINED,"%Y") = '2021') AS U
                                  
JOIN ONLINE_SALE O
ON U.USER_ID = O.USER_ID
GROUP BY YEAR,MONTH
ORDER BY YEAR,MONTH
