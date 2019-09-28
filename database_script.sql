-- Database: notes

-- DROP DATABASE notes;

CREATE DATABASE notes
    WITH OWNER = postgres
    ENCODING = 'UTF8'
    TABLESPACE = pg_default
    LC_COLLATE = 'Russian_Russia.1251'
    LC_CTYPE = 'Russian_Russia.1251'
    CONNECTION LIMIT = -1;


-- Table: public.note

-- DROP TABLE public.note;

CREATE TABLE public.note
(
    id    SERIAL                 NOT NULL PRIMARY KEY,
    title character varying(255) NOT NULL,
    text  character varying(255),
    date  date                   NOT NULL
)
    WITH (
        OIDS = FALSE
    );
ALTER TABLE public.note
    OWNER TO postgres;
