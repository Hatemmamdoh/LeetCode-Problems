# Write your MySQL query statement below
SELECT actor_id , director_id
FROM ActorDirector
group by actor_id , director_id
Having count(timestamp) >=3