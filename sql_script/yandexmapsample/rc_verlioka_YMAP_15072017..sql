--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.4
-- Dumped by pg_dump version 9.4.4
-- Started on 2016-08-11 15:25:56

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 214 (class 1259 OID 99410)
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE roles (
    id integer NOT NULL,
    name character varying(255),
    description character varying(255)
);


ALTER TABLE roles OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 99408)
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
-- TOC entry 2139 (class 0 OID 0)
-- Dependencies: 213
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE roles_id_seq OWNED BY roles.id;


--
-- TOC entry 216 (class 1259 OID 99418)
-- Name: usergroups; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE usergroups (
    id integer NOT NULL,
    name character varying(255)
);


ALTER TABLE usergroups OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 99416)
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
-- TOC entry 2140 (class 0 OID 0)
-- Dependencies: 215
-- Name: usergroups_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE usergroups_id_seq OWNED BY usergroups.id;


--
-- TOC entry 218 (class 1259 OID 99426)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE users (
    id integer NOT NULL,
    login character varying(255),
    password character varying(255)
);


ALTER TABLE users OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 99424)
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
-- TOC entry 2141 (class 0 OID 0)
-- Dependencies: 217
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


--
-- TOC entry 219 (class 1259 OID 99435)
-- Name: group_users; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE group_users (
    user_id integer NOT NULL,
    group_id integer NOT NULL
);


--
-- TOC entry 219 (class 1259 OID 99435)
-- Name: group_roles; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE group_roles (
    role_id integer NOT NULL,
    group_id integer NOT NULL
);


ALTER TABLE group_users OWNER TO postgres;

--
-- TOC entry 2006 (class 2604 OID 99413)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY roles ALTER COLUMN id SET DEFAULT nextval('roles_id_seq'::regclass);


--
-- TOC entry 2007 (class 2604 OID 99421)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usergroups ALTER COLUMN id SET DEFAULT nextval('usergroups_id_seq'::regclass);


--
-- TOC entry 2008 (class 2604 OID 99429)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


--
-- TOC entry 2129 (class 0 OID 99410)
-- Dependencies: 214
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO roles (id, name, description) VALUES (1, 'ROLE_ADMIN', NULL);
INSERT INTO roles (id, name, description) VALUES (2, 'ROLE_TEACHER', NULL);
INSERT INTO roles (id, name, description) VALUES (3, 'ROLE_EXPERT', NULL);
INSERT INTO roles (id, name, description) VALUES (4, 'ROLE_METHODIST', NULL);


--
-- TOC entry 2142 (class 0 OID 0)
-- Dependencies: 213
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('roles_id_seq', 4, true);


--
-- TOC entry 2131 (class 0 OID 99418)
-- Dependencies: 216
-- Data for Name: usergroups; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO usergroups (id, name) VALUES (1, 'admins');
INSERT INTO usergroups (id, name) VALUES (2, 'teachers');
INSERT INTO usergroups (id, name) VALUES (3, 'methodists');


--
-- TOC entry 2143 (class 0 OID 0)
-- Dependencies: 215
-- Name: usergroups_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('usergroups_id_seq', 3, true);


--
-- TOC entry 2133 (class 0 OID 99426)
-- Dependencies: 218
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO users (id, login, password) VALUES (2, 'teacher', '$2a$10$NHFU9JBCo.mx6znJvxmzQen25j3AGxvB5klKcRVm/mOMVJSCkKL5C');
INSERT INTO users (id, login, password) VALUES (3, 'expert', '$2a$10$XmLZtPnn0jB/C4c61ZQ0SeugjJcs3QV7z.Ye5UDWZX8rNOkFpB67i');
INSERT INTO users (id, login, password) VALUES (1, 'admin', '$2a$10$Dpsi6Nmtf4xofFAtTnOaSO2vN7Ie.FGqbl8D7jcpleTsx6EAxCvoC');


--
-- TOC entry 2144 (class 0 OID 0)
-- Dependencies: 217
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('users_id_seq', 3, true);


