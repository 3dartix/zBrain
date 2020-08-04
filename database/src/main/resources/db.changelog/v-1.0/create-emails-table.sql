create table emails (
       id bigint not null auto_increment,
        email varchar(255) not null unique,
        primary key (id)
    ) engine=InnoDB