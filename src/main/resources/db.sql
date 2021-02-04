drop table if exists user_role, users, roles;

create table if not exists users
(
    id       bigint       not null auto_increment primary key,
    name     varchar(255) not null unique,
    age      int,
    password varchar(255) not null
)
    ENGINE = InnoDB;

create table if not exists roles
(
    id    bigint     not null  auto_increment primary key,
    role  varchar(100) not null
)
    ENGINE = InnoDB;

create table if not exists user_role
(
    user_id  bigint not null,
    role_id  bigint not null,

    foreign key (user_id) references users(id),
    foreign key (role_id) references  roles(id),
    unique (user_id,role_id)
)
    ENGINE = InnoDB;
insert into users value (1, 'Chingis',32,1111);
insert into users value (2, 'Zarina',30,1111);

insert into roles value (1, 'ROLE_USER');
insert into roles value (2, 'ROLE_ADMIN');

insert into user_role value (1, 1);
insert into user_role value (1, 2);
insert into user_role value (2, 1);