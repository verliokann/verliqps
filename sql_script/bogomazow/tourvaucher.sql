CREATE TABLE IF NOT EXISTS public.vauchers (
  vaucher_id         BIGINT NOT NULL PRIMARY KEY UNIQUE,
  country  VARCHAR(100)  NOT NULL,
  seaside  VARCHAR(100)  NOT NULL,
  hotel    VARCHAR(100)  NOT NULL,
  rating   INT           NOT NULL,
  cost     FLOAT          NOT NULL,
  dayscount    INT       NOT NULL,
  beachtype VARCHAR(100)  NOT NULL,
  startdate DATE		 NOT NULL,
  finishdate DATE        NOT NULL,
  istravelpaid BOOLEAN,
  isvisaneed   BOOLEAN
);

INSERT INTO public.vauchers (vaucher_id,country,seaside,hotel,rating,cost,dayscount,beachtype,startdate,finishdate,istravelpaid,isvisaneed)
	VALUES (1,'Болгария','Черноморское','StarSea',3,43.700,10,'песок',to_date('10-11-2015', 'MM-DD-YYYY'),to_date('10-21-2015', 'MM-DD-YYYY'),true,true);
	
INSERT INTO public.vauchers (vaucher_id,country,seaside,hotel,rating,cost,dayscount,beachtype,startdate,finishdate,istravelpaid,isvisaneed)
	VALUES (2,'Россия','Джемете','Анапа',2,18.500,10,'песок',to_date('07-11-2015', 'MM-DD-YYYY'),to_date('07-21-2015', 'MM-DD-YYYY'),false,false);
	
INSERT INTO public.vauchers (vaucher_id,country,seaside,hotel,rating,cost,dayscount,beachtype,startdate,finishdate,istravelpaid,isvisaneed)
	VALUES (3,'Испания','Коста Дорада','HTop Aqua Park',4,55.700,8,'песок',to_date('05-21-2015', 'MM-DD-YYYY'),to_date('05-29-2015', 'MM-DD-YYYY'),true,true);
	
INSERT INTO public.vauchers (vaucher_id,country,seaside,hotel,rating,cost,dayscount,beachtype,startdate,finishdate,istravelpaid,isvisaneed)
	VALUES (4,'Египет','Хургада','Desert Rose',5,34.300,12,'песок',to_date('07-10-2015', 'MM-DD-YYYY'),to_date('07-22-2015', 'MM-DD-YYYY'),true,true);