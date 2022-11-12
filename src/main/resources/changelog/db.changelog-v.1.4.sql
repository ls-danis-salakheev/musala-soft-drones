--liquibase formatted sql

--changeset dsalakheev:1
CREATE TABLE drone_order
(
    id          BIGSERIAL NOT NULL PRIMARY KEY,
    created_at  TIMESTAMP,
    modified_at TIMESTAMP,
    state       VARCHAR(32) DEFAULT 'CREATED',
    drone_id    BIGINT REFERENCES drone
);

ALTER TABLE medication
    DROP COLUMN drone_id;

ALTER TABLE medication
    ADD order_id BIGINT REFERENCES drone_order;
--rollback DROP TABLE droneOrder;