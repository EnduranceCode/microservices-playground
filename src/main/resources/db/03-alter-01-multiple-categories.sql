-- -------------------------------------------------------------------------------------------------
-- This script is necessary to change the relationship between the entities Category and TvShow.
--
-- This script must be executed immediately after the script 02-insert.sql.
--

-- Create the CATEGORIES_TV_SHOWS table
CREATE TABLE IF NOT EXISTS `CATEGORIES_TV_SHOWS`
(
  `ID`          BIGINT(20)  NOT NULL AUTO_INCREMENT,
  `CATEGORY_ID` BIGINT(20)  NOT NULL,
  `TV_SHOW_ID`  BIGINT(20)  NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_CATEGORIES_TV_SHOWS_CATEGORY_ID`
    FOREIGN KEY (CATEGORY_ID) REFERENCES `CATEGORIES` (ID),
  CONSTRAINT `FK_CATEGORIES_TV_SHOWS_TV_SHOW_ID`
    FOREIGN KEY (TV_SHOW_ID) REFERENCES `TV_SHOWS` (ID)
);

-- Drop the constraint on the TV_SHOWS table
ALTER TABLE `TV_SHOWS` DROP CONSTRAINT `FK_TV_SHOWS_CATEGORY_ID`;

-- Drop the column CATEGORY_ID on the TV_SHOWS table
ALTER TABLE `TV_SHOWS` DROP COLUMN `CATEGORY_ID`;

-- Populate the table CATEGORIES_TV_SHOWS with the necessary data
INSERT INTO CATEGORIES_TV_SHOWS(CATEGORY_ID, TV_SHOW_ID) VALUES
	(1, 2),
	(2, 3),
	(3, 1);

