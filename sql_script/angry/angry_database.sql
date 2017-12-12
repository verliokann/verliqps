--
-- PostgreSQL database dump
--

-- Dumped from database version 10.1
-- Dumped by pg_dump version 10.0

-- Started on 2017-12-12 23:00:58

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
-- TOC entry 2903 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 209 (class 1259 OID 16552)
-- Name: commodity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE commodity (
    id integer NOT NULL,
    type_id integer NOT NULL,
    name character varying(128) NOT NULL,
    description character varying(1024) NOT NULL,
    unit character varying(64) NOT NULL,
    price money NOT NULL
);


ALTER TABLE commodity OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 16547)
-- Name: commodity_type; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE commodity_type (
    id integer NOT NULL,
    name character varying(256)
);


ALTER TABLE commodity_type OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 16456)
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
-- TOC entry 206 (class 1259 OID 16458)
-- Name: file_storage; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE file_storage (
    file_id bigint DEFAULT nextval('file_storage_file_id_seq'::regclass) NOT NULL,
    content oid,
    file_name character varying(255)
);


ALTER TABLE file_storage OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16418)
-- Name: group_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE group_roles (
    role_id integer NOT NULL,
    group_id integer NOT NULL
);


ALTER TABLE group_roles OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16415)
-- Name: group_users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE group_users (
    user_id integer NOT NULL,
    group_id integer NOT NULL
);


ALTER TABLE group_users OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16565)
-- Name: providers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE providers (
    id integer NOT NULL,
    name character varying(256) NOT NULL,
    country character varying(256) NOT NULL,
    city character varying(256) NOT NULL,
    phone character varying(256) NOT NULL,
    fax character varying(256) NOT NULL
);


ALTER TABLE providers OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 16394)
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE roles (
    id integer NOT NULL,
    name character varying(255),
    description character varying(255)
);


ALTER TABLE roles OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16400)
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
-- TOC entry 2904 (class 0 OID 0)
-- Dependencies: 197
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE roles_id_seq OWNED BY roles.id;


--
-- TOC entry 211 (class 1259 OID 16573)
-- Name: supply; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE supply (
    id integer NOT NULL,
    commodity_id integer,
    provider_id integer,
    date date,
    count integer,
    price money,
    shipments_are_stopped boolean
);


ALTER TABLE supply OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 16402)
-- Name: usergroups; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE usergroups (
    id integer NOT NULL,
    name character varying(255)
);


ALTER TABLE usergroups OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 16405)
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
-- TOC entry 2905 (class 0 OID 0)
-- Dependencies: 199
-- Name: usergroups_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE usergroups_id_seq OWNED BY usergroups.id;


--
-- TOC entry 200 (class 1259 OID 16407)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE users (
    id integer NOT NULL,
    login character varying(255),
    password character varying(255)
);


ALTER TABLE users OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16413)
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
-- TOC entry 2906 (class 0 OID 0)
-- Dependencies: 201
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


--
-- TOC entry 204 (class 1259 OID 16454)
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
-- TOC entry 207 (class 1259 OID 16464)
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
-- TOC entry 2723 (class 2604 OID 16421)
-- Name: roles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY roles ALTER COLUMN id SET DEFAULT nextval('roles_id_seq'::regclass);


--
-- TOC entry 2724 (class 2604 OID 16422)
-- Name: usergroups id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usergroups ALTER COLUMN id SET DEFAULT nextval('usergroups_id_seq'::regclass);


--
-- TOC entry 2725 (class 2604 OID 16423)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