--
-- TOC entry 2134 (class 0 OID 99435)
-- Dependencies: 219
-- Data for Name: users_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO group_roles (group_id, role_id) VALUES (1, 1);
INSERT INTO group_roles (group_id, role_id) VALUES (1, 2);
INSERT INTO group_roles (group_id, role_id) VALUES (1, 3);
INSERT INTO group_roles (group_id, role_id) VALUES (1, 4);
INSERT INTO group_roles (group_id, role_id) VALUES (2, 2);
INSERT INTO group_roles (group_id, role_id) VALUES (2, 3);
INSERT INTO group_roles (group_id, role_id) VALUES (2, 4);
INSERT INTO group_roles (group_id, role_id) VALUES (3, 4);

INSERT INTO group_users (group_id, user_id) VALUES (1, 1);
INSERT INTO group_users (group_id, user_id) VALUES (2, 1);
INSERT INTO group_users (group_id, user_id) VALUES (3, 1);
INSERT INTO group_users (group_id, user_id) VALUES (2, 2);
INSERT INTO group_users (group_id, user_id) VALUES (3, 2);
INSERT INTO group_users (group_id, user_id) VALUES (2, 3);
INSERT INTO group_users (group_id, user_id) VALUES (3, 3);


--
-- TOC entry 2010 (class 2606 OID 99415)
-- Name: roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- TOC entry 2012 (class 2606 OID 99423)
-- Name: usergroups_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usergroups
    ADD CONSTRAINT usergroups_pkey PRIMARY KEY (id);


--
-- TOC entry 2014 (class 2606 OID 99434)
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2016 (class 2606 OID 99439)
-- Name: group_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY group_roles
    ADD CONSTRAINT group_roles_pkey PRIMARY KEY (group_id, role_id);


--
-- TOC entry 2018 (class 2606 OID 99560)
-- Name: fk_1hjw31qvltj7v3wb5o31jsrd8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_roles
    ADD CONSTRAINT fk_1hjw31qvltj7v3wb5o31jsrd8 FOREIGN KEY (group_id) REFERENCES usergroups(id);


--
-- TOC entry 2017 (class 2606 OID 99555)
-- Name: fk_k2mq1ee4ob6uw649wgaus1ate; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_roles
    ADD CONSTRAINT fk_k2mq1ee4ob6uw649wgaus1ate FOREIGN KEY (role_id) REFERENCES roles(id);

    
--
-- TOC entry 2016 (class 2606 OID 99439)
-- Name: group_users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY group_users
    ADD CONSTRAINT group_users_pkey PRIMARY KEY (group_id, user_id);


--
-- TOC entry 2018 (class 2606 OID 99560)
-- Name: fk_1hjw31qvltj7v3wb5o31jsrd8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_users
    ADD CONSTRAINT fk_1hjw31qvltj7v3wb7o31jsrd8 FOREIGN KEY (group_id) REFERENCES usergroups(id);


--
-- TOC entry 2017 (class 2606 OID 99555)
-- Name: fk_k2mq1ee4ob6uw649wgaus1ate; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_users
    ADD CONSTRAINT fk_k2mq1ee4ob6uw640wgaus1ate FOREIGN KEY (user_id) REFERENCES users(id);

-- Completed on 2016-08-11 15:25:56

--
-- PostgreSQL database dump complete
--
    
    
    -- Completed on 2016-08-11 15:25:56

--
-- PostgreSQL database dump complete
--

CREATE SEQUENCE virtual_objects_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE SEQUENCE file_storage_file_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;

CREATE TABLE public.file_storage
(
    file_id bigint NOT NULL DEFAULT nextval('file_storage_file_id_seq'::regclass),
    content oid,
    file_name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT file_storage_pkey PRIMARY KEY (file_id)
);

CREATE TABLE public.virtual_objects
(
    id integer NOT NULL DEFAULT nextval('virtual_objects_id_seq'::regclass),
    description character varying(255) COLLATE pg_catalog."default",
    latitude real NOT NULL,
    longitude real NOT NULL,
    objectname character varying(255) COLLATE pg_catalog."default",
    icon_file_id bigint,
    CONSTRAINT virtual_objects_pkey PRIMARY KEY (id),
    CONSTRAINT fk_ecrkf47h4bbe6ay0ss807bsor FOREIGN KEY (icon_file_id)
    REFERENCES public.file_storage (file_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
);