create schema queries;

create table queries.CUSTOMERS
(
    id              serial primary key,
    name            varchar(30) not null,
    surname         varchar(30)     not null,
    age             integer not null ,
    phone_number    varchar(30) unique
);

create table queries.ORDERS
(
    id              serial primary key,
    date            DATE not null,
    customer_id     int,
    product_name    varchar(30) not null,
    amount          int,
    foreign key (customer_id) references queries.CUSTOMERS(id)
);