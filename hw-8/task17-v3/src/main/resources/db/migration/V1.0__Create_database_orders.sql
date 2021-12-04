create table orders (
    id serial primary key,
    order_number int,
    login text,
    article text,
    name text,
    price int
);