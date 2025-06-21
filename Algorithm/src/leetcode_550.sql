WITH login AS (
    SELECT player_id, DATEDIFF(event_date, MIN(event_date) OVER(PARTITION BY player_id)) = 1 as login_date
    FROM Activity
)
SELECT ROUND(SUM(login_date) / COUNT(DISTINCT player_id), 2) as fraction
FROM login;
