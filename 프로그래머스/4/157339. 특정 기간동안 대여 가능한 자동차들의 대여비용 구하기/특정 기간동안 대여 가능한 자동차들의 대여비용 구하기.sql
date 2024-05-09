-- 코드를 입력하세요
-- CAR_RENTAL_COMPANY_CAR : 자동차 대여 회사에서 대여 중인 자동차들의 정보
-- CAR_RENTAL_COMPANY_RENTAL_HISTORY : 자동차 대여 기록 정보 
-- CAR_RENTAL_COMPANY_DISCOUNT_PLAN : 자동차 종류 별 대여 기간 종류 별 정책 정보

-- SELECT CAR_ID, CAR_TYPE, AS FEE
-- WHERE CAR_TYPE = '세단' OR CAR_TYPE='SUV'
-- 대여기간 2022-11-01 2022-11-30
-- 해당 기간 동안 대여 금액이 50만원 이상 200만원 이하 
-- ORDER BY FEE DESC, CAR_TYPE, CAR_ID DESC
SELECT a.CAR_ID, a.CAR_TYPE, 
		ROUND(a.DAILY_FEE*30*(100-c.DISCOUNT_RATE)/100) AS FEE 
        -- 대여료 * 30 * ((100 - 할인률) / 100)
FROM CAR_RENTAL_COMPANY_CAR a -- 이 테이블로 다른 두 테이블 연결 가능 
JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY b
ON a.CAR_ID = b.CAR_ID -- CAR_ID 기준
JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN c
ON a.CAR_TYPE = c.CAR_TYPE -- CAR_TYPE 기준
WHERE a.CAR_ID NOT IN (SELECT CAR_ID 
                       FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                        WHERE END_DATE >= '2022-11-01' AND START_DATE <= '2022-11-30') 
                        --
                        AND c.DURATION_TYPE = '30일 이상' -- 대여 기간이 30일 이상인 것
                        AND a.CAR_TYPE IN ('세단','SUV') -- 자동차 종류가 세단이거나 suv인 것 
GROUP BY a.CAR_ID -- 별칭을 조건문에 사용하기 위해 고유한 값으로 그룹화
HAVING FEE>=500000 AND FEE<2000000 -- 30일 간의 대여 금액이 50만원 이상 200만원 미만인 것
ORDER BY FEE desc, a.CAR_TYPE, a.CAR_ID desc;