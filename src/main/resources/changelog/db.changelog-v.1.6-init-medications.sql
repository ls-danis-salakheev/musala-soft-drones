--liquibase formatted sql

--changeset dsalakheev:1
INSERT INTO medication(created_at, modified_at, code, name, weight, order_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'AAAAAAAAAAAAA', 'ProductA', 344, 13);

INSERT INTO medication(created_at, modified_at, code, name, weight, order_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'AAAAAAAAAA_AAB', 'ProductAA', 101, 9);

INSERT INTO medication(created_at, modified_at, code, name, weight, order_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'RRRRRRRR', 'ProductAAA', 133, 9);

INSERT INTO medication(created_at, modified_at, code, name, weight, order_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'AAAA_AAAAAAWWW_2342AAA', 'ProductAAD', 100, 11);

INSERT INTO medication(created_at, modified_at, code, name, weight, order_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'AAAAAAAAEEAAAAA', 'ProductAAR', 100, 11);

INSERT INTO medication(created_at, modified_at, code, name, weight, order_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'AAAAAAAAWWAAAAA', 'ProductAADR', 13, 11);

INSERT INTO medication(created_at, modified_at, code, name, weight, order_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'AAAAQ_FAAAAAAAAA', 'ProductAAW', 56, 1);

INSERT INTO medication(created_at, modified_at, code, name, weight, order_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'AAAAAAPOWW_AAAAAAA', 'ProductAAI', 230, 12);

INSERT INTO medication(created_at, modified_at, code, name, weight, order_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'AAAAAAAAMATH_AAAAA', 'ProductAAP', 23, 12);

INSERT INTO medication(created_at, modified_at, code, name, weight, order_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'AAAA777_AAAAAAAAA', 'ProductAA22', 21, 12);

INSERT INTO medication(created_at, modified_at, code, name, weight, order_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'AAADFA_AAAAAAAQQWETYU', 'ProductAA11', 33, 4);

INSERT INTO medication(created_at, modified_at, code, name, weight, order_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'AAAAAUYT_AAAAAAQQWETYU', 'ProductAALLLL', 11, 4);

INSERT INTO medication(created_at, modified_at, code, name, weight, order_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'AAAAAASD_AAAAAQQWETYU', 'ProductDAA', 190, 4);

INSERT INTO medication(created_at, modified_at, code, name, weight, order_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'AAAAAABB_AAAAAQQWETYU', 'ProductGAA', 280, 3);

INSERT INTO medication(created_at, modified_at, code, name, weight, order_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'AAAAAAAAAAAZX_AQQWETYU', 'ProductRAA', 201, 3);

INSERT INTO medication(created_at, modified_at, code, name, weight, order_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'AAAAA_SSD_AAAAAAQQWETYU', 'ProductATA', 150, 7);

INSERT INTO medication(created_at, modified_at, code, name, weight, order_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'AA_AADA_AAAAAAAQQWETYU', 'ProductUA', 200, 7);

INSERT INTO medication(created_at, modified_at, code, name, weight, order_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'AAAAAA_QWS_AAAAAQQWETYU', 'ProductIA', 69, 7);

INSERT INTO medication(created_at, modified_at, code, name, weight, order_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'AWS_AAAAAAAAAAQQWETYU', 'ProductWA', 10, 5);

INSERT INTO medication(created_at, modified_at, code, name, weight, order_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'AAAA_IUNB_AAAAAAAQQWETYU', 'ProductAWW', 51, 5);

INSERT INTO medication(created_at, modified_at, code, name, weight, order_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'AAAA_MMN_AAAAAAAQQWETYU', 'ProductARBBNNN', 9, 5);

INSERT INTO medication(created_at, modified_at, code, name, weight, order_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'AAAAAA_ERT_AAAAAQQWETYU', 'ProductBNMA', 92, 6);

INSERT INTO medication(created_at, modified_at, code, name, weight, order_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'AAA_MNBVAAAAAAAAQQWETYU', 'ProductRWEEA', 344, 2);

INSERT INTO medication(created_at, modified_at, code, name, weight, order_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'AAA_IUAAAAA_AAAQQWETYU', 'ProductTYUA', 103, 8);

INSERT INTO medication(created_at, modified_at, code, name, weight, order_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'AAAAAA_IIUD_AAAAAQQWETYU', 'ProductTREA', 11, 8);

INSERT INTO medication(created_at, modified_at, code, name, weight, order_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'AAA_AUUID_AAAAAAAQQWETYU', 'ProductWWEGFBBA', 35, 8);

INSERT INTO medication(created_at, modified_at, code, name, weight, order_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'AAAA_DSDSAAAAAAAQQWETYU', 'ProductTYPPPA', 42, 8);

INSERT INTO medication(created_at, modified_at, code, name, weight, order_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'AAADP_AAAAAAADAQQWETYU', 'ProductPIIIUA', 6, 10);

INSERT INTO medication(created_at, modified_at, code, name, weight, order_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'AAVC_AAAAAAQQWETYU', 'ProductCCVVBXA', 80, 10);

INSERT INTO medication(created_at, modified_at, code, name, weight, order_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'AAAADFC_AAAAAQQWETYU', 'ProductZZZAAAA', 9, 10);
--rollback DELETE FROM medication;