--
-- TOC entry 2894 (class 0 OID 16552)
-- Dependencies: 209
-- Data for Name: commodity; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO commodity (id, type_id, name, description, unit, price) VALUES (2, 2, 'name 1:2', 'description 1:2', 'unit 2', '$1.00');
INSERT INTO commodity (id, type_id, name, description, unit, price) VALUES (1, 1, 'name 1:1', 'description 1:1', 'unit 1', '$1.00');
INSERT INTO commodity (id, type_id, name, description, unit, price) VALUES (4, 4, 'name 1:4', 'description 1:4', 'unit 4', '$1.00');
INSERT INTO commodity (id, type_id, name, description, unit, price) VALUES (3, 3, 'name 1:3', 'description 1:3', 'unti 3', '$1.00');
INSERT INTO commodity (id, type_id, name, description, unit, price) VALUES (6, 6, 'name 1:6', 'description 1:6', 'unit 6', '$1.00');
INSERT INTO commodity (id, type_id, name, description, unit, price) VALUES (5, 5, 'name 1:5', 'description 1:5', 'unit 5', '$1.00');
INSERT INTO commodity (id, type_id, name, description, unit, price) VALUES (8, 8, 'name 1:8', 'description 1:8', 'unit 8', '$1.00');
INSERT INTO commodity (id, type_id, name, description, unit, price) VALUES (7, 7, 'name 1:7', 'description 1:7', 'unti 7', '$1.00');
INSERT INTO commodity (id, type_id, name, description, unit, price) VALUES (10, 10, 'name 1:10', 'description 1:10', 'unit 10', '$1.00');
INSERT INTO commodity (id, type_id, name, description, unit, price) VALUES (9, 9, 'name 1:9', 'description 1:9', 'unit 9', '$1.00');


--
-- TOC entry 2893 (class 0 OID 16547)
-- Dependencies: 208
-- Data for Name: commodity_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO commodity_type (id, name) VALUES (2, 'type 2');
INSERT INTO commodity_type (id, name) VALUES (1, 'type 1');
INSERT INTO commodity_type (id, name) VALUES (4, 'type 4');
INSERT INTO commodity_type (id, name) VALUES (3, 'type 3');
INSERT INTO commodity_type (id, name) VALUES (6, 'type 6');
INSERT INTO commodity_type (id, name) VALUES (5, 'type 5');
INSERT INTO commodity_type (id, name) VALUES (8, 'type 8');
INSERT INTO commodity_type (id, name) VALUES (7, 'type 7');
INSERT INTO commodity_type (id, name) VALUES (10, 'type 10');
INSERT INTO commodity_type (id, name) VALUES (9, 'type 9');


--
-- TOC entry 2891 (class 0 OID 16458)
-- Dependencies: 206
-- Data for Name: file_storage; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2888 (class 0 OID 16418)
-- Dependencies: 203
-- Data for Name: group_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO group_roles (role_id, group_id) VALUES (1, 1);
INSERT INTO group_roles (role_id, group_id) VALUES (2, 1);
INSERT INTO group_roles (role_id, group_id) VALUES (3, 1);
INSERT INTO group_roles (role_id, group_id) VALUES (4, 1);
INSERT INTO group_roles (role_id, group_id) VALUES (2, 2);
INSERT INTO group_roles (role_id, group_id) VALUES (3, 2);
INSERT INTO group_roles (role_id, group_id) VALUES (4, 2);
INSERT INTO group_roles (role_id, group_id) VALUES (4, 3);


--
-- TOC entry 2887 (class 0 OID 16415)
-- Dependencies: 202
-- Data for Name: group_users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO group_users (user_id, group_id) VALUES (1, 1);
INSERT INTO group_users (user_id, group_id) VALUES (1, 2);
INSERT INTO group_users (user_id, group_id) VALUES (1, 3);
INSERT INTO group_users (user_id, group_id) VALUES (2, 2);
INSERT INTO group_users (user_id, group_id) VALUES (2, 3);
INSERT INTO group_users (user_id, group_id) VALUES (3, 2);
INSERT INTO group_users (user_id, group_id) VALUES (3, 3);


