DROP TABLE IF EXISTS my_user;
create table my_user(
 login VARCHAR(50) not null primary key,
 password VARCHAR(50) not null,
 authority VARCHAR(50) not null
 );