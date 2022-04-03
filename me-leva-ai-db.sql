drop table ride;

drop table point;

drop table vehicle;

drop table driver;

drop table cnh;

drop table passenger;

drop table person;

-- nessa implementação o cpf não pode ser único, pois não seria possível adicionar um passageiro e um motorista com mesmo cpf
create table person (
    person_id number generated always as identity,
    name varchar(60) not null,
    email varchar(30) not null,
    birth_date date not null,
    cpf varchar2(14) not null,
    balance number(20,3) not null,
    avg_score number(1),
    constraint pk_person primary key (person_id)
);

insert into person (name, email, birth_date, cpf, balance, avg_score)
    values ('Martin Fowler', 'martin@fowler.com', '18-12-1963', '87693837078', 20.5, 4);

insert into person (name, email, birth_date, cpf, balance, avg_score)
    values ('Robert C. Martin', 'robert@cleancode.net', '05-12-1952', '32784419070', 152.5, 2);
    
insert into person (name, email, birth_date, cpf, balance, avg_score)
    values ('Fred Brooks', 'fb@manmonth.com', '19-04-1931', '91392406064', 200.0, 5);
    
insert into person (name, email, birth_date, cpf, balance, avg_score)
    values ('Erich Gamma', 'gammaerich@outlook.com', '13-03-1961', '39664423025', 0.0, 5);

insert into person (name, email, birth_date, cpf, balance, avg_score)
    values ('Richard Helm', 'richarhelm@ibm.com', '13-03-1961', '53295114021', 1.0, 3);    

insert into person (name, email, birth_date, cpf, balance, avg_score)
    values ('Ralph Johnson', 'johnson@uiuc.com', '07-10-1955', '59664897000', 1000.0, 1);
    
insert into person (name, email, birth_date, cpf, balance, avg_score)
    values ('John Vlissides', 'john.vlissides@gof.com', '02-08-1961', '50625267010', 63.32, 2);


create table passenger (
    person_id number not null,
    constraint pk_passenger primary key (person_id),
    constraint fk_passenger_person foreign key (person_id) references person(person_id)
);

insert into passenger (person_id) values (1);
insert into passenger (person_id) values (3);
insert into passenger (person_id) values (5);
insert into passenger (person_id) values (7);

create table cnh (
    cnh_id number generated always as identity,
    number_ varchar(11) not null unique,
    category_ varchar(3) not null,
    due_date date not null,
    constraint pk_cnh primary key (cnh_id),
    constraint cc_cnh_category check (category_ in ('A', 'B', 'C', 'D', 'E', 'ACC'))
);

insert into cnh (number_, category_, due_date) values ('12603145976', 'A', '10-12-2030');

insert into cnh (number_, category_, due_date) values ('61497941095', 'ACC', '10-12-2030');

insert into cnh (number_, category_, due_date) values ('45882898012', 'E', '10-12-2030');

create table driver (
    person_id number not null,
    cnh_id number not null,
    constraint pk_driver primary key (person_id),
    constraint fk_driver_person foreign key (person_id) references person(person_id),
    constraint fk_driver_cnh foreign key (cnh_id) references cnh(cnh_id)
);

insert into driver (person_id, cnh_id) values (2, 1);
insert into driver (person_id, cnh_id) values (4, 2);
insert into driver (person_id, cnh_id) values (6, 3);

create table vehicle (
    vehicle_id number generated always as identity,
    owner_id number not null,
    plate varchar(7) not null unique,
    brand varchar(30) not null,
    model varchar(30) not null,
    year_ number(4) not null,
    color varchar(15) not null,
    photo varchar(255) not null,
    category_ varchar(3) not null,
    qty_seats number(5) not null,
    constraint pk_vehicle primary key (vehicle_id),
    constraint fk_vehicle_driver foreign key (owner_id) references driver (person_id),
    constraint cc_vehicle_category check (category_ in ('A', 'B', 'C', 'D', 'E', 'ACC'))
);

insert into vehicle (owner_id, plate, brand, model, year_, color, photo, category_, qty_seats)
    values (2, 'JKS1228', 'AUDI', 'SUV', 2000, 'BRANCO', 'https://images.usadosbr.com/manipulatedImages/media/gallery/dc/09/9e/be2c3f734fb877d44d3ac1561f79c32b-image-760x570-crop.jpg', 'A', 5);

