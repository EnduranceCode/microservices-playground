-- -------------------------------------------------------------------------------------------------
-- This script is necessary to populate the database with some dummy data.
--
-- This script must be executed immediately after the script 01-database-tables-initial-creation.sql.
--

-- Populate the subscription table with dummy data
INSERT
INTO
  d4i_subscriptions.subscription
  (id, type, price, start_date, end_date)
VALUES
  (1, 'BASIC', 7.99, '2022-10-01', '2023-09-30'),
  (2, 'STANDARD', 11.99, '2022-10-01', '2023-09-30'),
  (3, 'PREMIUM', 15.99, '2022-10-01', '2023-09-30');

-- Populate the profile table with dummy data
INSERT
INTO
  d4i_subscriptions.profile
  (id, name, alias, subscription_id, avatar)
VALUES
  (1, 'John Doe', 'Mystery Man', 1, '/user-001.png'),
  (2, 'Jane Doe', 'Mystery Woman', 2, '/user-002.png'),
  (3, 'Gustav Iden', 'Viking', 3, '/user-003.png'),
  (4, 'Sam Laidlow', 'Gaul', 2, '/user-004.png'),
  (5, 'Kristian Blummentfelt', 'Fatman', 1, '/user-005.png'),
  (6, 'Chelsea Sodaro', 'TriMom', 3, '/user-006.png'),
  (7, 'Lucy Charles-Barclay', 'Brit', 2, '/user-007.png'),
  (8, 'Anne Haug', 'Celtic', 1, '/user-008.png');
