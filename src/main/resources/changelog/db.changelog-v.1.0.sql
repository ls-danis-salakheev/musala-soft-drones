--liquibase formatted sql

--changeset dsalakheev:1
CREATE TABLE drone
(
    id               BIGSERIAL    NOT NULL PRIMARY KEY,
    battery_capacity INTEGER      NOT NULL,
    model            VARCHAR(32),
    serial_number    VARCHAR(100) NOT NULL UNIQUE,
    state            VARCHAR(32),
    weight_limit     INTEGER      NOT NULL
);
--rollback DROP TABLE drone;

--changeset dsalakheev:2
CREATE TABLE medication
(
    id       BIGSERIAL    NOT NULL PRIMARY KEY,
    code     varchar(255) NOT NULL UNIQUE,
    image    BYTEA,
    name     VARCHAR(255) NOT NULL,
    weight   INTEGER      NOT NULL,
    drone_id BIGINT REFERENCES drone
);
--rollback DROP TABLE medication;