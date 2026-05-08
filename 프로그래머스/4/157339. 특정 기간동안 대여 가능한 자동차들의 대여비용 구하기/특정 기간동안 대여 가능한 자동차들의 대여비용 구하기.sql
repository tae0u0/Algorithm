SELECT combine.CAR_ID, combine.CAR_TYPE, combine.FEE
FROM (
    SELECT 
        CAR_ID,
        crcc.CAR_TYPE,
        FLOOR(30 * DAILY_FEE * (100 - DISCOUNT_RATE) / 100) AS FEE
    FROM CAR_RENTAL_COMPANY_CAR crcc
    JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN crcdp
        ON crcdp.CAR_TYPE = crcc.CAR_TYPE
    WHERE crcc.CAR_TYPE IN ('세단', 'SUV')
      AND crcdp.DURATION_TYPE = '30일 이상'
      AND crcc.CAR_ID NOT IN (
          SELECT CAR_ID
          FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
          WHERE START_DATE <= '2022-11-30'
            AND END_DATE >= '2022-11-01'
      )
) combine
WHERE combine.FEE >= 500000
  AND combine.FEE < 2000000
ORDER BY combine.FEE DESC, combine.CAR_TYPE ASC, combine.CAR_ID DESC;