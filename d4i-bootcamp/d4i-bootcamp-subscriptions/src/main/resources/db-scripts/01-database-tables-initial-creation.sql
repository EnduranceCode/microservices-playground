-- -------------------------------------------------------------------------------------------------
-- This script is necessary to create the database and the initial database tables.
--
-- This must be the first script to be executed
--

-- Create the database on the MySQL Server
CREATE DATABASE d4i_subscriptions CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- Create the user's database on the MySQL Server
CREATE USER IF NOT EXISTS 'd4i-user'@'localhost' IDENTIFIED WITH caching_sha2_password BY 'd4i-secret';

-- Grant privileges to the new user in the created database
GRANT ALL PRIVILEGES ON d4i_subscriptions.* TO 'd4i-user'@'localhost';

-- Create the subscription table
CREATE TABLE IF NOT EXISTS d4i_subscriptions.subscription (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  type VARCHAR(255) NOT NULL,
  price DECIMAL(4,2) NOT NULL,
  start_date DATE NOT NULL,
  end_date DATE NOT NULL,
  CONSTRAINT pk_subscription PRIMARY KEY (id),
  UNIQUE INDEX UNIQUE_ID (id ASC) VISIBLE
);

-- Create the profile table
CREATE TABLE IF NOT EXISTS d4i_subscriptions.profile (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  alias VARCHAR(255) NOT NULL,
  avatar VARCHAR(1020) NULL,
  subscription_id BIGINT(20) NOT NULL,
  CONSTRAINT pk_profile PRIMARY KEY (id),
  UNIQUE INDEX UNIQUE_ID (id ASC) VISIBLE,
  CONSTRAINT FK_PROFILE_SUBSCRIPTION_ID FOREIGN KEY (subscription_id) REFERENCES subscription (id)
);
