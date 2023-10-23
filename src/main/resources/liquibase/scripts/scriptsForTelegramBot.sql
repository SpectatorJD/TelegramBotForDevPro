--liquibase formatted sql
--changeset dgaraev:createTable
create table manager(id bigserial primary key, text text,);