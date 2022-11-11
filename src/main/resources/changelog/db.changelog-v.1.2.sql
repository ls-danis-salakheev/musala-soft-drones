--liquibase formatted sql

--changeset dsalakheev:1
CREATE TABLE shedlock
(
    name       VARCHAR(64) PRIMARY KEY,
    locked_by  VARCHAR(128),
    lock_until TIMESTAMP(3) NULL,
    locked_at  TIMESTAMP(3) NULL
);
--rollback DROP TABLE shedlock;