--
-- TOC entry 2895 (class 0 OID 16565)
-- Dependencies: 210
-- Data for Name: providers; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO providers (id, name, country, city, phone, fax) VALUES (1, 'Vscxggbwkfnqduxwf', 'Country 30', 'City 78', '72827675', '5874-8130');
INSERT INTO providers (id, name, country, city, phone, fax) VALUES (2, 'Rvystmwcysyycqpev', 'Country 72', 'City 63', '23721551', '1732-6236');
INSERT INTO providers (id, name, country, city, phone, fax) VALUES (3, 'Zkycxfxtlsgypsfad', 'Country 21', 'City 63', '01057581', '7536-3205');
INSERT INTO providers (id, name, country, city, phone, fax) VALUES (4, 'Gpoeylfpbnpljvrvi', 'Country 18', 'City 48', '61686883', '8516-6233');
INSERT INTO providers (id, name, country, city, phone, fax) VALUES (5, 'Oovaowuxwhmsncbxc', 'Country 10', 'City 23', '02684538', '2357-2768');
INSERT INTO providers (id, name, country, city, phone, fax) VALUES (6, 'Xjswnkkufnuxxzrzb', 'Country 08', 'City 28', '15002718', '2681-8276');
INSERT INTO providers (id, name, country, city, phone, fax) VALUES (7, 'Qrcddiuteiojwayyz', 'Country 85', 'City 77', '28581466', '1850-3365');
INSERT INTO providers (id, name, country, city, phone, fax) VALUES (8, 'Lzylntrkdcpwsrtes', 'Country 86', 'City 28', '34220188', '2703-3238');
INSERT INTO providers (id, name, country, city, phone, fax) VALUES (9, 'Dwvxhrcbldvgylwgb', 'Country 23', 'City 10', '57577846', '2388-5010');
INSERT INTO providers (id, name, country, city, phone, fax) VALUES (10, 'Gnkeufdxotogbgxpe', 'Country 13', 'City 07', '10138522', '3615-7852');
INSERT INTO providers (id, name, country, city, phone, fax) VALUES (11, 'Gekjdqzjenpevqgxi', 'Country 83', 'City 84', '85453257', '0823-1615');
INSERT INTO providers (id, name, country, city, phone, fax) VALUES (12, 'Mkimwzobiwybxduun', 'Country 85', 'City 80', '77226700', '2845-4864');
INSERT INTO providers (id, name, country, city, phone, fax) VALUES (13, 'Hmsrqcozijipfione', 'Country 16', 'City 15', '84541273', '4455-4621');
INSERT INTO providers (id, name, country, city, phone, fax) VALUES (14, 'Soemuvnpppsuacbaz', 'Country 84', 'City 47', '57884682', '4043-2644');
INSERT INTO providers (id, name, country, city, phone, fax) VALUES (15, 'Pweqtgjoparmowzdq', 'Country 81', 'City 65', '23348772', '5531-4142');
INSERT INTO providers (id, name, country, city, phone, fax) VALUES (16, 'Phoohpkwqyuhrqzhn', 'Country 01', 'City 26', '38875032', '5663-1661');
INSERT INTO providers (id, name, country, city, phone, fax) VALUES (17, 'Iexdzuzosrkrusvoj', 'Country 44', 'City 62', '34763585', '2756-4502');
INSERT INTO providers (id, name, country, city, phone, fax) VALUES (18, 'Igpnpuuhgxpqnjwjm', 'Country 70', 'City 22', '86201572', '0162-5873');
INSERT INTO providers (id, name, country, city, phone, fax) VALUES (19, 'Zotcjtnzxuglsdsmz', 'Country 53', 'City 11', '04676380', '3822-5014');
INSERT INTO providers (id, name, country, city, phone, fax) VALUES (20, 'Jzwucwljfrimpmyhc', 'Country 05', 'City 65', '88105143', '7430-4566');
INSERT INTO providers (id, name, country, city, phone, fax) VALUES (21, 'Ugixwtbvtrehbbcpx', 'Country 70', 'City 46', '58253072', '8582-5357');
INSERT INTO providers (id, name, country, city, phone, fax) VALUES (22, 'Kubmjrmbsztsshfro', 'Country 01', 'City 62', '25283287', '0018-3014');
INSERT INTO providers (id, name, country, city, phone, fax) VALUES (23, 'Qurpixiqflduuveoo', 'Country 67', 'City 52', '41820523', '3682-4165');
INSERT INTO providers (id, name, country, city, phone, fax) VALUES (24, 'Kuiduburiswtbrecu', 'Country 35', 'City 73', '30431731', '1547-5065');
INSERT INTO providers (id, name, country, city, phone, fax) VALUES (25, 'Jzefczzzbfkqdpqzi', 'Country 22', 'City 26', '68764040', '6128-5054');
INSERT INTO providers (id, name, country, city, phone, fax) VALUES (26, 'Paxamceroswitdptp', 'Country 63', 'City 26', '43676433', '7226-6778');
INSERT INTO providers (id, name, country, city, phone, fax) VALUES (27, 'Efxnxvgzedyyhngyc', 'Country 44', 'City 10', '40844612', '1565-1646');
INSERT INTO providers (id, name, country, city, phone, fax) VALUES (28, 'Ghfozqvlqfxwwkmfx', 'Country 76', 'City 70', '31618628', '0073-7086');
INSERT INTO providers (id, name, country, city, phone, fax) VALUES (29, 'Hcwmbmxrmhuyfyqga', 'Country 10', 'City 35', '58811125', '0448-3773');
INSERT INTO providers (id, name, country, city, phone, fax) VALUES (30, 'Ubzazcpkhktkydziv', 'Country 04', 'City 01', '15032626', '2873-5510');


