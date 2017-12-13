--
-- PostgreSQL database dump
--

-- Dumped from database version 10.1
-- Dumped by pg_dump version 10.1

-- Started on 2017-12-14 00:46:22

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = ON;
SET check_function_bodies = FALSE;
SET client_min_messages = WARNING;
SET row_security = OFF;

--
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner:
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;

--
-- TOC entry 2819 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner:
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = FALSE;

--
-- TOC entry 196 (class 1259 OID 16394)
-- Name: bank_branches; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE bank_branches (
  bank_branch_id UUID    NOT NULL,
  bank_details   TEXT    NOT NULL,
  address        TEXT    NOT NULL,
  number         INTEGER NOT NULL
);


ALTER TABLE bank_branches
  OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 16407)
-- Name: clients; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE clients (
  client_id    UUID   NOT NULL,
  name         TEXT   NOT NULL,
  account      TEXT   NOT NULL,
  date         DATE   NOT NULL,
  amount       BIGINT NOT NULL,
  deposit_type UUID   NOT NULL,
  bank_branch  UUID
);


ALTER TABLE clients
  OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16402)
-- Name: deposit_types; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE deposit_types (
  deposit_type_id UUID             NOT NULL,
  percents        DOUBLE PRECISION NOT NULL,
  duration        INTEGER          NOT NULL,
  name            TEXT             NOT NULL
);


ALTER TABLE deposit_types
  OWNER TO postgres;

--
-- TOC entry 2810 (class 0 OID 16394)
-- Dependencies: 196
-- Data for Name: bank_branches; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY bank_branches (bank_branch_id, bank_details, address, number) FROM STDIN;
ec430996-dacd-43cb-b688-424aa7f5b8ad  БИК 0564546559  Ижорская ул., 4, Нижний Новгород, Нижегородская обл., 603006  1
831790f8-38c1-4a23-acaf-0437603ed024  БИК 89565485  ул.Белинского, 61, Нижний Новгород, Нижегородская обл., 603006  2
fdcea64b-8676-4534-b0b5-d4d5c942c2e4  БИК 145638828  Большая Печерская ул., 39, Нижний Новгород, Нижегородская обл., 603155  3
99a84d75-f97c-4870-b91d-7645f4a99859  БИК 789635656  офис П40, Большая Покровская ул., 60, Нижний Новгород, Нижегородская обл., 603000  4
7a6d741b-8a4c-4ef1-b2fa-2176b80d7d48  БИК 45789686  пл.Максима Горького, 2, Нижний Новгород, Нижегородская обл., 603000  5
\.


--
-- TOC entry 2812 (class 0 OID 16407)
-- Dependencies: 198
-- Data for Name: clients; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY clients (client_id, name, account, date, amount, deposit_type, bank_branch) FROM STDIN;
a9b72bbe-6416-4bae-a191-aabef18f13ba  Василий Зверев  1216 5460 1554 4569  2017-09-01  5  b1dd8e0b-3658-4fc1-a767-ad9a6dc3810b  ec430996-dacd-43cb-b688-424aa7f5b8ad
f08fcb33-fd0a-4828-98a4-209ca88a7d93  Петя Пупкин  9856 2564 8547 9652  2015-09-10  56984  42485cdf-8659-4292-af56-b1583300b0dd  7a6d741b-8a4c-4ef1-b2fa-2176b80d7d48
bb201652-788 D -4d14-979e-82a81b7965c9  Александр Кочнев  6548 2563 4584  2008-10-05  999999  bbda8156-3766-48c6-a5f7-f4b840b37550  831790f8-38c1-4a23-acaf-0437603ed024
260fbc6a-bad9-4d10-8b11-4c2cbad181d9  Леонид Бахров  4562 8596 4586 5967  2009-10-06  5698  bbda8156-3766-48c6-a5f7-f4b840b37550  831790f8-38c1-4a23-acaf-0437603ed024
\.


--
-- TOC entry 2811 (class 0 OID 16402)
-- Dependencies: 197
-- Data for Name: deposit_types; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY deposit_types (deposit_type_id, percents, duration, name) FROM STDIN;
b1dd8e0b-3658-4fc1-a767-ad9a6dc3810b  0.050000000000000003  3600  выгодный
bbda8156-3766-48c6-a5f7-f4b840b37550  50  300  пенсионный
42485cdf-8659-4292-af56-b1583300b0dd  150  2  молодежный
34c986c7-6054-4840-881b-476358bd49ad  96  465  валютный
5f28e5c5-9237-4e51-90dc-059eab625351  9.9900000000000002  40065  экспресс
\.


--
-- TOC entry 2680 (class 2606 OID 16401)
-- Name: bank_branches bank_branches_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY bank_branches
  ADD CONSTRAINT bank_branches_pkey PRIMARY KEY (bank_branch_id);

--
-- TOC entry 2686 (class 2606 OID 16414)
-- Name: clients clients_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY clients
  ADD CONSTRAINT clients_pkey PRIMARY KEY (client_id);

--
-- TOC entry 2684 (class 2606 OID 16406)
-- Name: deposit_types deposit_types_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY deposit_types
  ADD CONSTRAINT deposit_types_pkey PRIMARY KEY (deposit_type_id);

--
-- TOC entry 2682 (class 2606 OID 16428)
-- Name: bank_branches unque_number; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY bank_branches
  ADD CONSTRAINT unque_number UNIQUE (number);

--
-- TOC entry 2688 (class 2606 OID 16420)
-- Name: clients bank_branch_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY clients
  ADD CONSTRAINT bank_branch_fk FOREIGN KEY (bank_branch) REFERENCES bank_branches (bank_branch_id);

--
-- TOC entry 2687 (class 2606 OID 16415)
-- Name: clients deposit_type_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY clients
  ADD CONSTRAINT deposit_type_fk FOREIGN KEY (deposit_type) REFERENCES deposit_types (deposit_type_id);

-- Completed on 2017-12-14 00:46:22

--
-- PostgreSQL database dump complete
--

