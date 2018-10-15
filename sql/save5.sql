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

--
-- Name: copiercamp(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION copiercamp() RETURNS void
    LANGUAGE plpgsql
    AS $$
DECLARE
	moutonCourant RECORD;
BEGIN
	FOR moutonCourant IN
		select *, cast(ancienpoids as double precision) as bonpoids from mouton
    
    LOOP
    	UPDATE MOUTON set poids = moutonCourant.bonpoids WHERE id = moutonCourant.id;
        
    END LOOP;
END
$$;


ALTER FUNCTION public.copiercamp() OWNER TO postgres;

--
-- Name: journaliserskieur(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION journaliserskieur() RETURNS trigger
    LANGUAGE plpgsql
    AS $$

DECLARE 
avant TEXT;
apres TEXT;
BEGIN
	avant := ' ';
    apres := ' ';
	IF TG_OP = 'DELETE' OR TG_OP = 'UPDATE' THEN
		avant := OLD.id || ',' || OLD.nom || ',' || OLD.prenom || ',' || OLD.age || ',' || OLD.poids;
    END IF;
    IF TG_OP = 'INSERT' OR TG_OP = 'UPDATE' THEN
		apres := NEW.nom || ',' || NEW.prenom || ',' || NEW.age || ',' || NEW.poids;
    END IF;
insert into journal_skieur(objet, avant, apres, opperation) values(TG_TABLE_NAME,avant,apres,TG_OP);
	IF TG_OP = 'DELETE' THEN
    	return OLD;
    ELSE
		return NEW;
	END IF;
END;
$$;


ALTER FUNCTION public.journaliserskieur() OWNER TO postgres;

--
-- Name: sauvegarderchamp(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION sauvegarderchamp() RETURNS void
    LANGUAGE plpgsql
    AS $$

DECLARE 

	skieurCourant RECORD;
	moyennePoidsSkieur integer;
	totalSkieur integer;
	checksum text;
	
BEGIN	

checksum:='';

	FOR skieurCourant IN 
    SELECT * from skieur 
    LOOP
		checksum:= checksum || skieurCourant.prenom || ', ' ;
	END LOOP; 
	
	select count(*) INTO totalSkieur from skieur ;
	select AVG(poids) INTO moyennePoidsSkieur from skieur;
	INSERT INTO surveillance_skieur (moment, "totalSkieur", "moyennePoidsSkieur", checksum) VALUES ( NOW(), totalSkieur, moyennePoidsSkieur, MD5(checksum));

END 
$$;


ALTER FUNCTION public.sauvegarderchamp() OWNER TO postgres;

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

INSERT INTO journal_skieur VALUES (1, 'skieur', ' ', 'test,lol,,', 'INSERT');
INSERT INTO journal_skieur VALUES (2, 'skieur', '31,test,lol,,', 'test,lol,,', 'UPDATE');
INSERT INTO journal_skieur VALUES (3, 'skieur', '31,test,lol,,', 'test,lolq,q,q', 'UPDATE');
INSERT INTO journal_skieur VALUES (4, 'skieur', '31,test,lolq,q,q', ' ', 'DELETE');
INSERT INTO journal_skieur VALUES (5, 'skieur', '31,test,lolq,q,q', ' ', 'DELETE');
INSERT INTO journal_skieur VALUES (6, 'skieur', '31,test,lolq,q,q', ' ', 'DELETE');
INSERT INTO journal_skieur VALUES (7, 'skieur', '31,test,lolq,q,q', ' ', 'DELETE');
INSERT INTO journal_skieur VALUES (8, 'skieur', '31,test,lolq,q,q', ' ', 'DELETE');
INSERT INTO journal_skieur VALUES (9, 'skieur', '31,test,lolq,q,q', ' ', 'DELETE');
INSERT INTO journal_skieur VALUES (10, 'skieur', '31,test,lolq,q,q', ' ', 'DELETE');
INSERT INTO journal_skieur VALUES (11, 'skieur', '31,test,lolq,q,q', ' ', 'DELETE');
INSERT INTO journal_skieur VALUES (12, 'skieur', '31,test,lolq,q,q', ' ', 'DELETE');
INSERT INTO journal_skieur VALUES (13, 'skieur', '31,test,lolq,q,q', ' ', 'DELETE');
INSERT INTO journal_skieur VALUES (14, 'skieur', '31,test,lolq,q,q', ' ', 'DELETE');
INSERT INTO journal_skieur VALUES (15, 'skieur', ' ', '123,123,,', 'INSERT');
INSERT INTO journal_skieur VALUES (16, 'skieur', NULL, '123,123,,1', 'UPDATE');
INSERT INTO journal_skieur VALUES (17, 'skieur', '32,123,123,,1', '123,123,,1', 'UPDATE');
INSERT INTO journal_skieur VALUES (18, 'skieur', NULL, 'test,test,test,0', 'UPDATE');
INSERT INTO journal_skieur VALUES (19, 'skieur', '24,test,test,test,0', 'test,test,test,0', 'UPDATE');


--
-- Name: journal_skieur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('journal_skieur_id_seq', 19, true);


--
-- Data for Name: prix; Type: TABLE DATA; Schema: public; Owner: postgres
--



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

INSERT INTO skieur VALUES (32, '123', '123', '', 1);
INSERT INTO skieur VALUES (24, 'test', 'test', 'test', 0);


--
-- Name: skieur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('skieur_id_seq', 32, true);


--
-- Data for Name: surveillance_skieur; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO surveillance_skieur VALUES (1, '2018-09-28', 1, '2', '6a3eaa0a95b57a9913539ba294855fa8');


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
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

