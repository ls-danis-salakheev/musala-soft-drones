--liquibase formatted sql

--changeset dsalakheev:1
INSERT INTO drone(battery_capacity, model, serial_number, state, weight_limit, created_at, modified_at)
VALUES (100, 'Heavyweight', 'XGP5X10', 'IDLE', 500, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO drone(battery_capacity, model, serial_number, state, weight_limit, created_at, modified_at)
VALUES (100, 'Middleweight', 'TD9WQ1R', 'LOADING', 250, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO drone(battery_capacity, model, serial_number, state, weight_limit, created_at, modified_at)
VALUES (98, 'Lightweight', 'QPC3MX9', 'LOADING', 100, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO drone(battery_capacity, model, serial_number, state, weight_limit, created_at, modified_at)
VALUES (100, 'Cruiserweight', 'NGIN3X1', 'IDLE', 350, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO drone(battery_capacity, model, serial_number, state, weight_limit, created_at, modified_at)
VALUES (60, 'Middleweight', 'RA6ZP22', 'LOADING', 250, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO drone(battery_capacity, model, serial_number, state, weight_limit, created_at, modified_at)
VALUES (30, 'Heavyweight', 'WWQ2OU8', 'DELIVERED', 500, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO drone(battery_capacity, model, serial_number, state, weight_limit, created_at, modified_at)
VALUES (20, 'Lightweight', 'VVC3PM2', 'RETURNING', 100, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO drone(battery_capacity, model, serial_number, state, weight_limit, created_at, modified_at)
VALUES (80, 'Cruiserweight', 'EE89KL1', 'DELIVERING', 350, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO drone(battery_capacity, model, serial_number, state, weight_limit, created_at, modified_at)
VALUES (95, 'Middleweight', 'NNM67U1', 'LOADED', 250, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO drone(battery_capacity, model, serial_number, state, weight_limit, created_at, modified_at)
VALUES (76, 'Lightweight', 'SA90HJ2', 'DELIVERED', 100, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
--rollback DELETE FROM DRONE;

