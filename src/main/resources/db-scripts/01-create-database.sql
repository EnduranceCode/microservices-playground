-- -------------------------------------------------------------------------------------------------
-- This script is necessary to create the database.
--
-- This must be the first script to be executed
--

-- Create the database on the MySQL Server
CREATE DATABASE d4i_films CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- Create the user's database on the MySQL Server
CREATE USER 'd4i-user'@'localhost' IDENTIFIED WITH caching_sha2_password BY 'd4i-secret';

-- Grant privileges to the new user in the created database
GRANT ALL PRIVILEGES ON d4i_films.* TO 'd4i-user'@'localhost';

