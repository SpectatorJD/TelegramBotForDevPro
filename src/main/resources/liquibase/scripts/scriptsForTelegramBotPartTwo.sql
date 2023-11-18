--liquibase formatted sql

--changeset dgaraev: alter column not null

  alter table cats
alter column name set not null;

  alter table dogs
alter column name set not null;

  alter table cat_adopters
alter column name set not null;

  alter table cat_adopters
alter column phone set not null;

  alter table dog_adopters
alter column name set not null;

  alter table dog_adopters
alter column phone set not null;

  alter table report_about_cats
alter column photo set not null;

  alter table report_about_cats
alter column ration set not null;

  alter table report_about_cats
alter column habits set not null;

  alter table report_about_cats
alter column behavior set not null;

  alter table report_about_cats
alter column lastMessage set not null;

  alter table report_about_dogs
alter column photo set not null;

  alter table report_about_dogs
alter column ration set not null;

  alter table report_about_dogs
alter column habits set not null;

  alter table report_about_dogs
alter column behavior set not null;

  alter table report_about_dogs
alter column lastMessage set not null;

  alter table volunteers
alter column name set not null;

  alter table volunteers
alter column phone set not null;

  alter table volunteers
alter column userName set not null;