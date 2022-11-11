--liquibase formatted sql

--changeset dsalakheev:1
ALTER TABLE drone
    ADD COLUMN created_at TIMESTAMP;

ALTER TABLE drone
    ADD COLUMN modified_at TIMESTAMP;

--changeset dsalakheev:2
ALTER TABLE medication
    ADD COLUMN created_at TIMESTAMP;

ALTER TABLE medication
    ADD COLUMN modified_at TIMESTAMP;
