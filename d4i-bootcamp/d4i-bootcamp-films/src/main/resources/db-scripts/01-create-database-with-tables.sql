-- -------------------------------------------------------------------------------------------------
-- This script is necessary to create the database and the database tables.
--
-- This must be the first script to be executed
--

-- Create the database on the MySQL Server
CREATE DATABASE d4i_films CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- Create the user's database on the MySQL Server
CREATE USER IF NOT EXISTS 'd4i-user'@'localhost' IDENTIFIED WITH caching_sha2_password BY 'd4i-secret';

-- Grant privileges to the new user in the created database
GRANT ALL PRIVILEGES ON d4i_films.* TO 'd4i-user'@'localhost';

-- Use the d4i_films database
USE d4i_films;

-- Create the recommended_age table
CREATE TABLE IF NOT EXISTS recommended_age (
  id          BIGINT(20)    NOT NULL,
  name        VARCHAR(255)  NOT NULL,
  min_age     TINYINT       NOT NULL,
  description VARCHAR(255)  NULL,
  CONSTRAINT FK_RECOMMENDED_AGE PRIMARY KEY (id),
  UNIQUE INDEX UNIQUE_ID (id ASC) VISIBLE
);

-- Create the film table
CREATE TABLE IF NOT EXISTS film (
  id                  BIGINT(20)    NOT NULL,
  name                VARCHAR(255)  NOT NULL,
  short_desc          VARCHAR(255)  NULL,
  long_desc           VARCHAR(2048) NULL,
  year                YEAR          NOT NULL,
  recommended_age_id  BIGINT(20)    NULL,
  advertising         VARCHAR(255)  NULL,
  CONSTRAINT pk_film PRIMARY KEY (id),
  UNIQUE INDEX UNIQUE_ID (id ASC) VISIBLE,
  CONSTRAINT FK_FILM_RECOMMENDED_AGE_ID
    FOREIGN KEY (recommended_age_id) REFERENCES recommended_age (id)
);

-- Create the film_categories table
CREATE TABLE IF NOT EXISTS film_categories (
  film_id     BIGINT(20)  NOT NULL,
  category_id BIGINT(20)  NULL,
  CONSTRAINT FK_FILM_CATEGORIES_FILM_ID
    FOREIGN KEY (film_id) REFERENCES film (id)
);
