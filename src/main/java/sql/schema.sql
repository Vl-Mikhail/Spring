create table roles (
  uid serial primary key,
  role varchar(200)
);

create table users (
  uid serial primary key,
  login varchar(200),
  password VARCHAR(40),
  email varchar(200),
  role_id int not null references roles(uid)
);

create table messages (
  uid serial primary key,
  text  character varying,
  user_id int not null references clients(uid)
);

create table pets (
  uid serial primary key,
  name  VARCHAR(40),
  age int,
  user_id int not null references clients(uid)
);