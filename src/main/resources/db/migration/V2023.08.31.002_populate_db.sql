insert into role(role)
values ('ADMIN'),
       ('WAITER');

insert into "user"(role_id, username, password)
select r.id,  'admin',  '1111'
from role r where r.role = 'ADMIN';

insert into menu_item (name, price, description, status)
values ('Roll', 15.5, 'Something with fist and rice', true),
       ('Lemonade', 5.2, 'Lemon and water', true),
       ('Pizza', 30.0, 'Classic pizza', false);