--
-- TOC entry 2881 (class 0 OID 16394)
-- Dependencies: 196
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO roles (id, name, description) VALUES (1, 'ROLE_ADMIN', NULL);
INSERT INTO roles (id, name, description) VALUES (2, 'ROLE_TEACHER', NULL);
INSERT INTO roles (id, name, description) VALUES (3, 'ROLE_EXPERT', NULL);
INSERT INTO roles (id, name, description) VALUES (4, 'ROLE_METHODIST', NULL);


--
-- TOC entry 2896 (class 0 OID 16573)
-- Dependencies: 211
-- Data for Name: supply; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO supply (id, commodity_id, provider_id, date, count, price, shipments_are_stopped) VALUES (1, 1, 1, '2010-01-08', 41, '$100.00', false);
INSERT INTO supply (id, commodity_id, provider_id, date, count, price, shipments_are_stopped) VALUES (2, 2, 2, '2003-07-01', 55, '$100.00', true);
INSERT INTO supply (id, commodity_id, provider_id, date, count, price, shipments_are_stopped) VALUES (3, 3, 3, '2018-08-17', 64, '$100.00', false);
INSERT INTO supply (id, commodity_id, provider_id, date, count, price, shipments_are_stopped) VALUES (4, 4, 4, '2015-05-10', 71, '$100.00', false);
INSERT INTO supply (id, commodity_id, provider_id, date, count, price, shipments_are_stopped) VALUES (5, 5, 5, '2012-01-05', 70, '$100.00', true);
INSERT INTO supply (id, commodity_id, provider_id, date, count, price, shipments_are_stopped) VALUES (6, 6, 6, '2003-01-14', 37, '$100.00', true);
INSERT INTO supply (id, commodity_id, provider_id, date, count, price, shipments_are_stopped) VALUES (7, 7, 7, '2014-03-15', 50, '$100.00', true);
INSERT INTO supply (id, commodity_id, provider_id, date, count, price, shipments_are_stopped) VALUES (8, 8, 8, '2004-04-12', 71, '$100.00', false);
INSERT INTO supply (id, commodity_id, provider_id, date, count, price, shipments_are_stopped) VALUES (9, 9, 9, '2016-03-03', 95, '$100.00', false);
INSERT INTO supply (id, commodity_id, provider_id, date, count, price, shipments_are_stopped) VALUES (10, 10, 10, '2013-04-13', 20, '$100.00', false);
INSERT INTO supply (id, commodity_id, provider_id, date, count, price, shipments_are_stopped) VALUES (11, 1, 11, '2004-04-18', 86, '$100.00', true);
INSERT INTO supply (id, commodity_id, provider_id, date, count, price, shipments_are_stopped) VALUES (12, 2, 12, '2013-06-16', 75, '$100.00', true);
INSERT INTO supply (id, commodity_id, provider_id, date, count, price, shipments_are_stopped) VALUES (13, 3, 13, '2000-03-04', 69, '$100.00', false);
INSERT INTO supply (id, commodity_id, provider_id, date, count, price, shipments_are_stopped) VALUES (14, 4, 14, '2014-08-02', 80, '$100.00', false);
INSERT INTO supply (id, commodity_id, provider_id, date, count, price, shipments_are_stopped) VALUES (15, 5, 15, '2001-04-06', 65, '$100.00', false);
INSERT INTO supply (id, commodity_id, provider_id, date, count, price, shipments_are_stopped) VALUES (16, 6, 16, '2003-06-10', 48, '$100.00', false);
INSERT INTO supply (id, commodity_id, provider_id, date, count, price, shipments_are_stopped) VALUES (17, 7, 17, '2008-04-03', 55, '$100.00', true);
INSERT INTO supply (id, commodity_id, provider_id, date, count, price, shipments_are_stopped) VALUES (18, 8, 18, '2011-05-06', 68, '$100.00', false);
INSERT INTO supply (id, commodity_id, provider_id, date, count, price, shipments_are_stopped) VALUES (19, 9, 19, '2007-04-14', 87, '$100.00', false);
INSERT INTO supply (id, commodity_id, provider_id, date, count, price, shipments_are_stopped) VALUES (20, 10, 20, '2018-02-05', 93, '$100.00', true);
INSERT INTO supply (id, commodity_id, provider_id, date, count, price, shipments_are_stopped) VALUES (21, 1, 21, '2010-01-12', 23, '$100.00', true);
INSERT INTO supply (id, commodity_id, provider_id, date, count, price, shipments_are_stopped) VALUES (22, 2, 22, '2006-07-06', 77, '$100.00', false);
INSERT INTO supply (id, commodity_id, provider_id, date, count, price, shipments_are_stopped) VALUES (23, 3, 23, '2016-03-11', 87, '$100.00', false);
INSERT INTO supply (id, commodity_id, provider_id, date, count, price, shipments_are_stopped) VALUES (24, 4, 24, '2004-07-05', 92, '$100.00', false);
INSERT INTO supply (id, commodity_id, provider_id, date, count, price, shipments_are_stopped) VALUES (25, 5, 25, '2003-02-01', 13, '$100.00', true);
INSERT INTO supply (id, commodity_id, provider_id, date, count, price, shipments_are_stopped) VALUES (26, 6, 26, '2005-01-13', 38, '$100.00', false);
INSERT INTO supply (id, commodity_id, provider_id, date, count, price, shipments_are_stopped) VALUES (27, 7, 27, '2018-05-16', 50, '$100.00', false);
INSERT INTO supply (id, commodity_id, provider_id, date, count, price, shipments_are_stopped) VALUES (28, 8, 28, '2012-02-06', 94, '$100.00', true);
INSERT INTO supply (id, commodity_id, provider_id, date, count, price, shipments_are_stopped) VALUES (29, 9, 29, '2003-01-04', 78, '$100.00', true);
INSERT INTO supply (id, commodity_id, provider_id, date, count, price, shipments_are_stopped) VALUES (30, 10, 30, '2008-08-15', 24, '$100.00', true);


