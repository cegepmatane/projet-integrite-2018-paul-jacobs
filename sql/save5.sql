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

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: journal_skieur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE journal_skieur (
    id integer NOT NULL,
    objet text,
    avant text,
    apres text,
    opperation text
);


ALTER TABLE journal_skieur OWNER TO postgres;

--
-- Name: journal_skieur_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE journal_skieur_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE journal_skieur_id_seq OWNER TO postgres;

--
-- Name: journal_skieur_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE journal_skieur_id_seq OWNED BY journal_skieur.id;


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
    poids integer
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
-- Name: surveillance_skieur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE surveillance_skieur (
    id integer NOT NULL,
    moment date,
    "moyennePoidsSkieur" integer,
    "totalSkieur" text,
    checksum text
);


ALTER TABLE surveillance_skieur OWNER TO postgres;

--
-- Name: surveillance_skieur_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE surveillance_skieur_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE surveillance_skieur_id_seq OWNER TO postgres;

--
-- Name: surveillance_skieur_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE surveillance_skieur_id_seq OWNED BY surveillance_skieur.id;


--
-- Name: journal_skieur id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY journal_skieur ALTER COLUMN id SET DEFAULT nextval('journal_skieur_id_seq'::regclass);


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
-- Name: surveillance_skieur id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY surveillance_skieur ALTER COLUMN id SET DEFAULT nextval('surveillance_skieur_id_seq'::regclass);


--
-- Data for Name: journal_skieur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY journal_skieur (id, objet, avant, apres, opperation) FROM stdin;
1	skieur	 	test,lol,,	INSERT
2	skieur	31,test,lol,,	test,lol,,	UPDATE
3	skieur	31,test,lol,,	test,lolq,q,q	UPDATE
4	skieur	31,test,lolq,q,q	 	DELETE
5	skieur	31,test,lolq,q,q	 	DELETE
6	skieur	31,test,lolq,q,q	 	DELETE
7	skieur	31,test,lolq,q,q	 	DELETE
8	skieur	31,test,lolq,q,q	 	DELETE
9	skieur	31,test,lolq,q,q	 	DELETE
10	skieur	31,test,lolq,q,q	 	DELETE
11	skieur	31,test,lolq,q,q	 	DELETE
12	skieur	31,test,lolq,q,q	 	DELETE
13	skieur	31,test,lolq,q,q	 	DELETE
14	skieur	31,test,lolq,q,q	 	DELETE
15	skieur	 	123,123,,	INSERT
16	skieur	\N	123,123,,1	UPDATE
17	skieur	32,123,123,,1	123,123,,1	UPDATE
\.


--
-- Name: journal_skieur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('journal_skieur_id_seq', 17, true);


--
-- Data for Name: prix; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY prix (id, titre, date_prix, id_skieur, temps) FROM stdin;
\.


--
-- Name: prix_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('prix_id_seq', 19, true);


--
-- Name: prix_id_skieur_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('prix_id_skieur_seq', 1, false);


--
-- Data for Name: skieur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY skieur (id, nom, prenom, age, poids) FROM stdin;
24	test	test	test	\N
32	123	123		1
\.


--
-- Name: skieur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('skieur_id_seq', 32, true);


--
-- Data for Name: surveillance_skieur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY surveillance_skieur (id, moment, "moyennePoidsSkieur", "totalSkieur", checksum) FROM stdin;
1	2018-09-28	1	2	6a3eaa0a95b57a9913539ba294855fa8
\.


--
-- Name: surveillance_skieur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('surveillance_skieur_id_seq', 1, true);


--
-- Name: journal_skieur journal_skieur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY journal_skieur
    ADD CONSTRAINT journal_skieur_pkey PRIMARY KEY (id);


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
-- Name: surveillance_skieur surveillance_skieur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY surveillance_skieur
    ADD CONSTRAINT surveillance_skieur_pkey PRIMARY KEY (id);


--
-- Name: fki_fk_skieur; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_fk_skieur ON prix USING btree (id_skieur);


--
-- Name: skieur journaliserskieur; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER journaliserskieur BEFORE INSERT OR DELETE OR UPDATE ON skieur FOR EACH ROW EXECUTE PROCEDURE journaliserskieur();


--
-- Name: prix fk_skieur; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY prix
    ADD CONSTRAINT fk_skieur FOREIGN KEY (id_skieur) REFERENCES skieur(id) ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

