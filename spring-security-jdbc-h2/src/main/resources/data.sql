
insert into users(username, password, enabled)
values('gopi','gopi',true);

insert into users(username, password, enabled)
values('ram','ram',true);

insert into authorities(username, authority)
values ('gopi','ROLE_ADMIN');

insert into authorities(username, authority)
values ('ram','ROLE_USER');