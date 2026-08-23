# Write your MySQL query statement below
SELECT
    round((
        SELECT COUNT(*)
        FROM Activity a
        JOIN (SELECT player_id, MIN(event_date) AS first_date
                FROM Activity
                GROUP BY player_id) b
            ON a.player_id = b.player_id
        WHERE DATEDIFF(a.event_date, b.first_date) = 1
    ) /
    (SELECT COUNT(DISTINCT player_id) FROM Activity), 2) AS fraction;