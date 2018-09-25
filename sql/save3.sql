--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.4
-- Dumped by pg_dump version 9.6.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE IF EXISTS skieur;
--
-- Name: skieur; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE skieur WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'French_Canada.1252' LC_CTYPE = 'French_Canada.1252';


ALTER DATABASE skieur OWNER TO postgres;

\connect skieur

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: prix; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE prix (
    id integer NOT NULL,
    titre text,
    date_prix text,
    id_skieur integer NOT NULL,
    temps text
);


ALTER TABLE prix OWNER TO postgres;

--
-- Name: prix_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE prix_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE prix_id_seq OWNER TO postgres;

--
-- Name: prix_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE prix_id_seq OWNED BY prix.id;


--
-- Name: prix_id_skieur_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE prix_id_skieur_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE prix_id_skieur_seq OWNER TO postgres;

--
-- Name: prix_id_skieur_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE prix_id_skieur_seq OWNED BY prix.id_skieur;


--
-- Name: skieur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE skieur (
    id integer NOT NULL,
    nom text,
    prenom text,
    age text,
    poids text
);


ALTER TABLE skieur OWNER TO postgres;

--
-- Name: skieur_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE skieur_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE skieur_id_seq OWNER TO postgres;

--
-- Name: skieur_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE skieur_id_seq OWNED BY skieur.id;


--
-- Name: prix id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY prix ALTER COLUMN id SET DEFAULT nextval('prix_id_seq'::regclass);


--
-- Name: prix id_skieur; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY prix ALTER COLUMN id_skieur SET DEFAULT nextval('prix_id_skieur_seq'::regclass);


--
-- Name: skieur id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY skieur ALTER COLUMN id SET DEFAULT nextval('skieur_id_seq'::regclass);


--
-- Data for Name: prix; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY prix (id, titre, date_prix, id_skieur, temps) FROM stdin;
16	coup	00-00-0001	22	2h
17	test	123 soleil	22	1s
\.


--
-- Name: prix_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('prix_id_seq', 17, true);


--
-- Name: prix_id_skieur_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('prix_id_skieur_seq', 1, false);


--
-- Data for Name: skieur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY skieur (id, nom, prenom, age, poids) FROM stdin;
22	test	12345678	18	74
\.


--
-- Name: skieur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('skieur_id_seq', 23, true);


--
-- Name: prix prix_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY prix
    ADD CONSTRAINT prix_pkey PRIMARY KEY (id);


--
-- Name: skieur skieur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY skieur
    ADD CONSTRAINT skieur_pkey PRIMARY KEY (id);


--
-- Name: fki_fk_skieur; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_fk_skieur ON prix USING btree (id_skieur);


--
-- Name: prix fk_skieur; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY prix
    ADD CONSTRAINT fk_skieur FOREIGN KEY (id_skieur) REFERENCES skieur(id) ON DELETE CASCADE;


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

