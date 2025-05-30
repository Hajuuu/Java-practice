SELECT ID, FISH_NAME, LENGTH
FROM FISH_INFO AS A
INNER JOIN FISH_NAME_INFO AS B ON A.FISH_TYPE = B.FISH_TYPE
WHERE (A.FISH_TYPE, LENGTH) IN (
    SELECT FISH_TYPE, MAX(LENGTH)
    FROM FISH_INFO
    GROUP BY FISH_TYPE
)
ORDER BY ID;
