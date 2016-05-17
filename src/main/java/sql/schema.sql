create table roles (
  uid serial primary key,
  role varchar(200)
);

CREATE TABLE images (
  id SERIAL PRIMARY KEY ,
  image BYTEA UNIQUE,
  url VARCHAR(250),
  user_id int references clients(uid)
);

INSERT INTO roles (role) VALUES ('ROLE_ADMIN');
INSERT INTO roles (role) VALUES ('ROLE_USER');

create table clients (
  uid serial primary key,
  login varchar(200),
  password VARCHAR(40),
  email varchar(200),
  role_id int references roles(uid)
);

create table messages (
  uid serial primary key,
  text  character varying,
  user_id int references clients(uid)
);

create table pets (
  uid serial primary key,
  name  VARCHAR(40),
  age int,
  user_id int not null references clients(uid)
);

INSERT INTO roles (role) VALUES ('ROLE_ADMIN');
INSERT INTO clients(login, password, email, role_id) VALUES ('Mike', '12345', '@mail', (SELECT uid FROM roles WHERE role = 'ROLE_ADMIN'));
INSERT INTO messages(text, user_id) VALUES ('Hello World', (SELECT uid FROM clients WHERE login = 'Mike'));
INSERT INTO pets(name, age, user_id) VALUES ('Cat', 3, (SELECT uid FROM clients WHERE login = 'Mike'));