CREATE TABLE IF NOT EXISTS public.tariffs (
  tariff_id         BIGINT NOT NULL PRIMARY KEY UNIQUE,
  monthly_payment   FLOAT  NOT NULL,
  minutes_per_month INTEGER
);

CREATE TABLE IF NOT EXISTS public.customers (
  customer_id  BIGINT       NOT NULL PRIMARY KEY UNIQUE,
  tariff_id    BIGINT       NOT NULL REFERENCES public.tariffs,
  phone_number VARCHAR(12)  NOT NULL,
  name         VARCHAR(255) NOT NULL,
  address      VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS public.payments (
  payment_id  BIGINT NOT NULL PRIMARY KEY UNIQUE,
  customer_id BIGINT NOT NULL REFERENCES public.customers,
  created_at  DATE,
  amount      FLOAT  NOT NULL
);

-- Insert some test data
INSERT INTO public.tariffs (tariff_id, monthly_payment, minutes_per_month) VALUES (1, 500, -1);
INSERT INTO public.tariffs (tariff_id, monthly_payment, minutes_per_month) VALUES (2, 400, 300);

INSERT INTO public.customers (customer_id, tariff_id, phone_number, name, address)
VALUES (1, 1, '+79990000001', 'Ivanov Ivan Ivanovich', 'Kovalikhinskaya, 8');
INSERT INTO public.customers (customer_id, tariff_id, phone_number, name, address)
VALUES (2, 2, '+79990000002', 'Petrov Petr Petrovich', 'Kovalikhinskaya, 9');

INSERT INTO public.payments (payment_id, customer_id, created_at, amount)
VALUES (1, 1, to_date('09-11-2017', 'MM-DD-YYYY'), 600);

-- This two will be represented as one entry in result (if everything was correct)
INSERT INTO public.payments (payment_id, customer_id, created_at, amount)
VALUES (2, 1, to_date('10-11-2017', 'MM-DD-YYYY'), 300);
INSERT INTO public.payments (payment_id, customer_id, created_at, amount)
VALUES (3, 1, to_date('10-20-2017', 'MM-DD-YYYY'), 200);

INSERT INTO public.payments (payment_id, customer_id, created_at, amount)
VALUES (4, 1, to_date('11-11-2017', 'MM-DD-YYYY'), 400);
INSERT INTO public.payments (payment_id, customer_id, created_at, amount)
VALUES (5, 1, to_date('12-11-2017', 'MM-DD-YYYY'), 500);

INSERT INTO public.payments (payment_id, customer_id, created_at, amount)
VALUES (6, 2, to_date('09-21-2017', 'MM-DD-YYYY'), 400);
INSERT INTO public.payments (payment_id, customer_id, created_at, amount)
VALUES (7, 2, to_date('10-21-2017', 'MM-DD-YYYY'), 300);

-- This two will be represented as one entry in result (if everything was correct)
INSERT INTO public.payments (payment_id, customer_id, created_at, amount)
VALUES (8, 2, to_date('11-01-2017', 'MM-DD-YYYY'), 100);
INSERT INTO public.payments (payment_id, customer_id, created_at, amount)
VALUES (9, 2, to_date('11-21-2017', 'MM-DD-YYYY'), 300);

INSERT INTO public.payments (payment_id, customer_id, created_at, amount)
VALUES (10, 2, to_date('12-21-2017', 'MM-DD-YYYY'), 400);

-- At the end, customer 1 is fine, but customer 2 must be in debt by -100 points and do not have minutes available (0)
