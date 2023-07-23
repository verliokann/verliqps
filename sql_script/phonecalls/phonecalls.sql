--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.6
-- Dumped by pg_dump version 9.6.6

-- Started on 2018-02-06 12:37:00

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12387)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2220 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 199 (class 1259 OID 16685)
-- Name: call; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE call (
    id bigint NOT NULL,
    phonenumber character varying(255),
    cityid bigint NOT NULL,
    length bigint,
    calldate character varying(255),
    calltime character varying(255),
    typeid bigint NOT NULL
);


ALTER TABLE call OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 16680)
-- Name: calltype; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE calltype (
    id bigint NOT NULL,
    type character varying(255),
    price bigint NOT NULL
);


ALTER TABLE calltype OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16672)
-- Name: city; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE city (
    id bigint NOT NULL,
    cityname character varying
);


ALTER TABLE city OWNER TO postgres;

--
-- TOC entry 194 (class 1259 OID 16605)
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
-- TOC entry 195 (class 1259 OID 16607)
-- Name: file_storage; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE file_storage (
    file_id bigint DEFAULT nextval('file_storage_file_id_seq'::regclass) NOT NULL,
    content oid,
    file_name character varying(255)
);


ALTER TABLE file_storage OWNER TO postgres;

--
-- TOC entry 192 (class 1259 OID 16567)
-- Name: group_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE group_roles (
    role_id integer NOT NULL,
    group_id integer NOT NULL
);


ALTER TABLE group_roles OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 16564)
-- Name: group_users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE group_users (
    user_id integer NOT NULL,
    group_id integer NOT NULL
);


ALTER TABLE group_users OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 16543)
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE roles (
    id integer NOT NULL,
    name character varying(255),
    description character varying(255)
);


ALTER TABLE roles OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 16549)
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
-- TOC entry 2221 (class 0 OID 0)
-- Dependencies: 186
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE roles_id_seq OWNED BY roles.id;


--
-- TOC entry 187 (class 1259 OID 16551)
-- Name: usergroups; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE usergroups (
    id integer NOT NULL,
    name character varying(255)
);


ALTER TABLE usergroups OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 16554)
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
-- TOC entry 2222 (class 0 OID 0)
-- Dependencies: 188
-- Name: usergroups_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE usergroups_id_seq OWNED BY usergroups.id;


--
-- TOC entry 189 (class 1259 OID 16556)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE users (
    id integer NOT NULL,
    login character varying(255),
    password character varying(255)
);


ALTER TABLE users OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 16562)
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
-- TOC entry 2223 (class 0 OID 0)
-- Dependencies: 190
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


--
-- TOC entry 193 (class 1259 OID 16603)
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
-- TOC entry 196 (class 1259 OID 16613)
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
-- TOC entry 2050 (class 2604 OID 16570)
-- Name: roles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY roles ALTER COLUMN id SET DEFAULT nextval('roles_id_seq'::regclass);


--
-- TOC entry 2051 (class 2604 OID 16571)
-- Name: usergroups id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usergroups ALTER COLUMN id SET DEFAULT nextval('usergroups_id_seq'::regclass);


--
-- TOC entry 2052 (class 2604 OID 16572)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


--
-- TOC entry 2213 (class 0 OID 16685)
-- Dependencies: 199
-- Data for Name: call; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO call VALUES (2, '888', 2, 20, '20-02-17', '11-00', 2);
INSERT INTO call VALUES (1, '7777', 1, 10, '10-10-17', '10-10', 1);


--
-- TOC entry 2212 (class 0 OID 16680)
-- Dependencies: 198
-- Data for Name: calltype; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO calltype VALUES (1, 'Межгород', 90);
INSERT INTO calltype VALUES (2, 'Городской', 10);


--
-- TOC entry 2211 (class 0 OID 16672)
-- Dependencies: 197
-- Data for Name: city; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO city VALUES (2, 'Казань');
INSERT INTO city VALUES (1, 'Москва');


--
-- TOC entry 2209 (class 0 OID 16607)
-- Dependencies: 195
-- Data for Name: file_storage; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2224 (class 0 OID 0)
-- Dependencies: 194
-- Name: file_storage_file_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('file_storage_file_id_seq', 1, false);


--
-- TOC entry 2206 (class 0 OID 16567)
-- Dependencies: 192
-- Data for Name: group_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO group_roles VALUES (1, 1);
INSERT INTO group_roles VALUES (2, 1);
INSERT INTO group_roles VALUES (3, 1);
INSERT INTO group_roles VALUES (4, 1);
INSERT INTO group_roles VALUES (2, 2);
INSERT INTO group_roles VALUES (3, 2);
INSERT INTO group_roles VALUES (4, 2);
INSERT INTO group_roles VALUES (4, 3);


--
-- TOC entry 2205 (class 0 OID 16564)
-- Dependencies: 191
-- Data for Name: group_users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO group_users VALUES (1, 1);
INSERT INTO group_users VALUES (1, 2);
INSERT INTO group_users VALUES (1, 3);
INSERT INTO group_users VALUES (2, 2);
INSERT INTO group_users VALUES (2, 3);
INSERT INTO group_users VALUES (3, 2);
INSERT INTO group_users VALUES (3, 3);


--
-- TOC entry 2199 (class 0 OID 16543)
-- Dependencies: 185
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO roles VALUES (1, 'ROLE_ADMIN', NULL);
INSERT INTO roles VALUES (2, 'ROLE_TEACHER', NULL);
INSERT INTO roles VALUES (3, 'ROLE_EXPERT', NULL);
INSERT INTO roles VALUES (4, 'ROLE_METHODIST', NULL);


