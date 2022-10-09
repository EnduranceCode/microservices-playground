-- -------------------------------------------------------------------------------------------------
-- This script is necessary to create the AWARD entity.
--
-- This script must be executed immediately after the script alter-02-create-actor.sql.
--

-- Create the AWARDS table
CREATE TABLE IF NOT EXISTS `AWARDS`
(
  `ID`          BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `NAME`        VARCHAR(256) NOT NULL,
  PRIMARY KEY (`ID`)
);

-- Create the AWARDS_TV_SHOWS table
CREATE TABLE IF NOT EXISTS `AWARDS_TV_SHOWS`
(
  `ID`          BIGINT(20)  NOT NULL AUTO_INCREMENT,
  `AWARD_ID`    BIGINT(20)  NOT NULL,
  `TV_SHOW_ID`  BIGINT(20)  NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_AWARDS_TV_SHOWS_AWARD_ID`
    FOREIGN KEY (AWARD_ID) REFERENCES `AWARDS` (ID),
  CONSTRAINT `FK_AWARDS_TV_SHOWS_TV_SHOW_ID`
    FOREIGN KEY (TV_SHOW_ID) REFERENCES `TV_SHOWS` (ID)
);

-- Populate the AWARDS table with data
American Film Institute Awards

-- Populate the AWARDS table with data
INSERT INTO AWARDS(ID, NAME) VALUES
	(1, 'American Film Institute Awards'),
	(2, 'Primetime Emmy Award'),
	(3, 'People\'s Choice Award');

-- Populate the table AWARDS_TV_SHOWS with the necessary data
INSERT INTO AWARDS_TV_SHOWS(AWARD_ID, TV_SHOW_ID) VALUES
  	(1, 1),
  	(2, 2),
  	(3, 3);


