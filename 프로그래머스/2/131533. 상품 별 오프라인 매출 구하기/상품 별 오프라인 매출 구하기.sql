-- 코드를 입력하세요
SELECT p.PRODUCT_CODE, sum(p.PRICE * os.SALES_AMOUNT)as SALES
FROM PRODUCT as p
JOIN OFFLINE_SALE as os
ON p.PRODUCT_ID	 = os.PRODUCT_ID	
GROUP BY p.PRODUCT_CODE
ORDER BY SALES desc, p.PRODUCT_CODE;