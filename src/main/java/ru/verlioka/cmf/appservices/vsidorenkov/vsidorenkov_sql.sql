SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

SET default_with_oids = false;

CREATE TABLE clients (
    id bigint NOT NULL,
    fio character varying(255),
    address character varying(255),
    phone character varying(255)
);

CREATE SEQUENCE clients_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE clients_id_seq OWNED BY clients.id;

CREATE TABLE deliverytype (
    id bigint NOT NULL,
    name character varying(255),
    type integer
);

CREATE SEQUENCE deliverytype_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE deliverytype_id_seq OWNED BY deliverytype.id;

CREATE TABLE orderproducts (
    id integer NOT NULL,
    orderid integer,
    productstockid integer,
    order_id integer
);

CREATE TABLE orders (
    id bigint NOT NULL,
    clientid integer,
    deliveryprice integer,
    deliverytypeid integer,
    orderprice integer,
    orderdate date
);

CREATE SEQUENCE orders_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE orders_id_seq OWNED BY orders.id;

CREATE TABLE productstock (
    id bigint NOT NULL,
    producttypeid integer,
    count integer
);


CREATE SEQUENCE productstock_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE productstock_id_seq OWNED BY productstock.id;

CREATE TABLE producttype (
    id bigint NOT NULL,
    name character varying(255),
    type character varying(255)
);

CREATE SEQUENCE producttype_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE producttype_id_seq OWNED BY producttype.id;

ALTER TABLE ONLY clients ALTER COLUMN id SET DEFAULT nextval('clients_id_seq'::regclass);

ALTER TABLE ONLY deliverytype ALTER COLUMN id SET DEFAULT nextval('deliverytype_id_seq'::regclass);

ALTER TABLE ONLY orders ALTER COLUMN id SET DEFAULT nextval('orders_id_seq'::regclass);

ALTER TABLE ONLY productstock ALTER COLUMN id SET DEFAULT nextval('productstock_id_seq'::regclass);

ALTER TABLE ONLY producttype ALTER COLUMN id SET DEFAULT nextval('producttype_id_seq'::regclass);

ALTER TABLE ONLY clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (id);

ALTER TABLE ONLY deliverytype
    ADD CONSTRAINT deliverytype_pkey PRIMARY KEY (id);

ALTER TABLE ONLY orderproducts
    ADD CONSTRAINT orderproducts_pkey PRIMARY KEY (id);

ALTER TABLE ONLY orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);

ALTER TABLE ONLY productstock
    ADD CONSTRAINT productstock_pkey PRIMARY KEY (id);

ALTER TABLE ONLY producttype
    ADD CONSTRAINT producttype_pkey PRIMARY KEY (id);

ALTER TABLE ONLY orderproducts
    ADD CONSTRAINT orderproducts_orderid_fkey FOREIGN KEY (orderid) REFERENCES orders(id);

ALTER TABLE ONLY orderproducts
    ADD CONSTRAINT orderproducts_productstockid_fkey FOREIGN KEY (productstockid) REFERENCES productstock(id);


ALTER TABLE ONLY orders
    ADD CONSTRAINT orders_clientid_fkey FOREIGN KEY (clientid) REFERENCES clients(id);

ALTER TABLE ONLY orders
    ADD CONSTRAINT orders_deliverytypeid_fkey FOREIGN KEY (deliverytypeid) REFERENCES deliverytype(id);


ALTER TABLE ONLY productstock
    ADD CONSTRAINT productstock_producttypeid_fkey FOREIGN KEY (producttypeid) REFERENCES producttype(id);

SET search_path = public, pg_catalog;

INSERT INTO clients VALUES (1, 'Ivanov Ivan', '88005553535', 'г.Москва');
INSERT INTO clients VALUES (2, 'Petrov Petr', '899999999991', 'г.Нижний Новгород');
INSERT INTO clients VALUES (4, 'Medvedev Dmitriy', '+89998887775', 'c. Moscow');
INSERT INTO clients VALUES (3, 'Putin Vladimir Vladimirovich', '+007', 'г.Москва, Кремль');
INSERT INTO clients VALUES (5, 'Guest', 'xxxxxxxxxxxxx', 'Unknown');

