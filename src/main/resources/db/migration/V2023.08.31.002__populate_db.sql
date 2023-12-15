insert into "user" (username, "password") values ('useruser', '12341234');
insert into "orders" (bill, people, table_id, user_id)
select 0, 2, 1, u.id from "user" u where u.username='useruser';

insert into "menu_item" (name, price, description, status)
values ('Roll', 15.5, 'Something with fist and rice', true),
       ('Lemonade', 5.2, 'Lemon and water', true),
       ('Pizza', 30.0, 'Classic pizza', false);

-- drop table flyway_schema_history;
-- drop table order_menu_items;
-- drop table menu_item;
-- drop table orders;
-- drop table "user";

