create table if not exists "user" (
                                      id bigserial primary key,
                                      username varchar (50) unique,
    password varchar (50) unique,
    check (length (username) >= 5 and length(username) <= 50)
    );

create table if not exists "orders" (
                                       id bigserial primary key,
                                       is_Closed boolean DEFAULT false,
                                       is_Payed boolean DEFAULT false,
                                       people int,
                                       bill float,
                                       table_id bigint,
                                       user_id bigint not null,
                                       foreign key (user_id) references "user"(id)
    );

create table if not exists "menu_item"(
                                          id bigserial primary key,
                                          name varchar(500) not null,
    price float,
    description varchar(500),
    status boolean not null
    );

create table if not exists "order_menu_items" (
                                                  id bigserial primary key,
                                                  order_id bigint not null,
                                                  menu_item_id bigint not null,
                                                  quantity float not null default 1,
                                                  total_price float,
                                                  foreign key (order_id) references "orders"(id),
    foreign key (menu_item_id) references "menu_item"(id)
    );

create unique index if not exists person_index on "user"(id, username);
create unique index if not exists order_index on "orders"(id);
create unique index if not exists menu_index on "menu_item"(id);
create unique index if not exists order_menu_items_index on "order_menu_items"(id);
