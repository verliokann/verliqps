CREATE TABLE IF NOT EXISTS public.countries (
  country_id    BIGINT       NOT NULL PRIMARY KEY UNIQUE,
  country_name  VARCHAR(255) NOT NULL,
  visa_required BOOLEAN      NOT NULL
);

CREATE TABLE IF NOT EXISTS public.hotels (
  hotel_id      BIGINT       NOT NULL PRIMARY KEY UNIQUE,
  country_id    BIGINT       NOT NULL REFERENCES public.countries,
  hotel_name    VARCHAR(255) NOT NULL,
  hotel_quality INTEGER      NOT NULL
);

CREATE TABLE IF NOT EXISTS public.vouchers (
  voucher_id               BIGINT  NOT NULL PRIMARY KEY UNIQUE,
  hotel_id                 BIGINT  NOT NULL REFERENCES public.hotels,
  cost                     FLOAT   NOT NULL,
  days                     INTEGER NOT NULL,
  start                    DATE    NOT NULL,
  "end"                    DATE,
  travel_expenses_included BOOLEAN
);

INSERT INTO public.countries VALUES (1, 'India', TRUE);
INSERT INTO public.countries VALUES (2, 'UAE', TRUE);
INSERT INTO public.countries VALUES (3, 'Egypt', FALSE);

INSERT INTO public.hotels VALUES (1, 1, 'The Verda Carmona', 5);
INSERT INTO public.hotels VALUES (2, 1, 'La Riviere', 5);
INSERT INTO public.hotels VALUES (3, 3, 'Sea Beach Aqua Park Blue Resorts', 4);
INSERT INTO public.hotels VALUES (4, 2, 'Carlton Tower Hotel Dubai', 4);

INSERT INTO public.vouchers
VALUES (1, 1, 40000, 14, to_date('10-11-2017', 'MM-DD-YYYY'), to_date('10-25-2017', 'MM-DD-YYYY'), TRUE);
INSERT INTO public.vouchers
VALUES (2, 3, 30000, 7, to_date('09-07-2017', 'MM-DD-YYYY'), to_date('09-14-2017', 'MM-DD-YYYY'));
INSERT INTO public.vouchers VALUES (3, 2, 30500, 14, to_date('12-03-2017', 'MM-DD-YYYY'));
INSERT INTO public.vouchers VALUES (4, 4, 45000, 7, to_date('05-01-2017', 'MM-DD-YYYY'));
