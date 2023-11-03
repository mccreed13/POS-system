create table if not exists role (
    id bigserial primary key,
    role varchar(30) check (role in ('ADMIN', 'WAITER'))
);

create table if not exists "user" (
    id bigserial primary key,
    username varchar (50) unique,
    password varchar (50) unique,
    role_id bigint not null,
    foreign key (role_id) references role(id),
    check (length (username) >= 5 and length(username) <= 50)
);

create table if not exists "order" (
    id bigserial primary key,
    timestamp timestamp not null,
    user_id bigint not null,
    foreign key (user_id) references "user"(id)
);

create table if not exists menu_item(
    id bigserial primary key,
    name varchar(500) not null,
    price numeric not null,
    description varchar(500),
    status boolean not null
);

create table if not exists order_items (
    id bigserial primary key,
    order_id bigint not null,
    menu_item_id bigint not null,
    quantity numeric not null default 1,
    price numeric not null,
    foreign key (order_id) references "order"(id),
    foreign key (menu_item_id) references "menu_item"(id)
);
