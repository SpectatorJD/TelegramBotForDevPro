--liquibase formatted sql

                   --changeset dgaraev:new tables

                     create table cats(
                   id bigint generated by default as identity primary key,
                   name text,
                   breed text,
                   color text
                    );

                     create table dogs(
                   id bigint generated by default as identity primary key,
                   name text,
                   breed text,
                   color text
                    );

                     create table cat_adopters(
                   id bigint generated by default as identity primary key,
                   name text,
                   phone text,
                   dog_id bigint references cats(id)
                    );

                     create table dog_adopters(
                   id bigint generated by default as identity primary key,
                   name text,
                   phone text,
                   dog_id bigint references dogs(id)
                    );

                     create table report_about_cats(
                   id bigint generated by default as identity primary key,
                   photo bytea,
                   ration text,
                   habits text,
                   behavior text,
                   lastMessage date,
                   cat_adopter_id bigint references cat_adopters(id)
                    );

                     create table report_about_dogs(
                   id bigint generated by default as identity primary key,
                   photo bytea,
                   ration text,
                   habits text,
                   behavior text,
                   lastMessage date,
                   dog_adopter_id bigint references dog_adopters(id)
                    );

                     create table volunteers(
                   id bigint generated by default as identity primary key,
                   name text,
                   phone text,
                   userName text
                    );


                   --changeset dgaraev:alter table

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

