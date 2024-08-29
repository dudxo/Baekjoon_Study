-- 코드를 입력하세요
-- REST_INFO 식당 정보(식당 ID, 식당 이름, 음식 종류, 조회수, 즐찾, 주차장, 주소, 전번)
-- REST_REVIEW 리뷰 정보(리뷰 ID, 식당 ID, 회원 ID, 점수, 리뷰 텍스트, 리뷰 작성일)
-- 서울에 위치한 식당 ID, 식당 이름, 음식 종류, 즐찾, 주소, 리뷰 평균 점수(소수 3번째 자리 반올림)
-- 평균점수 기준 내림차순, 2순위 즐찾 수 내림차순
SELECT i.REST_ID, i.REST_NAME, i.FOOD_TYPE, i.FAVORITES, i.ADDRESS, ROUND(AVG(r.REVIEW_SCORE), 2) AS SCORE
FROM REST_INFO i join REST_REVIEW r
ON i.REST_ID = r.REST_ID
WHERE i.ADDRESS LIKE '서울%'
GROUP BY REST_ID
ORDER BY SCORE DESC, i.FAVORITES DESC;