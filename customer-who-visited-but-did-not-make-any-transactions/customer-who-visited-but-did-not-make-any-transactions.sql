# Write your MySQL query statement below
SELECT customer_id, COUNT(Visits.visit_id) as count_no_trans
FROM Visits
LEFT JOIN Transactions on Visits.visit_id = Transactions.visit_id
WHERE Transactions.transaction_id IS NULL

GROUP BY Visits.customer_id;
