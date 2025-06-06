SELECT 
    t1.id,
    IF(t1.p_id IS NULL, 'Root',
       IF(t2.id IS NULL, 'Leaf', 'Inner')
    ) AS type
FROM Tree t1
LEFT JOIN Tree t2
    ON t1.id = t2.p_id
GROUP BY t1.id, t1.p_id
ORDER BY t1.id;