--
-- TOC entry 2883 (class 0 OID 16402)
-- Dependencies: 198
-- Data for Name: usergroups; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO usergroups (id, name) VALUES (1, 'admins');
INSERT INTO usergroups (id, name) VALUES (2, 'teachers');
INSERT INTO usergroups (id, name) VALUES (3, 'methodists');


--
-- TOC entry 2885 (class 0 OID 16407)
-- Dependencies: 200
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO users (id, login, password) VALUES (2, 'teacher', '$2a$10$NHFU9JBCo.mx6znJvxmzQen25j3AGxvB5klKcRVm/mOMVJSCkKL5C');
INSERT INTO users (id, login, password) VALUES (3, 'expert', '$2a$10$XmLZtPnn0jB/C4c61ZQ0SeugjJcs3QV7z.Ye5UDWZX8rNOkFpB67i');
INSERT INTO users (id, login, password) VALUES (1, 'admin', '$2a$10$Dpsi6Nmtf4xofFAtTnOaSO2vN7Ie.FGqbl8D7jcpleTsx6EAxCvoC');


--
-- TOC entry 2892 (class 0 OID 16464)
-- Dependencies: 207
-- Data for Name: virtual_objects; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2907 (class 0 OID 0)
-- Dependencies: 205
-- Name: file_storage_file_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('file_storage_file_id_seq', 1, false);


--
-- TOC entry 2908 (class 0 OID 0)
-- Dependencies: 197
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('roles_id_seq', 4, true);


--
-- TOC entry 2909 (class 0 OID 0)
-- Dependencies: 199
-- Name: usergroups_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('usergroups_id_seq', 3, true);


--
-- TOC entry 2910 (class 0 OID 0)
-- Dependencies: 201
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('users_id_seq', 3, true);


--
-- TOC entry 2911 (class 0 OID 0)
-- Dependencies: 204
-- Name: virtual_objects_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('virtual_objects_id_seq', 1, false);


--
-- TOC entry 2745 (class 2606 OID 16559)
-- Name: commodity commodity_pkey1; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY commodity
    ADD CONSTRAINT commodity_pkey1 PRIMARY KEY (id);


--
-- TOC entry 2743 (class 2606 OID 16551)
-- Name: commodity_type commodity_type_pkey1; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY commodity_type
    ADD CONSTRAINT commodity_type_pkey1 PRIMARY KEY (id);


