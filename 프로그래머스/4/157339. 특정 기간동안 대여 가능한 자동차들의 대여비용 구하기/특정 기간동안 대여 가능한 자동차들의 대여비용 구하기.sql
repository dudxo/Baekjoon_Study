-- 코드를 입력하세요
SELECT     c.car_id
         , c.car_type
         , c.daily_fee * 30 * (1 - dp.discount_rate/100) AS fee
FROM       (
           SELECT *
           FROM car_rental_company_car 
           WHERE car_type IN ('세단', 'SUV')
           ) c
INNER JOIN car_rental_company_discount_plan dp
           ON c.car_type = dp.car_type
           AND dp.duration_type = '30일 이상'
LEFT JOIN  car_rental_company_rental_history rh
           ON c.car_id = rh.car_id
           AND rh.start_date <= DATE '2022-11-30'
           AND rh.end_date > DATE '2022-11-01'
WHERE      rh.car_id IS NULL 
           AND c.daily_fee * 30 * (1  -dp.discount_rate/100) >= 500000
           AND c.daily_fee * 30 * (1 - dp.discount_rate/100) < 2000000
ORDER BY   fee DESC
         , c.car_type ASC
         , c.car_id DESC;