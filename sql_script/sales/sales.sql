--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.6
-- Dumped by pg_dump version 9.6.6

-- Started on 2018-02-08 21:21:06

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
-- TOC entry 2227 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

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

SET default_tablespace = '';

SET default_with_oids = false;

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
-- TOC entry 200 (class 1259 OID 16727)
-- Name: prodazhi; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE prodazhi (
    id integer NOT NULL,
    "idSotrudnika" integer,
    "idTovara" integer,
    "vidTovara" integer,
    "dataZakaza" character varying,
    "stoimostTovara" double precision
);


ALTER TABLE prodazhi OWNER TO postgres;

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
-- TOC entry 2228 (class 0 OID 0)
-- Dependencies: 186
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE roles_id_seq OWNED BY roles.id;


--
-- TOC entry 197 (class 1259 OID 16703)
-- Name: sotrudniki; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE sotrudniki (
    id integer NOT NULL,
    "FIO" character varying,
    dolzhnost character varying,
    telefon character varying,
    "birthDate" character varying,
    obrazovanie character varying,
    adress character varying
);


ALTER TABLE sotrudniki OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 16719)
-- Name: tovar; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tovar (
    id integer NOT NULL,
    nazvanie character varying,
    vid integer,
    opisanie character varying
);


ALTER TABLE tovar OWNER TO postgres;

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
-- TOC entry 2229 (class 0 OID 0)
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
-- TOC entry 2230 (class 0 OID 0)
-- Dependencies: 190
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


--
-- TOC entry 198 (class 1259 OID 16711)
-- Name: vidTovara; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "vidTovara" (
    id integer NOT NULL,
    vid character varying
);


ALTER TABLE "vidTovara" OWNER TO postgres;

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
-- TOC entry 2056 (class 2604 OID 16570)
-- Name: roles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY roles ALTER COLUMN id SET DEFAULT nextval('roles_id_seq'::regclass);


--
-- TOC entry 2057 (class 2604 OID 16571)
-- Name: usergroups id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usergroups ALTER COLUMN id SET DEFAULT nextval('usergroups_id_seq'::regclass);


--
-- TOC entry 2058 (class 2604 OID 16572)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


--
-- TOC entry 2215 (class 0 OID 16607)
-- Dependencies: 195
-- Data for Name: file_storage; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2231 (class 0 OID 0)
-- Dependencies: 194
-- Name: file_storage_file_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('file_storage_file_id_seq', 1, false);