SELECT pg_catalog.setval('clients_id_seq', 1, false);

INSERT INTO deliverytype VALUES (1, 'Почта России', NULL);
INSERT INTO deliverytype VALUES (2, 'Почта Китая', NULL);
INSERT INTO deliverytype VALUES (3, 'IML', NULL);

SELECT pg_catalog.setval('deliverytype_id_seq', 1, false);

INSERT INTO orders VALUES (1, 4, 100, 3, 10, '2017-12-12');
INSERT INTO orders VALUES (2, 3, 50, 1, 1, '2017-01-01');
INSERT INTO orders VALUES (3, 5, 1000, 2, 30, '2017-03-02');

INSERT INTO producttype VALUES (1, 'Хлеб', 'Советский');
INSERT INTO producttype VALUES (2, 'Йогурт', 'Московский');
INSERT INTO producttype VALUES (3, 'Молоко', 'Домашнее');
INSERT INTO producttype VALUES (4, 'Сосиски', 'Красная цена');
INSERT INTO producttype VALUES (5, 'Вода', 'Питьевая');
INSERT INTO producttype VALUES (6, 'Апельсин', 'Обычный');
INSERT INTO producttype VALUES (7, 'Мандарин', 'Обычный');
INSERT INTO producttype VALUES (8, 'Груша', 'Спелая');
INSERT INTO producttype VALUES (9, 'Яблоко', 'Спелое');
INSERT INTO producttype VALUES (10, 'Банан', 'Желтый');
INSERT INTO producttype VALUES (11, 'Ножницы', 'Some name here');
INSERT INTO producttype VALUES (12, 'Телефон', 'Nokia');
INSERT INTO producttype VALUES (13, 'Micro SD', '10 GB');
INSERT INTO producttype VALUES (14, 'Ручка', 'Apple Pen');
INSERT INTO producttype VALUES (15, 'Карандаш', 'Panapple');
INSERT INTO producttype VALUES (16, 'Циркуль', 'Default name');
INSERT INTO producttype VALUES (17, 'Ластик', 'Большая стирка');
INSERT INTO producttype VALUES (19, 'Монитор', 'Philips');
INSERT INTO producttype VALUES (20, 'Мышь', 'Logitech');
INSERT INTO producttype VALUES (18, 'Клавиатура', 'A4Tech');
INSERT INTO producttype VALUES (21, 'Печенье', 'Юбилейное');
INSERT INTO producttype VALUES (22, 'Стул', 'ИКЕА');
INSERT INTO producttype VALUES (23, 'Стол', 'ИКЕА');
INSERT INTO producttype VALUES (24, 'Утюг', 'Panasonic');
INSERT INTO producttype VALUES (25, 'Футболка', 'Adidas');

INSERT INTO productstock VALUES (1, 1, 30);
INSERT INTO productstock VALUES (2, 2, 14);
INSERT INTO productstock VALUES (3, 3, 4);
INSERT INTO productstock VALUES (4, 4, 6);
INSERT INTO productstock VALUES (5, 6, 5);
INSERT INTO productstock VALUES (6, 5, 1);
INSERT INTO productstock VALUES (7, 10, 0);
INSERT INTO productstock VALUES (8, 12, 30);

INSERT INTO orderproducts VALUES (1, 1, 4, NULL);
INSERT INTO orderproducts VALUES (2, 2, 1, NULL);
INSERT INTO orderproducts VALUES (3, 3, 2, NULL);
INSERT INTO orderproducts VALUES (4, 1, 3, NULL);
INSERT INTO orderproducts VALUES (5, 1, 6, NULL);
INSERT INTO orderproducts VALUES (6, 2, 7, NULL);


SELECT pg_catalog.setval('orders_id_seq', 1, false);
SELECT pg_catalog.setval('productstock_id_seq', 1, false);
SELECT pg_catalog.setval('producttype_id_seq', 1, false);
