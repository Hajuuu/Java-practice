SELECT A.ANIMAL_ID, A.ANIMAL_TYPE, A.NAME
FROM ANIMAL_INS AS A
INNER JOIN ANIMAL_OUTS AS B ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE A.SEX_UPON_INTAKE LIKE 'Intact%' AND (B.SEX_UPON_OUTCOME LIKE 'Neutered%' OR B.SEX_UPON_OUTCOME LIKE 'Spayed%')
ORDER BY A.ANIMAL_ID;
