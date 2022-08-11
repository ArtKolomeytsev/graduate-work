-- liquibase formatted sql
-- changeset TelegaBase:1
CREATE TABLE IF NOT EXISTS users
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    first_name character varying(255) COLLATE pg_catalog."default",
    last_name character varying(255) COLLATE pg_catalog."default",
    password character varying(255) COLLATE pg_catalog."default",
    phone character varying(255) COLLATE pg_catalog."default",
    username character varying(255) COLLATE pg_catalog."default",
    role character varying(10) COLLATE pg_catalog."default",
    CONSTRAINT usr_pkey PRIMARY KEY (id)
);
