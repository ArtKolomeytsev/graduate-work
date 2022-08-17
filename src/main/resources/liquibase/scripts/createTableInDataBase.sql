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

CREATE TABLE IF NOT EXISTS messages
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    date_mess timestamp without time zone,
    message character varying(255) COLLATE pg_catalog."default",
    id_user character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT messages_pkey PRIMARY KEY (id),
    CONSTRAINT fk5956sop4d9xepfqwxe5q01uly FOREIGN KEY (id_user)
    REFERENCES public.users (id) MATCH SIMPLE
                        ON UPDATE NO ACTION
                        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS images_for_message
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    content oid,
    date_img timestamp without time zone,
    media_type character varying(255) COLLATE pg_catalog."default",
    mess_id character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT images_for_message_pkey PRIMARY KEY (id),
    CONSTRAINT fk28pkw97wta2otdhhl8swvaxnh FOREIGN KEY (mess_id)
    REFERENCES public.messages (id) MATCH SIMPLE
                       ON UPDATE NO ACTION
                       ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS comments_for_message
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    comment character varying(255) COLLATE pg_catalog."default",
    date_comm timestamp without time zone,
    mess_id character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT comments_for_message_pkey PRIMARY KEY (id),
    CONSTRAINT fkl6chrx6kmxd1jh21nl98qx2p1 FOREIGN KEY (mess_id)
    REFERENCES public.messages (id) MATCH SIMPLE
                        ON UPDATE NO ACTION
                        ON DELETE NO ACTION
);
