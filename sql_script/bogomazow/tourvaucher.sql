CREATE TABLE IF NOT EXISTS public.countries (
  country_id    BIGINT       NOT NULL PRIMARY KEY UNIQUE,
  country_name  VARCHAR(255) NOT NULL,
  visa_required BOOLEAN      NOT NULL
);

CREATE TABLE IF NOT EXISTS public.hotels (
  hotel_id      BIGINT       NOT NULL PRIMARY KEY UNIQUE,
  country_id    BIGINT       NOT NULL REFERENCES public.countries,
  hotel_name    VARCHAR(255) NOT NULL,
  hotel_rating  INTEGER      NOT NULL,
  seaside       VARCHAR(255) NOT NULL,
  beachtype		VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS public.vouchers (
  voucher_id               BIGINT  NOT NULL PRIMARY KEY UNIQUE,
  hotel_id                 BIGINT  NOT NULL REFERENCES public.hotels,
  cost                     FLOAT   NOT NULL,
  days                     INTEGER NOT NULL,
  startdate                DATE    NOT NULL,
  finishdate                    DATE,
  travelpaid                BOOLEAN
);

INSERT INTO public.countries VALUES (1, 'Russia', FALSE);
INSERT INTO public.countries VALUES (2, 'Spain', TRUE);
INSERT INTO public.countries VALUES (3, 'Egypt', FALSE);
INSERT INTO public.countries VALUES (4, 'France', TRUE);
INSERT INTO public.countries VALUES (5, 'Cyprus', FALSE);
INSERT INTO public.countries VALUES (6, 'Greece', TRUE);

INSERT INTO public.hotels VALUES (1, 1, 'Sochi Star', 4, 'Gemete', 'sand');
INSERT INTO public.hotels VALUES (2, 1, 'Lazur', 5, 'Utrish', 'pebble');
INSERT INTO public.hotels VALUES (3, 2, 'Htop Molinos', 4, 'Costa Dorada', 'sand');
INSERT INTO public.hotels VALUES (4, 3, 'Desert Rose', 5, 'Hurgada', 'sand');
INSERT INTO public.hotels VALUES (5, 3, 'Dessole Star Beach', 5, 'Sharm el Sheikh', 'sand');
INSERT INTO public.hotels VALUES (6, 4, 'Dolce Vita', 3, 'Atlantic', 'pebble');
INSERT INTO public.hotels VALUES (7, 5, 'Sea side', 4, 'Aya Napa', 'sand');
INSERT INTO public.hotels VALUES (8, 6, 'Aqua dream', 5, 'Rodos', 'pebble');

INSERT INTO public.vouchers
VALUES (1, 1, 25000, 10, to_date('05-01-2017', 'MM-DD-YYYY'), to_date('05-11-2017', 'MM-DD-YYYY'), TRUE);
INSERT INTO public.vouchers
VALUES (2, 2, 29000, 8, to_date('05-21-2017', 'MM-DD-YYYY'), to_date('05-29-2017', 'MM-DD-YYYY'), TRUE);
INSERT INTO public.vouchers
VALUES (3, 3, 34000, 11, to_date('06-05-2017', 'MM-DD-YYYY'), to_date('06-16-2017', 'MM-DD-YYYY'), FALSE);
INSERT INTO public.vouchers
VALUES (4, 3, 38000, 10, to_date('06-20-2017', 'MM-DD-YYYY'), to_date('06-30-2017', 'MM-DD-YYYY'), TRUE);
INSERT INTO public.vouchers
VALUES (5, 4, 28000, 9, to_date('07-01-2017', 'MM-DD-YYYY'), to_date('07-10-2017', 'MM-DD-YYYY'), FALSE);
INSERT INTO public.vouchers
VALUES (6, 4, 30000, 11, to_date('07-01-2017', 'MM-DD-YYYY'), to_date('07-12-2017', 'MM-DD-YYYY'), FALSE);
INSERT INTO public.vouchers
VALUES (7, 5, 48000, 14, to_date('08-02-2017', 'MM-DD-YYYY'), to_date('08-16-2017', 'MM-DD-YYYY'), TRUE);