--
-- TOC entry 2212 (class 0 OID 16567)
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
-- TOC entry 2211 (class 0 OID 16564)
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
-- TOC entry 2220 (class 0 OID 16727)
-- Dependencies: 200
-- Data for Name: prodazhi; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO prodazhi VALUES (2, 8, 3, 2, '1.11.2017', 185);
INSERT INTO prodazhi VALUES (1, 5, 1, 1, '10.10.2017
', 1500);
INSERT INTO prodazhi VALUES (4, 12, 3, 2, '17.12.2017', 570);
INSERT INTO prodazhi VALUES (3, 3, 2, 1, '11.01.2018', 2133);
INSERT INTO prodazhi VALUES (6, 7, 10, 5, '15.10.2017', 8500);
INSERT INTO prodazhi VALUES (5, 19, 7, 4, '03.02.2018', 2000);


--
-- TOC entry 2205 (class 0 OID 16543)
-- Dependencies: 185
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO roles VALUES (1, 'ROLE_ADMIN', NULL);
INSERT INTO roles VALUES (2, 'ROLE_TEACHER', NULL);
INSERT INTO roles VALUES (3, 'ROLE_EXPERT', NULL);
INSERT INTO roles VALUES (4, 'ROLE_METHODIST', NULL);


--
-- TOC entry 2232 (class 0 OID 0)
-- Dependencies: 186
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('roles_id_seq', 4, true);


--
-- TOC entry 2217 (class 0 OID 16703)
-- Dependencies: 197
-- Data for Name: sotrudniki; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO sotrudniki VALUES (16, 'Квасникова Е.В.', 'Старший менеджер по продажам', '88007070707', '30.11.1990', 'Высшее', 'ул. Ленина, д.228');
INSERT INTO sotrudniki VALUES (15, 'Державин А.В.', 'Старший менеджер по продажам', '88006060606', '14.02.1981', 'Высшее', 'ул. Пушкина, д.100');
INSERT INTO sotrudniki VALUES (18, 'Николаев С.Е.', 'Старший менеджер по продажам', '88009090909', '07.07.1977', 'Высшее', 'ул. Ленина, д.95');
INSERT INTO sotrudniki VALUES (17, 'Павлов А.С.', 'Старший менеджер по продажам', '88008080808', '08.08.1988', 'Высшее', 'ул. Ленина, д.22');
INSERT INTO sotrudniki VALUES (20, 'Завьялов А.А.', 'Старший менеджер по продажам', '88001488148', '01.01.1971', 'Высшее', 'площадь Горького, д.55');
INSERT INTO sotrudniki VALUES (19, 'Горшкова Д.С.', 'Старший менеджер по продажам', '88008008000', '06.06.1976', 'Высшее', 'площадь Горького, д.23');
INSERT INTO sotrudniki VALUES (6, 'Романов С.С.', 'Специалист по продажам', '88006666666', '11.12.1988', 'Высшее', 'улица Гоголя, д. 11');
INSERT INTO sotrudniki VALUES (8, 'Пушкин А.С.', 'Специалист по продажам', '88008888888', '07.10.1982', 'Высшее', 'улица Минина, д. 76');
INSERT INTO sotrudniki VALUES (7, 'Сергеева И.Д.', 'Специалист по продажам', '88007777777', '18.08.1975', 'Высшее', 'улица Родионова, д. 90');
INSERT INTO sotrudniki VALUES (10, 'Ленин В.И.', 'Специалист по продажам', '88001010101', '06.09.1988', 'Высшее', 'улица Горького, д.233');
INSERT INTO sotrudniki VALUES (9, 'Чехова А.С.', 'Специалист по продажам', '88009999999
', '14.01.1979', 'Высшее', 'улица Гоголя, д. 60');
INSERT INTO sotrudniki VALUES (2, 'Степанова Е.А.', 'Младший специалист по продажам', '88002222222', '05.07.1992', 'Неоконченное высшее', 'улица Гоголя, д. 1');
INSERT INTO sotrudniki VALUES (1, 'Иванов И.И.', 'Младший специалист по продажам', '88001111111', '14.10.1997', 'Неоконченное высшее', 'улица Минина, д. 11');
INSERT INTO sotrudniki VALUES (4, 'Спирин Д.С.', 'Младший специалист по продажам', '88004444444', '03.05.1995', 'Неоконченное высшее', 'улица Родионова, д. 12');
INSERT INTO sotrudniki VALUES (3, 'Ильин В.К.', 'Младший специалист по продажам', '88003333333', '29.03.1998', 'Неоконченное высшее', 'улица Минина, д. 45');
INSERT INTO sotrudniki VALUES (5, 'Алексеева К.А.', 'Младший специалист по продажам', '88005555555', '31.12.1990', 'Высшее', 'улица Родионова, д. 65');
INSERT INTO sotrudniki VALUES (12, 'Андреев Ю.С.', 'Менеджер по продажам', '88003030303', '15.04.1983', 'Высшее', 'улица Горького, д.23');
INSERT INTO sotrudniki VALUES (11, 'Осипова А.Е.', 'Менеджер по продажам', '88002020202', '11.12.1977', 'Высшее', 'улица Горького, д.14');
INSERT INTO sotrudniki VALUES (14, 'Пыркин О.П.', 'Менеджер по продажам', '88005050505', '04.05.1982', 'Высшее', 'ул. Пушкина, д.125');
INSERT INTO sotrudniki VALUES (13, 'Дубинина К.С.', 'Менеджер по продажам', '88004040404
', '24.02.1975', 'Высшее', 'ул. Пушкина, д.150');


--
-- TOC entry 2219 (class 0 OID 16719)
-- Dependencies: 199
-- Data for Name: tovar; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tovar VALUES (2, 'Уайт-спирит', 1, 'Растворитель');
INSERT INTO tovar VALUES (1, 'Микстон', 1, 'Краска для потолков');
INSERT INTO tovar VALUES (4, 'Knauf', 2, 'Гипсовая штукатурка');
INSERT INTO tovar VALUES (3, 'Перлфикс', 2, 'Монтажный клей');
INSERT INTO tovar VALUES (6, 'Hitachi', 3, 'Циркулярная пила');
INSERT INTO tovar VALUES (5, 'Интерскол', 3, 'Дрель ударная');
INSERT INTO tovar VALUES (8, 'ОРДЕР', 4, 'Гвозди строительные');
INSERT INTO tovar VALUES (7, 'Fixbox', 4, 'Саморез универсальный');
INSERT INTO tovar VALUES (10, 'Терамобрик', 5, 'Кирпич облицовочный');
INSERT INTO tovar VALUES (9, 'Палитра', 5, 'Обои виниловые');


--
-- TOC entry 2207 (class 0 OID 16551)
-- Dependencies: 187
-- Data for Name: usergroups; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO usergroups VALUES (1, 'admins');
INSERT INTO usergroups VALUES (2, 'teachers');
INSERT INTO usergroups VALUES (3, 'methodists');


--
-- TOC entry 2233 (class 0 OID 0)
-- Dependencies: 188
-- Name: usergroups_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('usergroups_id_seq', 3, true);


--
-- TOC entry 2209 (class 0 OID 16556)
-- Dependencies: 189
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO users VALUES (2, 'teacher', '$2a$10$NHFU9JBCo.mx6znJvxmzQen25j3AGxvB5klKcRVm/mOMVJSCkKL5C');
INSERT INTO users VALUES (3, 'expert', '$2a$10$XmLZtPnn0jB/C4c61ZQ0SeugjJcs3QV7z.Ye5UDWZX8rNOkFpB67i');
INSERT INTO users VALUES (1, 'admin', '$2a$10$Dpsi6Nmtf4xofFAtTnOaSO2vN7Ie.FGqbl8D7jcpleTsx6EAxCvoC');


--
-- TOC entry 2234 (class 0 OID 0)
-- Dependencies: 190
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('users_id_seq', 3, true);


--
-- TOC entry 2218 (class 0 OID 16711)
-- Dependencies: 198
-- Data for Name: vidTovara; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "vidTovara" VALUES (2, 'сухие смеси');
INSERT INTO "vidTovara" VALUES (1, 'покрасочные материалы');
INSERT INTO "vidTovara" VALUES (4, 'крепеж');
INSERT INTO "vidTovara" VALUES (3, 'инструменты');
INSERT INTO "vidTovara" VALUES (5, 'отделочные материалы');


--
-- TOC entry 2216 (class 0 OID 16613)
-- Dependencies: 196
-- Data for Name: virtual_objects; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2235 (class 0 OID 0)
-- Dependencies: 193
-- Name: virtual_objects_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('virtual_objects_id_seq', 1, false);


--
-- TOC entry 2072 (class 2606 OID 16612)
-- Name: file_storage file_storage_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY file_storage
    ADD CONSTRAINT file_storage_pkey PRIMARY KEY (file_id);


--
-- TOC entry 2070 (class 2606 OID 16580)
-- Name: group_roles group_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_roles
    ADD CONSTRAINT group_roles_pkey PRIMARY KEY (group_id, role_id);


--
-- TOC entry 2068 (class 2606 OID 16592)
-- Name: group_users group_users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_users
    ADD CONSTRAINT group_users_pkey PRIMARY KEY (group_id, user_id);


--
-- TOC entry 2082 (class 2606 OID 16734)
-- Name: prodazhi prodazhi_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY prodazhi
    ADD CONSTRAINT prodazhi_pkey PRIMARY KEY (id);


--
-- TOC entry 2062 (class 2606 OID 16574)
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- TOC entry 2076 (class 2606 OID 16710)
-- Name: sotrudniki sotrudniki_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sotrudniki
    ADD CONSTRAINT sotrudniki_pkey PRIMARY KEY (id);


--
-- TOC entry 2080 (class 2606 OID 16726)
-- Name: tovar tovar_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tovar
    ADD CONSTRAINT tovar_pkey PRIMARY KEY (id);


--
-- TOC entry 2064 (class 2606 OID 16576)
-- Name: usergroups usergroups_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usergroups
    ADD CONSTRAINT usergroups_pkey PRIMARY KEY (id);


--
-- TOC entry 2066 (class 2606 OID 16578)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2078 (class 2606 OID 16718)
-- Name: vidTovara vidTovara_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "vidTovara"
    ADD CONSTRAINT "vidTovara_pkey" PRIMARY KEY (id);


--
-- TOC entry 2074 (class 2606 OID 16621)
-- Name: virtual_objects virtual_objects_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY virtual_objects
    ADD CONSTRAINT virtual_objects_pkey PRIMARY KEY (id);


--
-- TOC entry 2085 (class 2606 OID 16581)
-- Name: group_roles fk_1hjw31qvltj7v3wb5o31jsrd8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_roles
    ADD CONSTRAINT fk_1hjw31qvltj7v3wb5o31jsrd8 FOREIGN KEY (group_id) REFERENCES usergroups(id);


--
-- TOC entry 2083 (class 2606 OID 16593)
-- Name: group_users fk_1hjw31qvltj7v3wb7o31jsrd8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_users
    ADD CONSTRAINT fk_1hjw31qvltj7v3wb7o31jsrd8 FOREIGN KEY (group_id) REFERENCES usergroups(id);


--
-- TOC entry 2087 (class 2606 OID 16622)
-- Name: virtual_objects fk_ecrkf47h4bbe6ay0ss807bsor; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY virtual_objects
    ADD CONSTRAINT fk_ecrkf47h4bbe6ay0ss807bsor FOREIGN KEY (icon_file_id) REFERENCES file_storage(file_id);


--
-- TOC entry 2084 (class 2606 OID 16598)
-- Name: group_users fk_k2mq1ee4ob6uw640wgaus1ate; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_users
    ADD CONSTRAINT fk_k2mq1ee4ob6uw640wgaus1ate FOREIGN KEY (user_id) REFERENCES users(id);


--
-- TOC entry 2086 (class 2606 OID 16586)
-- Name: group_roles fk_k2mq1ee4ob6uw649wgaus1ate; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_roles
    ADD CONSTRAINT fk_k2mq1ee4ob6uw649wgaus1ate FOREIGN KEY (role_id) REFERENCES roles(id);


-- Completed on 2018-02-08 21:21:08

--
-- PostgreSQL database dump complete
--

