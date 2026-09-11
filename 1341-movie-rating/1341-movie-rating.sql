# Write your MySQL query statement below
(select u.name as results from Movies m join MovieRating mr on m.movie_id = mr.movie_id join Users u on u.user_id = mr.user_id group by u.user_id order by count(rating) desc, name limit 1)

union all

(select m.title from Movies m join MovieRating mr on m.movie_id = mr.movie_id join Users u on u.user_id = mr.user_id where month(created_at) = '02' and year(created_at) = '2020' group by title order by avg(rating) desc, title limit 1);