-- -------------------------------------------------------------------------------------------------
-- This script is necessary to create the database and the initial database tables.
--
-- This must be the first script to be executed
--

-- Create the database on the MySQL Server
CREATE DATABASE d4i_tvshows CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- Create the user's database on the MySQL Server
CREATE USER 'd4i-user'@'localhost' IDENTIFIED WITH caching_sha2_password BY 'd4i-secret';

-- Grant privileges to the new user in the created database
GRANT ALL PRIVILEGES ON d4i_tvshows.* TO 'd4i-user'@'localhost';

-- Use the newly created database
USE d4i_tvshows;

-- Create the CATEGORIES table
CREATE TABLE IF NOT EXISTS `CATEGORIES`
(
  `ID`          BIGINT(20)  NOT NULL AUTO_INCREMENT,
  `NAME`        VARCHAR(60) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `unique` (`NAME` ASC)
);

-- Create the TV_SHOWS table
CREATE TABLE IF NOT EXISTS `TV_SHOWS`
(
  `ID`          	BIGINT(20)    NOT NULL AUTO_INCREMENT,
  `NAME` 			VARCHAR(256)  NOT NULL,
  `SHORT_DESC` 		VARCHAR(256)  NULL DEFAULT NULL,
  `LONG_DESC` 		VARCHAR(2048) NULL DEFAULT NULL,
  `YEAR` 			YEAR(4) 	  NOT NULL,
  `RECOMMENDED_AGE` TINYINT 	  NOT NULL,
  `CATEGORY_ID` 	BIGINT(20)    NOT NULL,
  `ADVERTISING` 	VARCHAR(256)  NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_TV_SHOWS_CATEGORY_ID`
    FOREIGN KEY (CATEGORY_ID) REFERENCES `CATEGORIES` (ID)
);

-- Create the SEASONS table
CREATE TABLE IF NOT EXISTS `SEASONS`
(
  `ID`          BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `NUMBER` 		TINYINT 	 NOT NULL,
  `NAME` 		VARCHAR(256) NOT NULL,
  `TV_SHOW_ID`  BIGINT(20)   NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_SEASONS_TV_SHOW_ID`
    FOREIGN KEY (TV_SHOW_ID) REFERENCES `TV_SHOWS` (ID)
);

-- Create the CHAPTERS table
CREATE TABLE IF NOT EXISTS `CHAPTERS`
(
  `ID`          BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `NUMBER` 		TINYINT 	 NOT NULL,
  `NAME` 		VARCHAR(256) NOT NULL,
  `DURATION` 	TINYINT 	 NOT NULL,
  `SEASON_ID`  BIGINT(20)   NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_CHAPTERS_SEASON_ID`
    FOREIGN KEY (SEASON_ID) REFERENCES `SEASONS` (ID)
);
