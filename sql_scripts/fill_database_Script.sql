insert INTO stations (id, station_name)
VALUES (1, 'Granada'), (2, 'Madrid')

insert into passengers (id, name, surname, date_of_birth, password, role)
values (1, 'Ruben', 'Vilchez', '1997-04-19', 'Rubenpass', 'ROLE_USER'), (2, 'Jane', 'Doe', '1986-06-08', 'Janepass', 'ROLE_USER'), (3, 'admin', 'admin', '2001-01-01', 'adminpass', 'ROLE_ADMIN')

insert into trains (number, seats)
values (1, 12), (2, 30)

insert into schedule (id, station_id, train_number, time)
values (1, 1, 1, '2023-02-15 13:30:00'), (2, 2, 2, '2023-06-02 07:15:00')

insert into tickets (id, passenger_id, train_number)
values (1, 1, 1), (2, 2, 2)