CREATE SCHEMA `testdb` DEFAULT CHARACTER SET utf8;
COMMIT;

GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, CREATE TEMPORARY TABLES,
LOCK TABLES, EXECUTE, CREATE VIEW, SHOW VIEW, CREATE ROUTINE, ALTER ROUTINE, TRIGGER
ON `testdb`.* TO 'testdb'@'localhost' IDENTIFIED BY 'testdb';

FLUSH PRIVILEGES;

-- Create play_evolutions to deal with the scripts not being longtext by default
use testdb;
create table play_evolutions (
  id int not null primary key,
  hash varchar(255) not null,
  applied_at timestamp not null,
  apply_script longtext,
  revert_script longtext,
  state varchar(255),
  last_problem text
);
