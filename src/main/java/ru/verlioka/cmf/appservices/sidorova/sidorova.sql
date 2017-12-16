SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;


CREATE TABLE papers (
    number_company integer,
    number_stock integer NOT NULL,
    type_stock character(20),
    count_stock integer,
    nominal_price_stock integer,
    date_edition date,
    percent_accrual integer,
    time_repayment date,
    exchange_value integer,
    purchase_price integer
);


ALTER TABLE papers OWNER TO postgres;


ALTER TABLE ONLY papers
    ADD CONSTRAINT papers_pk PRIMARY KEY (number_stock);
	
INSERT INTO papers VALUES (1, 1, 'Обыкновенные        ', 100, 1000, '2010-07-08', 2, '2012-08-07', 10, 500);
INSERT INTO papers VALUES (2, 2, 'Привилегированные   ', 200, 2000, '2010-08-08', 3, '2012-07-07', 100, 5000);
INSERT INTO papers VALUES (2, 3, 'Привилегированные   ', 200, 2000, '2010-08-08', 3, '2012-07-07', 100, 5000);
INSERT INTO papers VALUES (1, 4, 'Обыкновенные        ', 100, 1000, '2010-09-08', 3, '2015-11-11', 100, 5000);
INSERT INTO papers VALUES (3, 5, 'Обыкновенные        ', 100, 1500, '2010-10-10', 2, '2011-10-10', 10, 500);