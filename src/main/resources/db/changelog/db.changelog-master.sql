--liquibase formatted sql

--changeset your.name:1
Create Table "pick_point"(
id serial primary key NOT NULL,
name character varying(255),
address character varying(255)
);

--changeset your.name:2
Create Table "client"(
id serial primary key NOT null,
email character varying(255),
phone character varying(255),
fio character varying(11)
);

--changeset your.name:3
Create Table Product(
id serial primary key NOT NULL,
name character varying(255),
number integer,
price decimal
);

--changeset your.name:4
create table "order"(
id serial primary key NOT NULL,
pick_point_id integer,
date date,
sum decimal,
client_id integer,
Foreign key(pick_point_id) references pick_point(id)
on delete cascade on update cascade,
Foreign key(client_id) references "client"(id)
on delete cascade on update cascade
);

--changeset your.name:5
create table "order_list"(
id serial primary key NOT NULL,
order_id integer,
product_id integer,
number integer,
price decimal,
Foreign key(order_id) references "order"(id)
on delete cascade on update cascade,
Foreign key(product_id) references "product"(id)
on delete cascade on update cascade
);

--changeset your.name:6
CREATE TABLE "order_status"(
id serial primary key NOT NULL,
name character varying(255)
);

--changeset your.name:7
INSERT INTO "order_status"(id,name) VALUES
(1,'Готов'),(2,'Завершен'),(3,'Ожидается'),(4,'Отменен');

--changeset your.name:8
ALTER TABLE "order"
ADD "status_id" integer NOT NULL DEFAULT '1'

--changeset your.name:9
ALTER TABLE "order"
ADD CONSTRAINT fk_status
FOREIGN key(status_id) references "order_status"(id);

