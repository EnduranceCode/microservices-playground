-- -------------------------------------------------------------------------------------------------
-- This script is necessary to populate the database with some dummy data.
--
-- This script must be executed immediately after the script 01-create-database-with-tables.sql.
--

-- Populate the recommended_age table with dummy data
INSERT INTO recommended_age
  (id, name, min_age, `description`)
VALUES
  (1, 'G – General Audiences', 0, 'All ages admitted. Nothing that would offend parents for viewing by children.'),
  (2, 'PG – Parental Guidance Suggested', 6, 'Some material may not be suitable for children. Parents urged to give "parental guidance". May contain some material parents might not like for their young children.'),
  (3, 'PG-13 – Parents Strongly Cautioned', 13, 'Some material may be inappropriate for children under 13. Parents are urged to be cautious. Some material may be inappropriate for pre-teenagers.'),
  (4, 'R – Restricted', 13, 'Under 17 requires accompanying parent or adult guardian. Contains some adult material. Parents are urged to learn more about the film before taking their young children with them.'),
  (5, 'NC-17 – Adults Only', 17, 'All ages admitted. Nothing that would offend parents for viewing by children.');

-- Populate the film table with dummy data
INSERT INTO film
  (id, name, year, recommended_age_id)
VALUES
  (1, 'Toy Story 4', 2019, 1),
  (2, 'The Unborn', 2009, 2),
  (3, 'Snowpiercer', 2013, 3),
  (4, 'Edge of Tomorrow', 2014, 4);

-- Populate the film_categories table with dummy data
INSERT INTO film_categories
  (film_id, category_id)
VALUES
  (1, 2),
  (2, 1),
  (3, 3),
  (4, 3);
