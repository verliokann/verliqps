--
-- PostgreSQL database dump
--

-- Dumped from database version 10.1
-- Dumped by pg_dump version 10.1

-- Started on 2017-12-23 19:15:02

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2884 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 210 (class 1259 OID 24788)
-- Name: criminal_articles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE criminal_articles (
    id integer NOT NULL,
    number integer,
    description character varying
);


ALTER TABLE criminal_articles OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 24794)
-- Name: criminal_cases; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE criminal_cases (
    id integer NOT NULL,
    article_id integer,
    investigator_id integer,
    defendats_id integer,
    notes character varying,
    entry_date character varying,
    date_of_trial character varying,
    is_uncovered boolean
);


ALTER TABLE criminal_cases OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 24782)
-- Name: defendants; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE defendants (
    id integer NOT NULL,
    name character varying,
    alias character varying,
    birth_date character varying,
    address character varying,
    portrait character varying,
    special_signs character varying
);


ALTER TABLE defendants OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 24748)
-- Name: file_storage_file_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE file_storage_file_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE file_storage_file_id_seq OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 24750)
-- Name: file_storage; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE file_storage (
    file_id bigint DEFAULT nextval('file_storage_file_id_seq'::regclass) NOT NULL,
    content oid,
    file_name character varying(255)
);


ALTER TABLE file_storage OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 24710)
-- Name: group_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE group_roles (
    role_id integer NOT NULL,
    group_id integer NOT NULL
);


ALTER TABLE group_roles OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 24707)
-- Name: group_users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE group_users (
    user_id integer NOT NULL,
    group_id integer NOT NULL
);


ALTER TABLE group_users OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 24776)
-- Name: investigators; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE investigators (
    id integer NOT NULL,
    name character varying
);


ALTER TABLE investigators OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 24686)
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE roles (
    id integer NOT NULL,
    name character varying(255),
    description character varying(255)
);


ALTER TABLE roles OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 24692)
-- Name: roles_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE roles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE roles_id_seq OWNER TO postgres;

--
-- TOC entry 2885 (class 0 OID 0)
-- Dependencies: 197
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE roles_id_seq OWNED BY roles.id;


--
-- TOC entry 198 (class 1259 OID 24694)
-- Name: usergroups; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE usergroups (
    id integer NOT NULL,
    name character varying(255)
);


ALTER TABLE usergroups OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 24697)
-- Name: usergroups_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE usergroups_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE usergroups_id_seq OWNER TO postgres;

--
-- TOC entry 2886 (class 0 OID 0)
-- Dependencies: 199
-- Name: usergroups_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE usergroups_id_seq OWNED BY usergroups.id;


--
-- TOC entry 200 (class 1259 OID 24699)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE users (
    id integer NOT NULL,
    login character varying(255),
    password character varying(255)
);


ALTER TABLE users OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 24705)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users_id_seq OWNER TO postgres;

--
-- TOC entry 2887 (class 0 OID 0)
-- Dependencies: 201
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


--
-- TOC entry 204 (class 1259 OID 24746)
-- Name: virtual_objects_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE virtual_objects_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE virtual_objects_id_seq OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 24756)
-- Name: virtual_objects; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE virtual_objects (
    id integer DEFAULT nextval('virtual_objects_id_seq'::regclass) NOT NULL,
    description character varying(255),
    latitude real NOT NULL,
    longitude real NOT NULL,
    objectname character varying(255),
    icon_file_id bigint
);


ALTER TABLE virtual_objects OWNER TO postgres;

--
-- TOC entry 2725 (class 2604 OID 24713)
-- Name: roles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY roles ALTER COLUMN id SET DEFAULT nextval('roles_id_seq'::regclass);


--
-- TOC entry 2726 (class 2604 OID 24714)
-- Name: usergroups id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usergroups ALTER COLUMN id SET DEFAULT nextval('usergroups_id_seq'::regclass);


--
-- TOC entry 2727 (class 2604 OID 24715)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


--
-- TOC entry 2749 (class 2606 OID 24810)
-- Name: criminal_articles criminal_articles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY criminal_articles
    ADD CONSTRAINT criminal_articles_pkey PRIMARY KEY (id);


--
-- TOC entry 2751 (class 2606 OID 24807)
-- Name: criminal_cases criminal_cases_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY criminal_cases
    ADD CONSTRAINT criminal_cases_pkey PRIMARY KEY (id);


--
-- TOC entry 2747 (class 2606 OID 24812)
-- Name: defendants defendants_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY defendants
    ADD CONSTRAINT defendants_pkey PRIMARY KEY (id);


--
-- TOC entry 2741 (class 2606 OID 24755)
-- Name: file_storage file_storage_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY file_storage
    ADD CONSTRAINT file_storage_pkey PRIMARY KEY (file_id);


--
-- TOC entry 2739 (class 2606 OID 24723)
-- Name: group_roles group_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_roles
    ADD CONSTRAINT group_roles_pkey PRIMARY KEY (group_id, role_id);


--
-- TOC entry 2737 (class 2606 OID 24735)
-- Name: group_users group_users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_users
    ADD CONSTRAINT group_users_pkey PRIMARY KEY (group_id, user_id);


--
-- TOC entry 2745 (class 2606 OID 24814)
-- Name: investigators investigators_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY investigators
    ADD CONSTRAINT investigators_pkey PRIMARY KEY (id);


--
-- TOC entry 2731 (class 2606 OID 24717)
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- TOC entry 2733 (class 2606 OID 24719)
-- Name: usergroups usergroups_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usergroups
    ADD CONSTRAINT usergroups_pkey PRIMARY KEY (id);


--
-- TOC entry 2735 (class 2606 OID 24721)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2743 (class 2606 OID 24764)
-- Name: virtual_objects virtual_objects_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY virtual_objects
    ADD CONSTRAINT virtual_objects_pkey PRIMARY KEY (id);


--
-- TOC entry 2754 (class 2606 OID 24724)
-- Name: group_roles fk_1hjw31qvltj7v3wb5o31jsrd8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_roles
    ADD CONSTRAINT fk_1hjw31qvltj7v3wb5o31jsrd8 FOREIGN KEY (group_id) REFERENCES usergroups(id);


--
-- TOC entry 2752 (class 2606 OID 24736)
-- Name: group_users fk_1hjw31qvltj7v3wb7o31jsrd8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_users
    ADD CONSTRAINT fk_1hjw31qvltj7v3wb7o31jsrd8 FOREIGN KEY (group_id) REFERENCES usergroups(id);


--
-- TOC entry 2756 (class 2606 OID 24765)
-- Name: virtual_objects fk_ecrkf47h4bbe6ay0ss807bsor; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY virtual_objects
    ADD CONSTRAINT fk_ecrkf47h4bbe6ay0ss807bsor FOREIGN KEY (icon_file_id) REFERENCES file_storage(file_id);


--
-- TOC entry 2753 (class 2606 OID 24741)
-- Name: group_users fk_k2mq1ee4ob6uw640wgaus1ate; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_users
    ADD CONSTRAINT fk_k2mq1ee4ob6uw640wgaus1ate FOREIGN KEY (user_id) REFERENCES users(id);


--
-- TOC entry 2755 (class 2606 OID 24729)
-- Name: group_roles fk_k2mq1ee4ob6uw649wgaus1ate; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_roles
    ADD CONSTRAINT fk_k2mq1ee4ob6uw649wgaus1ate FOREIGN KEY (role_id) REFERENCES roles(id);


-- Completed on 2017-12-23 19:15:03

--
-- PostgreSQL database dump complete
--

