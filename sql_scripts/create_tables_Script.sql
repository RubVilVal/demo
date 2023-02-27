CREATE TABLE passengers (
	id serial primary key,
	first_name character varying(200) NOT NULL,
	surname character varying(200) NOT NULL,
	date_of_birth date NOT NULL
);

CREATE TABLE trains (
	number integer primary key,
	seats integer
);

CREATE TABLE stations (
	id serial primary key,
	station_name character varying(200) NOT NULL
);

CREATE TABLE schedule (
	id serial primary key,
	station_id integer references stations(id),
	train_number integer references trains(number),
	time timestamp without time zone NOT NULL
);

CREATE TABLE tickets (
	id serial primary key,
	passenger_id integer references passengers(id),
	train_number integer references trains(number)
);

