create table contact
(
    id           bigserial primary key,
    phone_number character varying(32) not null,
    email        character varying(128) unique,
    profile_link text unique
);


create table medical_card
(
    id            bigserial primary key,
    client_status char,
    med_status    char,
    registry_date date not null,
    comment       text
);


create table address
(
    id         bigserial primary key,
    contact_id bigint references contact (id) not null,
    county_id  bigint                         not null,
    city       varchar(255)                   not null,
    index      integer,
    street     varchar(255)                   not null,
    building   varchar(32)                    not null,
    flat       varchar(32)
);



create table illness
(
    id              bigserial primary key,
    medical_card_id bigint references medical_card (id) not null,
    type_id         bigint,
    heaviness       char,
    appearance_dttm timestamp                           not null,
    recovery_dt     date
);



create table person_data
(
    id              bigserial primary key,
    last_name       varchar(255) not null,
    first_name      varchar(255) not null,
    email           varchar(255) not null unique,
    password        varchar(128) not null,
    disabled        bool         not null,
    birth_dt        date         not null,
    age             smallint,
    sex             char         not null,
    contact_id      bigint references contact (id),
    medical_card_id bigint references medical_card (id),
    parent_id       bigint references person_data (id)
);

create table roles
(
    id   bigserial primary key,
    role varchar(128)
);

create view person_contact_view as
select person_data.id,
       person_data.last_name,
       person_data.first_name,
       person_contact.email,
       person_contact.phone_number,
       person_contact.profile_link
from person_data
         join contact person_contact on person_data.contact_id = person_contact.id;

create or replace function getPersonAddress()
    returns table
            (
                id         bigint,
                last_name  varchar(255),
                first_name varchar(255),
                city       varchar(255),
                street     varchar(255),
                building   varchar(32),
                flat       varchar(32)
            )
    language plpgsql
as
$$
BEGIN
    return query (select person_data.id          as id,
                         person_data.first_name  as first_name,
                         person_data.last_name   as last_name,
                         person_address.city     as city,
                         person_address.street   as strees,
                         person_address.building as building,
                         person_address.flat     as flat
                  from person_data
                           inner join contact person_contact on person_contact.id = person_data.contact_id
                           inner join address person_address on person_contact.id = person_address.contact_id);
end;
$$;

create or replace function insert_person_data()
    returns trigger
    language plpgsql as
$$
begin
    insert into person_data (last_name, first_name, birth_dt, age, sex, contact_id, medical_card_id, parent_id)
    values (new.last_name, new.first_name, new.birth_dt, new.age, new.sex, new.contact_id, new.medical_card_id,
            new.parent_id);
    return new;
end;
$$;

create trigger person_data_trigger_insert
    after insert
    on person_data
    for each row
execute procedure insert_person_data();

insert into contact (phone_number, email, profile_link)
values ('000000', 'ivanova@mail.ru', 'ivanova.ru');

insert into medical_card (client_status, med_status, registry_date, comment)
values ('1', '1', '31.12.99', 'comment');

insert into address (contact_id, county_id, city, index, street, building, flat)
values ('1', '1', 'Moscow', '000000', 'streeeet', '24', '45');

insert into illness (medical_card_id, type_id, heaviness, appearance_dttm, recovery_dt)
values ('1', '2', 'y', '2004-01-08', '2005.05.30')