--
-- TOC entry 2739 (class 2606 OID 16463)
-- Name: file_storage file_storage_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY file_storage
    ADD CONSTRAINT file_storage_pkey PRIMARY KEY (file_id);


--
-- TOC entry 2737 (class 2606 OID 16431)
-- Name: group_roles group_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_roles
    ADD CONSTRAINT group_roles_pkey PRIMARY KEY (group_id, role_id);


--
-- TOC entry 2735 (class 2606 OID 16443)
-- Name: group_users group_users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_users
    ADD CONSTRAINT group_users_pkey PRIMARY KEY (group_id, user_id);


--
-- TOC entry 2747 (class 2606 OID 16572)
-- Name: providers providers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY providers
    ADD CONSTRAINT providers_pkey PRIMARY KEY (id);


--
-- TOC entry 2729 (class 2606 OID 16425)
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- TOC entry 2751 (class 2606 OID 16577)
-- Name: supply supply_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY supply
    ADD CONSTRAINT supply_pkey PRIMARY KEY (id);


--
-- TOC entry 2731 (class 2606 OID 16427)
-- Name: usergroups usergroups_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usergroups
    ADD CONSTRAINT usergroups_pkey PRIMARY KEY (id);


--
-- TOC entry 2733 (class 2606 OID 16429)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2741 (class 2606 OID 16472)
-- Name: virtual_objects virtual_objects_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY virtual_objects
    ADD CONSTRAINT virtual_objects_pkey PRIMARY KEY (id);


--
-- TOC entry 2748 (class 1259 OID 16583)
-- Name: fki_commodity_fkey; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_commodity_fkey ON supply USING btree (commodity_id);


--
-- TOC entry 2749 (class 1259 OID 16589)
-- Name: fki_providers_fkey; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_providers_fkey ON supply USING btree (provider_id);


--
-- TOC entry 2758 (class 2606 OID 16578)
-- Name: supply commodity_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY supply
    ADD CONSTRAINT commodity_fkey FOREIGN KEY (commodity_id) REFERENCES commodity(id);


--
-- TOC entry 2757 (class 2606 OID 16560)
-- Name: commodity commodity_type_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY commodity
    ADD CONSTRAINT commodity_type_fkey FOREIGN KEY (type_id) REFERENCES commodity_type(id);


--
-- TOC entry 2754 (class 2606 OID 16432)
-- Name: group_roles fk_1hjw31qvltj7v3wb5o31jsrd8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_roles
    ADD CONSTRAINT fk_1hjw31qvltj7v3wb5o31jsrd8 FOREIGN KEY (group_id) REFERENCES usergroups(id);


--
-- TOC entry 2752 (class 2606 OID 16444)
-- Name: group_users fk_1hjw31qvltj7v3wb7o31jsrd8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_users
    ADD CONSTRAINT fk_1hjw31qvltj7v3wb7o31jsrd8 FOREIGN KEY (group_id) REFERENCES usergroups(id);


--
-- TOC entry 2756 (class 2606 OID 16473)
-- Name: virtual_objects fk_ecrkf47h4bbe6ay0ss807bsor; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY virtual_objects
    ADD CONSTRAINT fk_ecrkf47h4bbe6ay0ss807bsor FOREIGN KEY (icon_file_id) REFERENCES file_storage(file_id);


--
-- TOC entry 2753 (class 2606 OID 16449)
-- Name: group_users fk_k2mq1ee4ob6uw640wgaus1ate; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_users
    ADD CONSTRAINT fk_k2mq1ee4ob6uw640wgaus1ate FOREIGN KEY (user_id) REFERENCES users(id);


--
-- TOC entry 2755 (class 2606 OID 16437)
-- Name: group_roles fk_k2mq1ee4ob6uw649wgaus1ate; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_roles
    ADD CONSTRAINT fk_k2mq1ee4ob6uw649wgaus1ate FOREIGN KEY (role_id) REFERENCES roles(id);


--
-- TOC entry 2759 (class 2606 OID 16584)
-- Name: supply providers_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY supply
    ADD CONSTRAINT providers_fkey FOREIGN KEY (provider_id) REFERENCES providers(id);


-- Completed on 2017-12-12 23:00:59

--
-- PostgreSQL database dump complete
--

