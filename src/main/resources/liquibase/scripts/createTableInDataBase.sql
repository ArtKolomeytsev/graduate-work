-- liquibase formatted sql
-- changeset Diplombase:1
CREATE TABLE IF NOT EXISTS public.users_info
(
    id integer NOT NULL
    ,first_name character varying(255) COLLATE pg_catalog."default"
    ,last_name character varying(255) COLLATE pg_catalog."default"
    ,phone character varying(255) COLLATE pg_catalog."default"
    ,username character varying(255) COLLATE pg_catalog."default"
    ,role character varying(10) COLLATE pg_catalog."default"
    ,email character varying(255) COLLATE pg_catalog."default"
    ,CONSTRAINT usr_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.users
(
    username character varying(255) COLLATE pg_catalog."default"
    ,password character varying(255) COLLATE pg_catalog."default"
    ,enabled boolean
);

CREATE TABLE IF NOT EXISTS public.authorities
(
    username character varying(255) COLLATE pg_catalog."default"
    ,authority character varying(255) COLLATE pg_catalog."default"
);

CREATE TABLE IF NOT EXISTS public.ads
(
    id integer NOT NULL
    ,price numeric(13,2)
    ,date_mess timestamp without time zone
    ,title character varying(255) COLLATE pg_catalog."default"
    ,description character varying(255) COLLATE pg_catalog."default"
    ,user_id integer
    ,CONSTRAINT messages_pkey PRIMARY KEY (id)
    ,CONSTRAINT fk5956sop4d9xepfqwxe5q01uly FOREIGN KEY (user_id)
    REFERENCES public.users_info (id) MATCH SIMPLE
                        ON UPDATE NO ACTION
                        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS public.ads_comment
(
    id integer NOT NULL
    ,comment character varying(255) COLLATE pg_catalog."default"
    ,date_comm timestamp without time zone
    ,mess_id integer
    ,user_id integer
    ,CONSTRAINT comments_for_message_pkey PRIMARY KEY (id)
    ,CONSTRAINT fk7trneikr3xfxugufe958wepq6 FOREIGN KEY (user_id)
    REFERENCES public.users_info (id) MATCH SIMPLE
                        ON UPDATE NO ACTION
                        ON DELETE NO ACTION
    ,CONSTRAINT fkl6chrx6kmxd1jh21nl98qx2p1 FOREIGN KEY (mess_id)
    REFERENCES public.ads (id) MATCH SIMPLE
                        ON UPDATE NO ACTION
                        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS public.images_for_message
(
    id integer NOT NULL
    ,content oid
    ,date_img timestamp without time zone
    ,media_type character varying(255) COLLATE pg_catalog."default"
    ,mess_id integer
    ,CONSTRAINT images_for_message_pkey PRIMARY KEY (id)
    ,CONSTRAINT fk28pkw97wta2otdhhl8swvaxnh FOREIGN KEY (mess_id)
    REFERENCES public.ads (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
);