--
-- TOC entry 2225 (class 0 OID 0)
-- Dependencies: 186
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('roles_id_seq', 4, true);


--
-- TOC entry 2201 (class 0 OID 16551)
-- Dependencies: 187
-- Data for Name: usergroups; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO usergroups VALUES (1, 'admins');
INSERT INTO usergroups VALUES (2, 'teachers');
INSERT INTO usergroups VALUES (3, 'methodists');


--
-- TOC entry 2226 (class 0 OID 0)
-- Dependencies: 188
-- Name: usergroups_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('usergroups_id_seq', 3, true);


--
-- TOC entry 2203 (class 0 OID 16556)
-- Dependencies: 189
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO users VALUES (2, 'teacher', '$2a$10$NHFU9JBCo.mx6znJvxmzQen25j3AGxvB5klKcRVm/mOMVJSCkKL5C');
INSERT INTO users VALUES (3, 'expert', '$2a$10$XmLZtPnn0jB/C4c61ZQ0SeugjJcs3QV7z.Ye5UDWZX8rNOkFpB67i');
INSERT INTO users VALUES (1, 'admin', '$2a$10$Dpsi6Nmtf4xofFAtTnOaSO2vN7Ie.FGqbl8D7jcpleTsx6EAxCvoC');


--
-- TOC entry 2227 (class 0 OID 0)
-- Dependencies: 190
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('users_id_seq', 3, true);


--
-- TOC entry 2210 (class 0 OID 16613)
-- Dependencies: 196
-- Data for Name: virtual_objects; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2228 (class 0 OID 0)
-- Dependencies: 193
-- Name: virtual_objects_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('virtual_objects_id_seq', 1, false);


--
-- TOC entry 2074 (class 2606 OID 16692)
-- Name: call call_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY call
    ADD CONSTRAINT call_pkey PRIMARY KEY (id);


--
-- TOC entry 2072 (class 2606 OID 16684)
-- Name: calltype calltype_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY calltype
    ADD CONSTRAINT calltype_pkey PRIMARY KEY (id);


--
-- TOC entry 2070 (class 2606 OID 16679)
-- Name: city city_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY city
    ADD CONSTRAINT city_pkey PRIMARY KEY (id);


--
-- TOC entry 2066 (class 2606 OID 16612)
-- Name: file_storage file_storage_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY file_storage
    ADD CONSTRAINT file_storage_pkey PRIMARY KEY (file_id);


--
-- TOC entry 2064 (class 2606 OID 16580)
-- Name: group_roles group_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_roles
    ADD CONSTRAINT group_roles_pkey PRIMARY KEY (group_id, role_id);


--
-- TOC entry 2062 (class 2606 OID 16592)
-- Name: group_users group_users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_users
    ADD CONSTRAINT group_users_pkey PRIMARY KEY (group_id, user_id);


--
-- TOC entry 2056 (class 2606 OID 16574)
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- TOC entry 2058 (class 2606 OID 16576)
-- Name: usergroups usergroups_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usergroups
    ADD CONSTRAINT usergroups_pkey PRIMARY KEY (id);


--
-- TOC entry 2060 (class 2606 OID 16578)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2068 (class 2606 OID 16621)
-- Name: virtual_objects virtual_objects_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY virtual_objects
    ADD CONSTRAINT virtual_objects_pkey PRIMARY KEY (id);


--
-- TOC entry 2080 (class 2606 OID 16693)
-- Name: call citykey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY call
    ADD CONSTRAINT citykey FOREIGN KEY (cityid) REFERENCES city(id);


--
-- TOC entry 2077 (class 2606 OID 16581)
-- Name: group_roles fk_1hjw31qvltj7v3wb5o31jsrd8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_roles
    ADD CONSTRAINT fk_1hjw31qvltj7v3wb5o31jsrd8 FOREIGN KEY (group_id) REFERENCES usergroups(id);


--
-- TOC entry 2075 (class 2606 OID 16593)
-- Name: group_users fk_1hjw31qvltj7v3wb7o31jsrd8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_users
    ADD CONSTRAINT fk_1hjw31qvltj7v3wb7o31jsrd8 FOREIGN KEY (group_id) REFERENCES usergroups(id);


--
-- TOC entry 2079 (class 2606 OID 16622)
-- Name: virtual_objects fk_ecrkf47h4bbe6ay0ss807bsor; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY virtual_objects
    ADD CONSTRAINT fk_ecrkf47h4bbe6ay0ss807bsor FOREIGN KEY (icon_file_id) REFERENCES file_storage(file_id);


--
-- TOC entry 2076 (class 2606 OID 16598)
-- Name: group_users fk_k2mq1ee4ob6uw640wgaus1ate; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_users
    ADD CONSTRAINT fk_k2mq1ee4ob6uw640wgaus1ate FOREIGN KEY (user_id) REFERENCES users(id);


--
-- TOC entry 2078 (class 2606 OID 16586)
-- Name: group_roles fk_k2mq1ee4ob6uw649wgaus1ate; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_roles
    ADD CONSTRAINT fk_k2mq1ee4ob6uw649wgaus1ate FOREIGN KEY (role_id) REFERENCES roles(id);


--
-- TOC entry 2081 (class 2606 OID 16698)
-- Name: call typekey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY call
    ADD CONSTRAINT typekey FOREIGN KEY (typeid) REFERENCES calltype(id);


-- Completed on 2018-02-06 12:37:02

--
-- PostgreSQL database dump complete
--

