-- Table: public.criminal

-- DROP TABLE public.criminal;

CREATE TABLE public.criminal
(
    id smallint NOT NULL,
    "fullname" character varying(500) COLLATE pg_catalog."default" NOT NULL,
    nick character varying(200) COLLATE pg_catalog."default",
    article character varying(100) COLLATE pg_catalog."default" NOT NULL,
    address character varying(1000) COLLATE pg_catalog."default" NOT NULL,
    birthday date NOT NULL,
    "courtday" date,
    "isprocessed" integer NOT NULL,
    "articledescription" character varying(500) COLLATE pg_catalog."default",
    ment character varying(500) COLLATE pg_catalog."default" NOT NULL,
    photo character varying(500) COLLATE pg_catalog."default",
    "articlenumber" character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT criminal_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.criminal
    OWNER to postgres;
    
    INSERT INTO criminal (id,fullname,nick,article,address,courtday,isprocessed,articledescription,ment,articlenumber)
    VALUES (1,"Вася","Кортавыч","123ч2","Щербинки","2017-01-01",0,"","Комисар Рекс","");
    
    INSERT INTO criminal (id,fullname,nick,article,address,courtday,isprocessed,articledescription,ment,articlenumber)
    VALUES (2,"Руслан","Русик","321ч332","Мещера","2017-01-01",0,"","Дукалис","");
    
    INSERT INTO criminal (id,fullname,nick,article,address,courtday,isprocessed,articledescription,ment,articlenumber)
    VALUES (2,"Евгений","Гендос","4ч5","Мещера","2017-01-01",0,"","Шерлок Холмс","");