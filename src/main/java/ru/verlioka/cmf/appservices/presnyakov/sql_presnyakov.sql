SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;


CREATE TABLE provider (
    id integer NOT NULL,
    name character varying(128) NOT NULL,
    director character varying(128) NOT NULL,
    city_id integer
);
ALTER TABLE provider OWNER TO postgres;


CREATE TABLE material (
    id integer NOT NULL,
    batch_number integer NOT NULL,
    cipher character varying(128) NOT NULL,
    count integer NOT NULL,
    unit character varying(128) NOT NULL,
    unit_price integer NOT NULL,
    date_of_receiving date NOT NULL,
    provider_id integer NOT NULL
);
ALTER TABLE material OWNER TO postgres;

CREATE TABLE city (
    id integer NOT NULL,
    name character varying(128) NOT NULL
);


ALTER TABLE city OWNER TO postgres;

INSERT INTO city (id, name) VALUES (2, 'Moscow');
INSERT INTO city (id, name) VALUES (1, 'Tokio');
INSERT INTO city (id, name) VALUES (3, 'Nizhny Novgorod');
INSERT INTO provider (id, name, director, city_id) VALUES (1, 'Pil inc', 'John Lydon', 1);
INSERT INTO provider (id, name, director, city_id) VALUES (2, 'Apple', 'Paul Cook', 2);
INSERT INTO provider (id, name, director, city_id) VALUES (3, 'Pirate corp', 'Blue Beard', 3);
INSERT INTO provider (id, name, director, city_id) VALUES (4, 'TexasTools', 'Ivan Petrov', 1);
INSERT INTO provider (id, name, director, city_id) VALUES (5, 'KUT corp', 'Igor Titov', 2);
INSERT INTO material (id, batch_number, cipher, count, unit, unit_price, date_of_receiving, provider_id) VALUES (1, 22, 'ZZZDD', 11, 'Meter', 2000, '2012-01-05', 1);
INSERT INTO material (id, batch_number, cipher, count, unit, unit_price, date_of_receiving, provider_id) VALUES (2, 12, 'SAQ', 44, 'Mm', 5000, '2015-06-05', 2);
INSERT INTO material (id, batch_number, cipher, count, unit, unit_price, date_of_receiving, provider_id) VALUES (4, 69, 'QWSDS', 9, 'Kg', 333, '2017-01-01', 4);
INSERT INTO material (id, batch_number, cipher, count, unit, unit_price, date_of_receiving, provider_id) VALUES (3, 33, 'VVRT', 21, 'Meter', 122, '2017-06-05', 3);
INSERT INTO material (id, batch_number, cipher, count, unit, unit_price, date_of_receiving, provider_id) VALUES (6, 12, 'NNNMM', 88, 'Mm', 120, '2017-01-05', 2);
INSERT INTO material (id, batch_number, cipher, count, unit, unit_price, date_of_receiving, provider_id) VALUES (5, 11, 'GGDDFF', 11, 'Kg', 588, '2015-09-05', 5);
INSERT INTO material (id, batch_number, cipher, count, unit, unit_price, date_of_receiving, provider_id) VALUES (7, 8, 'CC2CC', 1, 'Kg', 90, '2015-08-05', 4);
INSERT INTO material (id, batch_number, cipher, count, unit, unit_price, date_of_receiving, provider_id) VALUES (9, 33, 'XX9UU', 2, 'Meter', 900, '2012-07-01', 4);
INSERT INTO material (id, batch_number, cipher, count, unit, unit_price, date_of_receiving, provider_id) VALUES (8, 18, 'HHYY9', 21, 'Kg', 88, '2017-04-05', 3);



ALTER TABLE ONLY city
    ADD CONSTRAINT city_pkey PRIMARY KEY (id);

ALTER TABLE ONLY provider
    ADD CONSTRAINT provider_pkey PRIMARY KEY (id);


CREATE INDEX fki_city_key ON provider USING btree (city_id);


ALTER TABLE ONLY provider
    ADD CONSTRAINT city_key FOREIGN KEY (city_id) REFERENCES city(id);


ALTER TABLE ONLY material
    ADD CONSTRAINT material_pkey PRIMARY KEY (id);


CREATE INDEX fki_provider_key ON material USING btree (provider_id);



ALTER TABLE ONLY material
    ADD CONSTRAINT provider_key FOREIGN KEY (provider_id) REFERENCES provider(id);

