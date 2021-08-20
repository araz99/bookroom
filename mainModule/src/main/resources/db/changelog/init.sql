create table if not exists book
(
    id           bigint not null auto_increment,
    author       varchar(255),
    busy         bit,
    description  varchar(255),
    name         varchar(255),
    publisher    varchar(255),
    translator   varchar(255),
    year_edition integer,
    primary key (id)
) engine = InnoDB;

create table if not exists user_bk
(
    id            bigint not null auto_increment,
    password      varchar(255) not null,
    quantity_book integer default 0,
    username      varchar(255) not null ,
    primary key (id)
) engine = InnoDB;

create table if not exists roles
(
    id   bigint       not null auto_increment,
    name varchar(255) not null,
    primary key (id)
) engine = InnoDB;

create table if not exists order_book
(
    id         bigint not null auto_increment,
    book_id    bigint,
    order_date date,
    user_id    bigint,
    primary key (id)
) engine = InnoDB;

create table if not exists user_bk_roles
(
    user_id bigint not null,
    role_id bigint not null
) engine = InnoDB;

alter table order_book
    add constraint uq_order_book unique (user_id, book_id);

alter table user_bk_roles
    add constraint fk_users_roles_role foreign key (role_id) references roles (id);

alter table user_bk_roles
    add constraint fk_users_roles_user foreign key (user_id) references user_bk (id);

insert into roles (name) values ('ROLE_USER'), ('ROLE_ADMIN');