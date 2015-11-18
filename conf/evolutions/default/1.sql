# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table log (
  id                        varchar(40) not null,
  log_timestamp             datetime,
  log_text                  TEXT,
  custom_data               TEXT,
  constraint pk_log primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table log;

SET FOREIGN_KEY_CHECKS=1;

