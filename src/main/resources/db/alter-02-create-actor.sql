-- -------------------------------------------------------------------------------------------------
-- This script is necessary to create the Actor entity.
--
-- This script must be executed immediately after the script alter-01-multiple-categories.sql.
--

-- Create the ACTORS table
CREATE TABLE IF NOT EXISTS `ACTORS`
(
  `ID`          BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `NAME`        VARCHAR(256) NOT NULL,
  PRIMARY KEY (`ID`)
);

-- Create the ACTORS_CHAPTERS table
CREATE TABLE IF NOT EXISTS `ACTORS_CHAPTERS`
(
  `ID`          BIGINT(20)  NOT NULL AUTO_INCREMENT,
  `ACTOR_ID`    BIGINT(20)  NOT NULL,
  `CHAPTER_ID`  BIGINT(20)  NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_ACTORS_CHAPTERS_ACTOR_ID`
    FOREIGN KEY (ACTOR_ID) REFERENCES `ACTORS` (ID),
  CONSTRAINT `FK_ACTORS_CHAPTERS_CHAPTER_ID`
    FOREIGN KEY (CHAPTER_ID) REFERENCES `CHAPTERS` (ID)
);

-- Populate the ACTORS table with data
INSERT INTO ACTORS(ID, NAME) VALUES
	(1,'Sean Bean'),
	(2,'Mark Addy'),
	(3,'Michelle Fairley'),
	(4,'Lean Headey');

-- Populate the table ACTOR_CHAPTERS with data
INSERT INTO ACTORS_CHAPTERS(ACTOR_ID, CHAPTER_ID) VALUES
	(1, 1),
	(1, 2),
	(1, 3),
	(2, 1),
	(2, 2),
	(2, 3),
	(3, 1),
	(3, 2),
	(3, 3),
	(3, 4),
	(4, 1),
	(4, 2),
	(4, 3),
	(4, 4);
