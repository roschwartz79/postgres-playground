-- This will drop the current table and start a new one, since this is a playground.
-- This needs to be set in the application.yml file in order to do this! spring.jpa.hibernate.ddl-auto=none
DROP TABLE IF EXISTS names;
CREATE TABLE names(pk int GENERATED ALWAYS AS IDENTITY, name VARCHAR(255), age integer, email VARCHAR(255));