insert into vehicle (owner_id, plate, brand, model, year_, color, photo, category_, qty_seats)
    values (4, 'BMM8230', 'LEXUS', 'Esportivo', 1983, 'PRETO', 'https://images.usadosbr.com/manipulatedImages/media/gallery/dc/09/9e/be2c3f734fb877d44d3ac1561f79c32b-image-760x570-crop.jpg', 'ACC', 5);

insert into vehicle (owner_id, plate, brand, model, year_, color, photo, category_, qty_seats)
    values (6, 'NEV7953', 'MERCEDES_BENZ', 'Busão', 1961, 'PRATA', 'https://images.usadosbr.com/manipulatedImages/media/gallery/dc/09/9e/be2c3f734fb877d44d3ac1561f79c32b-image-760x570-crop.jpg', 'E', 20);
    
create table point (
    point_id number generated always as identity,
    x integer not null,
    y integer not null,
    constraint pk_point primary key (point_id)
);


insert into point (x, y) values (10, 0);
insert into point (x, y) values (5, 9);

insert into point (x, y) values (100, 100);
insert into point (x, y) values (0, 0);

insert into point (x, y) values (163, 14);
insert into point (x, y) values (1903, 123);

insert into point (x, y) values (0, 0);
insert into point (x, y) values (1, 1);

insert into point (x, y) values (35, 12);
insert into point (x, y) values (1, 3);


create table ride (
    ride_id number generated always as identity,
    origin_id number not null,
    destination_id number not null,
    
    passenger_id number not null,
    vehicle_id number not null,

    start_time timestamp,
    end_time timestamp,
    price number(20, 3),
    status varchar(10) not null,
    driver_score number(1),
    passenger_score number(1),
    
    constraint pk_ride primary key (ride_id),
    constraint fk_ride_passenger foreign key (passenger_id) references passenger (person_id),
    constraint fk_ride_vehicle foreign key (vehicle_id) references vehicle (vehicle_id),
    constraint fk_ride_origin foreign key (origin_id) references point (point_id),
    constraint fk_ride_destination foreign key (destination_id) references point (point_id),
    constraint cc_ride_status check (status in ('CHAMADA', 'INICIADA', 'FINALIZADA'))
);

insert into ride (origin_id, destination_id, passenger_id, vehicle_id, price, start_time, end_time, status, driver_score, passenger_score)
    values (1, 2, 1, 1, 100.92, TO_TIMESTAMP('11-26-2020 9:00', 'MM-DD-YYYY HH24:MI:SS'), TO_TIMESTAMP('11-26-2020 9:31', 'MM-DD-YYYY HH24:MI:SS'), 'FINALIZADA', 3, 5);
    
insert into ride (origin_id, destination_id, passenger_id, vehicle_id, price, start_time, end_time, status, driver_score, passenger_score)
    values (3, 4, 5, 1, 1.0, TO_TIMESTAMP('11-26-2020 10:00', 'MM-DD-YYYY HH24:MI:SS'), TO_TIMESTAMP('11-26-2020 10:12', 'MM-DD-YYYY HH24:MI:SS'), 'FINALIZADA', 3, 5);
    
insert into ride (origin_id, destination_id, passenger_id, vehicle_id, price, start_time, end_time, status, driver_score, passenger_score)
    values (5, 6, 3, 1, 23.4, TO_TIMESTAMP('11-26-2020 8:00', 'MM-DD-YYYY HH24:MI:SS'), TO_TIMESTAMP('11-26-2020 8:05', 'MM-DD-YYYY HH24:MI:SS'), 'FINALIZADA', 3, 5);
    
insert into ride (origin_id, destination_id, passenger_id, vehicle_id, price, start_time, end_time, status, driver_score, passenger_score)
    values (7, 8, 1, 3, 5, TO_TIMESTAMP('11-26-2020 23:06', 'MM-DD-YYYY HH24:MI:SS'), TO_TIMESTAMP('11-26-2020 00:00', 'MM-DD-YYYY HH24:MI:SS'), 'FINALIZADA', 3, 5);

insert into ride (origin_id, destination_id, passenger_id, vehicle_id, price, start_time, end_time, status, driver_score, passenger_score)
    values (9, 10, 7, 3, 30.2, TO_TIMESTAMP('11-26-2020 13:32', 'MM-DD-YYYY HH24:MI:SS'), TO_TIMESTAMP('11-26-2020 13:48', 'MM-DD-YYYY HH24:MI:SS'), 'FINALIZADA', 3, 5);

commit;
