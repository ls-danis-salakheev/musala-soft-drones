--liquibase formatted sql

--changeset dsalakheev:1
INSERT INTO drone_order(created_at, modified_at, state, drone_id)
VALUES (CURRENT_TIMESTAMP - INTERVAL '1 month', CURRENT_TIMESTAMP - INTERVAL '1 month', 'PROCESSING', 3);

INSERT INTO drone_order(created_at, modified_at, state, drone_id)
VALUES (CURRENT_TIMESTAMP - INTERVAL '1 month', CURRENT_TIMESTAMP - INTERVAL '1 month', 'DELIVERING', 8);

INSERT INTO drone_order(created_at, modified_at, state, drone_id)
VALUES (CURRENT_TIMESTAMP - INTERVAL '1 month', CURRENT_TIMESTAMP - INTERVAL '1 month', 'FINISHED', 6);

INSERT INTO drone_order(created_at, modified_at, state, drone_id)
VALUES (CURRENT_TIMESTAMP - INTERVAL '1 month', CURRENT_TIMESTAMP - INTERVAL '1 month', 'PROCESSING', 5);

INSERT INTO drone_order(created_at, modified_at, state, drone_id)
VALUES (CURRENT_TIMESTAMP - INTERVAL '1 month', CURRENT_TIMESTAMP - INTERVAL '1 month', 'FINISHED', 7);

INSERT INTO drone_order(created_at, modified_at, state, drone_id)
VALUES (CURRENT_TIMESTAMP - INTERVAL '1 month', CURRENT_TIMESTAMP - INTERVAL '1 month', 'FINISHED', 7);

INSERT INTO drone_order(created_at, modified_at, state, drone_id)
VALUES (CURRENT_TIMESTAMP - INTERVAL '1 month', CURRENT_TIMESTAMP - INTERVAL '1 month', 'DELIVERING', 6);

INSERT INTO drone_order(created_at, modified_at, state, drone_id)
VALUES (CURRENT_TIMESTAMP - INTERVAL '1 month', CURRENT_TIMESTAMP - INTERVAL '1 month', 'PROCESSING', 9);

INSERT INTO drone_order(created_at, modified_at, state, drone_id)
VALUES (CURRENT_TIMESTAMP - INTERVAL '1 month', CURRENT_TIMESTAMP - INTERVAL '1 month', 'PROCESSING', 2);

INSERT INTO drone_order(created_at, modified_at, state, drone_id)
VALUES (CURRENT_TIMESTAMP - INTERVAL '1 month', CURRENT_TIMESTAMP - INTERVAL '1 month', 'FINISHED', 10);

INSERT INTO drone_order(created_at, modified_at, state, drone_id)
VALUES (CURRENT_TIMESTAMP - INTERVAL '1 month', CURRENT_TIMESTAMP - INTERVAL '1 month', 'FINISHED', 2);

INSERT INTO drone_order(created_at, modified_at, state, drone_id)
VALUES (CURRENT_TIMESTAMP - INTERVAL '1 month', CURRENT_TIMESTAMP - INTERVAL '1 month', 'FINISHED', 4);

INSERT INTO drone_order(created_at, modified_at, state, drone_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'CREATED', 1);
--rollback DELETE FROM drone_order;

