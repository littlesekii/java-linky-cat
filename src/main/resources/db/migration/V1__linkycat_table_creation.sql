create table t_user (
    id bigserial primary key,
    username varchar(255) not null unique,
    email varchar(255) not null unique,
    password varchar(255) not null
);

create table t_user_info (
    id bigserial primary key,
    id_user bigint not null references t_user(id),
    name varchar(255) not null,
    last_name varchar(255) not null,
    created_at timestamp default now(),
    updated_at timestamp default now()
);

create table t_link (
    id bigserial primary key,
    id_user bigint not null references t_user(id),
    url varchar not null,
    title varchar
);